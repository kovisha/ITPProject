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

@WebServlet("/StaffLeaveInsertServlet")

  @MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 *
  1024 * 10, maxRequestSize= 1024 * 1024 * 50)
 
public class StaffLeaveInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

	    //Assiging the values in the jsp file variables to paramters to be passed to the Dbutil
		String staffID = request.getParameter("staffID");
		String leaveDate = request.getParameter("leaveDate");
		int totLeaveDays = Integer.parseInt(request.getParameter("totLeaveDays"));
		int workingDays = Integer.parseInt(request.getParameter("workingDays"));
		int totHalfDays = Integer.parseInt(request.getParameter("totHalfDays"));
		
	

		  
		 boolean isTrue;		//declaring boolean type variable
		 
		 

			
		//aassging the retrun type to boolean type variable weather true or false
		//Passing all parameters to the DBUTil class
		isTrue = StaffDBUtil.insertStaffLeave(staffID,leaveDate,workingDays,totLeaveDays,totHalfDays);
			
			//if boolean type is true
			if(isTrue == true) {
				
				
				HttpSession session = request.getSession();				//Iserting sessions to transfer the data to the alert page
				session.setAttribute("result","StaffLeaveInsertSucess");
				RequestDispatcher dis = request.getRequestDispatcher("staffAlertBoxes.jsp");
				dis.forward(request, response);
				
				
				
			}else {
				//if boolean type is false	
				
				
				HttpSession session = request.getSession();				//sessions to transfer the data to the alert page
				session.setAttribute("result","StaffLeaveInsertFail");
				RequestDispatcher dis2 = request.getRequestDispatcher("staffAlertBoxes.jsp");
				dis2.forward(request, response);
			}
			
	    
	}

	

	 
}
