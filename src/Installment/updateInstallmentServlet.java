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
 * Servlet implementation class updateInstallmentServlet
 */
@WebServlet("/updateInstallmentServlet")
public class updateInstallmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("installmentId");
		int remainInstall = Integer.parseInt(request.getParameter("remainInstalls"));
		
			boolean isTrue;
			
			isTrue = installmentDButil.updateInstall(id,remainInstall);
			
			if (isTrue == true) {
				HttpSession session = request.getSession();
				session.setAttribute("result","successUpdateInstallDet");
				List<installment> installDet = installmentDButil.getInstallmentDetails();
				request.setAttribute("installDetail", installDet);
				
				RequestDispatcher dis = request.getRequestDispatcher("adminAlertBoxes.jsp");
				dis.forward(request, response);
			}
			else{
				HttpSession session = request.getSession();
				session.setAttribute("result","failUpdateInstallDet");
				RequestDispatcher dis2 = request.getRequestDispatcher("adminAlertBoxes.jsp");
				dis2.forward(request, response);
			}
	}

}
