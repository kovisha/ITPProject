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
 * Servlet implementation class tempCartInsertServlet
 */
@WebServlet("/tempCartInsertServlet")
public class tempCartInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String LoggedUser = (String) session.getAttribute("LoggedUser");
		
		String itemid = request.getParameter("itemid");
		String itemName = request.getParameter("itemname");
		Double price = Double.parseDouble(request.getParameter("price"));
		Double discount = Double.parseDouble(request.getParameter("discount"));
		String offer = request.getParameter("offername");
		String category = request.getParameter("category");
		
	    int qty = Integer.parseInt(request.getParameter("quantity"));
	
	
	    Double netTotal = (qty * price)*((100-discount)/100);
		/*String qty1 = request.getParameter("quantity");*/
	    
	  /*  String category = request.getParameter("category");*/
		
            
          /*RequestDispatcher dis  = request.getRequestDispatcher("ItemDisplay.jsp");
            dis.forward(request, response);*/	
		
		boolean isTrue;
		
		isTrue = ShoppingCartDbUtil.insertCartDetails(LoggedUser,itemid, itemName, price, discount,qty,netTotal,offer,category);
		
		 try {
			 List<Item> itemDetails =itemDbUtil.display(category,response);
	          request.setAttribute("itemDetails", itemDetails);
		
		if(isTrue == true )
		{
			 
			session.setAttribute("result1","successItemInsert");
			RequestDispatcher dis = request.getRequestDispatcher("alertForUserSide.jsp");
			dis.forward(request, response);
			
		}
		
		else
		{
			session.setAttribute("result1","failedItemInsert");
			RequestDispatcher dis = request.getRequestDispatcher("alertForUserSide.jsp");
			dis.forward(request, response);			
		}
		
		 }
		
		 catch(Exception e)
	     {
	    	 e.printStackTrace();		    	 
	     }
	}

}
