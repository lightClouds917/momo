package com.java4all.momo.core.config;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author ITyunqing
 * @date 2019年11月27日 20:06:10
 */
@Configuration
public class MomoRestTemplateAutoConfiguration {

    @Autowired(required = true)
    private Collection<RestTemplate> restTemplates;

    @Autowired
    private MomoProperties momoProperties;

    public MomoRestTemplateAutoConfiguration() {

    }
}
