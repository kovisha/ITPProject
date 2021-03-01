<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="javax.swing.border.TitledBorder"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.lowagie.text.DocumentException"%>
<%@page import="com.lowagie.text.Paragraph"%>
<%@page import="com.lowagie.text.html.HtmlWriter"%>
<%@page import="com.lowagie.text.pdf.PdfWriter"%>
<%@page import="com.lowagie.text.Document"%>
<%@page import="java.io.*"%>;
<%@page import="java.awt.*"%>
<%@page import="javax.servlet.*"%>
<%@page import="javax.servlet.http.*"%>
<%@page import="com.lowagie.text.*"%>
<%@page import="com.lowagie.text.pdf.*"%>
<%@page import="com.lowagie.text.html.*"%>
<%@page import="Order_Management.DBManager"%>
<%@page import="java.awt.*"%>
<%@page import="java.io.IOException"%>
<%@page import="javax.servlet.*"%>
<%@page import="javax.servlet.http.*"%>
<%@page import="com.lowagie.text.*"%>
<%@page import="com.lowagie.text.pdf.*"%>
<%@page import="com.lowagie.text.html.*"%>
<%@page import="java.time.LocalDate"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Stock pdf Report</title>
</head>
<body>




<%
	String str="pdf";

Connection conn=null;
PreparedStatement ps=null;
ResultSet rs=null;



try
{
    Document document=new Document();
    if(str.equals("pdf"))
    {
        response.setContentType("application/pdf");
        PdfWriter.getInstance(document,response.getOutputStream());
    }
    conn= DBManager.getConection();
    
    LocalDate ld = java.time.LocalDate.now();
    
    String startDate = request.getParameter("sDate");
    String endDate = request.getParameter("eDate");
    
    
    String query = "SELECT * FROM uds_super.order where date between '"+startDate+"'AND '"+endDate+"' ORDER BY total DESC" ; //Fetching data from table
       ps=conn.prepareStatement(query);                // executing query
       rs=ps.executeQuery();
      
    document.open();

    /* new paragraph instance initialized and add function write in pdf file*/
    document.add(new Paragraph("-------------------ORDERS WITH HIGHER AMOUNTS FROM "+startDate+" TO " +endDate+"--------------\n\n"));
    document.add(new Paragraph("DATE GENERATED - "+ld+"\n\n"));
    document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------\n\n"));
    document.addCreationDate();
    
    int count = 0;
   
    while(rs.next())
    {
    	count = count +1 ;
    	
          // fetch & writing records in pdf files
        document.add(new Paragraph(count+")"+ "                 Order ID - " + rs.getString(2) + "     Total Amount - " + rs.getInt(3) + "     Order Date - " + rs.getString(4) + "\n                     User ID - " + rs.getString(5) +"     Offer ID - " + rs.getString(6) + "\n\n" ));
        document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------\n\n"));
        
	}
	document.add(new Paragraph("---------------------------------------------------------PAGE NO::"
	+ document.getPageNumber() + "------------------------------------------------------"));

	document.close(); //document instance closed
	conn.close(); //db connection close
} catch (Exception de) {
	de.printStackTrace();
	System.err.println("document: " + de.getMessage());

}
%>
</body>
</html>