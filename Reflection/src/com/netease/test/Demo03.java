package com.netease.test;
/** 
* @author  louxj424
* @date 创建时间：2018年4月16日 上午9:30:48 
* @version 0.1.0  
* @since jdk 1.7.0
 */
public class Demo03 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		F f=new F();
		ClassUtil.printClassMethodMessage(f);
		
		System.out.println("=======================");
		
		ClassUtil.printFieldMessage(f);
		
		System.out.println("=======================");
		
		ClassUtil.printConstructorMessage(f);
		
	}
}
