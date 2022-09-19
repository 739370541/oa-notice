package com.kelun.oa.notice.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * @author yale
 */
@Data
public class BatchUpdateDTO {

    private DataInfo dataInfo;

    private ControlInfo ControlInfo;

    @Data
    public static class DataInfo{
        private List<Sub> sub;
    }

    @Data
    public static class Sub{
        /**
         * fill_in_info表主键
         */
        private String id;

        /**
         * 发生状态 0-本期发生 1-本期未发生
         */
        private Integer state;
    }

    public static class ControlInfo{
        private String SendTime;
        private String Serial;
        private String SSystem;
        private String DSystem;
        private String InterfaceID;

        public String getSendTime() {
            return SendTime;
        }

        public void setSendTime(String SendTime) {
            this.SendTime = SendTime;
        }

        public String getSerial() {
            return Serial;
        }

        public void setSerial(String Serial) {
            this.Serial = Serial;
        }

        public String getSSystem() {
            return SSystem;
        }

        public void setSSystem(String SSystem) {
            this.SSystem = SSystem;
        }

        public String getDSystem() {
            return DSystem;
        }

        public void setDSystem(String DSystem) {
            this.DSystem = DSystem;
        }

        public String getInterfaceID() {
            return InterfaceID;
        }

        public void setInterfaceID(String InterfaceID) {
            InterfaceID = InterfaceID;
        }
    }

    public BatchUpdateDTO.ControlInfo getControlInfo() {
        return ControlInfo;
    }

    public void setControlInfo(BatchUpdateDTO.ControlInfo ControlInfo) {
        ControlInfo = ControlInfo;
    }
}
