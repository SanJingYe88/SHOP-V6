package it.service;

import java.util.List;

import it.entity.BuyHistory;
import it.entity.Good;
import it.entity.GoodAddress;
import it.entity.GoodType;

/*
 * 商品的业务逻辑接口类
 * */

public interface GoodService {
	
	//查询所有商品
	public List<Good> findAllGoods();
	
	//根据商品id,查询商品
	public Good findGoodById(int id);
	
	//查询所有商品的类别
	public List<GoodType> findAllGoodTypes();
	
	//根据商品类别id,查询商品
	public List<Good> findGoodByType(int typeId);
	
	//根据商品名,模糊查询商品
	public List<Good> findGoodByName(String name);
	
	
	
	//根据用户id,查询收货地址
	public List<GoodAddress> findGoodAddressByUserId(int u_id);
	
	//根据id,查询收货地址
	public GoodAddress findGoodAddressById(int id);
	
	//根据id,删除收货地址
	public boolean deleteGoodAddressById(int id);
	
	//根据用户id,添加收货地址
	public boolean addGoodAddress(GoodAddress goodAddress);
	
	//根据GoodAddress对象,修改收货地址
	public boolean updateGoodAddress(GoodAddress goodAddress);
	
	
	
	//向购买历史表中,插入购买记录
	public boolean addBuyHistory(BuyHistory bh);
	
	//根据用户id,查询购买历史
	public List<BuyHistory> findBuyHistory(int u_id);
	
	//根据id,删除购买记录
	public boolean deleteBuyHistoryById(int id);
	
}
