package com.meizhi.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录过滤器
 */
//@Component
public class LoginFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.DEBUG_FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // 登录校验逻辑。
        // 1）获取Zuul提供的请求上下文对象
        RequestContext ctx = RequestContext.getCurrentContext();
        // 2) 从上下文中获取request对象
        HttpServletRequest req = ctx.getRequest();
        // 3) 从请求中获取token
        String token = req.getParameter("access-token");
        // 4) 判断
        if(StringUtils.isBlank(token)){
            // 没有token，登录校验失败，拦截,一切都交给上下文控制,而不是简单返回false
            ctx.setSendZuulResponse(false);
            // 返回403状态码。也可以考虑重定向到登录页。
            ctx.setResponseStatusCode(HttpStatus.FORBIDDEN.value());
        }
        // 校验通过，可以考虑把用户信息放入上下文，继续向后执行,不进行处理,则上下文默认为null,则认为是放行
        return null;
    }
}
