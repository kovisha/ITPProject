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

/**
 * Servlet implementation class UserOrderDeleteServlet
 */
@WebServlet("/UserOrderDeleteServlet")
public class UserOrderDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 HttpSession session = request.getSession();
		String LoggedUser = (String) session.getAttribute("LoggedUser");
		
		
			
	        String sid = request.getParameter("id");
			
			boolean isTrue ;
			
			isTrue = orderHistoryDbUtil.deleteOrderUser(sid);
			
			try {
				
				List <Order> orderHisto = orderHistoryDbUtil.OrderHistoryDisplay(LoggedUser);
	            request.setAttribute("orderHisto", orderHisto);
	            
	            List <Order> orderHistoryDispatch = orderHistoryDbUtil.OrderHistoryDisplayDispatch(LoggedUser);
	            request.setAttribute("orderHistoDispatch", orderHistoryDispatch);
	            
			}
			catch (Exception e) {
				
				e.printStackTrace();
			}
	            
			if(isTrue == true )
			{
				
	            
				
				RequestDispatcher dis = request.getRequestDispatcher("OrderHistory.jsp");
				dis.forward(request, response);
				
			}
			
			else
			{
				
				
				RequestDispatcher dis = request.getRequestDispatcher("OrderHistory.jsp");
				dis.forward(request, response);
				
				
			}

			
	}

}
