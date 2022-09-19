package com.kelun.oa.notice.entity.dto;

import lombok.Data;

/**
 * 填报信息实体
 *
 * @author yale
 */
@Data
public class FillInInfoDTO {


    private String id;
    /**
     * 主题
     */
    private String subject;

    /**
     * 填充类型
     */
    private String fillInType;

    /**
     * 表单名称
     */
    private String formName;

    /**
     * 填报周期
     */
    private String fillInCycle;

    /**
     * 报表名称
     */
    private String reportName;

    /**
     * 填报开始日期
     */
    private String startDate;

    /**
     * 填报开始日期
     */
    private String endDate;

    /**
     * 填报方式
     */
    private String fillInWay;

    /**
     * 填报层级
     */
    private String hierarchy;

    /**
     * 基地编码
     */
    private String factoryCode;

    /**
     * 基地名称
     */
    private String factoryName;

    /**
     * 车间编码
     */
    private String workShop;

    /**
     * 车间名称
     */
    private String shopName;

    /**
     * 填报负责人
     */
    private String fillInPrincipal;

    /**
     * 填报负责人工号
     */
    private String fillInNo;

    /**
     * 板块负责人
     */
    private String platePrincipal;

    /**
     * 板块负责人工号
     */
    private String plateNo;

    /**
     * 监控负责人
     */
    private String monitorPrincipal;

    /**
     * 监控负责人工号
     */
    private String monitorNo;

    /**
     * url
     */
    private String url;

    /**
     * '报警开始时间'
     */
    private String AlarmStartTime;

    /**
     * '报警结束时间'
     */
    private String AlarmEndTime;


}
