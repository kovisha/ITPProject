package Offer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class deleteOfferServlet
 */
@WebServlet("/deleteOfferServlet")
public class deleteOfferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id= (String) session.getAttribute("id");
		
		boolean isTrue ;
		
		isTrue = offerDButil.deleteOfferDetails(id);
	
		if (isTrue == true) {
			List<Offer> offerDet = offerDButil.getOfferDetails(response);
	      	request.setAttribute("offerDetail", offerDet);
	      	session.setAttribute("result","successDeleteOffer");
	      	 
			RequestDispatcher dis = request.getRequestDispatcher("adminAlertBoxes.jsp");
			dis.forward(request, response);
		}
		else 
		{	
			session.setAttribute("result","failDeleteOffer");
			RequestDispatcher dis2 = request.getRequestDispatcher("adminAlertBoxes.jsp");
			dis2.forward(request, response);
		}
	}

}
