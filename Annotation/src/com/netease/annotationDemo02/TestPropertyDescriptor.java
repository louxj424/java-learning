package com.netease.annotationDemo02;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * @author louxj424
 * @date 创建时间：2018年4月16日 下午8:38:36
 * @version 0.1.0
 * @since jdk 1.7.0
 */
public class TestPropertyDescriptor {

	public static void main(String[] args) {
		Person person = new Person();
		person.setUsername("louxj424");
		person.setAge(18);
		getFiled(person, "username");// 结果输出 louxj424
	}

	// 通过反射得到name
	// 可以看到这是通过 得到 属性的get方法（pd.getReadMethod()） 再调用invoke方法取出对应的属性值
	// 同样得到set方法（pd.getWriteMethod()）
	private static void getFiled(Object object, String field) {
		Class<? extends Object> clazz = object.getClass();
		PropertyDescriptor pd = null;
		Method getMethod = null;
		try {
			pd = new PropertyDescriptor(field, clazz);
			if (null != pd) {
				// 获取 这个 field 属性 的get方法
				getMethod = pd.getReadMethod();
				Object invoke = getMethod.invoke(object);
				System.out.println(invoke);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
