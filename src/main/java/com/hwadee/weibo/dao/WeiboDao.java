/**
 * Copyright 2016 hwadee.com Co.,Ltd. All right reserved.
 *
 * weibo
 */
package com.hwadee.weibo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hwadee.weibo.entity.Weibo;

/**
 * @author 张三
 * @email zs@163.com
 * @version v1.0
 * @2016年5月24日 上午10:05:00
 * TODO
 */
public interface WeiboDao {
	
	/**
	 * 获得关注微博总条数
	 * @param accountId
	 * @return
	 */
	int count(int accountId);
	
	/**
	 * 查询关注人所以微博
	 * @param accountId 当前登录用户
	 * @param start 分页起始索引
	 * @param size 每多少条
	 * @return
	 */
	List<Weibo> findById(@Param("accountId") int accountId, @Param("start")int start, @Param("size")int size);
	
	/**
	 * 插入微博
	 * @param weibo
	 * @return
	 */
	int insert(Weibo weibo);
	

}
