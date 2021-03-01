package Delivery;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/CusDeliveryDetailsInsertServlet")
public class CusDeliveryDetailsInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		HttpSession session = request.getSession();
		String orderid = (String) session.getAttribute("orderid");

		boolean isTrue = false;
		String dtype, delAddress; 
		
		dtype = request.getParameter("dtype");
		delAddress = request.getParameter("address");
		String LoggedUser = (String) session.getAttribute("LoggedUser");
		
		if (delAddress == null) {
				
			isTrue = DeliveryDBUtil.insertCusDeliveryTypeDetailsWithoutAddress(orderid, dtype, LoggedUser);
		}
		
		else{
			isTrue = DeliveryDBUtil.insertCusDeliveryTypeDetailsWithAddress(orderid, dtype, delAddress, LoggedUser);
		}
		
		
		if(isTrue == true){		
			session.setAttribute("result","successcusInsertDelDetails");
			RequestDispatcher dis = request.getRequestDispatcher("DeliveryUserAlert.jsp");
			dis.forward(request, response);
		}
		else{
			session.setAttribute("result","failedcusInsertDelDetails");
			RequestDispatcher dis = request.getRequestDispatcher("DeliveryUserAlert.jsp");
			dis.forward(request, response);
		}
		
	}

}
