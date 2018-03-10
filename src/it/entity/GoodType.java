package it.entity;


/*
 * 商品类别实体类
 * */
public class GoodType {
	private int id;			//类别编号
	private String name;	//类别名
	
	public GoodType() {
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

	@Override
	public String toString() {
		return "GoodType [id=" + id + ", name=" + name + "]";
	}
	
	
}
