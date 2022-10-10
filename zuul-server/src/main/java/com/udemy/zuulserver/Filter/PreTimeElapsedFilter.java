package com.udemy.zuulserver.Filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class PreTimeElapsedFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(PreTimeElapsedFilter.class);

    @Override
    public String filterType() {
        return "PRE";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info(String.format("%s request enrutado a %s", request.getMethod(), request.getRequestURL().toString()));

        Long startTime = System.currentTimeMillis();
        request.setAttribute("tiempo incio", startTime);

        return null;
    }
}
