/**
 * Copyright 2016 hwadee.com Co.,Ltd. All right reserved.
 *
 * weibo
 */
package com.hwadee.weibo.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author 张三
 * @email zs@163.com
 * @version v1.0
 * @2016年5月23日 下午3:32:51
 * TODO
 */
public class Account implements Serializable {

	private static final long serialVersionUID = -5201444145446943166L;
	
	
	private int accountId;
	private String email;
	
	@JsonIgnore
	private String password;
	private String name;
	private String pic;
	private int follow;
	private int fans;
	private int weibo;
	
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public int getFollow() {
		return follow;
	}
	public void setFollow(int follow) {
		this.follow = follow;
	}
	public int getFans() {
		return fans;
	}
	public void setFans(int fans) {
		this.fans = fans;
	}
	public int getWeibo() {
		return weibo;
	}
	public void setWeibo(int weibo) {
		this.weibo = weibo;
	}
	
	
	
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", email=" + email + ", password=" + password + ", name=" + name
				+ ", pic=" + pic + ", follow=" + follow + ", fans=" + fans + ", weibo=" + weibo + "]";
	}

}
