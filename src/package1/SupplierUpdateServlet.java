package package1;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import package1.SupplierDBUtil;
import package1.Supplier;

/**
 * Servlet implementation class SupplierUpdateServlet
 */
@WebServlet("/SupplierUpdateServlet")
public class SupplierUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String supplierID = request.getParameter("supplierID");
		String name = request.getParameter("name");
		String status = request.getParameter("status");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String description = request.getParameter("description");
		
		boolean isTrue;
		
		isTrue = SupplierDBUtil.updateSupplier(supplierID, name, status, address , email , phone1, phone2, description);
		
		if(isTrue == true) {
			List<Supplier> supplierDetails = SupplierDBUtil.displaysupplier1();
			request.setAttribute("supplierDetails" , supplierDetails);
			
			session.setAttribute("result","successUpdateSupplier");
			RequestDispatcher dis = request.getRequestDispatcher("AlertBoxSupplier.jsp");
			dis.forward(request , response);
		}
		else {
			List<Supplier> supplierDetails = SupplierDBUtil.displaysupplier1();
			request.setAttribute("supplierDetails" , supplierDetails);
			
			session.setAttribute("result","failedUpdateSupplier");
			RequestDispatcher dis = request.getRequestDispatcher("AlertBoxSupplier.jsp");
			dis.forward(request , response);
		}
		
	}

}
