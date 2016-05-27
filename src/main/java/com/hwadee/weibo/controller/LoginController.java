/**
 * Copyright 2016 hwadee.com Co.,Ltd. All right reserved.
 *
 * weibo
 */
package com.hwadee.weibo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hwadee.weibo.entity.Account;
import com.hwadee.weibo.service.interfaces.AccountService;

/**
 * @author 张三
 * @email zs@163.com
 * @version v1.0
 * @2016年5月24日 下午3:51:50
 * TODO
 */
@Controller
public class LoginController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/login")
	public String login(Account account, HttpSession session){
		
		try {
			
			account = accountService.login(account);
			
			session.setAttribute("account", account);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		//res.sendRedirect(arg0);
		return "redirect:/u/" + account.getAccountId() + "/home";
	}

}
