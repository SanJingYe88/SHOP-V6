package it.service.impl;

import it.dao.UserDao;
import it.dao.impl.UserDaoImpl;
import it.entity.User;
import it.service.UserService;

/*
 * 用户的业务逻辑接口类的实现
 * */

public class UserServiceImpl implements UserService {

	//登录
	public User login(User user) {
		UserDao dao = new UserDaoImpl();
		try {
			User u = dao.findUser(user.getUserName(), user.getPassWord());
			return u;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	//注册
	public boolean register(User user) {
		try {
			UserDao dao = new UserDaoImpl();
			boolean flag = dao.checkUserExists(user.getUserName());
			if(flag){
				return false;	//注册失败
			}
			dao.saveUser(user);
			return true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	//查询用户是否存在
	public boolean findUser(String userName, String passWord) {
		try {
			UserDao dao = new UserDaoImpl();
			User user = dao.findUser(userName, passWord);
			if(user != null){
				return true;
			}
			return false;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	//根据用户id,更改用户密码
	public boolean updatePassWord(User user) {
		try {
			UserDao dao = new UserDaoImpl();
			boolean flag = dao.updatePassWord(user);
			return flag;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}



}
