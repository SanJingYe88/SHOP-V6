package it.dao;


import it.entity.User;

/*
 * 用户的数据访问Dao接口层
 * */

public interface UserDao {

	//登录用,根据用户名和密码,查询用户是否存在
	public User findUser(String userName,String passWord);
	
	//注册用,查询用户名是否存在
	public boolean checkUserExists(String userName);
	
	//注册用,若注册成功,保存用户名和密码到数据库
	public void saveUser(User user);
	
	//根据用户id,更改用户面膜
	public boolean updatePassWord(User user);
}
