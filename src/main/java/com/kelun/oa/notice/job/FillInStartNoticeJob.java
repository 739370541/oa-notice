package com.kelun.oa.notice.job;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.kelun.oa.notice.entity.FillInInfo;
import com.kelun.oa.notice.entity.OaRequest;
import com.kelun.oa.notice.entity.OaResponse;
import com.kelun.oa.notice.entity.dto.FillInInfoDTO;
import com.kelun.oa.notice.service.FillInInfoService;
import com.kelun.oa.notice.service.FillInStartService;
import com.kelun.oa.notice.service.OaMessageSendService;
import com.kelun.oa.notice.utils.BeanCopyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yale
 */
@Component
@Slf4j
public class FillInStartNoticeJob {

    @Autowired
    private OaMessageSendService messageSendService;

    @Autowired
    private FillInStartService fillInStartService;

    @Autowired
    private FillInInfoService fillInInfoService;

    @Value("${oa.senderCoder}")
    private String senderCoder;

    @Value("${oa.templateCode}")
    private String templateCode;

    //@Scheduled(cron = "0 0/1 * * * ? ")
    @Scheduled(cron = "0 0 9/2 * * ?")
    //@Scheduled(cron = "0 0 9,12,15 * * ? ")
    public void fillInStartNotice() {
        log.info("填报警告定时任务开始执行");
        //当前时间
        //String nowDate = getNowDateStr();
        String nowDate = "2022-09-19";

        //获取当天的填报信息，若全部填报程序结束
        List<FillInInfoDTO> fillInStartInfos = fillInStartService.getFillInStartInfos(nowDate);
        if (null == fillInStartInfos || fillInStartInfos.isEmpty()) {
            return;
        }

        //包含所有未填报的列表
        List<FillInInfo> fillInInfos = BeanCopyUtils.copyListProperties(fillInStartInfos, FillInInfo::new);

        //获取已发送的开始填报
        List<FillInInfo> startList = fillInInfoService.list(Wrappers.<FillInInfo>lambdaQuery()
                .eq(FillInInfo::getAlarmStartTime, nowDate)
                .eq(FillInInfo::getStartSendStatus, 1)
                .select(FillInInfo::getId));

        List<String> startIdList = startList.stream().map(FillInInfo::getId).collect(Collectors.toList());

        //获取已发送的结束填报
        List<FillInInfo> endList = fillInInfoService.list(Wrappers.<FillInInfo>lambdaQuery()
                .eq(FillInInfo::getAlarmEndTime, nowDate)
                .eq(FillInInfo::getEndSendStatus, 1)
                .select(FillInInfo::getId));

        List<String> endIdList = endList.stream().map(FillInInfo::getId).collect(Collectors.toList());

        //获取忽略发送的填报信息
        List<FillInInfo> stateList = fillInInfoService.list(Wrappers.<FillInInfo>lambdaQuery()
                .eq(FillInInfo::getAlarmEndTime, nowDate)
                .eq(FillInInfo::getState, 1)
                .select(FillInInfo::getId));

        List<String> stateIdList = stateList.stream().map(FillInInfo::getId).collect(Collectors.toList());

        //开始填报信息
        List<FillInInfo> startTime = new ArrayList<>();
        //结束填报信息
        List<FillInInfo> endTime = new ArrayList<>();

        for (FillInInfo fillInInfo : fillInInfos) {
            if (fillInInfo.getAlarmStartTime().equals(nowDate) && !fillInInfo.getAlarmEndTime().equals(nowDate)) {
                if (startIdList.contains(fillInInfo.getId())) {
                    continue;
                }
                startTime.add(fillInInfo);
            }
            if (fillInInfo.getAlarmEndTime().equals(nowDate)) {
                if (endIdList.contains(fillInInfo.getId()) || stateIdList.contains(fillInInfo.getId())) {
                    continue;
                }
                endTime.add(fillInInfo);
            }
        }
        //发送开始填报信息
        if (!startTime.isEmpty()) {
            sendFillInInfo(startTime, 1);
        }
        //发送结束填报信息
        if (!endTime.isEmpty()) {
            sendFillInInfo(endTime, 2);
        }
    }

    private void sendFillInInfo(List<FillInInfo> fillInInfos, Integer type) {
        Map<String, List<FillInInfo>> fillInMap = fillInInfos.stream().collect(Collectors.groupingBy(FillInInfo::getFillInNo));
        //按填报编号分组发送
        for (Map.Entry<String, List<FillInInfo>> fillInInfoEntry : fillInMap.entrySet()) {
            List<FillInInfo> value = fillInInfoEntry.getValue();
            Map<String, List<FillInInfo>> urlMap = value.stream().collect(Collectors.groupingBy(FillInInfo::getUrl));
            //按oa地址再分组
            for (Map.Entry<String, List<FillInInfo>> entry : urlMap.entrySet()) {
                sendMessage(type, fillInInfoEntry, entry.getValue(), entry.getKey());
            }

            //科伦oa有点烂，间隔一下时间，别把oa搞崩了
            try {
                log.info("发送睡眠开始");
                Thread.sleep(1000);
                log.info("发送睡眠结束");
            } catch (InterruptedException e) {
                log.error("睡眠报错", e);
            }
        }
    }

    private void sendMessage(Integer type, Map.Entry<String, List<FillInInfo>> fillInInfoEntry, List<FillInInfo> value, String url) {
        OaRequest oaRequest = convertToOARequest(fillInInfoEntry.getKey(), value, type);
        oaRequest.getControlInfo().setMessageType(type);
        OaResponse oaResponse;
        try {
            oaResponse = messageSendService.sendMessage(oaRequest, url);
        } catch (Exception e) {
            log.error("oa消息发送错误", e);
            return;
        }

        if (null != oaResponse && "S".equals(oaResponse.getType())) {
            for (FillInInfo fillInInfo : value) {
                if (type == 1) {
                    fillInInfo.setStartSendStatus(1);
                }
                if (type == 2) {
                    fillInInfo.setStartSendStatus(1);
                    fillInInfo.setEndSendStatus(1);
                }
            }
            fillInInfoService.saveOrUpdateBatch(value);
        }
    }

    private String getNowDateStr() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String nowDate = formatter.format(date);
        return nowDate;
    }

    private OaRequest convertToOARequest(String receiver, List<FillInInfo> fillInInfos, Integer type) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        OaRequest oaRequest = new OaRequest();
        OaRequest.ControlInfo controlInfo = new OaRequest.ControlInfo();
        controlInfo.setSendTime(simpleDateFormat.format(new Date()));
        oaRequest.setControlInfo(controlInfo);
        oaRequest.setTemplateCode(templateCode);
        oaRequest.setSenderCode(senderCoder);
        OaRequest.DataInfo dataInfo = new OaRequest.DataInfo();
        dataInfo.setReceiver(receiver);
        dataInfo.setMessageType(type);
        dataInfo.setDataSubs(fillInInfos);
        oaRequest.setDataInfo(dataInfo);
        return oaRequest;
    }
}
