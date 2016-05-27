/**
 * Copyright 2016 hwadee.com Co.,Ltd. All right reserved.
 *
 * weibo
 */
package com.hwadee.weibo.service.impl;

import javax.security.auth.login.LoginException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwadee.weibo.dao.AccountDao;
import com.hwadee.weibo.entity.Account;
import com.hwadee.weibo.service.interfaces.AccountService;

/**
 * @author 张三
 * @email zs@163.com
 * @version v1.0
 * @2016年5月23日 下午3:57:02
 * TODO
 */
@Service
public class AccountServiceImpl implements AccountService {
	
	private static final transient Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Autowired
	private AccountDao accountDao;
	
	@Override
	public Account login(Account account) throws LoginException {
		log.info("{}偿试登录", account.getEmail());
		
		Account na = accountDao.findByAccount(account.getEmail());
		//如果na为空， 表达该帐号xxxx
		if( na == null ){
			log.warn("{}登录失败,用户名或不存在", account.getEmail());
			throw new LoginException("用户名不存在!");
		} else if( ! account.getPassword().equals( na.getPassword() ) ){
			log.warn("{}登录失败,或密码错误", account.getEmail());
			throw new LoginException("密码错误!");
		}
		
		//na.setPassword(null);
		
		log.info("{}登录成功",account.getEmail());
		return na;
	}

	/**
	 * 
	 */
	@Override
	public int reg(Account account) throws Exception {
		int count = accountDao.insert(account);
		return account.getAccountId();
	}

}
