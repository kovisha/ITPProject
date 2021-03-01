package package2;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import package2.SupplierPayment;
import package2.SupplierPaymentDBUtil;

/**
 * Servlet implementation class DisplaySupplierPaymentServlet
 */
@WebServlet("/DisplaySupplierPaymentServlet")
public class DisplaySupplierPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			List <SupplierPayment> supplierPaymentDetails = SupplierPaymentDBUtil.displaysupplierpayment1();
			request.setAttribute("supplierPaymentDetails" , supplierPaymentDetails);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("ViewSupplierPayment.jsp");
		dis.forward(request , response);
	
	}

}
