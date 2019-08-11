package org.csl.study.spring.source.exception;

public class ErrorCode {

	 public static final String  SUCCESS = "0000";
	 /**
	  * 方法参数异常，进入不了方法
	  */
	 public static final String  Method_Params_Error = "0001";
	
	 //1开头的：业务异常  1001 普通业务异常
	 public static final String  Business_Common_Error = "1000";
	 //业务异常：数据校验异常
	 public static final String  Business_DataValid_Error = "1001";
	 //数据库异常
	 public static final String  DataBase_Error = "2000";
	 
	 //连不上服务器
	 public static final String  ThirdPart_Connect_TimeOut = "3100";
	 //服务器未及时响应
	 public static final String  ThirdPart_Socket_TimeOut = "3200";
	 //服务器返回数据异常或者返回错误
	 public static final String  ThirdPart_Unknow_Error = "3400";
	 
	 /***
	  * 系统未知异常
	  */
	 public static final String  INTERNAL_SERVER_ERROR = "9999";
}
