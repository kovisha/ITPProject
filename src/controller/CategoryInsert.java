package controller;

import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.categoryDao;


@WebServlet("/CategoryInsert")
public class CategoryInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 //response.setContentType("text/html;charset-UTF-5"); 
		 //PrintWriter out = response.getWriter();
		//enctype="multipart/form-data"
				 
			    //Assigning the values in the jsp file variables to parameters to be passed to the Dbutil
		 
		  String categoryid =  request.getParameter("id");
		  String categoryName =  request.getParameter("categoryName");
		 
		
		  //declaring boolean type variable
			 boolean isTrue;
				
			 //assigning the return type to boolean type variable whether true or false
				isTrue = categoryDao.insertCategory(categoryid,categoryName);
				
				//if boolean type is true
				if(isTrue == true) {
					//If the db connection is  successful and the data is been inserted to DB
					
					
					//redirecting to the jsp page
					RequestDispatcher dis = request.getRequestDispatcher("AdminDashBoard.jsp");
					dis.forward(request, response);
				}else {
					//if boolean type is false	
					
					
					//If our DB connection is not a success.
					RequestDispatcher dis2 = request.getRequestDispatcher("insertUnsucess.jsp");
					dis2.forward(request, response);
				}
				
		    
		}

}
