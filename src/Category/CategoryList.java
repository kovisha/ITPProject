	package Category;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/CategoryList")
public class CategoryList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//retrieve array type list of all category details from the dao
	try {
		
		List<Category> listCategory = categoryDao.getCategoryList();
		request.setAttribute("listCategory", listCategory);
	}
	catch(Exception e) {
		
		e.printStackTrace();
	}
		//navigating to the jsp page
		RequestDispatcher dispatcher = request.getRequestDispatcher("ViewCategory.jsp");
		dispatcher.forward(request, response);
	}

}
