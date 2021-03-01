package Delivery;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class deliveryDetailUpdateServlet
 */
@WebServlet("/deliveryDetailUpdateServlet")
public class deliveryDetailUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String uID = request.getParameter("uID");
//		String deliveryID = request.getParameter("deliveryID");
		String delDate = request.getParameter("delDate");
		String status = request.getParameter("status");
 		Double amount = Double.parseDouble(request.getParameter("amount"));
		
		boolean isTrue;
		
		isTrue = DeliveryDBUtil.updateDeliveryDetails(uID, id, status, amount, delDate);

		if(isTrue == true){
			session.setAttribute("result","successUpdateDeliveryDetails");
			RequestDispatcher dis = request.getRequestDispatcher("DeliveryAlertBox.jsp");
			dis.forward(request, response);
		}
		
		else {
			session.setAttribute("result","failedUpdateDeliveryDetails");
			RequestDispatcher dis = request.getRequestDispatcher("DeliveryAlertBox.jsp");
			dis.forward(request, response);
		}
		
	}

}
