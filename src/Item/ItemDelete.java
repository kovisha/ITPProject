package Item;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebServlet("/ItemDelete")
public class ItemDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getting the item id to delete
		String itemid = request.getParameter("id");
		
		boolean isTrue;//to catch boolean value
		 HttpSession session = request.getSession(); 
		
		isTrue = itemDao.delete(itemid);//passing values 
		
		 
		if(isTrue == true) {
			//returns an array type value from categoryList
			List<Item> listItem = itemDao.getItemList(response);
			request.setAttribute("listItem",  listItem);
			
			
			session.setAttribute("result","successDeleteItem");
			RequestDispatcher dis = request.getRequestDispatcher("ItemManagingAlerts.jsp");
			dis.forward(request, response);
			
		}else {
			
			//if boolean values is false not entered succesfully
			
			session.setAttribute("result","failDeleteItem");
			RequestDispatcher dis = request.getRequestDispatcher("ItemManagingAlerts.jsp");
			dis.forward(request, response);
		}

	}
}
