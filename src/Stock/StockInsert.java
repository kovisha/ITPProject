package Stock;

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


/**
 * Servlet implementation class StockInsert
 */
@WebServlet("/StockInsert")
@MultipartConfig(maxFileSize = 16177215)
public class StockInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.setContentType("text/html;charset-UTF-5"); PrintWriter out =
				  //response.getWriter();
				 
			    //Assigning the values in the jsp file variables to parameters to be passed to the Dbutil
		 
		  String stockname =  request.getParameter("stockName");
		  //String id = request.getParameter("id");
		  int suppliedQty = Integer.parseInt(request.getParameter("supQty")) ;
		  String suppliedDate =  request.getParameter("supDate");
		  int qtySent = Integer.parseInt(request.getParameter("qtySent")) ;
		  double stockSize= Double.parseDouble( request.getParameter("sSize"));
		  String supplierName = request.getParameter("supName");
		 // String offerName = request.getParameter("offerName");
		  String categoryName= request.getParameter("category");
		  
		  Part part = request.getPart("itemImage");
		  
		  //declaring boolean type variable
			 boolean isTrue;
				
			 //assigning the return type to boolean type variable whether true or false
				isTrue = stockDao.insertStock(stockname,stockSize,suppliedQty ,suppliedDate,qtySent,supplierName,categoryName,suppliedQty - qtySent,part );
				
				//if boolean type is true
				if(isTrue == true) {
					//If the db connection is  successful and the data is been inserted to DB
					HttpSession session = request.getSession();
					session.setAttribute("result","successInsertStock");
					RequestDispatcher dis = request.getRequestDispatcher("ItemManagingAlerts.jsp");
					dis.forward(request, response);
					
					
					
				}else {
					//if boolean type is false	
					HttpSession session = request.getSession();
					session.setAttribute("result","failInsertStock");
					RequestDispatcher dis2 = request.getRequestDispatcher("ItemManagingAlerts.jsp");
					dis2.forward(request, response);
					
					
				}
				
		    
		}

}
