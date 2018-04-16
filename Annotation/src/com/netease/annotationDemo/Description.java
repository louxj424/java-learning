package com.netease.annotationDemo;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/** 
* @author  louxj424
* @date 创建时间：2018年4月16日 下午3:04:05 
* @version 0.1.0  
* @since jdk 1.7.0
 */

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description {
	String desc();
	String author();
	int age() default 15;
}
