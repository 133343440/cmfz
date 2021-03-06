package com.baizhi.annotation;

import org.omg.SendingContext.RunTime;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//注解使用的时机，在运行时使用
@Retention(RetentionPolicy.RUNTIME)
 //自定义注解 使用的地方
@Target(ElementType.FIELD)
public @interface UserAnnotation {
   public String name();
}
