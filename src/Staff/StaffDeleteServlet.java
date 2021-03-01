package Staff;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/StaffDeleteServlet")
public class StaffDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	//Store paramter passed by the jsp file
		
		 
		String staffID = request.getParameter("staffID");
		
		
		boolean isTrue;			//initilaize boolean type variable
		
		
		isTrue = StaffDBUtil.deleteStaff(staffID);		//passing id as a parameter
														//receiving the boolean value of task
		
		
		
		if(isTrue == true) {
			
			HttpSession session = request.getSession();										//Using session and transfering the result to a aletjsp
			session.setAttribute("result","StaffDeleteSuccess");		
			//rediereting to the jsp page
			RequestDispatcher dis = request.getRequestDispatcher("staffAlertBoxes.jsp");	//rediereting to the jsp page
			dis.forward(request, response);													//with the result				
		
			dis.forward(request, response);
			
		}else {
			
			
																							
			HttpSession session = request.getSession();										//if boolean values is false not not deleted succesfully
			session.setAttribute("result","StaffDeleteFail");								//Result is sent to the alert page
			//If our DB connection is not a success.
			RequestDispatcher dis2 = request.getRequestDispatcher("staffAlertBoxes.jsp");
			dis2.forward(request, response);												//forward the response
		}
		
		
	}

}
