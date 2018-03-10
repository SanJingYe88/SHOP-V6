package it.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import it.dao.GoodDao;
import it.entity.BuyHistory;
import it.entity.Good;
import it.entity.GoodAddress;
import it.entity.GoodType;
import it.utils.JDBCUtil;

/*
 * 商品的数据访问dao接口的实现
 * */

public class GoodDaoImpl implements GoodDao {
	
	//查询所有商品
	public List<Good> findAllGoods() {
		String sql = "select * from good";
		QueryRunner qr = JDBCUtil.getQueryRunner();
		try {
			List<Good> list = qr.query(sql, new BeanListHandler<Good>(Good.class));
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//查询商品根据商品类别
	public Good findGoodById(int id) {
		String sql = "select * from good where id = ?";
		QueryRunner qr = JDBCUtil.getQueryRunner();
		try {
			Good good = qr.query(sql, new BeanHandler<Good>(Good.class),id);
			return good;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//查询所有商品的类别
	public List<GoodType> findAllGoodTypes() {
		String sql = "select * from good_type";
		QueryRunner qr = JDBCUtil.getQueryRunner();
		try {
			List<GoodType> list = qr.query(sql, new BeanListHandler<GoodType>(GoodType.class));
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//查询商品根据商品类别
	public List<Good> findGoodByType(int typeId) {
		String sql = "select * from good where typeid = ?";
		QueryRunner qr = JDBCUtil.getQueryRunner();
		try {
			List<Good> list = qr.query(sql, new BeanListHandler<Good>(Good.class),typeId);
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//根据商品名模糊查询
	public List<Good> findGoodByName(String name){
		String sql = "select * from good where name like \"%\"?\"%\"";
		QueryRunner qr = JDBCUtil.getQueryRunner();
		try {
			List<Good> list = qr.query(sql, new BeanListHandler<Good>(Good.class),name);
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//根据用户id查询收货地址
	public List<GoodAddress> findGoodAddressByUserId(int u_id) {
		String sql = "select * from good_address WHERE u_id = ?";
		QueryRunner qr = JDBCUtil.getQueryRunner();
		try {
			List<GoodAddress> list = qr.query(sql, new BeanListHandler<GoodAddress>(GoodAddress.class),u_id);
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//向购买历史表中插入购买记录
	public boolean addBuyHistory(BuyHistory bh) {
		String sql = "insert into buy_history(u_id,g_id,buyTime,num,money) values (?,?,?,?,?)";
		QueryRunner qr = JDBCUtil.getQueryRunner();
		try {
			int i = qr.update(sql,bh.getU_id(),bh.getG_id(),bh.getBuyTime(),bh.getNum(),bh.getMoney());
			if(i != 0){			//插入成功,返回true
				return true;	
			}
			return false;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//根据id查询收货地址
	public GoodAddress findGoodAddressById(int id) {
		String sql = "SELECT * FROM good_address WHERE id = ?";
		QueryRunner qr = JDBCUtil.getQueryRunner();
		try {
			GoodAddress goodAddress = qr.query(sql, new BeanHandler<GoodAddress>(GoodAddress.class),id);
			return goodAddress;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//根据用户id添加收货地址
	public boolean addGoodAddress(GoodAddress goodAddress) {
		String sql = "INSERT INTO good_address(u_id,address,postCode) VALUES(?,?,?)";
		QueryRunner qr = JDBCUtil.getQueryRunner();
		try {
			int i = qr.update(sql,goodAddress.getU_id(),goodAddress.getAddress(),goodAddress.getPostCode());
			if(i != 0){			//插入成功,返回true
				return true;	
			}
			return false;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//根据id删除收货地址
	public boolean deleteGoodAddressById(int id) {
		String sql = "DELETE FROM good_address WHERE id = ?";
		QueryRunner qr = JDBCUtil.getQueryRunner();
		try {
			int i = qr.update(sql,id);
			if(i != 0){			//删除成功,返回true
				return true;	
			}
			return false;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//根据用户id查询购买历史
	public List<BuyHistory> findBuyHistory(int u_id) {
		String sql = "SELECT * FROM buy_history WHERE u_id = ?";
		QueryRunner qr = JDBCUtil.getQueryRunner();
		try {
			List<BuyHistory> list = qr.query(sql, new BeanListHandler<BuyHistory>(BuyHistory.class),u_id);
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//根据id删除购买记录
	public boolean deleteBuyHistoryById(int id) {
		String sql = "DELETE FROM buy_history WHERE id = ?";
		QueryRunner qr = JDBCUtil.getQueryRunner();
		try {
			int i = qr.update(sql,id);
			if(i != 0){			//删除成功,返回true
				return true;	
			}
			return false;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//根据GoodAddress对象,修改收货地址
	public boolean updateGoodAddress(GoodAddress goodAddress) {
		String sql = "UPDATE good_address SET address = ?,postCode = ? WHERE id = ?";
		QueryRunner qr = JDBCUtil.getQueryRunner();
		try {
			int i = qr.update(sql,goodAddress.getAddress(),goodAddress.getPostCode(),goodAddress.getId());
			if(i != 0){			//更新成功,返回true
				return true;	
			}
			return false;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
