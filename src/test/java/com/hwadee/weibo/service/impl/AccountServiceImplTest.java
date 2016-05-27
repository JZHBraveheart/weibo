/**
 * Copyright 2016 hwadee.com Co.,Ltd. All right reserved.
 *
 * weibo
 */
package com.hwadee.weibo.service.impl;

import javax.security.auth.login.LoginException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hwadee.weibo.dto.PageInfo;
import com.hwadee.weibo.entity.Account;
import com.hwadee.weibo.entity.Weibo;
import com.hwadee.weibo.service.interfaces.AccountService;
import com.hwadee.weibo.service.interfaces.WeiboService;

/**
 * @author 张三
 * @email zs@163.com
 * @version v1.0
 * @2016年5月23日 下午4:04:07
 * TODO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-dao.xml"})
public class AccountServiceImplTest {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private WeiboService weiboService;
	
	@Test
	public void testLogin() throws LoginException{
		
		Account account = new Account();
		account.setEmail("zssrsdfgsdf@163.com");
		account.setPassword("123456");
		
		
		Account nc = accountService.login(account);
		
		Assert.assertNotNull( nc );
		
		System.out.println( nc );
		
	}
	
	@Test
	public void testReg() throws Exception{
		Account a = new Account();
		a.setEmail("ls2@163.com");
		a.setPassword("123456");
		a.setPic("/h.jpg");
		
		int id = accountService.reg(a);
		
		System.out.println("accountid=" + id);
		
		Assert.assertEquals(18, id);
		
	}
	
	@Test
	public void testWeibo() throws Exception{
		
		PageInfo<Weibo> pi = weiboService.list(18, 1);
		
		System.out.println( pi );
		
	}
	
}
