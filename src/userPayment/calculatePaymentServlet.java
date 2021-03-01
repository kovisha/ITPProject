package userPayment;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Offer.offerDButil;

/**
 * Servlet implementation class calculatePaymentServlet
 */
@WebServlet("/calculatePaymentServlet")
public class calculatePaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		double total = (double) session.getAttribute("totAmount");
		double totInstall = (double) session.getAttribute("payInstall");
		double grossTotal = 0;
	
		if(totInstall==99) {
			grossTotal = total;
		}
		else {
			grossTotal = total + totInstall;
		}
		int offerPerc = offerDButil.calculateTotal(grossTotal);
		
		double offerAmount = grossTotal*((double)offerPerc/100.0);
		double netTotal = grossTotal-offerAmount;
	
		String str = String.format("%1.2f", netTotal);
		netTotal = Double.valueOf(str);
		session.setAttribute("netTotal", netTotal);
		
		if (netTotal != 0 ) {
			request.setAttribute("netTotal",netTotal);
			session.setAttribute("offerAmount",offerAmount);
			session.setAttribute("offer",offerPerc);
			response.sendRedirect("getLoyaltyPoints");
		}
		else{
			RequestDispatcher dis = request.getRequestDispatcher("selectPayType.jsp");
			dis.forward(request, response);
		}
	}

}
