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
import com.secondary.DAO.UserDAO;
import com.secondary.bean.Product;
import com.secondary.bean.User;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class getUserByNameServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getUserByNameServlet() {
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
		
		String name=request.getParameter("name");
		System.out.println(name);
	
		
		UserDAO UserDAO=new UserDAO();
		ResultSet rSet;
		try {
			rSet = UserDAO.getUserByName(name);
			PrintStream out=new PrintStream(response.getOutputStream());
			User user=new User();
			
		
			while(rSet.next()){
				user.setUser_name(rSet.getString("username"));
				user.setUser_id(rSet.getInt("user_id"));
				user.setTelephonenumber(rSet.getString("telephonenumber"));
				user.setNickname(rSet.getString("nickname"));
				user.setAddress(rSet.getString("address"));
				
		        break;
			}
			JSONObject userJson = JSONObject.fromObject(user);
			out.print(userJson.toString());		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
	}
}
