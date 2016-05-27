/**
 * Copyright 2016 hwadee.com Co.,Ltd. All right reserved.
 *
 * weibo
 */
package com.hwadee.weibo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hwadee.weibo.dto.PageInfo;
import com.hwadee.weibo.dto.Result;
import com.hwadee.weibo.entity.Account;
import com.hwadee.weibo.entity.Weibo;
import com.hwadee.weibo.service.interfaces.WeiboService;

/**
 * @author 张三
 * @email zs@163.com
 * @version v1.0
 * @2016年5月24日 下午4:12:54
 * TODO
 */
@Controller
@RequestMapping("/u")
public class WeiboController {
	
	@Autowired
	private WeiboService weiboService;
	
	
	@RequestMapping("/{accountId}/home")
	public String home(@PathVariable("accountId") int accountId, Model model){
		
		try {
			PageInfo<Weibo> pi = weiboService.list(accountId, 1);
			
			model.addAttribute("pi", pi);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "home/index";
	}
	
	@RequestMapping("/my/weibo/{current}")
	public @ResponseBody PageInfo<Weibo> ajaxWeibo(@PathVariable("current") int current, HttpSession session ){
		PageInfo<Weibo> pi = null;
		try {
			Account account = (Account)session.getAttribute("account");
			pi = weiboService.list(account.getAccountId(), current);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pi;
	}
	
	@RequestMapping(value="/weibo", method=RequestMethod.POST)
	public @ResponseBody Result<Weibo> weibo(Weibo weibo, HttpSession session){
		Result<Weibo> result = new Result<Weibo>();
		try {
			
			Account account  = (Account)session.getAttribute("account");
			weibo.setAccount(account);
			
			weibo = weiboService.weibo(weibo);
			
			result.setCode(200);
			result.setMsg("微博发送成功");
			result.setObj(weibo);
			//return new Result(200, "微博发送成功", weibo);
			//session.setAttribute("account", account);
		} catch (Exception e) {
			result.setCode(500);
			result.setMsg( e.getMessage() );
		}
		return result;
	}

}
