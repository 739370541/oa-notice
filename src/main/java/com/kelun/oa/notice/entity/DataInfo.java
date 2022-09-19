package com.kelun.oa.notice.entity;

import lombok.Data;

import java.util.List;

@Data
public class DataInfo {

    private List<Sub> sub;

    @Data
    private static class Sub{
        /**
         * fill_in_info表主键
         */
        private Long id;

        /**
         * 发生状态 0-本期发生 1-本期未发生
         */
        private Integer state;
    }


}
