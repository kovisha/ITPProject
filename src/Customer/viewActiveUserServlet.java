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
 * Servlet implementation class viewActiveUserServlet
 */
@WebServlet("/viewActiveUserServlet")
public class viewActiveUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
		//calling the dao method to retrieve users
      	  List<CustomerOrder> custDetail = adminDAO.getAllUsers();
      	  request.setAttribute("custDetail", custDetail);
	    }
	    catch (Exception e) {
		e.printStackTrace();
	    }
	    
	    //on success redirects to a view user page
	    RequestDispatcher dis = request.getRequestDispatcher("viewUsers.jsp");
	    dis.forward(request, response);  
	}

}
