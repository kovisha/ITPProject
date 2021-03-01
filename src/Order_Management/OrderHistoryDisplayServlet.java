package Order_Management;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Order_Management.AdminDbUtil;
import Order_Management.Order;

/**
 * Servlet implementation class OrderHistoryDisplayServlet
 */
@WebServlet("/OrderHistoryDisplayServlet")
public class OrderHistoryDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String LoggedUser = (String) session.getAttribute("LoggedUser");
		
		//int uID = LoggedUser.getiD();
		
		try {
            List <Order> orderHistory = orderHistoryDbUtil.OrderHistoryDisplay(LoggedUser);
            request.setAttribute("orderHistory", orderHistory);
		     }
		     
		     catch(Exception e)
		     {
		    	 e.printStackTrace();
		    	 
		     }
            
            RequestDispatcher dis  = request.getRequestDispatcher("OrderHistory.jsp");
            dis.forward(request, response);
	}

}
