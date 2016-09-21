package cn.ezi.services.impl;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;

import cn.ezi.mapper.UserMapper;

import cn.ezi.pojo.User_t;
import cn.ezi.servieces.IUserService;

@Service("userService")
public class UserService implements IUserService {
	@Resource
	private UserMapper userMapper;

	@Override
	public User_t selectByPrimaryKey(int key) {		
		return this.userMapper.selectByPrimaryKey(key);
	}
	
}
