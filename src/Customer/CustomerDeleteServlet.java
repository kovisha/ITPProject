package Customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class CustomerDeleteServlet
 */
@WebServlet("/CustomerDeleteServlet")
public class CustomerDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerDeleteServlet() {
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
		//getting the appointment id to delete
				String id = request.getParameter("userNo");
				
				
				boolean isTrue;//to catch boolean value
				 
				isTrue = adminDAO.deleteCust(id);//passing values 
				
				//on success returns to home page 
				if(isTrue == true) {
					
					//session for alerts
					HttpSession session = request.getSession();
					session.setAttribute("result","successCustomerDelete");
					RequestDispatcher dis = request.getRequestDispatcher("adminAlerts.jsp");//alerts
					dis.forward(request, response);
				}
				else {
					//session for alerts
					HttpSession session = request.getSession();
					session.setAttribute("result","failedCustomerDelete");
					RequestDispatcher dis2 = request.getRequestDispatcher("adminAlerts.jsp");//alerts
					dis2.forward(request, response);
				}
	}

}
