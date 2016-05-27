/**
 * Copyright 2016 hwadee.com Co.,Ltd. All right reserved.
 *
 * weibo
 */
package com.hwadee.weibo.dao;

import com.hwadee.weibo.entity.Account;

/**
 * @author 张三
 * @email zs@163.com
 * @version v1.0
 * @2016年5月23日 下午3:31:32
 * TODO
 */
public interface AccountDao {
	
	/**
	 * 
	 * @param account
	 * @return
	 */
	Account findByAccount(String account);
	
	/**
	 * 
	 * @param account
	 * @return
	 */
	int insert(Account account);
	
	
	int updateWeibo(Account account);

}
