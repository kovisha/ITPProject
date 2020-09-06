package Offer;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


/**
 * Servlet implementation class insertOfferServlet
 */
@WebServlet("/insertServ")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
maxFileSize = 1024 *1024 * 10,
maxRequestSize = 1024 * 1024 * 50)

public class insertOfferServlet extends HttpServlet {
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset-UTF-5");
		PrintWriter out = response.getWriter();
		
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String desc = request.getParameter("desc");
		String dPerc = request.getParameter("dPerc");
		String status = request.getParameter("status");
		Part part = request.getPart("img");
		
		String fileName = extractFileName(part);
		String savepath = "C:\\Users\\SAWMIYA\\eclipse-workspace\\User_Payment\\WebContent\\img\\"+File.separator + fileName;
		File fileSave = new File(savepath);
		
		part.write(savepath + File.separator); 
		
			boolean isTrue;
			
			isTrue = offerDButil.insertOfferDetail(name, desc, dPerc, status, fileName,savepath);
			
			if (isTrue == true) {
				RequestDispatcher dis = request.getRequestDispatcher("insertOffer.jsp");
				dis.forward(request, response);
			}
			else{
				RequestDispatcher dis2 = request.getRequestDispatcher("failRegistration.jsp");
				dis2.forward(request, response);
			}
		}

	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";"); 
		for (String s : items) {
			if(s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}

}
