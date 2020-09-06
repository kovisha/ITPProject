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
 * Servlet implementation class retrieveInstallmentTypeServlet
 */
@WebServlet("/installmentTypeServlet")
public class retrieveInstallmentTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
	      	  List<installmentType> installTypeDet = installmentDButil.getInstallmentTypeDetails();
	      	  request.setAttribute("installTypeDetail", installTypeDet);
		    }
		    catch (Exception e) {
			e.printStackTrace();
		    }
		    
		    
		    RequestDispatcher dis = request.getRequestDispatcher("DisplayInstallmentType.jsp");
		    dis.forward(request, response);
	}

}
