package Installment;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.RoundingMode;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class userInputInstallmentServlet
 */
@WebServlet("/userInputInstallmentServlet")
public class userInputInstallmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		double installmentValue = (double) session.getAttribute("installvalue");
		int installType = Integer.parseInt(request.getParameter("installType"));
		double downPay = Double.parseDouble(request.getParameter("downPayAmount"));
		double min = (double)(installmentValue*10)/100;
		double monthlyInstall = ((double)(installmentValue-downPay)/installType);
		String str = String.format("%1.2f", monthlyInstall);
		monthlyInstall = Double.valueOf(str);
		session.setAttribute("installType",installType);
		
		if(min > downPay) {  
			session.setAttribute("out", "failDownpay");
		    response.sendRedirect("userAlert.jsp");
		}
		else {
			session.setAttribute("payInstall", downPay);
			request.setAttribute("installmentValue", installmentValue);
			request.setAttribute("installType", installType);
			request.setAttribute("monthlyInstall", monthlyInstall);
			RequestDispatcher dis = request.getRequestDispatcher("userInstall02.jsp");
		    dis.forward(request, response);    
		}
	}

}
