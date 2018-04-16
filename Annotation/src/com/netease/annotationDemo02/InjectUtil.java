package com.netease.annotationDemo02;
/** 
* @author  louxj424
* @date 创建时间：2018年4月16日 下午8:23:41 
* @version 0.1.0  
* @since jdk 1.7.0
 */

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InjectUtil {
	public static void InjectPersonMethod() {

		PropertyDescriptor descriptor = null;

		Person person = null;
		Method method = null;

		try {
			// 1.根据这个属性名字的字符串去得到属性的值
			descriptor = new PropertyDescriptor("person", PersonDao.class);
		} catch (IntrospectionException e1) {
			e1.printStackTrace();
		}

		try {
			// 2.得到要想注入属性的具体对象
			person = (Person) descriptor.getPropertyType().newInstance();

			// 3.得到该属性的写方法【setPerson()】
			method = descriptor.getWriteMethod();

		} catch (InstantiationException | IllegalAccessException e1) {
			e1.printStackTrace();
		}

		// 4.得到写方法的注解
		Annotation annotation = method.getAnnotation(InjectPerson.class);

		// 5.得到注解上的信息【注解的成员变量就是用方法来定义的】
		Method[] methods = annotation.getClass().getMethods();

		// 6.将注解上的信息填充到person对象上
		for (Method m : methods) {

			// 得到注解上属性的名字【age或name】
			String name = m.getName();

			// 看看Person对象有没有与之对应的方法【setAge(),setName()】
			try {
				// 6.1这里假设：有与之对应的写方法，得到写方法
				PropertyDescriptor descriptor1 = new PropertyDescriptor(name, Person.class);
				Method method1 = descriptor1.getWriteMethod();// setAge(), setName()

				// 得到注解中的值
				Object o = m.invoke(annotation);

				// 调用Person对象的setter方法，将注解上的值设置进去
				method1.invoke(person, o);

			} catch (Exception e) {
				// 6.2 Person对象没有与之对应的方法，会跳到catch来。我们要让它继续遍历注解就好了
				continue;
			}
		}

		// 当程序遍历完之后，person对象已经填充完数据了
		// 7.将person对象赋给PersonDao【通过写方法】
		PersonDao personDao = new PersonDao();
		try {
			method.invoke(personDao, person);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		System.out.println(personDao.getPerson().getUsername());
		System.out.println(personDao.getPerson().getAge());
	}

	public static void InjectPersonFiled() {

		// 1.得到想要注入的属性
		Class<? extends Object> persondao = PersonDao.class;
		Field field = null;
		try {
			field = persondao.getDeclaredField("person");
		} catch (NoSuchFieldException | SecurityException e1) {
			e1.printStackTrace();
		}

		// 2.得到属性的具体对象
		Person person = null;
		try {
			if (field != null) {
				person = (Person) field.getType().newInstance();

				// 3.得到属性上的注解
				Annotation annotation = null;
				if (field.isAnnotationPresent(InjectPerson.class)) {
					annotation = field.getAnnotation(InjectPerson.class);
				}
				if (annotation != null) {
					// 4.得到注解的属性【注解上的属性使用方法来表示的】
					Method[] methods = annotation.getClass().getMethods();

					// 5.将注入的属性填充到person对象上
					for (Method method : methods) {

						// 5.1得到注解属性的名字
						String name = method.getName();
						// 查看一下Person对象上有没有与之对应的写方法
						try {
							// 如果有
							PropertyDescriptor descriptor = new PropertyDescriptor(name, Person.class);

							// 得到Person对象上的写方法
							Method method1 = descriptor.getWriteMethod();

							// 得到注解上的值
							Object o = method.invoke(annotation, null);

							// 填充person对象
							method1.invoke(person, o);
						} catch (IntrospectionException e) {

							// 如果没有想对应的属性，继续循环
							continue;
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							e.printStackTrace();
						}
					}

					// 循环完之后，person就已经填充好数据了
					// 6.把person对象设置到PersonDao中
					PersonDao personDao = new PersonDao();
					field.setAccessible(true);
					field.set(personDao, person);

					System.out.println(personDao.getPerson().getUsername());
				}
			}
		} catch (InstantiationException | IllegalAccessException e1) {
			e1.printStackTrace();
		}

	}

}
