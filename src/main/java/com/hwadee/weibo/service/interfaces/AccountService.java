/**
 * Copyright 2016 hwadee.com Co.,Ltd. All right reserved.
 *
 * weibo
 */
package com.hwadee.weibo.service.interfaces;

import javax.security.auth.login.LoginException;

import com.hwadee.weibo.entity.Account;

/**
 * @author 张三
 * @email zs@163.com
 * @version v1.0
 * @2016年5月23日 下午3:53:32
 * TODO
 */
public interface AccountService {
	
	/**
	 * 用户登录
	 * @param account
	 * @return
	 * @throws LoginException
	 */
	Account login(Account account) throws LoginException;
	
	/**
	 * 
	 * @param account
	 * @return
	 * @throws Exception
	 */
	int reg(Account account) throws Exception;
	

}
