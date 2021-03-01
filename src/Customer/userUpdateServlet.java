package Customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class userUpdateServlet
 */
@WebServlet("/userUpdateServlet")
public class userUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userUpdateServlet() {
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
		
		PrintWriter out=response.getWriter();
		
		//getting the details of logged user
		HttpSession session = request.getSession();
		String LoggedUser = (String) session.getAttribute("LoggedUser");
		String LoggedPass = (String) session.getAttribute("LoggedPass");
		
		//getting the update form values to variables
		String password = request.getParameter("pass");
		String uname = request.getParameter("uname");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String dob = request.getParameter("dob");
		String anniversary = request.getParameter("doa");
		String occupation = request.getParameter("job");
		String phone = request.getParameter("phone");
		
		//checking passwords
		if (LoggedPass.equals(password)) {
			
			//catches boolean value
			boolean isTrue;
			
			//instance of dao class
			UserDAO u1 = new UserDAO();
			
			isTrue = u1.updateUser(uname ,fname ,lname , email, address, dob, anniversary, occupation,phone);//calling the method
			
			//update success
			if(isTrue == true)
			{
				//retrieving the updated variables to the logged user session
				List<User> UserDetail = UserDAO.getUsers(LoggedUser);
				request.setAttribute("UserDetail", UserDetail);
				
				//setting session for alerts
				HttpSession session1 = request.getSession();
				session1.setAttribute("result","updateSuccess");
				RequestDispatcher dispatcher = request.getRequestDispatcher("userAlerts.jsp");//alerts
	  		  	dispatcher.forward(request, response);
			}
			//update fail
			else
			{
				//setting session for alerts
				HttpSession session1 = request.getSession();
				session1.setAttribute("result","updateFailed");
				RequestDispatcher dispatcher = request.getRequestDispatcher("userAlerts.jsp");//alerts
		  		dispatcher.forward(request, response);
				//System.out.println("update failed");
			}
			
		//when password mismatch	
		}else {
			//response.sendRedirect("Logout");
			System.out.println("password doesnt match!");
		}
	}

}
