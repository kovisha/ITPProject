package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import dao.UserDAO;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//assigning name of sign up form fields to variables
				PrintWriter out=response.getWriter();
				
				String fname = request.getParameter("fname");
				String lname = request.getParameter("lname");
				String username = request.getParameter("uname");
				String email = request.getParameter("email"); 
				String address = request.getParameter("address");
				String phone = request.getParameter("phone");
				String dob = request.getParameter("dob");
				String doa = request.getParameter("doa");
				String occupation = request.getParameter("job");
			    String password = request.getParameter("pass");
			   
			    
			    boolean isTrue;//to catch boolean value
				 
				//calling the method to insert data
				isTrue=UserDAO.registerUser(fname,lname,username,email,address,phone,dob,doa,occupation,password);
				
				//on success redirects to retrieve servlet else home page
				if(isTrue == true) 
				{
					RequestDispatcher dis =request.getRequestDispatcher("home.jsp");
					dis.forward(request, response);
				}
				else 
				{
						RequestDispatcher dis2 =request.getRequestDispatcher("login.jsp");
						dis2.forward(request, response);
				}
	}

}
