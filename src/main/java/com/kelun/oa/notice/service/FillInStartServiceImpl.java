package com.kelun.oa.notice.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.kelun.oa.notice.entity.dto.FillInInfoDTO;
import com.kelun.oa.notice.mapper.FillInfoTempMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yale
 */
@Service
@Slf4j
@DS("impala")
public class FillInStartServiceImpl implements FillInStartService {


    @Autowired
    private FillInfoTempMapper mapper;


    @Override
    public List<FillInInfoDTO> getFillInStartInfos(String ds) {
        return mapper.getFillInStartInfos(ds);
    }
}
