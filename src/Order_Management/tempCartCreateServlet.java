package Order_Management;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Order_Management.Offer;
import Order_Management.offerDbUtil;

/**
 * Servlet implementation class tempCartCreateServlet
 */
@WebServlet("/tempCartCreateServlet")
public class tempCartCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String LoggedUser = (String) session.getAttribute("LoggedUser");
		
		boolean isTrue;
		
		isTrue = ShoppingCartDbUtil.cartCreation(LoggedUser);
		
		try {
            List<Offer> offDetails =offerDbUtil.display(response);
            request.setAttribute("offDetails", offDetails);
		     }
		     
		     catch(Exception e)
		     {
		    	 e.printStackTrace();
		    	 
		     }
		
		if(isTrue == true )
		{
			RequestDispatcher dis = request.getRequestDispatcher("search.jsp");
			dis.forward(request, response);
			
		}
		
		else
		{
			RequestDispatcher dis = request.getRequestDispatcher("Test2.jsp");
			dis.forward(request, response);
			
		}
	}

}
