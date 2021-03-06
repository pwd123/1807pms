package com.zs.pms.po;

import java.io.Serializable;
import java.util.Date;

import com.zs.pms.util.DateUtil;

public class TUser implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5293214558214995122L;
	// id
	private int id;
	// 用户名
	private String loginname;
	// 密码
	private String password;
	// 性别
	private String sex;
	// 生日
	private Date birthday;
	// email
	private String email;
	// 部门(一对一关联)
	private TDep dept;
	// 真实姓名
	private String realname;
	// 创建人
	private int creator;
	// 创建时间
	private Date creatime;
	// 修改人
	private int updator;
	// 修改时间
	private Date updatime;
	//头像
	private String pic;
	// 是否可用
	private int isenabled;
	
	private String isenabledTxt;
	
	private String birthdayTxt;

	// get和set方法
	
	public int getId() {
		return id;
	}

	public String getIsenabledTxt() {
		if (isenabled==1) {
			return "可用";
		} else {
			return "不可用";
		}
	}

	public String getBirthdayTxt() {
		return DateUtil.getDateToStr(birthday, "yyyy-mm-dd");
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRealname() {
		return realname;
	}

	public TDep getDept() {
		return dept;
	}

	public void setDept(TDep dept) {
		this.dept = dept;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public int getCreator() {
		return creator;
	}

	public void setCreator(int creator) {
		this.creator = creator;
	}

	public Date getCreatime() {
		return creatime;
	}

	public void setCreatime(Date creatime) {
		this.creatime = creatime;
	}

	public int getUpdator() {
		return updator;
	}

	public void setUpdator(int updator) {
		this.updator = updator;
	}

	public Date getUpdatime() {
		return updatime;
	}

	public void setUpdatime(Date updatime) {
		this.updatime = updatime;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public int getIsenabled() {
		return isenabled;
	}

	public void setIsenabled(int isenabled) {
		this.isenabled = isenabled;
	}

	@Override
	public String toString() {
		return "TUser [id=" + id + ", loginname=" + loginname + ", password=" + password + ", sex=" + sex
				+ ", birthday=" + birthday + ", email=" + email + ", dept=" + dept + ", realname=" + realname
				+ ", creator=" + creator + ", creatime=" + creatime + ", updator=" + updator + ", updatime=" + updatime
				+ ", isenabled=" + isenabled + "]";
	}

}
