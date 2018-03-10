package it.test;

import java.util.List;

import it.dao.GoodDao;
import it.dao.impl.GoodDaoImpl;
import it.entity.BuyHistory;
import it.entity.Good;
import it.entity.GoodAddress;
import it.entity.GoodType;

public class GoodDaoImplTest {

	public static void main(String[] args) {
		testAddGoodAddress();
	}
	
	//查询所有商品
	public static void testFindAllGoods() {
		GoodDao dao = new GoodDaoImpl();
		List<Good> list = dao.findAllGoods();
		System.out.println(list);
	}
	
	
	//查询商品根据商品类别
	public static void testFindById() {
		GoodDao dao = new GoodDaoImpl();
		Good good = dao.findGoodById(5);
		System.out.println(good);
	}
	
	
	//查询所有商品的类别
	public static void testFindAllGoodTypes() {
		GoodDao dao = new GoodDaoImpl();
		List<GoodType> list = dao.findAllGoodTypes();
		System.out.println(list);
	}
	
	
	//查询商品根据商品类别
	public static void testFindGoodByType() {
		GoodDao dao = new GoodDaoImpl();
		List<Good> list = dao.findGoodByType(5);
		System.out.println(list);
	}
	
	//根据商品名模糊查询
	public static void testFindGoodByName() {
		GoodDao dao = new GoodDaoImpl();
		List<Good> list = dao.findGoodByName("联想");
		System.out.println(list);
	}
	
	//向购买历史表中插入购买记录
	public static void testAddBuyHistory() {
		GoodDao dao = new GoodDaoImpl();
		BuyHistory bh = new BuyHistory();
		bh.setU_id(1);
		bh.setG_id(2);
		bh.setBuyTime("123456");
		bh.setNum(5);
		System.out.println(bh);
		dao.addBuyHistory(bh);
	}
	
	
	//根据商品名模糊查询
	public static void testFindGoodAddressById() {
		GoodDao dao = new GoodDaoImpl();
		GoodAddress goodAddress = dao.findGoodAddressById(1);
		System.out.println(goodAddress);
	}
	
	//根据用户id添加收货地址
	public static void testAddGoodAddress() {
		GoodDao dao = new GoodDaoImpl();
		GoodAddress goodAddress = new GoodAddress();
		goodAddress.setU_id(4);
		goodAddress.setAddress("危机xxx年");
		goodAddress.setPostCode("065xxx");
		dao.addGoodAddress(goodAddress);
	}
}
