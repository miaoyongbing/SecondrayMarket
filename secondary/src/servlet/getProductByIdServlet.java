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

import com.secondary.DAO.ProductDAO;
import com.secondary.bean.Product;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class getProductByIdServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getProductByIdServlet() {
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
		
		String product_idstring=request.getParameter("product_id");
		System.out.println(product_idstring);
	
		int product_id = Integer.parseInt(product_idstring);
		ProductDAO productDAO=new ProductDAO();
		ResultSet rSet;
		try {
			rSet = productDAO.getProduct(product_id);
			PrintStream out=new PrintStream(response.getOutputStream());
			Product product = new Product();
		
			while(rSet.next()){
				product.setProduct_id(rSet.getInt("product_id"));
				product.setPublishtime(rSet.getString("publishtime"));
				product.setTitle(rSet.getString("title"));
				product.setAbout(rSet.getString("about"));
				System.out.println(rSet.getString("about"));
				product.setProductprice(rSet.getInt("productprice"));
				product.setType(rSet.getString("type"));
				product.setUserforsale(rSet.getString("userforsale"));
				System.out.println(rSet.getString("userforsale"));
		        break;
			}
			JSONObject userJson = JSONObject.fromObject(product);
			out.print(userJson.toString());		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
	}
}
