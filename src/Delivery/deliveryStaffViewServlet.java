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
 * Servlet implementation class deliveryStaffViewServlet
 */
@WebServlet("/deliveryStaffViewServlet")
public class deliveryStaffViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	try {
			List<DeliveryStaff> DeliveryStaffDetails = DeliveryDBUtil.getDeliveryStaffDetails();
			request.setAttribute("DeliveryStaffDetails", DeliveryStaffDetails);	
		}
   
		catch (Exception e) {				
			e.printStackTrace();
		}
	        
	    RequestDispatcher dis = request.getRequestDispatcher("AdminDeliveryStaff.jsp");
	    dis.forward(request, response);
		
	}


}
