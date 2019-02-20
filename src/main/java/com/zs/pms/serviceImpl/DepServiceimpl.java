package com.zs.pms.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zs.pms.dao.DepDao;
import com.zs.pms.po.TDep;
import com.zs.pms.service.DepService;

@Service
public class DepServiceimpl implements DepService {
	@Autowired
	DepDao dao;

	@Override
	public List<TDep> queryByPid(int pid) {
		// TODO Auto-generated method stub
		
		return dao.queryByPid(pid);
	}

}
