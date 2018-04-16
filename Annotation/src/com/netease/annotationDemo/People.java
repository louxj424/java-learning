package com.netease.annotationDemo;
/** 
* @author  louxj424
* @date 创建时间：2018年4月16日 下午2:58:13 
* @version 0.1.0  
* @since jdk 1.7.0
 */
public interface People {
    public String name();
    public int age();
    
    @Deprecated
    public void work();
}
