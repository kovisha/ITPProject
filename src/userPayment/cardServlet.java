package userPayment;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class cardServlet
 */
@WebServlet("/cardServlet")
public class cardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();	
		String installType= (String) session.getAttribute("insType");
		
		if(installType == null) {
			installType = "NotUsing";
		}
		
		if(installType.equals("install")) {
			RequestDispatcher dis = request.getRequestDispatcher("userInstall01.jsp");
			dis.forward(request, response);
		}
		else {
			RequestDispatcher dis = request.getRequestDispatcher("userPaySummary.jsp");
			dis.forward(request, response);
		}
	}

}
