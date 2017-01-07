package com.dky.web.controller;

import com.dky.common.response.ReturnT;
import com.dky.common.utils.ConverImagePathUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


/**
 * Created by wonpera on 2017/1/7.
 */
@Order(Integer.MAX_VALUE)
@ControllerAdvice(basePackages = "com.dky.web.controller")
public class DykResponseBodyAdvice implements ResponseBodyAdvice<Object> {


    private static final Logger LOGGER = LoggerFactory.getLogger(DykResponseBodyAdvice.class);


    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> aClass) {
        return ReturnT.class.isAssignableFrom(returnType.getMethod()
                .getReturnType());
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if(body != null && body instanceof ReturnT){
            ReturnT returnT = (ReturnT) body;
            ConverImagePathUtils.transferImageUrl(returnT);//转换ImageUrl
        }
        return body;
    }




}
