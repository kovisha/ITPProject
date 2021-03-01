package Order_Management;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ItemDisplayServlet
 */
@WebServlet("/ItemDisplayServlet")
public class ItemDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String LoggedUser = (String) session.getAttribute("LoggedUser");
		
		String category = request.getParameter("category");
		try {
            List<Item> itemDetails =itemDbUtil.display(category,response);
            request.setAttribute("itemDetails", itemDetails);
		     }
		     
		     catch(Exception e)
		     {
		    	 e.printStackTrace();
		    	 
		     }
            
            RequestDispatcher dis  = request.getRequestDispatcher("ItemDisplay.jsp");
            dis.forward(request, response);
	}

}
