package com.tzword.demo.aspect;

import java.lang.annotation.*;

public class RespAspect {
    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface responseResult {
        /**
         *
         **/
        String resultCode() default "";

        /**
         * 要执行的具体操作比如：添加用户
         **/
        String resultMessage() default "";
    }
}
