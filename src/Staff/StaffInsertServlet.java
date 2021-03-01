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

@WebServlet("/StaffInsertServlet")
@MultipartConfig(maxFileSize = 16177215)
 
public class StaffInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  
	    //Get all values passed from the form id through get parameter and assign it to variables
		String staffID = request.getParameter("staffID");	
	    String staffFirstName =  request.getParameter("staffFirstName");
	    String staffLastName =  request.getParameter("staffLastName");
	    String staffUserName =  request.getParameter("staffUserName");
	    String staffPassword =  request.getParameter("staffPassword");
	    String staffAddress =  request.getParameter("staffAddress");
	    String staffemailAddress =  request.getParameter("staffemailAddress");
	    String dob =  request.getParameter("dob");
	    String staffNIC =  request.getParameter("staffNIC");
	    String categoryRel =  request.getParameter("categoryRel");
	    String staffGender =  request.getParameter("staffGender");
	    String staffEPF =  request.getParameter("staffEPF");
	    String joinedDate =  request.getParameter("joinedDate");
	    String categoryJob =  request.getParameter("categoryJob");
	    double staffBasicSalary = Double.parseDouble(request.getParameter("staffBasicSalary"));
	    String mobNo = request.getParameter("mobNo");	
	    String homNo = request.getParameter("homNo");	
	    Part part = request.getPart("filename");	//Get image as a part and store in part type varible
	    
	    

	    
		 boolean isTrue;			//Declaring boolean variable
		 
		 

			
		 							//aassging the retrun type to boolean type variable weather true or false
		 							//Passing all the inserted values to the DBUtil class through the method
			isTrue = StaffDBUtil.insertStaff(staffFirstName,staffLastName,staffUserName,staffPassword,staffAddress,staffemailAddress,dob,staffNIC,categoryRel,
					staffGender,staffEPF,joinedDate,categoryJob,staffBasicSalary,mobNo,homNo,part);
			
			
			if(isTrue == true) {	//if boolean type is true
				
				HttpSession session = request.getSession();			//Through sessions redierect to the alert.jsp page
				session.setAttribute("result","StaffInsertSucess");
				RequestDispatcher dis = request.getRequestDispatcher("staffAlertBoxes.jsp");
				dis.forward(request, response);						//the result is forward
				
				
			}else {					//if boolean type is false	
				
				
				HttpSession session = request.getSession();			//using session to redierect to the alert page
				session.setAttribute("result","StaffInsertFail");
				RequestDispatcher dis2 = request.getRequestDispatcher("staffAlertBoxes.jsp");
				dis2.forward(request, response);					//Forward the result
			}
			
	    
	}

	
	
}
