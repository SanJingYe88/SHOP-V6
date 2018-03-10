package it.entity;

/*
 * 商品 实体类
 * */
public class Good {
	private int id;				//商品编号
	private String name;		//商品名
	private int price ;			//单价
	private int xl;				//销量	
	private int kcl;			//库存量
	private String picPath;		//图片路径
	private int typeid;			//类别编号
	
	public Good() {
		//
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getXl() {
		return xl;
	}

	public void setXl(int xl) {
		this.xl = xl;
	}

	public int getKcl() {
		return kcl;
	}

	public void setKcl(int kcl) {
		this.kcl = kcl;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public int getTypeId() {
		return typeid;
	}

	public void setTypeId(int typeid) {
		this.typeid = typeid;
	}

	@Override
	public String toString() {
		return "Good [id=" + id + ", name=" + name + ", price=" + price + ", xl=" + xl + ", kcl=" + kcl + ", picPath="
				+ picPath + ", typeid=" + typeid + "]";
	}
	
	
}
