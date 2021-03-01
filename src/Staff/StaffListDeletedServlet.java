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



@WebServlet("/StaffListDeletedServlet")
@MultipartConfig(maxFileSize = 16177215)
public class StaffListDeletedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//retrive aray type list of all book details from the dbutil
		try {
		List<Staff> listDeleteStaff = StaffDBUtil.getStaffListDeleted(response);	//Store the result in a list type variable
		request.setAttribute("listDeleteStaff", listDeleteStaff);					//Set the attribute for the variable
		}catch(Exception e) {
			e.printStackTrace();													//Print the exception type
			
		}
		//navigating to the jsp page
		RequestDispatcher dispatcher = request.getRequestDispatcher("StaffList.jsp");	//Redirect to the relevant jsp page
		dispatcher.forward(request, response);											//Forward the response
		

		
	}

}
