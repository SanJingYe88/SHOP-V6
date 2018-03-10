package it.service;

import it.entity.User;

/*
 * 用户的业务逻辑接口类
 * */

public interface UserService {
	
	//登录
	public User login(User user);
	
	//注册
	public boolean register(User user);
	
	//查询用户是否存在
	public boolean findUser(String userName,String passWord);
	
	//根据用户id,更改用户密码
	public boolean updatePassWord(User user);
}
