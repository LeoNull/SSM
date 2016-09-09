package cn.ezi.services.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ezi.dao.IUserDao;
import cn.ezi.pojo.User;
import cn.ezi.servieces.IUserService;

@Service("userService")
public class UserService implements IUserService {
	@Resource
	private IUserDao userDao;

	@Override
	public User selectByPrimaryKey(int key) {		
		return this.userDao.selectByPrimaryKey(key);
	}
	
}
