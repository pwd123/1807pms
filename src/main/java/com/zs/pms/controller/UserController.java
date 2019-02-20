package com.zs.pms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zs.pms.po.TUser;
import com.zs.pms.service.DepService;
import com.zs.pms.service.UserService;
import com.zs.pms.vo.QueryUser;

@Controller
public class UserController {

	@Autowired
	UserService us;
	@Autowired
	DepService ds;

	/**分页
	 * @param page 页数
	 * @param query 查询条件
	 * @param model 返回查询信息
	 * @return 跳转列表页
	 */
	@RequestMapping("/user/list.do")
	public String list(String page, QueryUser query, ModelMap model) {
		// 如果page是空就赋值为1
		if (page == "" || page == null) {
			page = "1";
		}
		// 返回用户列表分页信息
		model.addAttribute("LIST", us.QueryByPage(Integer.parseInt(page), query));
		// 返回总页数
		model.addAttribute("PAGECONT", us.QueryPageCont(query));
		// 返回当前页
		model.addAttribute("PAGE", page);
		// 返回条件，用于条件查询
		model.addAttribute("QUERY", query);

		return "user/list";
	}

	/**去新增页面
	 * @param model 返回一级部门
	 * @return 跳转到新增页面
	 */
	@RequestMapping("/user/toadd.do")
	public String toAdd(ModelMap model) {

		// 初始化部门信息，去新增页面
		model.addAttribute("DLIST", ds.queryByPid(0));

		return "user/add";
	}
	
	@RequestMapping("/user/add.do")
	public String add(TUser user,HttpSession session) {
		//先把session信息放进TUser中
		TUser cu = (TUser)session.getAttribute("CUSER");
		//获得当前登录人的id
		user.setCreator(cu.getId());
		user.setIsenabled(1);
		user.setPic("");
		us.insertUser(user);
		return "redirect:list.do";
	}

	/**
	 * 批量删除
	 * @param ids id数组   删除的条件
	 * @return 成功返回列表页  跳转url
	 */
	@RequestMapping("/user/deledes.do")
	public String delete(int[] ids) {
		us.deleteByIds(ids);
		// 跳转url
		return "redirect:list.do";
	}

	/**删除
	 * @param id 删除条件
	 * @return  成功返回列表页  跳转url
	 */
	@RequestMapping("/user/delede.do")
	public String delete(int id) {
		us.deleteUser(id);
		// 跳转url
		return "redirect:list.do";
	}

}
