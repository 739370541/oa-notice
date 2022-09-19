package com.kelun.oa.notice.service;

import com.alibaba.fastjson.JSON;
import com.kelun.oa.notice.entity.OaRequest;
import com.kelun.oa.notice.entity.OaResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * oa消息发送服务类
 * @author yale
 */
@Service
@Slf4j
public class OaMessageSendServiceImpl implements OaMessageSendService {

//    private static final String OA_URL="http://118.114.254.69:7360/seeyon/rest/customBpmProcess";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public OaResponse sendMessage(OaRequest oaRequest,String url) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(JSON.toJSONString(oaRequest), httpHeaders);
        log.info("oa请求路径：{}",url);
        log.info("oa请求信息：{}",entity.getBody());
        ResponseEntity<OaResponse> exchange = restTemplate.exchange(url, HttpMethod.POST, entity, OaResponse.class);
        log.info("oa响应信息：{}",exchange);
        return exchange.getBody();
    }
}
