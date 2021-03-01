package Delivery;

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
 * Servlet implementation class DeliveryRateServlet
 */
@WebServlet("/DeliveryRateServlet")
public class DeliveryRateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String dID = request.getParameter("dID");
		session.setAttribute("DelID", dID);
		String LoggedUser = (String) session.getAttribute("LoggedUser");

		
		 RequestDispatcher dis = request.getRequestDispatcher("UserProfileRateDeliveryDetails.jsp");
		 dis.forward(request, response);
		 
	}

}
