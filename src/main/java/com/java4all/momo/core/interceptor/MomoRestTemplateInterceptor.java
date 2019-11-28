package com.java4all.momo.core.interceptor;

import com.java4all.momo.context.RootContext;
import java.io.IOException;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.util.StringUtils;

/**
 * @author ITyunqing
 * @date 2019年11月28日 20:05:57
 */
public class MomoRestTemplateInterceptor implements ClientHttpRequestInterceptor{

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes,
            ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        HttpRequestWrapper requestWrapper = new HttpRequestWrapper(httpRequest);
        String xid = RootContext.getXID();
        if(!StringUtils.isEmpty(xid)){
            requestWrapper.getHeaders().add("TX_XID",xid);
        }
        return clientHttpRequestExecution.execute(requestWrapper,bytes);
    }
}
