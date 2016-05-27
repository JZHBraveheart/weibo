package com.hwadee.weibo.dto;

import java.util.List;

public class PageInfo<T> {
	
	/**
	 * 共多少条
	 */
	private int count;
	
	/**
	 * 共多少页
	 */
	private int total;
	
	/**
	 * 当前页
	 */
	private int current = 1;
	
	/**
	 * 每页多少条
	 */
	private int size = 5;
	
	
	private int start;
	
	/**
	 * 分页查询结果集合
	 */
	private List<T> list;
	
	

	public PageInfo() {}

	public PageInfo(int current) {
		this.current = current;
		
		this.start = (current - 1) * this.size; 
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
		
		this.total = count / size + ((count % size > 0 ) ? 1 : 0);
		
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
		this.start = (current - 1) * this.size;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getStart() {
		return start;
	}
	
	
	@Override
	public String toString() {
		return "PageInfo [count=" + count + ", total=" + total + ", current=" + current + ", size=" + size + ", start="
				+ start + ", list=" + list + "]";
	}

}
