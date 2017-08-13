package com.secondary.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.secondary.bean.User;

public class UserDAO extends BaseDAO {

	//添加新用户
	public boolean Add(User user){
		try {
			String sql = "SELECT * FROM users WHERE username = ?;";
			ResultSet rs = buildSql(sql,""+user.getUser_name()).executeQuery();
			if(rs.next()){
				System.out.println("用户名已经存在！！！");
				return false;
			} else {
				sql = "INSERT INTO users(username,password,telephonenumber,nickname,address) VALUES(?,?,?,?,?);";
				PreparedStatement ps = buildSql(sql,user.getUser_name(),user.getPassword(),""+user.getTelephonenumber(),user.getNickname(),user.getAddress());
				if(!(ps.executeUpdate()>0)){
					System.out.println("数据库未知错误!!");
					return false;
				} else {
					//测试用
					System.out.println("new User:"+user.toString()+"add success!!");
					ResultSet rSet=ps.getGeneratedKeys();
					while(rSet.next()){
						System.out.println(rSet.getInt(1));
					}
					return true;
				}			
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	//验证登录 失败返回null 成功返回对象
	public static ResultSet verify(String user_name,String password){		
		try {
			String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
			ResultSet rs = buildSql(sql, user_name,password).executeQuery();
			return rs;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
	}

	//查找所有用户	返回ArrayList
	public ResultSet UserAll(){

		try {
			String sql = "select * from users";
			ResultSet rs = buildSql(sql).executeQuery();
			return rs;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	

	//查找所有用户	返回ArrayList
		public ResultSet getUserByName(String name){

			try {
				String sql = "select * from users WHERE username = ? ";
				ResultSet rs = buildSql(sql,name).executeQuery();
				return rs;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
	//删除用户
	public int deleteUser(String username) throws SQLException{
		PreparedStatement preparedStatement=buildSql("delete from users where username=?", username);
		int num=preparedStatement.executeUpdate();
		return num;
	}

	public static void main(String[] args) throws SQLException {
		UserDAO userDAO=new UserDAO();
//		ResultSet resultSet=userDAO.UserAll();
//		while(resultSet.next()){
//			System.out.println(resultSet.getObject("username"));		
//		}
//				User user=new User();
//				user.setPassword("1112");
//				user.setTelephonenumber("12345678");
//				user.setUser_name("大二");
//				user.setNickname("王二小");
//				user.setAddress("天津市");
//				userDAO.Add(user);

//		        ResultSet rSet=verify("111", "111");
//		        while(rSet.next()){
//		        	System.out.println(rSet.getString("user_id"));
//		        }

		//我们涉及不到删除用户 如果有这里输出1正确输出0错误进行判断再进一步处理
//		int num=userDAO.deleteUser("牛聪聪");
//		System.out.println(num);
//
//		resultSet=userDAO.UserAll();
//		while(resultSet.next()){
//			System.out.println(resultSet.getObject("user_id"));		
//		}
	}

}
