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
 * Servlet implementation class stockDelete
 */
@WebServlet("/stockDelete")
public class stockDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getting the stock id to delete
				String itemid = request.getParameter("id");
				
				boolean isTrue;//to catch boolean value
				HttpSession session = request.getSession(); 
				
				isTrue = stockDao.delete(itemid);//passing values 
				
				 
				if(isTrue == true) {
					//returns an array type value from categoryList
					List<Stock> listStock = stockDao.getStockList(response);
					request.setAttribute("listStock",  listStock);
					
					session.setAttribute("result","deleteStockSuccess");
					RequestDispatcher dis = request.getRequestDispatcher("ItemManagingAlerts.jsp");
					dis.forward(request, response);
					
				}else {
					
					//if boolean values is false not entered succesfully
					
					session.setAttribute("result","deleteStockFail");
					RequestDispatcher dis = request.getRequestDispatcher("ItemManagingAlerts.jsp");
					dis.forward(request, response);
				}

			}

}
