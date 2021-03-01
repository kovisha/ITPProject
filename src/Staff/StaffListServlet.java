package Staff;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import DBUtil.StaffDBUtil;
//import Model.Staff;


@WebServlet("/StaffListServlet")
@MultipartConfig(maxFileSize = 16177215)
public class StaffListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//retrive aray type list of all book details from the dbutil
		try {
		List<Staff> listStaff = StaffDBUtil.getStaffList(response);		//Store result in list type variable
		request.setAttribute("listStaff", listStaff);
		}catch(Exception e) {
			e.printStackTrace();										//Print exception type
			
		}
		//navigating to the jsp page
		RequestDispatcher dispatcher = request.getRequestDispatcher("StaffList.jsp");	//Redierect to the jsp page 
		dispatcher.forward(request, response);											//Forward the reponse
		
		
		
	
		
		
	}

}
