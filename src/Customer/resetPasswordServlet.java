package Customer;

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
 * Servlet implementation class resetPasswordServlet
 */
@WebServlet("/resetPasswordServlet")
public class resetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public resetPasswordServlet() {
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
		//getting the form values
		String password = request.getParameter("npass");
		String email = request.getParameter("email");
		
		//catch boolean value
		boolean isTrue;
		
		//dao class instantiation
		UserDAO u1 = new UserDAO();
		
		isTrue = u1.resetPassword(email,password);//calling reset method
		
		//on success
		if(isTrue == true)
		{
			//session for alerts
			HttpSession session1 = request.getSession();
			session1.setAttribute("result","ResetSuccess");
			RequestDispatcher dispatcher = request.getRequestDispatcher("userAlerts.jsp");//alerts
  		  	dispatcher.forward(request, response);
		}
		//on fail
		else
		{
			//session for alerts
			HttpSession session1 = request.getSession();
			session1.setAttribute("result","ResetFailed");
			RequestDispatcher dispatcher = request.getRequestDispatcher("userAlerts.jsp");//alerts
	  		dispatcher.forward(request, response);
		}
	}

}
