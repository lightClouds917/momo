package com.java4all.momo.core.config;

import com.java4all.momo.core.interceptor.MomoRestTemplateInterceptor;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

/**
 * @author ITyunqing
 * @date 2019年11月27日 20:06:10
 */
@Configuration
public class MomoRestTemplateAutoConfiguration {


    @Autowired(required = false)
    private Collection<RestTemplate> restTemplates;
    //TODO true or false

    @Autowired
    private MomoRestTemplateInterceptor momoRestTemplateInterceptor;

    @Bean
    public MomoRestTemplateInterceptor momoRestTemplateInterceptor(){
        return new MomoRestTemplateInterceptor();
    }

    @PostConstruct
    public void init(){
        if(!CollectionUtils.isEmpty(restTemplates)){
            Iterator<RestTemplate> iterator = restTemplates.iterator();
            while (iterator.hasNext()){
                RestTemplate restTemplate = iterator.next();
                List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
                interceptors.add(this.momoRestTemplateInterceptor);
                restTemplate.setInterceptors(interceptors);
            }
        }

    }
}
