package userPayment;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Offer.Offer;
import Offer.offerDButil;

/**
 * Servlet implementation class yourPaymentDetailsServlet
 */
@WebServlet("/yourPaymentDetailsServlet")
public class yourPaymentDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String uname = (String)session.getAttribute("LoggedUser");
		
		try {
	      	  List<yourPayDetails> yourPayDet = userPaymentDButil.getYourPaymentDetails(uname);
	      	  request.setAttribute("yourPayDetail", yourPayDet);
		    }
		    catch (Exception e) {
			e.printStackTrace();
		    }
		    
		    
		    RequestDispatcher dis = request.getRequestDispatcher("userYourPayDetails.jsp");
		    dis.forward(request, response);
	}

}
