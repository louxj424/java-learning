package com.netease.annotationDemo;

import java.lang.reflect.Method;

/**
 * @author louxj424
 * @date 创建时间：2018年4月16日 下午2:59:55
 * @version 0.1.0
 * @since jdk 1.7.0
 */
public class Test {

	public static void main(String[] args) {
		try {
			// 使用类加载器加载类
			Class c = Class.forName("com.netease.annotationDemo.Child");
			// 找到类上面的注解
			@SuppressWarnings("unchecked")
			boolean isExist = c.isAnnotationPresent(Desp.class);
			// 上面的这个方法是用这个类来判断这个类是否存在Description这样的一个注解
			if (isExist) {
				// 拿到注解实例，解析类上面的注解
				@SuppressWarnings("unchecked")
				Desp d1 = (Desp) c.getAnnotation(Desp.class);
				System.out.println(d1.value());
			}
			
			//获取所有的方法
            Method[] ms = c.getMethods();
            // 遍历所有的方法
            for (Method m : ms) {
				isExist=m.isAnnotationPresent(Desp.class);
				if (isExist) {
					Desp d2=m.getAnnotation(Desp.class);
					System.out.println(d2.value());
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public void test() {
		People people = new Child();
		people.work();
	}

	@Description(desc = "i am clor", author = "louxj424", age = 20)
	public String color() {
		return "red";
	}

}
