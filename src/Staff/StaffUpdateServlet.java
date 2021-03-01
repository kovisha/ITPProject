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



/**
 * Servlet implementation class BookUpdateServlet
 */
@WebServlet("/StaffUpdateServlet")
@MultipartConfig(maxFileSize = 16177215)

public class StaffUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
				
	    //Assiging the values in the jsp file variables to paramters to be passed to the Dbutil
		Part part = null;
		
		String id = request.getParameter("id");
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
	    String img = request.getParameter("filename");			//Get image and store is at an String variable
        part = request.getPart("filename");
	    String mobNo = request.getParameter("mobNo");	
	    String homNo = request.getParameter("homNo");
	    
	    
	    boolean isTrue;
	   
        
        if(part.getSize() == 0) {		//IF the updation process doesnot contains an image
            isTrue = StaffDBUtil.updateStaff(id,staffID,staffFirstName,staffLastName,staffUserName,staffPassword,staffAddress,staffemailAddress,dob,staffNIC,categoryRel,
					staffGender,staffEPF,joinedDate,categoryJob,staffBasicSalary,mobNo,homNo);
        }
        else {							//IF the updation process does contains an image
            isTrue = StaffDBUtil.updateStaff2(id,staffID,staffFirstName,staffLastName,staffUserName,staffPassword,staffAddress,staffemailAddress,dob,staffNIC,categoryRel,
					staffGender,staffEPF,joinedDate,categoryJob,staffBasicSalary,mobNo,homNo,part);
        }
		
	    
	   
			
			if(isTrue == true) {
																	//If the db connection is a success and the data is been inserted DB
				HttpSession session = request.getSession();
				session.setAttribute("result","StaffUpdateSucess");
																	//rediereting to the jsp page
				RequestDispatcher dis = request.getRequestDispatcher("staffAlertBoxes.jsp");
				dis.forward(request, response);
				
				
			}else {
																	//If our DB connection is not a success.
				HttpSession session = request.getSession();
				session.setAttribute("result","StaffUpdateFail");
																	//rediereting to the jsp page
				RequestDispatcher dis = request.getRequestDispatcher("staffAlertBoxes.jsp");
				dis.forward(request, response);
			}
		  
		  
	    
	}

	
	 
			 
}
