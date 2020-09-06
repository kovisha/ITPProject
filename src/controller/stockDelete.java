package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.stockDao;

import model.Stock;

/**
 * Servlet implementation class stockDelete
 */
@WebServlet("/stockDelete")
public class stockDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getting the stock id to delete
				String itemid = request.getParameter("id");
				
				boolean isTrue;//to catch boolean value
				 
				isTrue = stockDao.delete(itemid);//passing values 
				
				 
				if(isTrue == true) {
					//returns an array type value from categoryList
					List<Stock> listStock = stockDao.getStockList();
					request.setAttribute("listStock",  listStock);
					RequestDispatcher dis = request.getRequestDispatcher("ViewStock.jsp");
				
					dis.forward(request, response);
					
				}else {
					
					//if boolean values is false not entered succesfully
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("deleteUnsuccess.jsp");
					dispatcher.forward(request, response);
				}

			}

}
