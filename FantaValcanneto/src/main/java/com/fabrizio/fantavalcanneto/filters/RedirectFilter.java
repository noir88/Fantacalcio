package com.fabrizio.fantavalcanneto.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class RedirectFilter implements Filter{

    public void init(FilterConfig filterConfig) throws ServletException {
       
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)request;
//check if "role" attribute is null
        if(req.getSession().getAttribute("utentes")==null){
//forward request to login.jsp
            req.getRequestDispatcher("/").forward(request, response);
        }else{
        chain.doFilter(request, response);
        }
    }

    public void destroy() {
        
    }  
}