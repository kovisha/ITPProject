package Customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loyaltyDeductServlet
 */
@WebServlet("/loyaltyDeductServlet")
public class loyaltyDeductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getting the logged user name using sessions
		HttpSession session = request.getSession();
		String LoggedUser = (String) session.getAttribute("LoggedUser");
		String LoggedPass = (String) session.getAttribute("LoggedPass");
		
		//getting the amount and points
		double amt = Double.parseDouble(request.getParameter("totAmnt")); 
		int pts = Integer.parseInt(request.getParameter("ptAmnt"));
		double finalAmt = amt-pts;
		
		//catch boolean value
		boolean isTrue;
		
		//user dao instantiation
		UserDAO u1 = new UserDAO();
		
		isTrue = u1.reduceLoyaltyPoints(LoggedUser, amt , pts);//calling method
		
		//on successful update
		if(isTrue == true) {
			
			HttpSession session1 = request.getSession();
			session1.setAttribute("result","CalcSuccess");
			RequestDispatcher dis = request.getRequestDispatcher("userAlerts.jsp");
			dis.forward(request, response);
			
			/*RequestDispatcher dis = request.getRequestDispatcher("DeliverDetails.jsp");
			dis.forward(request, response);*/
		}
		//if update fails
		else {
			HttpSession session1 = request.getSession();
			session1.setAttribute("result","CalcFail");
			RequestDispatcher dis = request.getRequestDispatcher("userAlerts.jsp");
			dis.forward(request, response);
			
			/*RequestDispatcher dis = request.getRequestDispatcher("loyaltyCalc.jsp");
			dis.forward(request, response);*/
		}
		
		
		
	}

}
