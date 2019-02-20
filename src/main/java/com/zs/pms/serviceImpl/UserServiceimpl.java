package com.zs.pms.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zs.pms.dao.UserDao;
import com.zs.pms.po.TDep;
import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService;
import com.zs.pms.util.Contents;
import com.zs.pms.vo.QueryUser;

@Service
@Transactional
public class UserServiceimpl implements UserService {
	@Autowired
	UserDao dao;

	@Override
	public void HelloSpring() {
		// TODO Auto-generated method stub
		System.out.println("hello------spring");
	}

	@Override
	public List<TPermission> queryByUid(int id) {
		// TODO Auto-generated method stub
		return dao.queryByUid(id);
	}

	@Override
	public List<TPermission> genMenu(List<TPermission> pers) {
		// TODO Auto-generated method stub
		// 创建新容器
		List<TPermission> list = new ArrayList<>();
		// 遍历权限列表
		for (TPermission per : pers) {
			// 一级菜单
			if (per.getLev() == 1) {
				// 加载该一级菜单下的二级菜单
				// 遍历
				for (TPermission per2 : pers) {
					// 二级权限的上级id等于以及权限id
					if (per2.getPid() == per.getId()) {
						// 添加子权限
						per.addChlid(per2);
					}
				}
				list.add(per);
			}
		}
		return list;
	}

	@Override
	public List<TUser> queryByCon(QueryUser query) {
		// TODO Auto-generated method stub

		return dao.queryByCon(query);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int insertUser(TUser user) {
		// TODO Auto-generated method stub
		dao.insertUser(user);
//		int a=1/0;
//		dao.insertUser(user);
		return user.getId();
	}

	@Override
	public void deleteByIds(int[] ids) {
		// TODO Auto-generated method stub
		dao.deleteByIds(ids);
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		dao.deleteUser(id);
	}

	@Override
	public void updateUser(TUser user) {
		// TODO Auto-generated method stub
		dao.updateUser(user);
	}

	@Override
	public List<TUser> QueryByPage(int page, QueryUser query) {
		// TODO Auto-generated method stub
		// 起始数 从1开始
		int start = (page - 1) * Contents.PAGECOUNT + 1;
		// 截止数
		int end = page * Contents.PAGECOUNT;
		query.setStart(start);
		query.setEnd(end);
		return dao.QueryByPage(query);
	}

	@Override
	public int QueryPageCont(QueryUser query) {
		// TODO Auto-generated method stub
		// 获得总条数
		int cont = dao.QueryCount(query);
		if (cont % Contents.PAGECOUNT == 0) {
			return cont / Contents.PAGECOUNT;
		} else {
			return cont / Contents.PAGECOUNT + 1;
		}
	}

	@Override
	public TUser queryById(int id) {
		// TODO Auto-generated method stub
		return dao.queryById(id);
	}



}
