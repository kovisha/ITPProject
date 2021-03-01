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
 * Servlet implementation class userProfileServlet
 */
@WebServlet("/userProfileServlet")
public class userProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//getting logged user name using session
		HttpSession session = request.getSession();
		String LoggedUser = (String) session.getAttribute("LoggedUser");
		
		
		try {
			
			List<User> UserDetail = UserDAO.getUsers(LoggedUser);//retrieving details
			request.setAttribute("UserDetail", UserDetail);
			
			String retrieveImage = UserDAO.getImg(LoggedUser, response);//image retrieval
			session.setAttribute("UserImage", retrieveImage);//setting to session
	    }
	    catch (Exception e) {
		e.printStackTrace();
	    }
	    
	    //on success redirects to a user profile page
		RequestDispatcher dis = request.getRequestDispatcher("UserProfile.jsp");
	    dis.forward(request, response);  
	}

}
