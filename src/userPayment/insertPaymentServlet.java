package userPayment;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Installment.installmentDButil;
import Offer.offerDButil;

/**
 * Servlet implementation class insertPaymentServlet
 */
@WebServlet("/insertPaymentServlet")
public class insertPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		boolean isTrue,isTrue2;
		
		HttpSession session = request.getSession();
		double downPay = (double) session.getAttribute("payInstall");
		double netTotal = (double) session.getAttribute("netTotal");
		String payType = (String) session.getAttribute("pType"); 
		String orderId = (String) session.getAttribute("orderId");
		LocalDate d =java.time.LocalDate.now();
		userPaymentIdGenerator upyId = new userPaymentIdGenerator();
		String uPayId = upyId.userPaymentIdGenerator();
		
		try {
			 isTrue2 = userPaymentDButil.insertPaymentDetail(uPayId,payType, netTotal, orderId,d);
			 if (isTrue2 != true) {
				 	session.setAttribute("out","fail");
					RequestDispatcher dis = request.getRequestDispatcher("userAlert.jsp");
					dis.forward(request, response);
				}
				
			
			if(downPay != 99.0 ) {
				double installemntValue = (double) session.getAttribute("installvalue");
				int installType = (int) session.getAttribute("installType");
				
				isTrue = installmentDButil.insertInstallmentDetail(uPayId, installemntValue, downPay, installType);
				
				if (isTrue != true) {
					session.setAttribute("out","fail");
					RequestDispatcher dis = request.getRequestDispatcher("userAlert.jsp");
					dis.forward(request, response);
				}
				
			}
			
			session.setAttribute("out","success");
			RequestDispatcher dis = request.getRequestDispatcher("userAlert.jsp");
			dis.forward(request, response);
		}
		catch(Exception ex) {
			
		}
		
		
	}

}
