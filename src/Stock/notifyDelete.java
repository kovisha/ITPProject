package Stock;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/notifyDelete")
public class notifyDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getting the notification id to delete
		String notificationid = request.getParameter("id");
		
		boolean isTrue;//to catch boolean value
		 
		isTrue = stockDao.deleteNotifications(notificationid);//passing values 
		
		 
		if(isTrue == true) {
			//returns an array type value from categoryList
			List<Notifications> listNotifications = stockDao.getNotification();
			request.setAttribute("listNotifications", listNotifications);
			RequestDispatcher dis = request.getRequestDispatcher("StockNotify.jsp");
		
			dis.forward(request, response);
			
		}else {
			
			//if boolean values is false not entered succesfully
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("deleteUnsuccess.jsp");
			dispatcher.forward(request, response);
		}

	}

	}


