package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.itemDao;
import dao.stockDao;

/**
 * Servlet implementation class StockInsert
 */
@WebServlet("/StockInsert")
public class StockInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.setContentType("text/html;charset-UTF-5"); PrintWriter out =
				  //response.getWriter();
				 
			    //Assigning the values in the jsp file variables to parameters to be passed to the Dbutil
		 
		  String stockname =  request.getParameter("stockName");
		  String id = request.getParameter("id");
		  int suppliedQty = Integer.parseInt(request.getParameter("supQty")) ;
		  String suppliedDate =  request.getParameter("supDate");
		  int qtySent = Integer.parseInt(request.getParameter("qtySent")) ;
		  double stockSize= Double.parseDouble( request.getParameter("sSize"));
		  String supplierName = request.getParameter("supName");
		 // String offerName = request.getParameter("offerName");
		  String categoryName= request.getParameter("category");
		  
		  //declaring boolean type variable
			 boolean isTrue;
				
			 //assigning the return type to boolean type variable whether true or false
				isTrue = stockDao.insertStock(id,stockname,stockSize,suppliedQty ,suppliedDate,qtySent,supplierName,categoryName );
				
				//if boolean type is true
				if(isTrue == true) {
					//If the db connection is  successful and the data is been inserted to DB
					
					
					//redirecting to the jsp page
					RequestDispatcher dis = request.getRequestDispatcher("AdminDashBoard.jsp");
					dis.forward(request, response);
				}else {
					//if boolean type is false	
					
					
					//If our DB connection is not a success.
					RequestDispatcher dis2 = request.getRequestDispatcher("insertUnsucess.jsp");
					dis2.forward(request, response);
				}
				
		    
		}

}
