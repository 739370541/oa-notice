package com.kelun.oa.notice.config;

import com.google.common.collect.Lists;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yexiaolong
 * @version 1.0
 * @date 2021-03-10 14:46
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        List<HttpMessageConverter<?>> messageConverters = builder.build().getMessageConverters();
        messageConverters.forEach(converter -> {
            if (converter instanceof MappingJackson2HttpMessageConverter) {
                List<MediaType> supportedMediaTypes = converter.getSupportedMediaTypes();
                ArrayList<MediaType> mediaTypes = Lists.newArrayList(supportedMediaTypes);
                mediaTypes.add(MediaType.TEXT_PLAIN);
                ((MappingJackson2HttpMessageConverter) converter).setSupportedMediaTypes(mediaTypes);
            }
        });
        return builder
                .setReadTimeout(Duration.ofMillis(100000))
                .setConnectTimeout(Duration.ofMillis(40000))
                .build();
    }

}
