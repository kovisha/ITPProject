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



/**
 * Servlet implementation class tempCartRetrieveServlet
 */
@WebServlet("/tempCartRetrieveServlet")
public class tempCartRetrieveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		double installValue= 0;
		double totalPayment = 0;
		
		ShoppingCartTotalAmount tot = new ShoppingCartTotalAmount();
		
		
		HttpSession session = request.getSession();
		String LoggedUser = (String) session.getAttribute("LoggedUser");
		
		
		
		try {
			
			 
			installValue = ShoppingCartDbUtil.retreiveTotalForHomeApply(LoggedUser);
			
		     
				
			List<ShoppingCart> shop =ShoppingCartDbUtil.retreiveData(LoggedUser);
	    	request.setAttribute("cartDetails", shop);
	    	
	    	List<ShoppingCartTotalAmount> shop1 = ShoppingCartDbUtil.retreiveTotal(LoggedUser);
	    	request.setAttribute("total", shop1);
	    	
	    	
	    	totalPayment = tot.getTotal();
	    	session.setAttribute("totAmount", totalPayment);
	    			
	    	
	    	
	    	
	     }
	     
	     catch(Exception e)
	     {
	    	 e.printStackTrace();
	    	 
	     }
       
		session.setAttribute("installvalue", installValue);
       RequestDispatcher dis  = request.getRequestDispatcher("OrderSummary.jsp");
       dis.forward(request, response);
				
	}
}
