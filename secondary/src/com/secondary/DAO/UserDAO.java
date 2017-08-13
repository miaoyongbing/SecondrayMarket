package com.secondary.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.secondary.bean.User;

public class UserDAO extends BaseDAO {

	//������û�
	public boolean Add(User user){
		try {
			String sql = "SELECT * FROM users WHERE username = ?;";
			ResultSet rs = buildSql(sql,""+user.getUser_name()).executeQuery();
			if(rs.next()){
				System.out.println("�û����Ѿ����ڣ�����");
				return false;
			} else {
				sql = "INSERT INTO users(username,password,telephonenumber,nickname,address) VALUES(?,?,?,?,?);";
				PreparedStatement ps = buildSql(sql,user.getUser_name(),user.getPassword(),""+user.getTelephonenumber(),user.getNickname(),user.getAddress());
				if(!(ps.executeUpdate()>0)){
					System.out.println("���ݿ�δ֪����!!");
					return false;
				} else {
					//������
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

	//��֤��¼ ʧ�ܷ���null �ɹ����ض���
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

	//���������û�	����ArrayList
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
	
	

	//���������û�	����ArrayList
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
		
	//ɾ���û�
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
//				user.setUser_name("���");
//				user.setNickname("����С");
//				user.setAddress("�����");
//				userDAO.Add(user);

//		        ResultSet rSet=verify("111", "111");
//		        while(rSet.next()){
//		        	System.out.println(rSet.getString("user_id"));
//		        }

		//�����漰����ɾ���û� ������������1��ȷ���0��������ж��ٽ�һ������
//		int num=userDAO.deleteUser("ţ�ϴ�");
//		System.out.println(num);
//
//		resultSet=userDAO.UserAll();
//		while(resultSet.next()){
//			System.out.println(resultSet.getObject("user_id"));		
//		}
	}

}
