package com.kelun.oa.notice.entity.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author 刘欢
 * @version 2.0.1
 * @date 2022-04-08 15:30
 */
@Data
public class ResultDTO {

    @JsonProperty("ControlInfo")
    private ControlInfo ControlInfo;

    private Result result;

    @Data
    public static class ControlInfo{

        @JsonProperty("SSystem")
        private String SSystem;

        @JsonProperty("DSystem")
        private String DSystem;

        private String interfaceID;

        @JsonProperty("Serial")
        private String Serial;

        @JsonProperty("SendTime")
        private String SendTime;
    }

    @Data
    public static class Result{

        private String msgtxt;

        private String msgtype;
    }
}
