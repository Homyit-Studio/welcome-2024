package org.example.yingxin.cn.homyit.filter;

import com.alibaba.fastjson.JSONObject;
import org.example.yingxin.cn.homyit.Until.JwtUntil;
import org.example.yingxin.cn.homyit.enums.CodeEnum;
import org.example.yingxin.cn.homyit.mapper.BlacklistMapper;
import org.example.yingxin.cn.homyit.pojo.Jwt;
import org.example.yingxin.cn.homyit.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
@WebFilter("/guanliyuan/*")
public class Filter implements javax.servlet.Filter {
    @Autowired
    private BlacklistMapper blacklistMapper;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        javax.servlet.Filter.super.init(filterConfig);
    }
    @ResponseBody
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //解决中文请求乱码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String url = request.getRequestURL().toString();
        if(url.contains("/login")){
            filterChain.doFilter(request, response);
            return;
        }
        String jwt = request.getHeader("token");
        if(!StringUtils.hasLength(jwt)){
            String jsonString = JSONObject.toJSONString(Result.error(CodeEnum.NOLOGIN));
            response.getWriter().write(jsonString);
            return;
        }
        Jwt blacklist = blacklistMapper.selectblacklist(jwt);
        if(blacklist != null && !"".equals(blacklist.getJwt())){
            String jsonString = JSONObject.toJSONString(Result.error(CodeEnum.JWT_ERORR));
            response.getWriter().write(jsonString);
            return;
        }
        try {
            JwtUntil.parseJwt(jwt);

        } catch (Exception e){
            e.printStackTrace();
            String jsonString = JSONObject.toJSONString(Result.error(CodeEnum.LOGIN_STATUS_EXPIRED));
            response.getWriter().write(jsonString);
            return;
        }
        filterChain.doFilter(request, response);
    }


    @Override
    public void destroy() {
        javax.servlet.Filter.super.destroy();
    }
}
