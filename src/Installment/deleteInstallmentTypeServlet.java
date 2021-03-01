package Installment;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class deleteInstallmentTypeServlet
 */
@WebServlet("/deleteInstallmentTypeServlet")
public class deleteInstallmentTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id= (String) session.getAttribute("id");
		
		boolean isTrue ;
		
		isTrue = installmentDButil.deleteInstallmentTypeDetails(id);
	
		if (isTrue == true) {
			List<installmentType> installTypeDet = installmentDButil.getInstallmentTypeDetails();
	      	request.setAttribute("installTypeDetail", installTypeDet);
	      	session.setAttribute("result","successDeleteInstallType");
	      	  
			RequestDispatcher dis = request.getRequestDispatcher("adminAlertBoxes.jsp");
			dis.forward(request, response);
		}
		else 
		{	
			session.setAttribute("result","failDeleteInstallType");
			RequestDispatcher dis2 = request.getRequestDispatcher("adminAlertBoxes.jsp");
			dis2.forward(request, response);
		}
	}

}
