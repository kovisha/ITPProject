package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.itemDao;

import model.Item;


@WebServlet("/ItemDelete")
public class ItemDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getting the item id to delete
		String itemid = request.getParameter("id");
		
		boolean isTrue;//to catch boolean value
		 
		isTrue = itemDao.delete(itemid);//passing values 
		
		 
		if(isTrue == true) {
			//returns an array type value from categoryList
			List<Item> listItem = itemDao.getItemList();
			request.setAttribute("listItem",  listItem);
			RequestDispatcher dis = request.getRequestDispatcher("ViewItems.jsp");
		
			dis.forward(request, response);
			
		}else {
			
			//if boolean values is false not entered succesfully
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("deleteUnsucess.jsp");
			dispatcher.forward(request, response);
		}

	}
}
