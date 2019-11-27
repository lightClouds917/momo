package com.java4all.momo.core.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author ITyunqing
 * @date 2019年11月27日 19:53:52
 */
@ConfigurationProperties("spring.cloud.momo")
public class MomoProperties {

    private String txServiceGroup;

    public String getTxServiceGroup() {
        return txServiceGroup;
    }

    public void setTxServiceGroup(String txServiceGroup) {
        this.txServiceGroup = txServiceGroup;
    }
}
