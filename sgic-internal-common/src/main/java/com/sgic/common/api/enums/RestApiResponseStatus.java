package com.sgic.common.api.enums;

public enum RestApiResponseStatus {

	OK(20000, "OK"), CREATED(20100, "Record Successfully Created"), UPDATED(20200, "Record Successfully Updated"), DELETED(20300, "Record Successfully Deleted"), RECEIVED(20400, "Record(s) Successfully Received"), VALIDATION_FAILURE(40000, "VALIDATION_FAILURE"), NOT_FOUND(40400, "Id Not Found"), FORBIDDEN(40300, "FORBIDDEN"), ERROR(50000, "ERROR");

   private Integer code;
   
   private String message;
  
   private RestApiResponseStatus(Integer code, String message) {
	   this.code = code;
	   this.message = message;
   }
  
  	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}
 
	@Override
	public String toString() {
		return code + ":" + message;
	}

}
