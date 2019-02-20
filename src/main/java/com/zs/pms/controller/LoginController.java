package com.zs.pms.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService;
import com.zs.pms.util.DateUtil;
import com.zs.pms.util.MD5;
import com.zs.pms.vo.QueryLogin;
import com.zs.pms.vo.QueryUser;

//注解说明是一个控制器
@Controller
public class LoginController {

	@Autowired
	UserService us;

	// 去登陆页面的
	@RequestMapping("/tologin.do")
	public String ToLogin() {

		return "login";
	}

	@RequestMapping("/login.do")
	public String login(QueryLogin login, ModelMap model, HttpSession session) {

		// 验证验证码
		// 获得一开始生成的验证码
		String chkcode = (String) session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		// 判断输入的信息和生成的验证码是否一致，如果不一致就直接返回登录页面，如果一致再去验证账号和密码
		// 不区分大小写的验证
		if (!chkcode.equalsIgnoreCase(login.getChkcode())) {
			model.addAttribute("MSG", "验证码错误，请重新输入");
			return "login";
		}
		// 验证账号密码
		// 装载数据
		QueryUser query = new QueryUser();
		query.setLoginname(login.getLoginname());

		// MD5加密
		MD5 md5 = new MD5();

		query.setPassword(md5.getMD5ofStr(login.getPassword()));
		// 将参数直接设置成可用
		query.setIsenabled(1);
		// 调用登录验证的方法
		List<TUser> users = us.queryByCon(query);
		// 判断查询的返回值
		if (users == null || users.size() != 1) {
			model.addAttribute("MSG", "用户名或密码错误，请重新输入.....");
			return "login";
		}

		//将用户信息放入session中
		session.setAttribute("CUSER", users.get(0));
		
		return "main";
	}

	@RequestMapping("/top.do")
	public String top(HttpSession session) {

		//把当前时间放进session中
		session.setAttribute("TODAY", DateUtil.getStrDate());
		
		return "top";
	}

	@RequestMapping("/right.do")
	public String main() {

		return "right";
	}

	@RequestMapping("/left.do")
	public String menu(HttpSession session,ModelMap model) {

		//获得当前登陆用户的信息
		TUser cu = (TUser) session.getAttribute("CUSER");
		//获得用户的权限列表
		List<TPermission> list1 = us.queryByUid(cu.getId());
		//返回权限列表菜单
		model.addAttribute("MENU", us.genMenu(list1));
		
		return "left";
	}
	

}
