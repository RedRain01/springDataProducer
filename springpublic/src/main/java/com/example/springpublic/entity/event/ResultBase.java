package com.example.springpublic.entity.event;



public class ResultBase {
	private String code;
	private String message;

	public ResultBase() {
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResultBase(String code, String message) {
		this.code = code;
		this.message = message;
	}
	static public ResultBase OK() {
		return new ResultBase("0", "ok");
	}

}
