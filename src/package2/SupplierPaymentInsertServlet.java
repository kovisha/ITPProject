package package2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession();
		
		String stockid = request.getParameter("stockid");
		String discounttype = request.getParameter("discounttype");
		float discpercent = Float.parseFloat(request.getParameter("discountpercentage"));
		double totalAmount = Double.parseDouble(request.getParameter("totalamount"));
		
		boolean isTrue;
		
		isTrue = SupplierPaymentDBUtil.insertsupplierpayment(stockid,  discounttype, discpercent, totalAmount);
			
		if(isTrue == true) {
			session.setAttribute("result","successInsertSupplierPayment");
			RequestDispatcher dis = request.getRequestDispatcher("AlertBoxSupplier.jsp");
			dis.forward(request,response);
			
		}else {
			session.setAttribute("result","failedInsertSupplierPayment");
			RequestDispatcher dis2 = request.getRequestDispatcher("AlertBoxSupplier.jsp");
			dis2.forward(request,response);
		}
		
		
	}

}
