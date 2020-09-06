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


@WebServlet("/StockList")
public class StockList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//retrieve array type list of all stock details from the dao
		try {
			
			List<Stock> listStock = stockDao.getStockList();
			request.setAttribute("listStock", listStock);
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
			//navigating to the jsp page
			RequestDispatcher dispatcher = request.getRequestDispatcher("ViewStock.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}

	


