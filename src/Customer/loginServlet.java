package Customer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
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
		
		//getting the parameters of user enter from sign in form
			String username = request.getParameter("uname");
			String password = request.getParameter("password");
			
			PrintWriter out = response.getWriter();
			
		//dao class instantiation
			UserDAO user = new UserDAO();
			
			boolean userexist = user.validate(username, password);
			
			
			try { //exceptions handled
				
				
				if(userexist == true)
				{
					
					// set user details in session...
					HttpSession session = request.getSession();
					session.setAttribute("LoggedUser", username);
					session.setAttribute("LoggedPass", password);
					
					// Redirect the web page to home page...
					//response.sendRedirect("Home.jsp");
					
					HttpSession session1 = request.getSession();
					session1.setAttribute("result","LoginSuccess");
					RequestDispatcher dis = request.getRequestDispatcher("userAlerts.jsp");
					dis.forward(request, response);
					
				}
				
				else
				{
					
					// user not exist Redirect the web page to login page 
					//response.sendRedirect("login.jsp");
					HttpSession session1 = request.getSession();
					session1.setAttribute("result","LoginFail");
					RequestDispatcher dis = request.getRequestDispatcher("userAlerts.jsp");
					dis.forward(request, response);
				}
				
			
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}	
		
	}

}
