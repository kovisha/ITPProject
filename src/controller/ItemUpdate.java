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


@WebServlet("/ItemUpdate")
public class ItemUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//getting the item id to update
				String itemid = request.getParameter("id");
				String itemName = request.getParameter("itemName");
				double itemSize = Double.parseDouble(request.getParameter("iSize"));
				String itembarcode = request.getParameter("barcodeID");
				double itemprice = Double.parseDouble(request.getParameter("iPrice"));
				int itemQty = Integer.parseInt(request.getParameter("qty"));
				String itemStatus = request.getParameter("itemStatus");
				String itemOffer = request.getParameter("Offerr");
				String itemCategory = request.getParameter("catName");
				
				//declaring the boolean type variable to store the return type from the dao
				  boolean isTrue;
				 
					isTrue = itemDao.updateItem( itemid ,itemName,itemSize,itembarcode,itemprice,itemQty,itemStatus,itemOffer,itemCategory);
					
					if(isTrue == true) {
						//If the db connection is a success and the data is been inserted DB
						List<Item> listItem = itemDao.getItemList();
						request.setAttribute("listItem", listItem);
						RequestDispatcher dis = request.getRequestDispatcher("AdminDashBoard.jsp");
						
						dis.forward(request, response);
					}else {
						//If our DB connection is not a success.
						RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
						dis2.forward(request, response);
					}
	}

}
