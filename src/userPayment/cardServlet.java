package userPayment;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Installment.installmentDButil;
import Installment.installmentType;

/**
 * Servlet implementation class cardServlet
 */
@WebServlet("/cardServlet")
public class cardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();	
		String installType= (String) session.getAttribute("insType");
		double totAmount = (double) session.getAttribute("totAmount");
		
		if(installType == null) {
			installType = "NotUsing";
		}
		
		if(installType.equals("install")) {
			try {
	        	  List<installmentType> typeDet = installmentDButil.getInstallmentTypeDetails();
	        	  request.setAttribute("typeDetail", typeDet);
	  	    }
	  	    catch (Exception e) {
	  		e.printStackTrace();
	  	    }
			
			RequestDispatcher dis = request.getRequestDispatcher("userInstall01.jsp");
			dis.forward(request, response);
		}
		else {
			double installmentValue = 99;
			session.setAttribute("payInstall", installmentValue);
			request.setAttribute("totAmount", totAmount);
		    response.sendRedirect("calculatePaymentServlet");

		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
      	  List<installmentType> typeDet = installmentDButil.getInstallmentTypeDetails();
      	  request.setAttribute("typeDetail", typeDet);
	    }
	    catch (Exception e) {
		e.printStackTrace();
	    }
		
		RequestDispatcher dis = request.getRequestDispatcher("userInstall01.jsp");
		dis.forward(request, response);
		
	}

}
