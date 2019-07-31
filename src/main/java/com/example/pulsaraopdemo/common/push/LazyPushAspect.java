package com.example.pulsaraopdemo.common.push;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author kmz
 */
@Aspect
@Component
public class LazyPushAspect {

    public Object invoke(ProceedingJoinPoint pjp){
        return "";
    }


    public boolean rollbackOn(ProceedingJoinPoint pjp, Throwable e){

        return false;
    }
}
