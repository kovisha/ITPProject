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
 * Servlet implementation class adminloginServlet
 */
@WebServlet("/adminloginServlet")
public class adminloginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminloginServlet() {
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
				String username = request.getParameter("userName");
				String password = request.getParameter("pw");
				
				//dao class instantiation
				adminDAO admin = new adminDAO();
				
				boolean userexist = admin.validateAdmin(username, password);
				
				
				try { //exceptions handled
					
					
					if(userexist == true)
					{
						// if it is exist, get the user details using UserLogin...
						StaffUser s1 = adminDAO.checkAdmin(username, password);
						
						// set user details in session...
						HttpSession session = request.getSession();
						session.setAttribute("loggedStaff", s1);
						
						// Redirect the web page to home page...
						HttpSession session1 = request.getSession();
						session1.setAttribute("result","loginSuccess");
						RequestDispatcher dis = request.getRequestDispatcher("adminAlerts.jsp");
						dis.forward(request, response);
						
						//response.sendRedirect("adminDashboard.jsp");
						
					}
					
					else
					{
						HttpSession session1 = request.getSession();
						session1.setAttribute("result","loginFailed");
						RequestDispatcher dis = request.getRequestDispatcher("adminAlerts.jsp");
						dis.forward(request, response);
						// user not exist Redirect the web page to login page 
						//response.sendRedirect("adminLogin.jsp");
					}
					
				
					
				}catch(Exception e)
				{
					e.printStackTrace();
				}	
			
	}

}
