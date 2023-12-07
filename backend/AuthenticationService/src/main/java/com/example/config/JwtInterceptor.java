package com.example.config;

import com.example.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.WebRequestHandlerInterceptorAdapter;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class JwtInterceptor extends WebRequestHandlerInterceptorAdapter {
    @Autowired
    private JwtUtil jwtUtil;

    public JwtInterceptor(WebRequestInterceptor requestInterceptor) {
        super(requestInterceptor);
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getRequestURI());
        String auth = request.getHeader("authentication");
        System.out.println(request.getHeader("Content-Type"));
        System.out.println("pre handler:"+auth);
        if( !((request.getRequestURI().contains("login"))||(request.getRequestURI().contains("update")) || (request.getRequestURI().contains("add"))||(request.getRequestURI().contains("sendmail")))){
            jwtUtil.verify(auth);
        }

        return super.preHandle(request, response, handler);
    }
}