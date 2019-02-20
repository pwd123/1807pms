package com.zs.pms.dao;

import java.util.List;

import com.zs.pms.po.TDep;
import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUser;
import com.zs.pms.vo.QueryUser;

public interface UserDao {

	// 根据用户id获得权限列表
	public List<TPermission> queryByUid(int id);
	//根据条件查询
	public List<TUser> queryByCon(QueryUser query);
	//新增    返回主键
	public int insertUser(TUser user);
	//批量删除
	public void deleteByIds(int [] ids);
	//删除一个
	public void deleteUser(int id);
	//修改
	public void updateUser(TUser user);
	//分页查询
	public List<TUser> QueryByPage(QueryUser query);
	//获取总条数
	public int QueryCount(QueryUser query);
	//通过id获取一条用户信息
	public TUser queryById(int id);
}
