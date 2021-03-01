package Category;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebServlet("/CategoryUpdate")
public class CategoryUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//getting the category id and name to update
				String id = request.getParameter("id");
				String categoryName = request.getParameter("categoryName");
				
				
				//declaring the boolean type variable to store the return type from the dao
				HttpSession session = request.getSession();
				  boolean isTrue;
					
					isTrue = categoryDao.updateCategory( id ,categoryName);
					
					if(isTrue == true) {
						//If the db connection is a success and the data is been inserted DB
						List<Category> listCategory = categoryDao.getCategoryList();
						request.setAttribute("listCategory", listCategory);
						
						session.setAttribute("result","successUpdateCategory");
						RequestDispatcher dis = request.getRequestDispatcher("ItemManagingAlerts.jsp");
						dis.forward(request, response);
					}else {
						//If our DB connection is not a success.
						
						List<Category> listCategory = categoryDao.getCategoryList();
						request.setAttribute("listCatgory",  listCategory);
						
						
						session.setAttribute("result","failUpdateCategory");
						RequestDispatcher dis2 = request.getRequestDispatcher("ItemManagingAlerts.jsp");
						dis2.forward(request, response);
					}
				  
	}

}
