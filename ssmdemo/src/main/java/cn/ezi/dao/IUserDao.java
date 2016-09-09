package cn.ezi.dao;

import cn.ezi.pojo.User;

public interface IUserDao {
	
	public User selectByPrimaryKey(int key);
}
