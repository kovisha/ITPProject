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
 * Servlet implementation class SupplierPaymentInsertServlet
 */
@WebServlet("/SupplierPaymentInsertServlet")
public class SupplierPaymentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String suppPayID = request.getParameter("supplierpayid");
		String stockid = request.getParameter("stockid");
		String discID = request.getParameter("discountid");
		String discounttype = request.getParameter("discounttype");
		float discpercent = Float.parseFloat(request.getParameter("discountpercentage"));
		double totalAmount = Double.parseDouble(request.getParameter("totalamount"));
		
		
		boolean isTrue;
		
		isTrue = SupplierPaymentDBUtil.insertsupplierpayment(suppPayID, stockid, discID, discounttype, discpercent, totalAmount);
		
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("Success.jsp");
			dis.forward(request,response);
			
		}else {
			RequestDispatcher dis2 = request.getRequestDispatcher("Unsuccess.jsp");
			dis2.forward(request,response);
		}
		
		
	}

}
