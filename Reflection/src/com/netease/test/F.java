package com.netease.test;

/**
 * @author louxj424
 * @date 创建时间：2018年4月16日 上午9:28:54
 * @version 0.1.0
 * @since jdk 1.7.0
 */

public class F {

	public int num;

	private String str;

	F() {
	}

	F(int num, String str) {
		this.num = num;
		this.str = str;
	}

	void print() {
		System.out.println("test in class F");
	}
}
