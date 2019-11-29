package com.java4all.momo.core.filter;

import com.java4all.momo.context.RootContext;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.util.StringUtils;

/**
 *
 * @author ITyunqing
 * @date 2019年11月29日 22:02:08
 */
public class MomoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
            FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String xid = httpServletRequest.getHeader(RootContext.KEY_XID.toLowerCase());
        boolean isBind = false;
        if(!StringUtils.isEmpty(xid)){
            RootContext.bind(xid);
        }
        isBind = true;
        try {
            filterChain.doFilter(servletRequest,servletResponse);
        }finally {
            if(isBind){
                RootContext.unbind();
            }
        }
    }

    @Override
    public void destroy() {

    }
}
