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
import model.Item;
import model.Stock;


@WebServlet("/StockUpdate")
public class StockUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String stockName = request.getParameter("stockName");
		int qtySupplied = Integer.parseInt(request.getParameter("supQty"));
		String suppliedDate = request.getParameter("supDate");
		double stockSize = Double.parseDouble(request.getParameter("sSize"));
		int reOrderLevel = Integer.parseInt(request.getParameter("rOrder"));
		int storeQty =Integer.parseInt(request.getParameter("qtySent"));
		String supplierName = request.getParameter("supname");
		String categoryName = request.getParameter("catname");
		int qtyAvailable = Integer.parseInt(request.getParameter("qtyAvaialbale"));
		
		//declaring the boolean type variable to store the return type from the dao
		  boolean isTrue;
		  
			isTrue = stockDao.updateStock( id ,stockName,qtyAvailable,stockSize,reOrderLevel,qtySupplied,suppliedDate,storeQty,supplierName,categoryName);
			
			if(isTrue == true) {
				//If the db connection is a success and the data is been inserted DB
				List<Stock> listStock = stockDao.getStockList();
				request.setAttribute("listStock", listStock);
				RequestDispatcher dis = request.getRequestDispatcher("AdminDashBoard.jsp");
				
				dis.forward(request, response);
			}else {
				//If our DB connection is not a success.
				RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
				dis2.forward(request, response);
			}
	}

}
