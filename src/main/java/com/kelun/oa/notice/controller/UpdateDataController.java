package com.kelun.oa.notice.controller;


import com.kelun.oa.notice.entity.FillInInfo;
import com.kelun.oa.notice.entity.dto.BatchUpdateDTO;
import com.kelun.oa.notice.entity.dto.ResultDTO;
import com.kelun.oa.notice.service.FillInInfoService;
import com.kelun.oa.notice.utils.BeanCopyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author yale
 */
@RestController
@RequestMapping("/fill-in")
@Slf4j
public class UpdateDataController {

    @Autowired
    private FillInInfoService fillInInfoService;

    @PostMapping("/update")
    public ResultDTO update(@RequestBody BatchUpdateDTO batchUpdateDTO) {
        log.info("oa回调开始，request={}", batchUpdateDTO);
        List<FillInInfo> fillInInfos = BeanCopyUtils.copyListProperties(batchUpdateDTO.getDataInfo().getSub(), FillInInfo::new);
        ResultDTO resultDTO = new ResultDTO();
        ResultDTO.ControlInfo controlInfo = new ResultDTO.ControlInfo();
        controlInfo.setSerial("大数据");
        controlInfo.setSSystem("OA");
        controlInfo.setDSystem("SAP");
        controlInfo.setInterfaceID("");
        ResultDTO.Result result = new ResultDTO.Result();
        resultDTO.setControlInfo(controlInfo);
        resultDTO.setResult(result);

        try {
            fillInInfoService.updateBatchById(fillInInfos);
        } catch (Exception e) {
            controlInfo.setSendTime(getNowDateStr());
            result.setMsgtxt("失败");
            result.setMsgtype("E");
            return resultDTO;
        }
        controlInfo.setSendTime(getNowDateStr());
        result.setMsgtxt("成功");
        result.setMsgtype("S");
        return resultDTO;
    }

    private String getNowDateStr() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date(System.currentTimeMillis());
        String nowDate = formatter.format(date);
        return nowDate;
    }
}
