import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zs.pms.po.TDep;
import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService;
import com.zs.pms.vo.QueryUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationcontext.xml")
public class TestUser {
	@Autowired
	UserService us;

	public void testService() {
		us.HelloSpring();
	}

	public void testlogin() {
		for (TPermission per : us.queryByUid(1001)) {
			System.out.println(per.getPname());
		}
	}

	@Test
	public void testlogin2() {
		List<TPermission> list1 = us.queryByUid(1001);
		for (TPermission per : list1) {
			System.out.println(per.getPname());
		}
		System.out.println("-----------------------------整理后的权限列表------------------");
		for (TPermission per1 : us.genMenu(list1)) {
			// 一级权限
			System.out.println(per1.getPname());
			for (TPermission per2 : per1.getChildren()) {
				System.out.println("------" + per2.getPname());
			}
		}
	}
	
	public void testCon() {
		QueryUser query = new QueryUser();
		query.setLoginname("test");
		query.setPassword("1234");
		System.out.println(us.queryByCon(query).size());
	}
	
	public void testInsert() {
	    TUser user=new TUser();
	    user.setLoginname("test新增-trans");
	    user.setPassword("xinzeng");
	    user.setSex("女");
	    user.setBirthday(new Date());
	    user.setEmail("xinzeng12@qq.com");
	    TDep dept=new TDep();
	    dept.setId(1);
	    user.setDept(dept);
	    user.setRealname("新增测试3");
	    user.setCreator(1);
	    user.setPic("1234567.jgp");
	    user.setIsenabled(1);
	    System.out.println(us.insertUser(user));
	}
	
	public void testDeleteByIds() {
		int [] ids= {1013,1012};
		us.deleteByIds(ids);
	}
	
	public void testUpdate() {
		TUser user=new TUser();
		user.setId(1011);
		user.setUpdator(1001);
		user.setLoginname("修改测试0");
		user.setIsenabled(1);
		user.setPassword("1234567890");
		us.updateUser(user);
	}
	
	public void testDelete() {
		us.deleteUser(1014);
	}
	
	public void testpage() {
    QueryUser query=new QueryUser();
    query.setSex("女");
    for(TUser tuser:us.QueryByPage(1, query)) {
    	System.out.println(tuser);
    }
    System.out.println("共"+us.QueryPageCont(query)+"页");
	}
}
