package Order_Management;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class insertQtyServlet
 */
@WebServlet("/insertQtyServlet")
public class insertQtyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String LoggedUser = (String) session.getAttribute("LoggedUser");
		
		int qty = Integer.parseInt(request.getParameter("quantity"));
		
		boolean isTrue;
		
		isTrue = ShoppingCartDbUtil.insertqty(LoggedUser, qty);
		
		try {	    	
	    	if(isTrue == true) {
				RequestDispatcher dis = request.getRequestDispatcher("Test2.jsp");
				dis.forward(request, response);
			}
			else {
				RequestDispatcher dis1 = request.getRequestDispatcher("Test3.jsp");
				dis1.forward(request, response);
			}

		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
