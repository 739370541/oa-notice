package com.kelun.oa.notice.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author yale
 */
public enum FillInCycleEnum {

    YEAR(1,"年"),
    MONTH(2,"月"),
    WEEK(3,"周"),
    DAY(4,"日"),
    REQUIREMENT(5,"年");

    private Integer type;

    @JsonValue
    private String desc;

    FillInCycleEnum(Integer type, String desc){
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
        for (FillInCycleEnum fillInTypeEnum : FillInCycleEnum.values()) {
            if(fillInTypeEnum.getType().equals(type)){
                return fillInTypeEnum.getDesc();
            }
        }
        return null;
    }
}
