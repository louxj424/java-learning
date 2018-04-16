package com.netease.annotationDemo01;
/** 
* @author  louxj424
* @date 创建时间：2018年4月16日 下午7:59:04 
* @version 0.1.0  
* @since jdk 1.7.0
 */
public class Calculator {
	//注解拥有什么属性，在修饰的时候就要给出相对应的值
    @MyAnnotation(username = "zhongfucheng", age = 20)
    public void add(String username, int age) {
    	System.out.println("username:"+username+",age="+age);
    }
    
    

}
