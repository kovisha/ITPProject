package Staff;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/StaffOTListServlet")
public class StaffOTListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
																			//Pass month and year thorugh getparamaeter and assign to variables
		String categoryMonth = request.getParameter("categoryMonth");
		String categoryYear = request.getParameter("categoryYear");
		

		try {
			
			//retrive aray type list of all book details from the dbutil
				List<Staff> listStaffOT = StaffDBUtil.getStaffOTList(categoryMonth,categoryYear);
				request.setAttribute("listStaffOT", listStaffOT);
			
		}catch(Exception e) {
			
		}
																					//navigating to the jsp page
		RequestDispatcher dispatcher = request.getRequestDispatcher("StaffOTList.jsp");
		dispatcher.forward(request, response);
	}

}
