package servlet;

import java.io.IOException;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondary.DAO.UserDAO;
import com.secondary.bean.User;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class verifyUserServlet
 */
public class verifyUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public verifyUserServlet() {
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
		//http://localhost:8088/SmartRestaurantServlet/verifyUserServlet?username=admin&password=admin
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charSet=utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		ResultSet rSet=UserDAO.verify(username, password);
		PrintStream out=new PrintStream(response.getOutputStream());
        User user = new User();
		try {
			while(rSet.next()){
		        user.setUser_id(rSet.getInt("user_id"));
		        user.setUser_name(rSet.getString("username"));
		        user.setPassword(rSet.getString("password"));
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
