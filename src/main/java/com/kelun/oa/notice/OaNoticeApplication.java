package com.kelun.oa.notice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author yale
 */
@SpringBootApplication
@EnableScheduling
@MapperScan(basePackages = {"com.kelun.oa.notice.mapper"})
public class OaNoticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(OaNoticeApplication.class,args);
    }
}
