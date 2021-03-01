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
 * Servlet implementation class DeliveryTypeUpdateServlet
 */
@WebServlet("/DeliveryTypeUpdateServlet")
public class DeliveryTypeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String DTID =request.getParameter("DTID");
		
		try {
      	
				List<DeliveryType> DeliveryTypeDetails = DeliveryDBUtil.getDeliveryTypeDetail(DTID);
				request.setAttribute("DeliveryTypeDetails", DeliveryTypeDetails);
								
		}
	   
		catch (Exception e) {
				
			e.printStackTrace();
	   
		}
	        
	    RequestDispatcher dis = request.getRequestDispatcher("viewUpdateDeliveryTypeDetails.jsp");
	    dis.forward(request, response);
	}

}
