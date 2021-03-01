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
 * Servlet implementation class DeliveryRatingInsertServlet
 */
@WebServlet("/DeliveryRatingInsertServlet")
public class DeliveryRatingInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String LoggedUser = (String) session.getAttribute("LoggedUser");
 		String delID = (String) session.getAttribute("DelID");
		
		
		int drate = Integer.parseInt(request.getParameter("drate"));
 		String sugg = request.getParameter("sugg");
 		String comp = request.getParameter("comp");

		
		boolean isTrue;
		
		isTrue = DeliveryDBUtil.insertDeliveryRateDetails(drate, sugg, comp, delID, LoggedUser);

		if(isTrue == true){
			session.setAttribute("result","successInsertdeliveryRating");
			RequestDispatcher dis = request.getRequestDispatcher("DeliveryRateAlertBox.jsp");
			dis.forward(request, response);
		}
		
		else {
			session.setAttribute("result","failedInsertdeliveryRating");
			RequestDispatcher dis = request.getRequestDispatcher("DeliveryRateAlertBox.jsp");
			dis.forward(request, response);
		}
	}

}
