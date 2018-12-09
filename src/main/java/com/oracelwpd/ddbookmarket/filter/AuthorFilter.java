package com.oracelwpd.ddbookmarket.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AuthorFilter",urlPatterns = "/*")
public class AuthorFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //转化
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;
        //因为需要先登录，开放
        if (request.getRequestURI().endsWith("/login.jsp")||request.getRequestURI().contains("/bower_components/")||request.getRequestURI().endsWith("/login")||request.getRequestURI().endsWith("/vcode.png")){
            chain.doFilter(req, resp);
            return;
        }
        //过滤，对没有登录的，不允许对其他页面操作，只返回登录页面
        if (request.getSession().getAttribute("hasLogined")==null||!(boolean)request.getSession().getAttribute("hasLogined")){
            response.sendRedirect("login.jsp");
            return;
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
