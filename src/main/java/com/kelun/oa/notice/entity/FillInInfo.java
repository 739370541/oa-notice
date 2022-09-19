package com.kelun.oa.notice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * @author yale
 */
@Data
@TableName("fill_in_info_log")
public class FillInInfo {

    @TableId(type = IdType.INPUT)
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

    /**
     * 开始时间报警发送状态0:未发送，1：已发送
     */
    private Integer startSendStatus;

    /**
     * 结束时间报警发送状态0:未发送，1：已发送
     */
    private Integer endSendStatus;

    /**
     * 未填报忽略发送状态0：不忽略，1：忽略
     */
    private Integer state;


}