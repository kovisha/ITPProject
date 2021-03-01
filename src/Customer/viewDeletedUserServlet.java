package Customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewDeletedUserServlet
 */
@WebServlet("/viewDeletedUserServlet")
public class viewDeletedUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewDeletedUserServlet() {
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
		try {
			
		//calling the dao method to retrive users
      	  List<User> custDetail = adminDAO.getAllDeletedUsers();
      	  request.setAttribute("custDetail", custDetail);
	    }
	    catch (Exception e) {
		e.printStackTrace();
	    }
	    
	    //on success redirects to a user display page
	    RequestDispatcher dis = request.getRequestDispatcher("viewDeletedUser.jsp");
	    dis.forward(request, response);  
	}

}
