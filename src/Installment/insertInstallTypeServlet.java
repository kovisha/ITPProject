package Installment;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class insertInstallTypeServlet
 */
@WebServlet("/insertInstallTypeServlet")
public class insertInstallTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String desc = request.getParameter("desc");
		int months = Integer.parseInt(request.getParameter("months"));
		
			boolean isTrue;
			
			isTrue = installmentDButil.insertInstallType(desc,months);
			
			if (isTrue == true) {
				HttpSession session = request.getSession();
				session.setAttribute("result","successInsertInstallType");
				RequestDispatcher dis = request.getRequestDispatcher("adminAlertBoxes.jsp");
				dis.forward(request, response);
			}
			else{
				HttpSession session = request.getSession();
				session.setAttribute("result","failInsertInstallType");
				RequestDispatcher dis2 = request.getRequestDispatcher("adminAlertBoxes.jsp");
				dis2.forward(request, response);
			}
	}

}
