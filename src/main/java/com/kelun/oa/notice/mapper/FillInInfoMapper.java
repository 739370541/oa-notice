package com.kelun.oa.notice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kelun.oa.notice.entity.FillInInfo;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author yale
 */
@Repository
public interface FillInInfoMapper extends BaseMapper<FillInInfo> {

    List<FillInInfo> getFillInEndInfos(Date endDate);
}