package com.zs.pms.service;

import java.util.List;

import com.zs.pms.po.TDep;

/**
 * @author Administrator
 *
 */
public interface DepService {

	/**
	 * 获取部门信息，带到新增页面中
	 * 
	 * @param pid
	 * @return
	 */
	public List<TDep> queryByPid(int pid);
}
