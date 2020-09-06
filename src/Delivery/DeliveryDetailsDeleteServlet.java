package Delivery;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeliveryDetailsDeleteServlet
 */
@WebServlet("/DeliveryDetailsDeleteServlet")
public class DeliveryDetailsDeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String DID = request.getParameter("deliveryID");
		
		boolean isTrue;
		
//		change this to delete
		isTrue = false;
//		isTrue = DeliveryDBUtil.deleteDeliveryDetails(DID);
		
		try {	    	
	    	if(isTrue == true) {
				RequestDispatcher dis = request.getRequestDispatcher("ApointDeliveryStaff.jsp");
				dis.forward(request, response);
			}
			else {
				RequestDispatcher dis1 = request.getRequestDispatcher("unsuccess.jsp");
				dis1.forward(request, response);
			}

		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
