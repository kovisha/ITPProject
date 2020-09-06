package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBUtil.StaffDBUtil;
import model.Staff;




@WebServlet("/StaffDeleteServlet")
public class StaffDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Store paramter passed by the jsp file 
		String id = request.getParameter("id");
		
		//declare boolran type variable
		boolean isTrue;
		
		//passing the id as a parameter to the data base to delete form the data base
		isTrue = StaffDBUtil.deleteStaff(id);
		
		
		
		if(isTrue == true) {
			//returns an arary type value from bookList
			List<Staff> listStaff = StaffDBUtil.getStaffList();
			request.setAttribute("listStaff", listStaff);
			RequestDispatcher dis = request.getRequestDispatcher("StaffDeleteSuccess.jsp");
		
			dis.forward(request, response);
			
		}else {
			
			//if boolean values is false not enterde succesfully
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("unsuccess.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}

}
