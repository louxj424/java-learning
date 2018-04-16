package com.netease.annotationDemo01;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author louxj424
 * @date 创建时间：2018年4月16日 下午8:00:16
 * @version 0.1.0
 * @since jdk 1.7.0
 */
public class TestAnnotation {

	public static void main(String[] args) {
		// 反射出该类的方法
		Class calculator = Calculator.class;
		Method method;
		try {
			method = calculator.getMethod("add", String.class, int.class);

			if (method.isAnnotationPresent(MyAnnotation.class)) {
				// 通过该方法得到注解上的具体信息
				MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
				String username = annotation.username();
				int age = annotation.age();

				// 将注解上的信息注入到方法上
				Object object = calculator.newInstance();
				method.invoke(object, username, age);
			}

		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}
}
