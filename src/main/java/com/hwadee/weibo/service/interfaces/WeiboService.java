/**
 * Copyright 2016 hwadee.com Co.,Ltd. All rights reserved.
 *
 * weibo
 */
package com.hwadee.weibo.service.interfaces;

import com.hwadee.weibo.dto.PageInfo;
import com.hwadee.weibo.entity.Weibo;

/**
 * @author 张三
 * @email zs@163.com
 * @version v1.0
 * @2016年5月24日 上午10:19:30
 * TODO
 */
public interface WeiboService {

	/**
	 * 查询当前用户微薄信息列表
	 * @param accountId
	 * @param current
	 * @return
	 * @throws Exception
	 */
	PageInfo<Weibo> list( int accountId, int current) throws Exception;
	
	/**
	 * 发微博
	 * @param weibo
	 * @return
	 * @throws Exception
	 */
	Weibo weibo(Weibo weibo) throws Exception;
	
	
}
