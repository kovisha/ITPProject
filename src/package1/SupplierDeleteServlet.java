package package1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import package1.SupplierDBUtil;

/**
 * Servlet implementation class SupplierDeleteServlet
 */
@WebServlet("/SupplierDeleteServlet")
public class SupplierDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String supplierID = request.getParameter("supplierID");
		String name = request.getParameter("name");
		String status = request.getParameter("status");
		
		boolean isTrue;
		
		isTrue = SupplierDBUtil.deleteSupplier(supplierID,name,status);
		
		if(isTrue == true) {
			
			//List<Event> eventDetails = AddEventDBUtil.displayUpdateEvent(id);
			//request.setAttribute("eventDetails" , eventDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("ViewSupplier.jsp");
			dis.forward(request , response);
		}
		else {
			//List<Event> eventDetails = AddEventDBUtil.displayUpdateEvent(id);
			//request.setAttribute("eventDetails" , eventDetails);
			
			
			RequestDispatcher dis = request.getRequestDispatcher("ViewSupplier.jsp");
			dis.forward(request , response);
		}
	}
	

}
