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
	 * ��Ӷ���
	 */
	public int addOrder(Orders order) throws SQLException{
		//����Order�����Order_time��String����
		
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
	 * ͨ��userforbuyer��ȡ��ǰ�û������ж�������
	 */
	public ResultSet getOrderforbuyer(String userforbuyer) throws SQLException{
		PreparedStatement preparedStatement=(PreparedStatement) buildSql("select * from orders where userforbuyer=?", userforbuyer);
		ResultSet rSet=preparedStatement.executeQuery();
		return rSet;
	}

	/*
	 * �û�����ɾ��Order
	 */
	public int deleteOrderByOrder_id(int order_id) throws SQLException{
		PreparedStatement preparedStatement=(PreparedStatement) buildSql("delete from orders where order_id=?", order_id);
		int num=preparedStatement.executeUpdate();
		System.out.println("ɾ��"+num+"��order");
		return num;
	}
	
	/*
	 * �û�����order״̬
	 */
	public boolean changeOrderState(int order_id,int state) throws SQLException{
		PreparedStatement preparedStatement=(PreparedStatement)buildSql("update orders set orderstate=? where order_id=?",state,order_id);
		int num=preparedStatement.executeUpdate();
		return num>0?true:false;
	}


	
	public static void main(String[] args) throws SQLException {
		//������Щ���Ƕ�û��try_catch�����ʹ���������ֻ��֪�������˴��󣬵���û�취�����û������ڸĽ�
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
//		order.setUserforbuyer("����");
//		order.setUserforsaler("����");
//		order.setNumber(1);
//		int ret=orderDAO.addOrder(order);
//		System.out.println(ret);

//		ResultSet resultSet=orderDAO.getOrderforbuyer("����");
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
