package it.service.impl;

import java.util.List;


import it.dao.GoodDao;
import it.dao.impl.GoodDaoImpl;
import it.entity.BuyHistory;
import it.entity.Good;
import it.entity.GoodAddress;
import it.entity.GoodType;
import it.service.GoodService;

/*
 * 商品的业务逻辑接口类的实现
 * */

public class GoodServiceImpl implements GoodService {

	//查询所有商品
	public List<Good> findAllGoods() {
		GoodDao dao = new GoodDaoImpl();
		try {
			List<Good> list = dao.findAllGoods();
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	//查询商品根据商品id
	public Good findGoodById(int id) {
		GoodDao dao = new GoodDaoImpl();
		try {
			Good good = dao.findGoodById(id);
			return good;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	//查询所有商品的类别
	public List<GoodType> findAllGoodTypes() {
		GoodDao dao = new GoodDaoImpl();
		try {
			List<GoodType> list = dao.findAllGoodTypes();
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	//查询商品根据商品类别
	public List<Good> findGoodByType(int typeId) {
		GoodDao dao = new GoodDaoImpl();
		try {
			List<Good> list = dao.findGoodByType(typeId);
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	//根据商品名模糊查询
	public List<Good> findGoodByName(String name) {
		GoodDao dao = new GoodDaoImpl();
		try {
			List<Good> list = dao.findGoodByName(name);
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	//根据用户id查询收货地址
	public List<GoodAddress> findGoodAddressByUserId(int u_id) {
		GoodDao dao = new GoodDaoImpl();
		try {
			List<GoodAddress> list = dao.findGoodAddressByUserId(u_id);
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	//向购买历史表中插入购买记录
	public boolean addBuyHistory(BuyHistory bh) {
		GoodDao dao = new GoodDaoImpl();
		try {
			if(dao.addBuyHistory(bh)){
				return true;
			}
			return false;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	//根据id查询收货地址
	public GoodAddress findGoodAddressById(int id) {
		GoodDao dao = new GoodDaoImpl();
		try {
			GoodAddress goodAddress = dao.findGoodAddressById(id);
			return goodAddress;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	//根据用户id添加收货地址
	public boolean addGoodAddress(GoodAddress goodAddress) {
		GoodDao dao = new GoodDaoImpl();
		try {
			if(dao.addGoodAddress(goodAddress)){
				return true;
			}
			return false;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	//根据id删除收货地址
	public boolean deleteGoodAddressById(int id) {
		GoodDao dao = new GoodDaoImpl();
		try {
			if(dao.deleteGoodAddressById(id)){
				return true;
			}
			return false;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	//根据用户id查询购买历史
	public List<BuyHistory> findBuyHistory(int u_id) {
		GoodDao dao = new GoodDaoImpl();
		try {
			List<BuyHistory> list = dao.findBuyHistory(u_id);
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	//根据id删除购买记录
	public boolean deleteBuyHistoryById(int id) {
		GoodDao dao = new GoodDaoImpl();
		try {
			if(dao.deleteBuyHistoryById(id)){
				return true;
			}
			return false;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	//根据GoodAddress对象,修改收货地址
	public boolean updateGoodAddress(GoodAddress goodAddress) {
		GoodDao dao = new GoodDaoImpl();
		try {
			if(dao.updateGoodAddress(goodAddress)){
				return true;
			}
			return false;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
