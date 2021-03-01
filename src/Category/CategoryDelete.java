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




@WebServlet("/CategoryDelete")
public class CategoryDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//getting the category id to delete
		String cid = request.getParameter("id");
		//String catname = request.getParameter("categoryName");
		
		
		HttpSession session = request.getSession();
		boolean isTrue;//to catch boolean value
		 
		isTrue = categoryDao.delete(cid);//passing values 
		
		 
		if(isTrue == true) {
			//returns an array type value from categoryList
			List<Category> listCategory = categoryDao.getCategoryList();
			request.setAttribute("listCatgory",  listCategory);
			
			
			session.setAttribute("result","successDeleteCategory");
			RequestDispatcher dis = request.getRequestDispatcher("ItemManagingAlerts.jsp");
			dis.forward(request, response);
			
		}else {
			
			//if boolean values is false not entered succesfully
			
			List<Category> listCategory = categoryDao.getCategoryList();
			request.setAttribute("listCatgory",  listCategory);
			
			
			session.setAttribute("result","failDeleteCategory");
			RequestDispatcher dis2 = request.getRequestDispatcher("ItemManagingAlerts.jsp");
			dis2.forward(request, response);
		}
		
}

}