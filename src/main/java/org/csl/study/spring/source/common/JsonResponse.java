package org.csl.study.spring.source.common;

import org.csl.study.spring.source.exception.BusinessException;
import org.csl.study.spring.source.exception.ErrorCode;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JsonResponse {

  //失败
  public static final int Error = -1;
  
  public static final int SUCCESS = 0;
  //登录状态失效
  public static final int InValidLogin = 1001;
  
  private long status;
  
  private String code;
  
  private String message;
  
  private Object data;

  public JsonResponse()
  {
    this.status = SUCCESS;
    this.code = ErrorCode.SUCCESS;
    this.message = "Success";
  }
  public JsonResponse(long status, String message, Object data)
  {
    this.status = status;
    this.message = message;
    this.data = data;
  }
  
  public JsonResponse(Object data)
  {
	if((data instanceof BusinessException)){
		  this.status = Error;
		  this.code = ((BusinessException)data).getErrorCode();
	      this.message = ((BusinessException)data).getMessage();
		
	}else if ((data instanceof Exception)) {
	      this.status = Error;
	      this.code = ErrorCode.Business_Common_Error;
	      this.message = ((Exception)data).getLocalizedMessage();
    } else {
	      this.status = SUCCESS;
	      this.code = ErrorCode.SUCCESS;
	      this.message = "Success";
	      this.data = data;
    }
  }
  public JsonResponse data(Object data) {
	this.status = SUCCESS;
	this.code = ErrorCode.SUCCESS;
    this.data = data;
    return this;
  }
  public JsonResponse success( ){
	  this.status = SUCCESS;
	  this.code = ErrorCode.SUCCESS;
	  this.message = "Success";
	  return this;
  }
  public JsonResponse error(String message){
	  this.status = Error;
	  this.code = ErrorCode.Business_Common_Error;
	  this.message = message;
	  return this;
  }
  public JsonResponse error(String code,String message){
	  this.status = Error;
	  this.code = code;
	  this.message = message;
	  return this;
  }
  public JsonResponse InValidLogin(String message){
	  this.status = InValidLogin;
	  this.code = ErrorCode.Business_Common_Error;
	  if(message != null && !"".equals(message)){
		  this.message = message;
	  }else{
		  this.message = "请先登录！";
	  }
	  return this;
  }
}
