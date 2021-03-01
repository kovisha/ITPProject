package Stock;

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
 * Servlet implementation class UpdateStockWithoutReorder
 */
@WebServlet("/UpdateStockWithoutReorder")
public class UpdateStockWithoutReorder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String stockName = request.getParameter("stockName");
		int qtySupplied = Integer.parseInt(request.getParameter("supQty"));
		String suppliedDate = request.getParameter("supDate");
		float stockSize = Float.parseFloat(request.getParameter("sSize"));
		//int reOrderLevel = Integer.parseInt(request.getParameter("rOrder"));
		int storeQty =Integer.parseInt(request.getParameter("qtySent"));
		String supplierName = request.getParameter("supname");
		String categoryName = request.getParameter("catname");
		int qtyAvailable = Integer.parseInt(request.getParameter("qtyAvaialbale"));
		
		//declaring the boolean type variable to store the return type from the dao
		  boolean isTrue;
		  HttpSession session = request.getSession();
		  
		  
			isTrue = stockDao.updateStockWithoutReorder(id, stockName, qtyAvailable, stockSize, qtySupplied, suppliedDate, storeQty, supplierName, categoryName);
			
			if(isTrue == true) {
				//If the db connection is a success and the data is been inserted DB
				List<Stock> listStock = stockDao.getStockList(response);
				request.setAttribute("listStock", listStock);
				
				session.setAttribute("result","updateStockSuccess");
				RequestDispatcher dis = request.getRequestDispatcher("ItemManagingAlerts.jsp");
				dis.forward(request, response);
			}else {
				//If our DB connection is not a success.
				session.setAttribute("result","updateStockFail");
				RequestDispatcher dis = request.getRequestDispatcher("ItemManagingAlerts.jsp");
				dis.forward(request, response);
			}
	}

}
