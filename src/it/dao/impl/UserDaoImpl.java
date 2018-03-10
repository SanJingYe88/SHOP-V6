package it.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import it.dao.UserDao;
import it.entity.User;
import it.utils.JDBCUtil;

/*
 * 用户的数据访问Dao接口的实现
 * */

public class UserDaoImpl implements UserDao{
	
	//登录用, 查询用户是否存在, 不存在返回null
	public User findUser(String userName, String passWord) {
		User user = null;
		String sql = "SELECT * FROM USER WHERE userName = ? AND passWord = ?";
		try {
			QueryRunner qr = JDBCUtil.getQueryRunner();
			user = qr.query(sql, new BeanHandler<User>(User.class),userName,passWord);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	//注册用, 查询用户名是否存在
	public boolean checkUserExists(String userName) {
		boolean flag = false;		//标志是否查询到该用户
		String sql = "SELECT * FROM USER WHERE userName = ?";
		try {
			QueryRunner qr = JDBCUtil.getQueryRunner();
			Integer in = qr.query(sql, new ScalarHandler<Integer>(),userName);
			if (in != null) {
				flag = true;
			}
			return flag;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//注册用, 若注册成功, 保存用户名和密码到数据库
	public void saveUser(User user) {
		String sql = "INSERT INTO USER VALUES(NULL,?,?)";
		QueryRunner qr = JDBCUtil.getQueryRunner();
		try {
			qr.update(sql, user.getUserName(),user.getPassWord());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//根据用户id,更改用户密码
	public boolean updatePassWord(User user) {
		String sql = "UPDATE user SET password = ? WHERE id = ?";
		 QueryRunner qr = JDBCUtil.getQueryRunner();
		try {
			int i = qr.update(sql, user.getPassWord(),user.getId());
			if(i > 0){
				return true;
			}
			return false;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

