package com.zs.pms.vo;

public class QueryLogin {
	// 用户名
	private String loginname;
	// 密码
	private String password;
	// 是否可用
	private int isenabled;
	//验证码
	private String chkcode;

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIsenabled() {
		return isenabled;
	}

	public void setIsenabled(int isenabled) {
		this.isenabled = isenabled;
	}

	public String getChkcode() {
		return chkcode;
	}

	public void setChkcode(String chkcode) {
		this.chkcode = chkcode;
	}
	

}
