package Delivery;

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
 * Servlet implementation class UProfileDeliveryDet
 */
@WebServlet("/UProfileDeliveryDet")
public class UProfileDeliveryDet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	HttpSession session = request.getSession();
		String LoggedUser = (String) session.getAttribute("LoggedUser");
    	
    	try {
			List<DeliveryUserDetails> deliveryUserDetail = DeliveryDBUtil.deliveryUserDetails(LoggedUser);
			request.setAttribute("deliveryUserDetail", deliveryUserDetail);	
		}
   
		catch (Exception e) {				
			e.printStackTrace();
		}
	        
	    RequestDispatcher dis = request.getRequestDispatcher("UserProfileDeliverDetails.jsp");
	    dis.forward(request, response);
	}

}
