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
 * Servlet implementation class CustomerRestoreServlet
 */
@WebServlet("/CustomerRestoreServlet")
public class CustomerRestoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerRestoreServlet() {
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
		String id = request.getParameter("userNo");
		
		boolean isTrue;//to catch boolean value
		 
		isTrue = adminDAO.restoreCust(id);//calling the method  
		
		//on success returns to home page 
		if(isTrue == true) {
			//session for alerts
			HttpSession session = request.getSession();
			session.setAttribute("result","restoreSuccess");
			RequestDispatcher dis = request.getRequestDispatcher("adminAlerts.jsp");//alerts
			dis.forward(request, response);
		}
		//on fail
		else {
			//session for alerts
			HttpSession session = request.getSession();
			session.setAttribute("result","restoreFailed");
			RequestDispatcher dis = request.getRequestDispatcher("adminAlerts.jsp");//alerts
			dis.forward(request, response);
		}
	}

}
