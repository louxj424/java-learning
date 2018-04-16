package com.netease.annotationDemo;
/** 
* @author  louxj424
* @date 创建时间：2018年4月16日 下午2:58:46 
* @version 0.1.0  
* @since jdk 1.7.0
 */

@Desp("i am a class annotation")
public class Child implements People{

	@Desp("i am a method annotation")
	@Override	
	public String name() {
		return null;
	}

	@Override
	public int age() {
		return 0;
	}

	@Override
	public void work() {
	}

}
