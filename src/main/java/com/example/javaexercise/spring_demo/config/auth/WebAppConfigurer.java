package com.example.javaexercise.spring_demo.config.auth;

import com.example.javaexercise.spring_demo.interceptor.LogProcessTimeHandlerInterceptor;
import com.example.javaexercise.spring_demo.interceptor.LoginCheckHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        InterceptorRegistration logprocessRegistration = registry.addInterceptor(new LogProcessTimeHandlerInterceptor());
        InterceptorRegistration loginRegistration = registry.addInterceptor(new LoginCheckHandlerInterceptor());

        //所有路径都被拦截
        //loginRegistration.addPathPatterns("/**");
        //添加不拦截路径
        //loginRegistration.excludePathPatterns("/sayHi/**");
        loginRegistration.excludePathPatterns("/**");

//        loginRegistration.excludePathPatterns(
//                "/**/*.html",
//                "/**/*.js",
//                "/**/*.css",
//                "/**/*.woff",
//                "/**/*.ttf"
//        );
    }
}

