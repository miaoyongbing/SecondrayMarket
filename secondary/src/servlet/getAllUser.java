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

import com.secondary.DAO.UserDAO;
import com.secondary.bean.User;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class getAllUser
 */
public class getAllUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getAllUser() {
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
		PrintStream out=new PrintStream(response.getOutputStream());
		
		UserDAO userDAO = new UserDAO();
		List<User> user_list = new ArrayList<>();
		ResultSet rSet = userDAO.UserAll();
		try {
			while(rSet.next()){
				User user = new User();
				 user.setUser_id(rSet.getInt("user_id"));
			     user.setUser_name(rSet.getString("username"));
			     user.setPassword(rSet.getString("password"));
			     user.setTelephonenumber(rSet.getString("telephonenumber"));
			     user.setNickname(rSet.getString("nickname"));
			     user.setAddress(rSet.getString("address"));
				user_list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray jsonArray = JSONArray.fromObject(user_list);
		out.print(jsonArray.toString());	
	}

}
