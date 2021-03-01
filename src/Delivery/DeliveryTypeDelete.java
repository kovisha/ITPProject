package Delivery;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class DeliveryTypeDelete
 */
@WebServlet("/DeliveryTypeDelete")
public class DeliveryTypeDelete extends HttpServlet {	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("DTID"));
		HttpSession session = request.getSession();
		boolean isTrue;
		
		isTrue = DeliveryDBUtil.deleteDeliveryType(id);
		
		try 
		{	if(isTrue == true){
				session.setAttribute("result","successDeletedeliveryType");
				RequestDispatcher dis = request.getRequestDispatcher("DeliveryAlertBox.jsp");
				dis.forward(request, response);
			}
			
			else {
				session.setAttribute("result","failedDeletedeliveryType");
				RequestDispatcher dis = request.getRequestDispatcher("DeliveryAlertBox.jsp");
				dis.forward(request, response);
			}	    	
		
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
