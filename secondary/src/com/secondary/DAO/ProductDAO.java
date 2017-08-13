package com.secondary.DAO;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.util.Date;


import com.secondary.bean.Product;
import com.secondary.bean.User;

public class ProductDAO extends BaseDAO{

	private static List<String>list=new ArrayList<>();
	static{
		list.add("product_id");
		list.add("title");
		list.add("publishtime");
		list.add("about");
		list.add("userforsale");
		list.add("productprize");
		list.add("type");
	}
//�����Ʒ
	public boolean Add(Product product){
		try {
			
			String	sql = "INSERT INTO products(title,publishtime,about,userforsale,productprice,type) VALUES(?,?,?,?,?,?);";
				PreparedStatement ps = buildSql(sql,product.getTitle(),product.getPublishtime(),product.getAbout(),product.getUserforsale(),product.getProductprice(),product.getType());
				if(!(ps.executeUpdate()>0)){
					System.out.println("���ݿ�δ֪����!!");
					return false;
				} else {
					//������
					System.out.println("new User:"+product.toString()+"add success!!");
					ResultSet rSet=ps.getGeneratedKeys();
					while(rSet.next()){
						System.out.println(rSet.getInt(1));
					}
					return true;
				}			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//���������Ʒ
	public ResultSet getAllProducts() throws SQLException{
		PreparedStatement preparedStatement=(PreparedStatement) buildSql("select * from products");
		ResultSet rSet=preparedStatement.executeQuery();
		return rSet;
	}
	
	//��ȡĳ����Ʒ��Ϣ
		public static ResultSet getProductbytype(String type) throws SQLException{
			try {
				PreparedStatement preparedStatement=(PreparedStatement) buildSql("select * from products where type=?",type);
				ResultSet rSet=preparedStatement.executeQuery();
				
				return rSet;
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;

		}

	//��ȡĳ����Ʒ��Ϣ
	public static ResultSet getProduct(int pruduct_id) throws SQLException{
		try {
			PreparedStatement preparedStatement=(PreparedStatement) buildSql("select * from products where product_id=?",pruduct_id);
			ResultSet rSet=preparedStatement.executeQuery();
			
			return rSet;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	//ɾ����Ʒ
	public int deleteProduct( int product_id) throws SQLException{
		PreparedStatement preparedStatement=buildSql("delete from products where product_id=?", product_id);
		int num=preparedStatement.executeUpdate();
		return num;
	}
	

	//��ȡĳ���Ͳ�Ʒ��Ϣ
	public static ResultSet gettypeProduct(String type) throws SQLException{
		try {
			PreparedStatement preparedStatement=(PreparedStatement) buildSql("select * from products where type=?",type);
			ResultSet rSet=preparedStatement.executeQuery();
			
			
				return rSet;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	//��ȡĳ�˵Ĳ�Ʒ��Ϣ
		public static ResultSet getProductsbyname(String name) throws SQLException{
			try {
				PreparedStatement preparedStatement=(PreparedStatement) buildSql("select * from products where userforsale=?",name);
				ResultSet rSet=preparedStatement.executeQuery();
				
				
					return rSet;
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;

		}
		
	
	
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		ProductDAO productDao=new ProductDAO();
		
//		ResultSet resultSet=productDao.getProductsbyname("����");
//		while(resultSet.next()){
//			System.out.println(resultSet.getObject("title"));		
//		}
		
//		Product product=new Product();
//		product.setTitle("�������Ʒ");
//		Date d = new Date();  
//        System.out.println(d);  
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
//        String dateNowStr = sdf.format(d);  
//		product.setPublishtime(dateNowStr);
//		product.setAbout("�˲�Ʒ������");
//		product.setUserforsale("����");
//		product.setProductprice(20);
//		product.setType("���");
//		productDao.Add(product);
		
//		ResultSet resultSet=productDao.getAllProducts();
//		while(resultSet.next()){
//			System.out.println(resultSet.getObject("title"));		
//		}
		
//		ResultSet resultSet=productDao.getProduct(1);
//		while(resultSet.next()){
//			System.out.println(resultSet.getObject("title"));		
//		}
		
//		ResultSet resultSet=productDao.gettypeProduct("����");
//		while(resultSet.next()){
//			System.out.println(resultSet.getObject("title"));		
//		}
		
		//�����漰����ɾ����Ʒ ������������1��ȷ���0��������ж��ٽ�һ������
//		int num=productDao.deleteProduct(1);
//		System.out.println(num);
//		
		
	}
}
