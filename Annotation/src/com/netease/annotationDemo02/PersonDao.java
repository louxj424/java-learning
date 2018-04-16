package com.netease.annotationDemo02;

/** 
* @author  louxj424
* @date 创建时间：2018年4月16日 下午8:20:36 
* @version 0.1.0  
* @since jdk 1.7.0
 */
public class PersonDao {

	@InjectPerson(username = "zhangsan",age = 18) 
	private Person person;

	public Person getPerson() {
		return person;
	}

	@InjectPerson(username="louxj424",age=27)
	public void setPerson(Person person) {
		this.person = person;
	}
	
	
}
