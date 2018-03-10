package it.entity;

/*
 * 购买历史 实体类
 * */

public class BuyHistory {
	private int id;				//表中编号
	private int u_id;			//用户编号
	private int g_id;			//商品编号
	private String buyTime;		//购买时间,存储的是String类型的毫秒值
	private int num;			//花费金额
	private int money;
	
	public BuyHistory() {
		//
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public int getG_id() {
		return g_id;
	}

	public void setG_id(int g_id) {
		this.g_id = g_id;
	}

	public String getBuyTime() {
		return buyTime;
	}

	public void setBuyTime(String buyTime) {
		this.buyTime = buyTime;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "BuyHistory [id=" + id + ", u_id=" + u_id + ", g_id=" + g_id + ", buyTime=" + buyTime + ", num=" + num
				+ ", money=" + money + "]";
	}

}
