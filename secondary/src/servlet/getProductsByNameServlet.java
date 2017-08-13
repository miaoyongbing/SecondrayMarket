package servlet;

import java.io.IOException;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondary.DAO.ProductDAO;
import com.secondary.bean.Product;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class getAllMenuServlet
 */
public class getProductsByNameServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getProductsByNameServlet() {
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
		//doGet(request, response);

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charSet=utf-8");
		
		String name=request.getParameter("userforsale");
		System.out.println(name);
	
		PrintStream out=new PrintStream(response.getOutputStream());
		

		ProductDAO productDao = new ProductDAO();
		List<Product> product_list = new ArrayList<>();
		try {
			ResultSet rSet = productDao.getProductsbyname(name);
			while(rSet.next()){
				Product product=new Product();
				product.setProduct_id(rSet.getInt("product_id"));
				product.setTitle(rSet.getString("title"));
				product.setAbout(rSet.getString("about"));
				product.setPublishtime(rSet.getString("publishtime"));
				product.setUserforsale(rSet.getString("userforsale"));
				product.setProductprice(rSet.getInt("productprice"));
				product.setType(rSet.getString("type"));
				
				
				product_list.add(product);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray jsonArray = JSONArray.fromObject(product_list);
		out.print(jsonArray);

	}

	
	
}
