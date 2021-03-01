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
 * Servlet implementation class loyaltyPointsAddServlet
 */
@WebServlet("/loyaltyPointsAddServlet")
public class loyaltyPointsAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loyaltyPointsAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

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
		
		//catch boolean value
		boolean isTrue;
		
		//user dao instantiation
		UserDAO u1 = new UserDAO();
		
		isTrue = u1.addLoyaltyPoints(LoggedUser, amt);
		
		//on successful update
		if(isTrue == true) {
			
			HttpSession session1 = request.getSession();
			session1.setAttribute("result","CalcSuccess");
			RequestDispatcher dis = request.getRequestDispatcher("userAlerts.jsp");
			dis.forward(request, response);
			
			/*RequestDispatcher dis = request.getRequestDispatcher("DeliverDetails.jsp");//calling method
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
