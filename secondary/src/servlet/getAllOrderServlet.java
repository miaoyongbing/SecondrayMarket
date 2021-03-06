package servlet;

import java.io.IOException;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondary.DAO.OrderDAO;
import com.secondary.bean.Orders;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class getAllOrderServlet
 */
public class getAllOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getAllOrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charSet=utf-8");
		PrintStream out=new PrintStream(response.getOutputStream());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

		String user_name = request.getParameter("userforbuyer");
		System.out.println(user_name);
		
		OrderDAO orderDAO = new OrderDAO();
		List<Orders> orderItem_list = new ArrayList<>();
		try {
			ResultSet rSet = orderDAO.getOrderforbuyer(user_name);

			
			while(rSet.next()){
				Orders order = new Orders();
				order.setOrder_id(rSet.getInt("order_id"));
				order.setOrder_time(sdf.format(rSet.getDate("order_time")));
				order.setOrder_state(rSet.getInt("orderstate"));
				order.setTotal_price(rSet.getInt("orderprice"));
				
				order.setUserforbuyer(rSet.getString("userforbuyer"));
				order.setUserforsaler(rSet.getString("userforsaler"));
				order.setNumber(rSet.getInt("number"));
				order.setProdut_id(rSet.getInt("product_id"));
				//System.out.println(rSet.getInt("order_id"));
				
				orderItem_list.add(order);
			}
			
			JSONArray orderItemJson = JSONArray.fromObject(orderItem_list);
			
			out.print(orderItemJson);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
