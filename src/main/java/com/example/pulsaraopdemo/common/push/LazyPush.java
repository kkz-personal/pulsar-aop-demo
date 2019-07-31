package com.example.pulsaraopdemo.common.push;


import java.lang.annotation.*;

/**
 * @author kmz
 * 延迟推送
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LazyPush {
}
