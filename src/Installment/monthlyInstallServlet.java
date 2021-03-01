package Installment;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import userPayment.userPaymentDButil;
import userPayment.yourPayDetails;

/**
 * Servlet implementation class monthlyInstallServlet
 */
@WebServlet("/monthlyInstallServlet")
public class monthlyInstallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String uid = (String)session.getAttribute("userId");
		
		boolean isTrue ;
		
		isTrue = installmentDButil.payMonthlyInstalllment(uid);
	
		if (isTrue == true) {
			List<yourPayDetails> yourPayDet = userPaymentDButil.getYourPaymentDetails(uid);
	      	request.setAttribute("yourPayDetail", yourPayDet);
			session.setAttribute("resultMonth","successMonthInstall");
			
			RequestDispatcher dis = request.getRequestDispatcher("userYourPayDetails.jsp");
			dis.forward(request, response);
		}
		else 
		{	
			List<yourPayDetails> yourPayDet = userPaymentDButil.getYourPaymentDetails(uid);
	      	request.setAttribute("yourPayDetail", yourPayDet);
			session.setAttribute("resultMonth","failMonthInstall");
			RequestDispatcher dis2 = request.getRequestDispatcher("userYourPayDetails.jsp");
			dis2.forward(request, response);
		};
	}

}
