package Delivery;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewSuggestions
 */
@WebServlet("/ViewSuggestions")
public class ViewSuggestions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			List<Suggestions> suggestions = DeliveryDBUtil.getSuggestionsDetails();
			request.setAttribute("suggestions", suggestions);	
		}
   
		catch (Exception e) {				
			e.printStackTrace();
		}
	        
	    RequestDispatcher dis = request.getRequestDispatcher("Suggestions.jsp");
	    dis.forward(request, response);
	}

}
