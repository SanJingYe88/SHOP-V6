package it.test;

import it.dao.UserDao;
import it.dao.impl.UserDaoImpl;
import it.entity.User;

public class UserDaoImplTest {

	public static void main(String[] args) {
		testSaveUser();
	}
	
	public static void testFindUser() {
		UserDao dao = new UserDaoImpl();
		User u = dao.findUser("艾AA", "123456");
		System.out.println(u);
	}
	
	public static void testCheckUserExists() {
		UserDao dao = new UserDaoImpl();
		boolean u = dao.checkUserExists("艾AA");
		System.out.println(u);
	}
	
	public static void testSaveUser() {
		UserDao dao = new UserDaoImpl();
		User u = new User();
		u.setUserName("艾AA");
		u.setPassWord("123456");
		dao.saveUser(u);
	}
}
