package package2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import package2.SupplierPaymentDBUtil;

/**
 * Servlet implementation class SupplierPaymentDeleteServlet
 */
@WebServlet("/SupplierPaymentDeleteServlet")
public class SupplierPaymentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String suppPayID = request.getParameter("suppPayID");
		String stockid = request.getParameter("stockid");
		double totalAmount = Double.parseDouble(request.getParameter("totalAmount"));
		double paidAmount = Double.parseDouble(request.getParameter("paidAmount"));
		
		boolean isTrue;
		
		isTrue = SupplierPaymentDBUtil.deleteSupplierpayment(suppPayID, stockid, totalAmount, paidAmount);
		
		if(isTrue == true) {
			
			//List<Event> eventDetails = AddEventDBUtil.displayUpdateEvent(id);
			//request.setAttribute("eventDetails" , eventDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("ViewSupplierPayment.jsp");
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
