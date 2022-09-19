package com.kelun.oa.notice.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author yale
 */
public enum FillInTypeEnum {

    YEAR(1,"数据填报"),
    MONTH(2,"主数据填报");

    private Integer type;

    @JsonValue
    private String desc;

    FillInTypeEnum(Integer type,String desc){
        this.type=type;
        this.desc=desc;
    }


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc(Integer type){
        for (FillInTypeEnum fillInTypeEnum : FillInTypeEnum.values()) {
            if(fillInTypeEnum.getType().equals(type)){
                return fillInTypeEnum.getDesc();
            }
        }
        return null;
    }

    public Integer getType(String desc){
        for (FillInTypeEnum fillInTypeEnum : FillInTypeEnum.values()) {
            if(fillInTypeEnum.getDesc().equals(desc)){
                return fillInTypeEnum.getType();
            }
        }
        return null;
    }
}
