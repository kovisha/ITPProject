package controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.categoryDao;
import model.Category;


@WebServlet("/CategoryDelete")
public class CategoryDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//getting the category id to delete
		String cid = request.getParameter("id");
		//String catname = request.getParameter("categoryName");
		
		boolean isTrue;//to catch boolean value
		 
		isTrue = categoryDao.delete(cid);//passing values 
		
		 
		if(isTrue == true) {
			//returns an array type value from categoryList
			List<Category> listCategory = categoryDao.getCategoryList();
			request.setAttribute("listCatgory",  listCategory);
			RequestDispatcher dis = request.getRequestDispatcher("ViewCategory.jsp");
		
			dis.forward(request, response);
			
		}else {
			
			//if boolean values is false not entered succesfully
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("deleteUnsuccess.jsp");
			dispatcher.forward(request, response);
		}
		
}

}