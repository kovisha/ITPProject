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


@WebServlet("/StaffOTServlet")
@MultipartConfig(maxFileSize = 16177215)
public class StaffOTServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {											//Try block
														//retrive aray type list of all book details from the dbutil
		List<Staff> listStaff = StaffDBUtil.getStaffList(response);
		request.setAttribute("listStaff", listStaff);
														
		}catch(Exception e)								//Catch block
		{
			e.printStackTrace();						//Print exception type
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("StaffOTInsert.jsp");		//Naviaget to the relevant page with the result
		dispatcher.forward(request, response);
	}

}
