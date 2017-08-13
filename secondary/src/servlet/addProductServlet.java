package servlet;


import java.io.IOException;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondary.DAO.ProductDAO;
import com.secondary.bean.Product;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class addProductServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addProductServlet() {
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
		
		//http://localhost:8088/SmartRestaurantServlet/foodOrderAddServlet?order=[{"order_time":"2017-04-15 14:26:25","order_state":"1","total_price":"100","table_id":"2"}]&order_item=[{"food_id":"1","food_num":"4","food_state":"0"},{"food_id":"2","food_num":"4","food_state":"1"}]
		response.setCharacterEncoding("utf8");
		String productstring=request.getParameter("product");	
		System.out.println(productstring);
		
		JSONObject jsonObject=JSONObject.fromObject(productstring);
		Product product=(Product) JSONObject.toBean(jsonObject, Product.class);
		
		ProductDAO productDAO = new ProductDAO();
		PrintStream out=new PrintStream(response.getOutputStream());
		if(productDAO.Add(product))
			out.print("true");
		else
			out.print("false");
	
		
		
	}


}
