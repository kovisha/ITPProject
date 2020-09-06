package Servlet;

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
import javax.servlet.http.Part;

import DBUtil.StaffDBUtil;

@WebServlet("/StaffInsertServlet")

  @MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 *
  1024 * 10, maxRequestSize= 1024 * 1024 * 50)
 
public class StaffInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 response.setContentType("text/html;charset-UTF-5"); PrintWriter out =
				  response.getWriter();
//		 
		  
		  
	    //Assiging the values in the jsp file variables to paramters to be passed to the Dbutil
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
	    //int staffBasicSalary = Integer.parseInt(request.getParameter("staffBasicSalary"));
	    //String staffBasicSalary =  request.getParameter("staffBasicSalary");
	    double staffBasicSalary = Double.parseDouble(request.getParameter("staffBasicSalary"));
	    
	    String mobNo = request.getParameter("mobNo");	
	    String homNo = request.getParameter("homNo");	
	   
	    

	    
		
//	    //Declaring string ttype variable to store the path and fileName
		  Part part = request.getPart("filename"); 
		  String savepath = null; 
		  String fileName = null;
//		  
//		  //extract file name and save the path
		  fileName = extractFileName(part); 
		  savepath =
		  "C:\\Users\\RADESH\\Downloads\\SLIIT\\sliit 2nd semester 2nd year\\Project_ITP\\UDS_1\\WebContent\\images"
		  +File.separator+ fileName; File fileSaveDir = new File(savepath);
		  part.write(savepath+File.separator);
		 
		 
		  //declaring boolean type variable
		 boolean isTrue;
		 
		 

			
		 //aassging the retrun type to boolean type variable weather true or false
			isTrue = StaffDBUtil.insertStaff(staffID,staffFirstName,staffLastName,staffUserName,staffPassword,staffAddress,staffemailAddress,dob,staffNIC,categoryRel,
					staffGender,staffEPF,joinedDate,categoryJob,staffBasicSalary,mobNo,homNo,fileName,savepath);
			
			//if boolean type is true
			if(isTrue == true) {
				//If the db connection is a success and the data is been inserted DB
				
			
				
				
				//rediereting to the jsp page
				RequestDispatcher dis = request.getRequestDispatcher("StaffInsertSuccess.jsp");
				dis.forward(request, response);
			}else {
				//if boolean type is false	
				
				
				//If our DB connection is not a success.
				RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
				dis2.forward(request, response);
			}
			
	    
	}

	
	
	//method to extract file name
	  private String extractFileName(Part part) { 
		  String contentDisp = part.getHeader("content-disposition"); String[] items =
	  contentDisp.split(";"); 
		  for (String s : items) {
	  if(s.trim().startsWith("filename")) 
	  { return s.substring(s.indexOf("=") + 2,
	  s.length() - 1); } } 
		  return ""; }
	 
}
