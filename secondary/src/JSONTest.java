import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.secondary.bean.Orders;
import com.secondary.bean.Product;
import com.secondary.bean.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JSONTest {
	public static void main(String[] args) {
		System.out.println("user JavaBeanת����JSON");
		User user=new User();
		user.setUser_name("����");
		user.setPassword("12345");
		user.setTelephonenumber("2345678976543");
		user.setNickname("����С");
		user.setAddress("�����");
		
		
		JSONObject jsonObject0=JSONObject.fromObject(user);
		System.out.println(jsonObject0.toString());
		
		user=(User) jsonObject0.toBean(jsonObject0, User.class);
		
		System.out.println("JavaBeanת����JSON");
		Orders orders=new Orders();
		orders.setOrder_id(1);
		orders.setOrder_state(1);
		orders.setOrder_time("2017-04-15 14:26:25");
		orders.setProdut_id(2);
		orders.setTotal_price(1000);
		orders.setNumber(2);
		orders.setUserforsaler("����");
		orders.setUserforbuyer("����");
		JSONObject jsonObject=JSONObject.fromObject(orders);
		System.out.println(jsonObject.toString());
		
		orders=(Orders) jsonObject.toBean(jsonObject, Orders.class);
		
		System.out.println("JavaBeanת����JSONArray");
		Product product=new Product();
		product.setProduct_id(1);
		product.setTitle("��һ��");
		product.setAbout("����");
		product.setProductprice(20);
		product.setPublishtime("2017-04-15 14:26:25");
		product.setUserforsale("����");
		product.setType("����");
		
		Product product1=new Product();
		product1.setProduct_id(1);
		product1.setTitle("��һ��");
		product1.setAbout("����");
		product1.setProductprice(20);
		product1.setPublishtime("2017-04-15 14:26:25");
		product1.setUserforsale("����");
		product1.setType("����");
		
		Product product2=new Product();
		product2.setProduct_id(1);
		product2.setTitle("��һ��");
		product2.setAbout("����");
		product2.setProductprice(20);
		product2.setPublishtime("2017-04-15 14:26:25");
		product2.setUserforsale("����");
		product2.setType("����");
		
		Product product3=new Product();
		product3.setProduct_id(1);
		product3.setTitle("��һ��");
		product3.setAbout("����");
		product3.setProductprice(20);
		product3.setPublishtime("2017-04-15 14:26:25");
		product3.setUserforsale("����");
		product3.setType("����");
		
		List<Product>list=new ArrayList<>();
		list.add(product);
		list.add(product1);
		list.add(product2);
		list.add(product3);

		JSONArray jsonArray=JSONArray.fromObject(list);
		System.out.println(jsonArray.toString());
		
		Map<String,String>map=new HashMap<>();
		map.put("order", jsonObject.toString());
		map.put("order_item", jsonArray.toString());
		JSONObject jsonObject2=JSONObject.fromObject(map);
		System.out.println(jsonObject2);
		
		
		String string=jsonObject2.get("order").toString();
		System.out.println(string);
		
	}
}
