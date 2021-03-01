package Stock;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





@WebServlet("/NotificationsList")
public class NotificationsList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//retrieve array type list of all notification details from the dao
				try {
					
					List<Notifications> listNotifications = stockDao.getNotification();
					request.setAttribute("listNotifications", listNotifications);
				}
				catch(Exception e) {
					
					e.printStackTrace();
				}
					//navigating to the jsp page
					RequestDispatcher dispatcher = request.getRequestDispatcher("StockNotify.jsp");
					dispatcher.forward(request, response);
	}

}
