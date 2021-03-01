package Item;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





@WebServlet("/ItemList")
public class ItemList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//retrieve array type list of all item details from the dao
		try {
			
			List<Item> listItem = itemDao.getItemList(response);
			request.setAttribute("listItem", listItem);
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
			//navigating to the jsp page
			RequestDispatcher dispatcher = request.getRequestDispatcher("ViewItems.jsp");
			dispatcher.forward(request, response);
		}
	}

	


