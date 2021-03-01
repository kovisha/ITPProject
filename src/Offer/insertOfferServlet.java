package Offer;


import java.io.IOException;
import java.io.InputStream;
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
 * Servlet implementation class insertOfferServlet
 */
@WebServlet("/insertServ")
@MultipartConfig(maxFileSize = 16177215)

public class insertOfferServlet extends HttpServlet {
	PrintWriter out; 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out=response.getWriter();
		
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String desc = request.getParameter("desc");
		String dPerc = request.getParameter("dPerc") ;
		String status = request.getParameter("status");
		double min = Double.parseDouble(request.getParameter("min"));
		double max = Double.parseDouble(request.getParameter("max"));
		Part part = request.getPart("filename");
		
		
			boolean isTrue;
			
			isTrue = offerDButil.insertOfferDetail(name, desc, dPerc, status, min, max, part);
			
			if (isTrue == true) {
				HttpSession session = request.getSession();
				session.setAttribute("result","successInsertOffer");
				RequestDispatcher dis = request.getRequestDispatcher("adminAlertBoxes.jsp");
				dis.forward(request, response);
			}
			else{
				HttpSession session = request.getSession();
				session.setAttribute("result","failInsertOffer");
				RequestDispatcher dis2 = request.getRequestDispatcher("adminAlertBoxes.jsp");
				dis2.forward(request, response);
			}
		}

		/*
		 * private String extractFileName(Part part) { String contentDisp =
		 * part.getHeader("content-disposition"); String[] items =
		 * contentDisp.split(";"); for (String s : items) {
		 * if(s.trim().startsWith("filename")) { return s.substring(s.indexOf("=") + 2,
		 * s.length() - 1); } } return ""; }
		 */

}
