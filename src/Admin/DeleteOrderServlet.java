package Admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteOrderServlet
 */
@WebServlet("/DeleteOrderServlet")
public class DeleteOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        String sid = request.getParameter("id");
		
		boolean isTrue ;
		
		isTrue = AdminDbUtil.deleteOrder(sid);
		
		if(isTrue == true )
		{
			RequestDispatcher dis = request.getRequestDispatcher("OnProgressAdmin.jsp");
			dis.forward(request, response);
			
		}
		
		else
		{
			RequestDispatcher dis = request.getRequestDispatcher("DispatchAdmin.jsp");
			dis.forward(request, response);
			
		}
	}

	}


