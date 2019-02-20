package com.zs.pms.service;

import java.util.List;

import com.zs.pms.po.TDep;
import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUser;
import com.zs.pms.vo.QueryUser;

/**
 * @author Administrator
 *
 */
public interface UserService {

	/**
	 * 测试
	 */
	public void HelloSpring();

	/**
	 * 查询列表权限
	 * 
	 * @param id
	 * @return
	 */
	public List<TPermission> queryByUid(int id);

	/**
	 * 根据原有的权限整理菜单
	 * 
	 * @param pers
	 * @return
	 */
	public List<TPermission> genMenu(List<TPermission> pers);

	/**
	 * 根据条件查询
	 * 
	 * @param query
	 * @return
	 */
	public List<TUser> queryByCon(QueryUser query);
	


	/**
	 * 新增 返回主键
	 * 
	 * @param user
	 * @return
	 */
	public int insertUser(TUser user);

	/**
	 * 批量删除
	 * 
	 * @param id
	 */
	public void deleteByIds(int[] ids);

	/**
	 * 删除一个
	 * 
	 * @param id
	 */
	public void deleteUser(int id);

	/**
	 * 修改
	 * 
	 * @param user
	 */
	public void updateUser(TUser user);
	/**通过id获取一条用户信息
	 * @param id
	 * @return
	 */
	public TUser queryById(int id);

	/**
	 * 分页查询
	 * 
	 * @param page
	 * @param query
	 * @return
	 */
	public List<TUser> QueryByPage(int page, QueryUser query);
	/**计算总页数
	 * @param query
	 * @return
	 */
	public int QueryPageCont(QueryUser query);
}
