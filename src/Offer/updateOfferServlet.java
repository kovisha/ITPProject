package Offer;

import java.io.File;
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
 * Servlet implementation class updateOfferServlet
 */
@WebServlet("/updateOfferServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
maxFileSize = 1024 *1024 * 10,
maxRequestSize = 1024 * 1024 * 50)
public class updateOfferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean isTrue = false;
		PrintWriter out = response.getWriter();
		 
		Part part = null;
		String offerId = request.getParameter("offerId");
		String name = request.getParameter("name");
		String desc = request.getParameter("desc");
		String dPerc = request.getParameter("dPerc");
		String status = request.getParameter("status");
		double min = Double.parseDouble(request.getParameter("min"));
		double max = Double.parseDouble(request.getParameter("max"));
		String img = request.getParameter("filename");
		part = request.getPart("filename");
		 
		
		out.println(part);
		
		if(part.getSize()==0) {
			isTrue = offerDButil.updateOfferDetail2(offerId, name, desc, dPerc, status, min, max);
		}
		else {
			isTrue = offerDButil.updateOfferDetail(offerId, name, desc, dPerc, status, min, max, part);
		}
		
		
		

		
			
		if (isTrue == true) {
			HttpSession session = request.getSession();
			session.setAttribute("result","successUpdateOffer");
			RequestDispatcher dis = request.getRequestDispatcher("adminAlertBoxes.jsp");
			dis.forward(request, response);
		}
		else{
			HttpSession session = request.getSession();
			session.setAttribute("result","failUpdateOffer");
			RequestDispatcher dis2 = request.getRequestDispatcher("adminAlertBoxes.jsp");
			dis2.forward(request, response);
		}
	}

}
