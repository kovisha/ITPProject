package Staff;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import DBUtil.StaffDBUtil;
//import Model.Staff;


@WebServlet("/StaffLeaveListServlet")
public class StaffLeaveListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
																		
																		
		String categoryMonth = request.getParameter("categoryMonth");	//Passssing the month and year obtained from the form to the
		String categoryYear = request.getParameter("categoryYear");		//Assigning to variables		
		
		
		try {
			
																		//retrive aray type list of all book details from the dbutil
																		//Store all list value in listStaffLeve of staff type array
				List<Staff> listStaffLeave = StaffDBUtil.getStaffLeaveList(categoryMonth,categoryYear);
				request.setAttribute("listStaffLeave", listStaffLeave);
			
		}catch(Exception e) {
			

			e.printStackTrace();
			
		}
		
		//navigating to the jsp page
		RequestDispatcher dispatcher = request.getRequestDispatcher("StaffleaveList.jsp");	//REdierect to main page
		dispatcher.forward(request, response);												//Forward the result
		
		
	}

}
