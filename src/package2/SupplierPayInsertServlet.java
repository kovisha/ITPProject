package package2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SupplierPayInsertServlet
 */
@WebServlet("/SupplierPayInsertServlet")
public class SupplierPayInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String suppPayID = request.getParameter("suppPayID");
		String lastPayDate = request.getParameter("payingdate");
		int chequeNo = Integer.parseInt(request.getParameter("chequenumber"));
		double paidAmount = Double.parseDouble(request.getParameter("payamount"));
		String invoiceNo = request.getParameter("invoicenumber");
		
		
		
		boolean isTrue;
		
		isTrue = SupplierPaymentDBUtil.insertsupplierpaynow(suppPayID, lastPayDate, chequeNo, paidAmount, invoiceNo);
		
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("ViewSupplierPayment.jsp");
			dis.forward(request,response);
			
		}else {
			RequestDispatcher dis2 = request.getRequestDispatcher("Unsuccess.jsp");
			dis2.forward(request,response);
		}
		
	}

}
