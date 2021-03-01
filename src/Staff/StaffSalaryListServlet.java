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


@WebServlet("/StaffSalaryListServlet")
public class StaffSalaryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
																		//Passing the month and the year through getParameter and assigning to the relevant variables
		String categoryMonth = request.getParameter("categoryMonth");
		String categoryYear = request.getParameter("categoryYear");
		
		
		try {
			
			//retrive aray type list of all book details from the dbutil
				List<Staff> listStaffSalary = StaffDBUtil.getStaffSalaryList(categoryMonth,categoryYear);
				request.setAttribute("listStaffSalary", listStaffSalary);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
									
		//navigating to the jsp page
		RequestDispatcher dispatcher = request.getRequestDispatcher("Salary.jsp");
		dispatcher.forward(request, response);
	}

}
