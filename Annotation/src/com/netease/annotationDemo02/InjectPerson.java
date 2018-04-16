package com.netease.annotationDemo02;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author louxj424
 * @date 创建时间：2018年4月16日 下午8:21:14
 * @version 0.1.0
 * @since jdk 1.7.0
 */
//注入工具是通过反射来得到注解的信息的，于是保留域必须使用RunTime
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectPerson {
	String username();

	int age();
}
