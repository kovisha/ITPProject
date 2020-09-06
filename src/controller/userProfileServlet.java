package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import dao.UserDAO;

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
		
		HttpSession session = request.getSession();
		String LoggedUser = (String) session.getAttribute("LoggedUser");
		//int uID = LoggedUser.getID();
		//String uID = LoggedUser.getUName();
		
		
		try {
			//calling the dao method to retrive doctors
      	  //List<User> UserDetails = UserDAO.getUsers();
      	 // request.setAttribute("UserDetails", UserDetails);
			List<User> UserDetail = UserDAO.getUsers(LoggedUser);
			request.setAttribute("UserDetail", UserDetail);
	    }
	    catch (Exception e) {
		e.printStackTrace();
	    }
	    
	    //on success redirects to a doctor page
	    //RequestDispatcher dis = request.getRequestDispatcher("UserProfile.jsp");
		RequestDispatcher dis = request.getRequestDispatcher("UserProfile.jsp");
	    dis.forward(request, response);  
	}

}
