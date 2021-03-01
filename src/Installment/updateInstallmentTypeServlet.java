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
 * Servlet implementation class updateInstallmentTypeServlet
 */
@WebServlet("/updateInstallmentTypeServlet")
public class updateInstallmentTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String desc = request.getParameter("desc");
		int months = Integer.parseInt(request.getParameter("months"));
		
			boolean isTrue;
			
			isTrue = installmentDButil.updateInstallType(id,desc,months);
			
			if (isTrue == true) {
				HttpSession session = request.getSession();
				session.setAttribute("result","successUpdateInstallType");
				List<installmentType> installTypeDet = installmentDButil.getInstallmentTypeDetails();
		      	request.setAttribute("installTypeDetail", installTypeDet);
				
				RequestDispatcher dis = request.getRequestDispatcher("adminAlertBoxes.jsp");
				dis.forward(request, response);
			}
			else{
				HttpSession session = request.getSession();
				session.setAttribute("result","failUpdateInstallType");
				RequestDispatcher dis2 = request.getRequestDispatcher("adminAlertBoxes.jsp");
				dis2.forward(request, response);
			}
	}

}
