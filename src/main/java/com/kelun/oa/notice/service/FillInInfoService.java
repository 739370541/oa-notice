package com.kelun.oa.notice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kelun.oa.notice.entity.FillInInfo;

import java.util.Date;
import java.util.List;

/**
 * @author yale
 */
public interface FillInInfoService extends IService<FillInInfo> {

    /**
     * 获取截止日期需要通知的数据
     * @param endDate 截止日期
     * @return
     */
    List<FillInInfo> getFillInEndInfos(Date endDate);
}
