package package1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import package1.SupplierDBUtil;

/**
 * Servlet implementation class SupplierInsertServlet
 */
@WebServlet("/SupplierInsertServlet")
public class SupplierInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String name = request.getParameter("suppliername");
		String status = request.getParameter("status");
		String address = request.getParameter("supplieraddress");
		String email = request.getParameter("supplieremail");
		String phone1 = request.getParameter("supplierphone1");
		String phone2 = request.getParameter("supplierphone2");
		String description = request.getParameter("description");
		
		boolean isTrue;
		
		isTrue = SupplierDBUtil.insertsupplier(name, status, address, email, phone1, phone2, description);
 
		if(isTrue == true) {
			session.setAttribute("result","successInsertSupplier");
			RequestDispatcher dis = request.getRequestDispatcher("AlertBoxSupplier.jsp");
			dis.forward(request,response);
			
		}else {
			session.setAttribute("result","failedInsertSupplier");
			RequestDispatcher dis2 = request.getRequestDispatcher("AlertBoxSupplier.jsp");
			dis2.forward(request,response);
		}
		
	}

}
