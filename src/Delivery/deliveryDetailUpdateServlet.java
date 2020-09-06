package Delivery;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deliveryDetailUpdateServlet
 */
@WebServlet("/deliveryDetailUpdateServlet")
public class deliveryDetailUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String uID = request.getParameter("uID");
//		String deliveryID = request.getParameter("deliveryID");
		String status = request.getParameter("status");
 		Double amount = Double.parseDouble(request.getParameter("amount"));
		
		boolean isTrue;
		
		isTrue = DeliveryDBUtil.updateDeliveryDetails(uID, id, status, amount);

		if(isTrue == true){
			RequestDispatcher dis = request.getRequestDispatcher("ApointDeliveryStaff.jsp");
			dis.forward(request, response);
		}
		
		else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}
	}

}
