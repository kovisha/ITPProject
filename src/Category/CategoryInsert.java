package Category;

import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebServlet("/CategoryInsert")
public class CategoryInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 //response.setContentType("text/html;charset-UTF-5"); 
		 //PrintWriter out = response.getWriter();
		//enctype="multipart/form-data"
				 
			    //Assigning the values in the jsp file variables to parameters to be passed to the Dbutil
		 
		  
		  String categoryName =  request.getParameter("categoryName");
		 
		
		  //declaring boolean type variable
			 boolean isTrue;
				
			 //assigning the return type to boolean type variable whether true or false
				isTrue = categoryDao.insertCategory(categoryName);
				
				//if boolean type is true
				if(isTrue == true) {
					//If the db connection is  successful and the data is been inserted to DB
					HttpSession session = request.getSession();
					session.setAttribute("result","successInsertCategory");
					RequestDispatcher dis = request.getRequestDispatcher("ItemManagingAlerts.jsp");
					dis.forward(request, response);
					
					
					
				}else {
					//if boolean type is false	
					HttpSession session = request.getSession();
					session.setAttribute("result","failInsertCategory");
					RequestDispatcher dis2 = request.getRequestDispatcher("ItemManagingAlerts.jsp");
					dis2.forward(request, response);
					
					
				}
				
		    
		}

}
