package com.kelun.oa.notice.service;

import com.kelun.oa.notice.entity.dto.FillInInfoDTO;

import java.util.List;

/**
 * 填报开始服务类
 * @author yale
 */
public interface FillInStartService {

    /**
     * 获取填报开始日期符合条件的数据
     * @return
     */
    List<FillInInfoDTO> getFillInStartInfos(String ds);


}
