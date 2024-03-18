package com.wileyedge;

import java.util.Date;

public class ExceptionResponse {
      private String msg;
      private String details;
      private Date timestamp;
	public ExceptionResponse(String msg, String details, Date timestamp) {
		super();
		this.msg = msg;
		this.details = details;
		this.timestamp = timestamp;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
      
}
