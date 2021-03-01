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
 * Servlet implementation class deleteInstallmentServlet
 */
@WebServlet("/deleteInstallmentServlet")
public class deleteInstallmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id= (String) session.getAttribute("id");
		
		boolean isTrue ;
		
		isTrue = installmentDButil.deleteInstallmentDetails(id);
	
		if (isTrue == true) {
			List<installment> installDet = installmentDButil.getInstallmentDetails();
			request.setAttribute("installDetail", installDet);
			session.setAttribute("result","successDeleteInstallDet");
			
			RequestDispatcher dis = request.getRequestDispatcher("adminAlertBoxes.jsp");
			dis.forward(request, response);
		}
		else 
		{	
			session.setAttribute("result","failDeleteInstallDet");
			RequestDispatcher dis2 = request.getRequestDispatcher("adminAlertBoxes.jsp");
			dis2.forward(request, response);
		}
	}

}
