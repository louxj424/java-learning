package com.netease.test;
/** 
* @author  louxj424
* @date 创建时间：2018年4月16日 上午9:30:06 
* @version 0.1.0  
* @since jdk 1.7.0
 */
public class Demo02 {
	public static void main(String[] args) {
		Class c1 = int.class;// int 的类类型
		Class c2 = Integer.class;// Integer的类类型
		Class c3 = String.class;// String类的类类型
		Class c4 = void.class; //void的类类型
		System.out.println(c1.getName());
		System.out.println(c2.getName());
		System.out.println(c2.getSimpleName());
		System.out.println(c3.getName());
		System.out.println(c3.getSimpleName());
		System.out.println(c4.getName());
	}
}
