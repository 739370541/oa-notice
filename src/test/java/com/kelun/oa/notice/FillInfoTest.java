package com.kelun.oa.notice;

import com.kelun.oa.notice.job.FillInStartNoticeJob;
import com.kelun.oa.notice.service.FillInStartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author 刘欢
 * @version 2.0.1
 * @date 2022-04-07 14:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {OaNoticeApplication.class})
public class FillInfoTest {
    @Autowired
    private FillInStartService service;
    @Autowired
    private FillInStartNoticeJob job;

    @Test
    public void name() {

        //List<FillInInfoDTO> fillInStartInfos = service.getFillInStartInfos("2022-06-20");
        //System.out.println(fillInStartInfos);
        job.fillInStartNotice();

    }
}
