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
 * Servlet implementation class changePasswordServlet
 */
@WebServlet("/changePasswordServlet")
public class changePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changePasswordServlet() {
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
		
		//setting sesion
		HttpSession session = request.getSession();
		String LoggedUser = (String) session.getAttribute("LoggedUser");
		String LoggedPass = (String) session.getAttribute("LoggedPass");
		
		//getting the parameters
		String pass = request.getParameter("pass");
		String npass = request.getParameter("npass");
		String renpass = request.getParameter("renpass");
		
		//checking if the logged in password and given password matches
		if (LoggedPass.equals(pass)) {
			if(npass.equals(renpass))//matching the new passwords
			{
				
				boolean isTrue;
				
				UserDAO u1 = new UserDAO();
				isTrue = u1.changePassword(LoggedUser, npass);//calling method to change password
				
				//on success
				if(isTrue == true)
				{
					//session for alerts
					HttpSession session1 = request.getSession();
					session1.setAttribute("result","ChangeSuccess");
					RequestDispatcher dispatcher = request.getRequestDispatcher("userAlerts.jsp");//alerts
		  		  	dispatcher.forward(request, response);
					
				}
				
				else//if failed
				{
					//session for alerts
					HttpSession session1 = request.getSession();
					session1.setAttribute("result","ChangeFailed");
					RequestDispatcher dispatcher = request.getRequestDispatcher("userAlerts.jsp");//alerts
			  		dispatcher.forward(request, response);
					//System.out.println("update failed");
				}
			}

			else
			{
				response.sendRedirect("changePassword.jsp");
			}
		}
		else {
			response.sendRedirect("changePassword.jsp");
		}
		
	}

}
