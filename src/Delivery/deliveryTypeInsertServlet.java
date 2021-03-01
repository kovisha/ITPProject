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
 * Servlet implementation class deliveryTypeInsertServlet
 */
@WebServlet("/deliveryTypeInsertServlet")
public class deliveryTypeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String dType = request.getParameter("dType");
 		Double dCharges = Double.parseDouble(request.getParameter("dCharge"));
		
		boolean isTrue;
		
		isTrue = DeliveryDBUtil.insertDeliveryTypeDetails(dType, dCharges);

		if(isTrue == true){
			session.setAttribute("result","successInsertdeliveryType");
			RequestDispatcher dis = request.getRequestDispatcher("DeliveryAlertBox.jsp");
			dis.forward(request, response);
		}
		
		else {
			session.setAttribute("result","failedInsertdeliveryType");
			RequestDispatcher dis = request.getRequestDispatcher("DeliveryAlertBox.jsp");
			dis.forward(request, response);
		}
		
	}

}
