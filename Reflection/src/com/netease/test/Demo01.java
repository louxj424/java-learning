package com.netease.test;
/** 
* @author  louxj424
* @date 创建时间：2018年4月16日 上午9:29:39 
* @version 0.1.0  
* @since jdk 1.7.0
 */

public class Demo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		F f = new F();

		// 第一种表达方式
		Class c1 = F.class;// 这种表达方式同时也告诉了我们任何一个类都有一个隐含的静态成员变量class

		// 第二种表达方式
		Class c2 = f.getClass();// 这种表达方式在已知了该类的对象的情况下通过getClass方法获取

		// 第三种表达方式
		Class c3 = null;
		try {
			c3 = Class.forName("com.netease.test.F");// 类的全称
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println(c1.equals(c2));
		System.out.println(c2.equals(c3));

		try {
			F foo = (F) c1.newInstance();// foo就表示F类的实例化对象
			foo.print();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}
}