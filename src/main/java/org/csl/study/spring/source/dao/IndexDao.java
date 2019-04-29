package org.csl.study.spring.source.dao;

import org.springframework.stereotype.Repository;

@Repository
public class IndexDao    {

	/**
	 * 
	 */
	public IndexDao() {
		super();
	}
	
	public String getParam() {
		System.out.println(" --IndexDao 执行getParam方法-- >");
		return "RESULT";
	}

	public  void setParam(String str) {
		// TODO Auto-generated method stub
		System.out.println(" --IndexDao 传送值 = "+str);
	}
	
}
