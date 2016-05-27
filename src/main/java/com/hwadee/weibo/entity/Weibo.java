/**
 * Copyright 2016 hwadee.com Co.,Ltd. All right reserved.
 *
 * weibo
 */
package com.hwadee.weibo.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * @author 张三
 * @email zs@163.com
 * @version v1.0
 * @2016年5月23日 下午3:37:16
 * TODO
 */
public class Weibo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -465319302342301146L;
	
	
	private int wid;
	private Account account;
	private String content;
	private int liked;
	private int comment;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date wdatetime;

	public int getWid() {
		return wid;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getLiked() {
		return liked;
	}

	public void setLiked(int liked) {
		this.liked = liked;
	}

	public int getComment() {
		return comment;
	}

	public void setComment(int comment) {
		this.comment = comment;
	}

	public Date getWdatetime() {
		return wdatetime;
	}

	public void setWdatetime(Date wdatetime) {
		this.wdatetime = wdatetime;
	}
	
	
	@Override
	public String toString() {
		return "Weibo [wid=" + wid + ", account=" + account + ", content=" + content + ", liked=" + liked + ", comment="
				+ comment + ", wdatetime=" + wdatetime + "]";
	}

}
