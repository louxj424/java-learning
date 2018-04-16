package com.netease.annotationDemo01;
/** 
* @author  louxj424
* @date 创建时间：2018年4月16日 下午7:59:28 
* @version 0.1.0  
* @since jdk 1.7.0
 */

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyAnnotation {
    //定义了两个成员变量
    String username() default "louxj424";
    int age() default 27;
}
