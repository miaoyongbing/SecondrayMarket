package servlet;

import java.io.IOException;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondary.DAO.OrderDAO;
import com.secondary.bean.Orders;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class addOrderServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @throws SQLException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//http://localhost:8088/SmartRestaurantServlet/addUserServlet?user={"user_name":"admin","password":"admin","job":"11"}
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charSet=utf-8");
		String orderString = request.getParameter("order");
		System.out.println(orderString);
		

		JSONObject jsonObject=JSONObject.fromObject(orderString);
		Orders order=(Orders) JSONObject.toBean(jsonObject, Orders.class);
		
		@SuppressWarnings({ "deprecation", "unchecked" })
		OrderDAO orderDAO = new OrderDAO();
		PrintStream out=new PrintStream(response.getOutputStream());
		int order_id = 0;
		try {
			order_id = orderDAO.addOrder(order);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(order_id);
	}

}
