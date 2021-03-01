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


@WebServlet("/StaffLeaveServlet")
@MultipartConfig(maxFileSize = 16177215)
public class StaffLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		//retrive aray type list of all book details from the dbutil
		List<Staff> listStaff = StaffDBUtil.getStaffList(response);
		request.setAttribute("listStaff", listStaff);
		//navigating to the jsp page
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("StaffleaveInsert.jsp");	//Redeierect to relevant page
		dispatcher.forward(request, response);													//Forward the reponse
		
		
		
		
		
		
	}

}
