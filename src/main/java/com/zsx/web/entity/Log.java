package com.zsx.web.entity;

import java.sql.Time;

public class Log {
	
	private String Description;
	private String Method;
	private String Type;
	private String ReuquestIp;
	private int ExceptionCode;
	private String ExceptionDetail;
	private String Params;
	private String CreateBy;
	private Time CreateDate;
	
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getMethod() {
		return Method;
	}
	public void setMethod(String method) {
		Method = method;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getReuquestIp() {
		return ReuquestIp;
	}
	public void setReuquestIp(String reuquestIp) {
		ReuquestIp = reuquestIp;
	}
	public int getExceptionCode() {
		return ExceptionCode;
	}
	public void setExceptionCode(int exceptionCode) {
		ExceptionCode = exceptionCode;
	}
	public String getExceptionDetail() {
		return ExceptionDetail;
	}
	public void setExceptionDetail(String exceptionDetail) {
		ExceptionDetail = exceptionDetail;
	}
	public String getParams() {
		return Params;
	}
	public void setParams(String params) {
		Params = params;
	}
	public String getCreateBy() {
		return CreateBy;
	}
	public void setCreateBy(String createBy) {
		CreateBy = createBy;
	}
	public Time getCreateDate() {
		return CreateDate;
	}
	public void setCreateDate(Time createDate) {
		CreateDate = createDate;
	}
	
	
	
}
