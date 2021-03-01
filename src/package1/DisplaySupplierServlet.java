package package1;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import package1.SupplierDBUtil;
import package1.Supplier;

/**
 * Servlet implementation class DisplaySupplierServlet
 */
@WebServlet("/DisplaySupplierServlet")
@MultipartConfig(maxFileSize = 16177216)//1.5mb
public class DisplaySupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			List <Supplier> supplierDetails = SupplierDBUtil.displaysupplier1();
			request.setAttribute("supplierDetails" , supplierDetails);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("ViewSupplier.jsp");
		dis.forward(request , response);
	}


}
