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
 * Servlet implementation class orderInsertServlet
 */
@WebServlet("/orderInsertServlet")
public class orderInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		String LoggedUser = (String) session.getAttribute("LoggedUser");
		
		Double total = Double.parseDouble(request.getParameter("total"));
		
		
		OrderIdGenerator id = new OrderIdGenerator(); 
		String orderid = id.OrderIDgenerator();
		
		session.setAttribute("orderid", orderid);
		
		
        boolean isTrue;
		
		isTrue = OrderDbUtil.insertOrder(LoggedUser, total,orderid);
		

		/*
		 * List<ShoppingCart> shop =ShoppingCartDbUtil.retreiveData(LoggedUser);
		 * request.setAttribute("cartDetails", shop);
		 * 
		 * List<ShoppingCartTotalAmount> shop1 =
		 * ShoppingCartDbUtil.retreiveTotal(LoggedUser); request.setAttribute("total",
		 * shop1);
		 */
		
		if(isTrue == true )
		{
			List<ShoppingCart> shop =ShoppingCartDbUtil.retreiveData(LoggedUser);
	    	request.setAttribute("cartDetails", shop);
	    	
	    	List<ShoppingCartTotalAmount> shop1 = ShoppingCartDbUtil.retreiveTotal(LoggedUser);
	    	request.setAttribute("total", shop1);
			
			session.setAttribute("result2","successorderplacement");
			RequestDispatcher dis = request.getRequestDispatcher("alertForOrderplacement.jsp");
			dis.forward(request, response);
			
		}
		
		else
		{
			

			List<ShoppingCart> shop =ShoppingCartDbUtil.retreiveData(LoggedUser);
	    	request.setAttribute("cartDetails", shop);
	    	
	    	List<ShoppingCartTotalAmount> shop1 = ShoppingCartDbUtil.retreiveTotal(LoggedUser);
	    	request.setAttribute("total", shop1);
	    	
			session.setAttribute("result2","failedorderplacement");
			RequestDispatcher dis = request.getRequestDispatcher("alertForOrderplacement.jsp");
			dis.forward(request, response);
			
		}
		
	}

}
