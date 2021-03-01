package Staff;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

//import DBUtil.StaffDBUtil;

@WebServlet("/StaffOTInsertServlet")

  @MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 *
  1024 * 10, maxRequestSize= 1024 * 1024 * 50)
 
public class StaffOTInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		  
	    //Assigning the values in the jsp file variables to paramters to be passed to the Dbutil
		String staffID = request.getParameter("staffID");
		String otDate = request.getParameter("ot");
		String otHours = request.getParameter("otHours");
		
		  						//declaring boolean type variable
		 boolean isTrue;
		 	
		 						//aassging the retrun type to boolean type variable weather true or false
			isTrue = StaffDBUtil.insertStaffOT(staffID,otDate,otHours);
			
								//if boolean type is true
			if(isTrue == true) {
								//If the db connection is a success and the data is been inserted DB


																							
				HttpSession session = request.getSession();									//Iserting sessions to transfer the data
				session.setAttribute("result","StaffOTInsertSucess");																			
				RequestDispatcher dis = request.getRequestDispatcher("staffAlertBoxes.jsp");//rediereting to the jsp page
				dis.forward(request, response);
				
				
			}else {
																							//if boolean type is false	
																							//If our DB connection is not a success.
				HttpSession session = request.getSession();									//Inserting sessions to transfer the data
				session.setAttribute("result","StaffOTInsertFail");	
				
				RequestDispatcher dis2 = request.getRequestDispatcher("staffAlertBoxes.jsp");
				dis2.forward(request, response);
			}
			
	    
	}

	

	 
}
