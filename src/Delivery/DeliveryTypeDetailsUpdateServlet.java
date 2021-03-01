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
 * Servlet implementation class DeliveryTypeDetailsUpdateServlet
 */
@WebServlet("/DeliveryTypeDetailsUpdateServlet")
public class DeliveryTypeDetailsUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		
		int id = Integer.parseInt(request.getParameter("id"));
 		Double dtCharges = Double.parseDouble(request.getParameter("dtCharges"));
		
		boolean isTrue;
		
		isTrue = DeliveryDBUtil.updateDeliveryTypeDetails( id, dtCharges);

		if(isTrue == true){
			session.setAttribute("result","successUpdateDeliveryType");
			RequestDispatcher dis = request.getRequestDispatcher("DeliveryAlertBox.jsp");
			dis.forward(request, response);
		}
		
		else {
			session.setAttribute("result","failedUpdateDeliveryType");
			RequestDispatcher dis = request.getRequestDispatcher("DeliveryAlertBox.jsp");
			dis.forward(request, response);
		}
		
	}
}
