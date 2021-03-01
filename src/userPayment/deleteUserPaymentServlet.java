package userPayment;

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
 * Servlet implementation class deleteOfferServlet
 */
@WebServlet("/deleteUserPaymentServlet")
public class deleteUserPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id= (String) session.getAttribute("id");
		
		boolean isTrue ;
		
		isTrue = userPaymentDButil.deleteUserPayment(id);
	
		if (isTrue == true) {
			List<userPayment> uPayDet = userPaymentDButil.getUserPaymentDetails();
	      	request.setAttribute("uPayDetail", uPayDet);
			session.setAttribute("result","successDeleteUserPay");
	      	
			RequestDispatcher dis = request.getRequestDispatcher("adminAlertBoxes.jsp");
			dis.forward(request, response);
		}
		else 
		{	
			session.setAttribute("result","failDeleteUserPay");
			RequestDispatcher dis2 = request.getRequestDispatcher("adminAlertBoxes.jsp");
			dis2.forward(request, response);
		}
	}

}
