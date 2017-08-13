package servlet;

import java.io.IOException;
import java.io.PrintStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondary.DAO.OrderDAO;

public class changeOrderstateServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeOrderstateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		
		String order_idString = request.getParameter("order_id");
		System.out.println(order_idString);
		String stateString = request.getParameter("state");
		System.out.println(stateString);
		
		int order_id = Integer.parseInt(order_idString);
		int state = Integer.parseInt(stateString);
		
		OrderDAO orderDAO = new OrderDAO();
		
		try {
			if(orderDAO.changeOrderState( order_id, state))
				out.print("true");
			else
				out.print("false");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
