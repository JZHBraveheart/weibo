/**
 * Copyright 2016 hwadee.com Co.,Ltd. All right reserved.
 *
 * weibo
 */
package com.hwadee.weibo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hwadee.weibo.dao.AccountDao;
import com.hwadee.weibo.dao.WeiboDao;
import com.hwadee.weibo.dto.PageInfo;
import com.hwadee.weibo.entity.Weibo;
import com.hwadee.weibo.service.interfaces.WeiboService;

/**
 * @author 张三
 * @email zs@163.com
 * @version v1.0
 * @2016年5月24日 上午10:24:29
 * TODO
 */
@Service
public class WeiboServiceImpl implements WeiboService {
	
	@Autowired
	private WeiboDao weiboDao;
	
	@Autowired
	private AccountDao accountDao;

	
	@Override
	public PageInfo<Weibo> list(int accountId, int current) throws Exception {
		
		PageInfo<Weibo> pi = new PageInfo<Weibo>( current );
		
		int count = weiboDao.count(accountId);
		
		List<Weibo> list = weiboDao.findById(accountId, pi.getStart(), pi.getSize());
		
		pi.setCount(count);
		pi.setList(list);
		
		return pi;
	}


	@Transactional
	@Override
	public Weibo weibo(Weibo weibo) throws Exception {
		System.out.println(weibo);
		
		weibo.setWdatetime(new Date());
		
		int ir = weiboDao.insert(weibo);
		
		int ur = accountDao.updateWeibo(weibo.getAccount());
		
		System.out.println(weibo);
		return weibo;
	}

}
