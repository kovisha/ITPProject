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

@WebServlet("/deliveryTypeRetrieveServlet")
public class deliveryTypeRetrieveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		try {
			List<DeliveryType> deliveryDetail = DeliveryDBUtil.getDeliveryTypeDetails();
			request.setAttribute("deliveryDetail", deliveryDetail);	
		}
   
		catch (Exception e) {				
			e.printStackTrace();
		}
	        
	    RequestDispatcher dis = request.getRequestDispatcher("AdminDeliveryType.jsp");
	    dis.forward(request, response);
	
	}


}
