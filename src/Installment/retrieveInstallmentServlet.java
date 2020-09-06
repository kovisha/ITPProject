package Installment;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class retrieveInstallmentServlet
 */
@WebServlet("/retrieveInstallmentServlet")
public class retrieveInstallmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
	      	  List<installment> installDet = installmentDButil.getInstallmentDetails();
	      	  request.setAttribute("installDetail", installDet);
		    }
		    catch (Exception e) {
			e.printStackTrace();
		    }
		    
		    
		    RequestDispatcher dis = request.getRequestDispatcher("DisplayInstallment.jsp");
		    dis.forward(request, response);
	}

}
