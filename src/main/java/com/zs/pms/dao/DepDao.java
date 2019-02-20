package com.zs.pms.dao;

import java.util.List;

import com.zs.pms.po.TDep;

public interface DepDao {

	//获取部门信息，带到新增页面中
	public List<TDep> queryByPid(int pid);
}
