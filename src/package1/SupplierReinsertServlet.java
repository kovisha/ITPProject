package package1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SupplierReinsertServlet
 */
@WebServlet("/SupplierReinsertServlet")
public class SupplierReinsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String supplierID = request.getParameter("supplierID");

		boolean isTrue;
		
		isTrue = SupplierDBUtil.ReinsertSupplier(supplierID);
		
		if(isTrue == true) {
			session.setAttribute("result","successInsertSupplier");
			RequestDispatcher dis = request.getRequestDispatcher("AlertBoxSupplier.jsp");
			dis.forward(request , response);
		}
		else {
			session.setAttribute("result","failedInsertSupplier");
			RequestDispatcher dis = request.getRequestDispatcher("AlertBoxSupplier.jsp");
			dis.forward(request , response);
		}
	}
}
