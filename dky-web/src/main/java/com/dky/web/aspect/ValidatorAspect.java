package com.dky.web.aspect;

import com.dky.common.exception.ValidatorException;
import com.dky.common.response.ReturnT;
import com.dky.common.utils.ValidatorUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * 校验切面类
 * Created by wonpera on 2017/1/4.
 */
@Aspect
@Component
public class ValidatorAspect implements Ordered {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidatorAspect.class);

    @Around("execution(* com.dky.web.controller..*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        //校验
        Object[] parameters = pjp.getArgs();
        try {
            if(parameters != null && parameters.length > 0){
                for (Object obj :parameters ){
                    ValidatorUtils.validator(obj);
                }
            }
        } catch (ValidatorException e) {
            LOGGER.error(e.getMessage());
            return new ReturnT<>().failureData(e.getMessage());
        }

        return pjp.proceed();
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
