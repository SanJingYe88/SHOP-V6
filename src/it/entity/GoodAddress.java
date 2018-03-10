package it.entity;

/*
 * 收货地址实体类
 * */

public class GoodAddress {
	
	private int id;				//地址在表中的编号
	private int u_id;			//用户id
	private String address;		//地址
	private String postCode;	//邮编
	
	public GoodAddress() {
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

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	@Override
	public String toString() {
		return "GoodAddress [id=" + id + ", u_id=" + u_id + ", address=" + address + ", postCode=" + postCode + "]";
	}

}
