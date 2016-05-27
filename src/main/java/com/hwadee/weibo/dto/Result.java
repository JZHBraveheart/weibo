/**
 * Copyright 2016 hwadee.com Co.,Ltd. All right reserved.
 *
 * weibo
 */
package com.hwadee.weibo.dto;

/**
 * @author 张三
 * @email zs@163.com
 * @version v1.0
 * @2016年5月26日 上午11:08:05
 * TODO
 */
public class Result<T> {
	
	
	private int code;
	private String msg;
	
	
	private T obj;


	public int getCode() {
		return code;
	}

	public Result() { }


	public Result(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Result(int code, String msg, T obj) {
		this.code = code;
		this.msg = msg;
		this.obj = obj;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public T getObj() {
		return obj;
	}


	public void setObj(T obj) {
		this.obj = obj;
	}
	
	
	

}
