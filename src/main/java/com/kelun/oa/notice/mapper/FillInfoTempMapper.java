package com.kelun.oa.notice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kelun.oa.notice.entity.FillInInfo;
import com.kelun.oa.notice.entity.Tabdiytable4766;
import com.kelun.oa.notice.entity.dto.FillInInfoDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FillInfoTempMapper extends BaseMapper<FillInInfoDTO> {
    List<FillInInfoDTO> getFillInStartInfos(@Param("ds") String ds);
}