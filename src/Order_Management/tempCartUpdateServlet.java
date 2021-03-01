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
 * Servlet implementation class tempCartUpdateServlet
 */
@WebServlet("/tempCartUpdateServlet")
public class tempCartUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String LoggedUser = (String) session.getAttribute("LoggedUser");

		String id = request.getParameter("id");
		String itemname =  request.getParameter("itemname");
		int qty = Integer.parseInt(request.getParameter("quantity"));
		
		Double price = Double.parseDouble(request.getParameter("price"));
		Double discount = Double.parseDouble(request.getParameter("discount"));
		
		Double netTotal = (qty * price)*((100-discount)/100);
		
		boolean isTrue;
		
		isTrue = ShoppingCartDbUtil.updateCart(LoggedUser, id, itemname, qty,netTotal);
		
		List<ShoppingCart> shop =ShoppingCartDbUtil.retreiveData(LoggedUser);
    	request.setAttribute("cartDetails", shop);
    	
    	List<ShoppingCartTotalAmount> shop1 = ShoppingCartDbUtil.retreiveTotal(LoggedUser);
    	request.setAttribute("total", shop1);
		
		if(isTrue == true )
		{
			RequestDispatcher dis = request.getRequestDispatcher("OrderSummary.jsp");
			dis.forward(request, response);
			
		}
		
		else
		{
			RequestDispatcher dis = request.getRequestDispatcher("Test3.jsp");
			dis.forward(request, response);
			
		}
		
		
	}

}
