package userPayment;

import java.io.IOException;
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
 * Servlet implementation class userPayServlet
 */
@WebServlet("/userPayServlet")
public class userPayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String payType = request.getParameter("payType");
		String installType = request.getParameter("installType");
		HttpSession session = request.getSession();
		double totAmount = (double) session.getAttribute("totAmount");
		
		
		if(installType == null) {
			installType = "NotUsing";
		}
		
		if(payType.equals("card")) {
			if(installType.equals("install")) {    
		        session.setAttribute("pType",payType);
		        session.setAttribute("insType",installType);
				RequestDispatcher dis = request.getRequestDispatcher("userCardInput.jsp");
				dis.forward(request, response);
			}
			else if(installType.equals("normal")){	   
		        session.setAttribute("pType",payType);
		        session.setAttribute("insType",installType);
				RequestDispatcher dis = request.getRequestDispatcher("userCardInput.jsp");
				dis.forward(request, response);
			}
			else {    
			
				session.setAttribute("insType","notInstall");
				session.setAttribute("pType",payType);
				RequestDispatcher dis = request.getRequestDispatcher("userCardInput.jsp");
				dis.forward(request, response);
			}
		}
		else if(payType.equals("cash")) {
			if(installType.equals("install")) {	    
		        session.setAttribute("pType",payType);
		        session.setAttribute("insType",installType);
		        
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
			else if(installType.equals("normal")){	
				double installmentValue = (double) session.getAttribute("installvalue");
				
		        session.setAttribute("pType",payType);
		        session.setAttribute("insType",installType);
		        request.setAttribute("totAmount", totAmount);
		        session.setAttribute("payInstall", installmentValue);
		        response.sendRedirect("calculatePaymentServlet");
			}
			else{    
				double installmentValue = 99;
				
		        session.setAttribute("pType",payType);
		        session.setAttribute("payInstall", installmentValue);
		        request.setAttribute("totAmount", totAmount);
		        response.sendRedirect("calculatePaymentServlet");
			}
		}
	}

}
