package com.secondary.DAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.NTCredentials;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;

import com.secondary.bean.Orders;
//import com.sun.org.apache.regexp.internal.recompile;

//import sun.dc.pr.PRError;

public class OrderDAO extends BaseDAO{
	/*
	 * 添加订单
	 */
	public int addOrder(Orders order) throws SQLException{
		//我们Order对象的Order_time是String类型
		
		PreparedStatement pStatement=(PreparedStatement)buildSql("insert into orders(order_time,orderstate,orderprice,userforsaler,userforbuyer,number,product_id)values(?,?,?,?,?,?,?)", 
				order.getOrder_time(),order.getOrder_state(),order.getTotal_price(),order.getUserforsaler(),order.getUserforbuyer(),order.getNumber(),order.getProdut_id());
		int num=pStatement.executeUpdate();
		ResultSet rSet=pStatement.getGeneratedKeys();
		int order_id=-1;
		while(rSet.next()){
			order_id=rSet.getInt(1);
		}
		return order_id;
	}

	/*
	 * 通过userforbuyer获取当前用户的所有订单单号
	 */
	public ResultSet getOrderforbuyer(String userforbuyer) throws SQLException{
		PreparedStatement preparedStatement=(PreparedStatement) buildSql("select * from orders where userforbuyer=?", userforbuyer);
		ResultSet rSet=preparedStatement.executeQuery();
		return rSet;
	}

	/*
	 * 用户可以删除Order
	 */
	public int deleteOrderByOrder_id(int order_id) throws SQLException{
		PreparedStatement preparedStatement=(PreparedStatement) buildSql("delete from orders where order_id=?", order_id);
		int num=preparedStatement.executeUpdate();
		System.out.println("删除"+num+"个order");
		return num;
	}
	
	/*
	 * 用户更改order状态
	 */
	public boolean changeOrderState(int order_id,int state) throws SQLException{
		PreparedStatement preparedStatement=(PreparedStatement)buildSql("update orders set orderstate=? where order_id=?",state,order_id);
		int num=preparedStatement.executeUpdate();
		return num>0?true:false;
	}


	
	public static void main(String[] args) throws SQLException {
		//所有这些我们都没有try_catch这样就代表这我们只会知道出现了错误，但是没办法提醒用户，后期改进
		OrderDAO orderDAO=new OrderDAO();
//		Orders order=new Orders();
//		java.util.Date d = new java.util.Date();
//		System.out.println(1);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
//		String dateNowStr = sdf.format(d);  
//		order.setOrder_time(dateNowStr);
//		order.setOrder_state(1);
//		order.setProdut_id(3);
//		order.setTotal_price(20);
//		order.setUserforbuyer("李四");
//		order.setUserforsaler("王五");
//		order.setNumber(1);
//		int ret=orderDAO.addOrder(order);
//		System.out.println(ret);

//		ResultSet resultSet=orderDAO.getOrderforbuyer("张三");
//		while(resultSet.next()){
//			System.out.println(resultSet.getObject("order_id"));		
//		}
//		
//		int num=orderDAO.deleteOrderByOrder_id(1);
//		System.out.println(num);
		
//		
//		boolean num1=orderDAO.changeOrderState(2, 2);
//		System.out.println(num1);
		
	}

}
