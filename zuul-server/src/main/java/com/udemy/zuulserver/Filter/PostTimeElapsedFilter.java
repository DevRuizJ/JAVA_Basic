package com.udemy.zuulserver.Filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class PostTimeElapsedFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(PostTimeElapsedFilter.class);

    @Override
    public String filterType() {
        return "POST";
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

        log.info("entrando a post filter");

        Long startTime = (Long) request.getAttribute("tiempo de inicio");
        Long finalTime = System.currentTimeMillis();
        Long timeElapsed = finalTime - startTime;

        log.info(String.format("tiempo transcurrido en segundos %s seg.", timeElapsed.doubleValue()/1000.00));
        log.info(String.format("tiempo transcurrido en  milisegundos %s ms.", request.getMethod(), timeElapsed));

        return null;
    }
}
