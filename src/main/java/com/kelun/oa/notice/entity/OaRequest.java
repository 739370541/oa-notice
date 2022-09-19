package com.kelun.oa.notice.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.List;

/**
 * @author yale
 */
@Data
public class OaRequest {

    /**
     * 模板编码
     */
    private String templateCode;

    /**
     * 发起人
     */
    private String senderCode;


    /**
     * 接口信息
     */
    private ControlInfo controlInfo;

    /**
     * 数据信息
     */
    private DataInfo dataInfo;

    @Data
    public  static class  ControlInfo{

        /**
         * 源系统
         */
        private String sourceSystem;

        /**
         * 目标系统
         */
        private String targetSystem;

        /**
         * 接口号
         */
        private String interfaceID;

        /**
         * 序列号
         */
        private String serialNo;

        /**
         * 发送时间(时间戳:日期 + 时间) yyyy-MM-dd HH:mm:ss
         */
        private String sendTime;

        /**
         * 发起人
         */
        private String sponsor;

        /**
         * 发起日期
         */
        private String messageDate;

        /**
         * 消息类型 1-填报开始发送 2-填报截至前发送
         */
        private Integer messageType;


    }

    @Data
    public static class  DataInfo {

        /**
         * 接收人员oa账号
         */
        private String receiver;

        /**
         * 消息类型 1-填报开始发送 2-填报截至前发送
         */
        private Integer messageType;


        /**
         * 明细行数据信息
         */
        private List<FillInInfo> sub;
    }

}
