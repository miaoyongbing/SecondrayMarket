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
		System.out.println("user JavaBean转换成JSON");
		User user=new User();
		user.setUser_name("张三");
		user.setPassword("12345");
		user.setTelephonenumber("2345678976543");
		user.setNickname("王二小");
		user.setAddress("天津市");
		
		
		JSONObject jsonObject0=JSONObject.fromObject(user);
		System.out.println(jsonObject0.toString());
		
		user=(User) jsonObject0.toBean(jsonObject0, User.class);
		
		System.out.println("JavaBean转换成JSON");
		Orders orders=new Orders();
		orders.setOrder_id(1);
		orders.setOrder_state(1);
		orders.setOrder_time("2017-04-15 14:26:25");
		orders.setProdut_id(2);
		orders.setTotal_price(1000);
		orders.setNumber(2);
		orders.setUserforsaler("李三");
		orders.setUserforbuyer("李四");
		JSONObject jsonObject=JSONObject.fromObject(orders);
		System.out.println(jsonObject.toString());
		
		orders=(Orders) jsonObject.toBean(jsonObject, Orders.class);
		
		System.out.println("JavaBean转换成JSONArray");
		Product product=new Product();
		product.setProduct_id(1);
		product.setTitle("第一件");
		product.setAbout("详情");
		product.setProductprice(20);
		product.setPublishtime("2017-04-15 14:26:25");
		product.setUserforsale("张三");
		product.setType("电子");
		
		Product product1=new Product();
		product1.setProduct_id(1);
		product1.setTitle("第一件");
		product1.setAbout("详情");
		product1.setProductprice(20);
		product1.setPublishtime("2017-04-15 14:26:25");
		product1.setUserforsale("张三");
		product1.setType("电子");
		
		Product product2=new Product();
		product2.setProduct_id(1);
		product2.setTitle("第一件");
		product2.setAbout("详情");
		product2.setProductprice(20);
		product2.setPublishtime("2017-04-15 14:26:25");
		product2.setUserforsale("张三");
		product2.setType("电子");
		
		Product product3=new Product();
		product3.setProduct_id(1);
		product3.setTitle("第一件");
		product3.setAbout("详情");
		product3.setProductprice(20);
		product3.setPublishtime("2017-04-15 14:26:25");
		product3.setUserforsale("张三");
		product3.setType("电子");
		
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
