package com.kelun.oa.notice.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kelun.oa.notice.entity.FillInInfo;
import com.kelun.oa.notice.mapper.FillInInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author yale
 */
@Service
@Slf4j
public class FillInInfoServiceImpl extends ServiceImpl<FillInInfoMapper, FillInInfo> implements FillInInfoService {
    @Override
    public List<FillInInfo> getFillInEndInfos(Date endDate) {
        return baseMapper.getFillInEndInfos(endDate);
    }
}
