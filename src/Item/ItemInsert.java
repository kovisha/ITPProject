package Item;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;




@WebServlet("/ItemInsert")
@MultipartConfig(maxFileSize = 16177215)
public class ItemInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  //response.setContentType("text/html;charset-UTF-5"); PrintWriter out =
				 // response.getWriter();
				 
			    //Assigning the values in the jsp file variables to parameters to be passed to the Dbutil
		  String category= request.getParameter("category");
		 // String id = request.getParameter("id");
		  String itemName =  request.getParameter("itemName");
		  double iSize = Double.parseDouble(request.getParameter("iSize"));
		 // String barcodeID =  request.getParameter("barcodeID");
		  double iPrice = Double.parseDouble(request.getParameter("iPrice"));
		  int qty = Integer.parseInt(request.getParameter("qty"));
		  String itemStatus =  request.getParameter("itemStatus");
		  String offerName =  request.getParameter("offerName");
		  
		  Part part = request.getPart("itemImage");
		  
			    
				  //declaring boolean type variable
				 boolean isTrue;
				 
				 
					
				 //assigning the return type to boolean type variable whether true or false
					isTrue = itemDao.insertItem(itemName,iSize,iPrice,qty,itemStatus,offerName,category,part);
					
					//if boolean type is true
					if(isTrue == true) {
						//If the db connection is  successful and the data is been inserted to DB
						HttpSession session = request.getSession();
						session.setAttribute("result","successInsertItem");
						RequestDispatcher dis = request.getRequestDispatcher("ItemManagingAlerts.jsp");
						dis.forward(request, response);
						
						
						
					}else {
						//if boolean type is false	
						HttpSession session = request.getSession();
						session.setAttribute("result","failInsertItem");
						RequestDispatcher dis2 = request.getRequestDispatcher("ItemManagingAlerts.jsp");
						dis2.forward(request, response);
						
						
					}
					
			    
			}
}
