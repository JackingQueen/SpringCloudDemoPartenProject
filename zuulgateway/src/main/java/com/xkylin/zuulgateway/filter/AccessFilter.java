package com.xkylin.zuulgateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

public class AccessFilter extends ZuulFilter {

    /**
     * 四种不同生命周期
     * pre：可以在请求被路由之前调用
     * routing：在路由请求时候被调用
     * post：在routing和error过滤器之后被调用
     * error：处理请求时发生错误时被调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器的执行顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 过滤器是否要执行
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx= RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getParameter("accesstoken");
        if(token == null) {
            // 过滤该请求，不对其进行路由
            ctx.setSendZuulResponse(false);
            // 返回的错误码。也可以通过ctx.setResponseBody(body)对返回
            ctx.setResponseStatusCode(401);
            return null;
        }
        return null;
    }
}
