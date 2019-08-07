package com.example.pulsaraopdemo.common.push;


import com.example.pulsaraopdemo.service.PushService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;

/**
 * @author kmz
 */
@Aspect
@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 2)
public class LazyPushAspect {

    @Autowired
    PushService pushService;

    @Around(value = "@annotation(LazyPush)")
    public Object invoke(ProceedingJoinPoint pjp) throws Throwable {

        if (this.pushService.processing()) {
            pjp.proceed();
        }

        try {
            pushService.begin();
            Object val = pjp.proceed();
            pushService.commit();
            return val;
        } catch (Throwable e) {
            //为什么是Throwable呢  查看一下Transactional就知道了
            if (rollbackOn(pjp, e)) {
                this.pushService.rollback();
            } else {
                this.pushService.commit();
            }
            throw e;
        }


    }


    public boolean rollbackOn(ProceedingJoinPoint pjp, Throwable e) {

        Method method = ((MethodSignature) pjp.getSignature()).getMethod();

        Transactional transactional = method.getAnnotation(Transactional.class);

        //没有事务时 直接回滚
        if (transactional == null){
            return true;
        }

        //存在事务没有指定回滚异常时，默认RuntimeException回滚
        if (transactional.rollbackFor().length == 0){
            return e instanceof RuntimeException;
        }

        //存在事务并指定了回滚异常, 如果异常是回滚异常的实例才回滚
        for (Class<?> clazz : transactional.rollbackFor()) {
            if (clazz.isInstance(e)) {
                return true;
            }
        }
        return false;
    }
}
