package com.secondary.bean;

public class Orders {
	
	private int order_id;
	private String order_time;
	private int order_state;
	private int total_price;
	
	private String userforsaler;
	private String userforbuyer;
	private int number;
	private int produt_id;
	
	public final int getOrder_id() {   return order_id;  }
	public final void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public final String getOrder_time() {
		return order_time;
	}
	public final void setOrder_time(String order_time) {
		this.order_time = order_time;
	}
	public final int getOrder_state() {
		return order_state;
	}
	public final void setOrder_state(int order_state) {
		this.order_state = order_state;
	}
	public final int getTotal_price() {
		return total_price;
	}
	public final void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public final String getUserforsaler() {
		return userforsaler;
	}
	public final void setUserforsaler(String userforsaler) {
		this.userforsaler = userforsaler;
	}
	public final String getUserforbuyer() {
		return userforbuyer;
	}
	public final void setUserforbuyer(String userforbuyer) {
		this.userforbuyer = userforbuyer;
	}
	
	public final int getNumber() {
		return number;
	}
	public final void setNumber(int number) {
		this.number = number;
	}
	public final int getProdut_id() {   return produt_id;  }
	public final void setProdut_id(int produt_id) {
		this.produt_id = produt_id;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " order_id:"+order_id+" order_time:"+order_time+" order_state:"+order_state+" total_price:"+total_price+" userforsaler:"+userforsaler+
		"userforbuyer:"+userforbuyer+"number:"+number+"prudut_id:"+produt_id;
	}
}
