package Staff;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/StaffReinsertServlet")
public class StaffReinsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String staffID = request.getParameter("staffID");			//Store paramter passed by the jsp file 
		
		
		boolean isTrue;												//declare boolran type variable
		
		
		isTrue = StaffDBUtil.deleteReinsert(staffID);				//passing the id as a parameter to the data base to delete form the data base
		
		
		
		if(isTrue == true) {
			
			HttpSession session = request.getSession();				//returns an arary type value from bookList
			session.setAttribute("result","StaffReinsertSuccess");
			
			RequestDispatcher dis = request.getRequestDispatcher("staffAlertBoxes.jsp"); //rediereting to the jsp page
			dis.forward(request, response);
		
			dis.forward(request, response);
			
		}else {
			
			
			
			HttpSession session = request.getSession();				//if boolean values is false not enterde succesfully
			session.setAttribute("result","StaffReinsertFail");
			//If our DB connection is not a success.
			RequestDispatcher dis2 = request.getRequestDispatcher("staffAlertBoxes.jsp");	//Redierect to the relecant apge with the result
			dis2.forward(request, response);
		}
		
		
	}

}
