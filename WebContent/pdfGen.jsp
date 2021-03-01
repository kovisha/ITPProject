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
<%@page import="util.DBUtil"%>
<%@page import="java.awt.*"%>
<%@page import="java.io.IOException"%>
<%@page import="javax.servlet.*"%>
<%@page import="javax.servlet.http.*"%>
<%@page import="com.lowagie.text.*"%>
<%@page import="com.lowagie.text.pdf.*"%>
<%@page import="com.lowagie.text.html.*"%>

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
    conn= DBUtil.getConnection();
    
    String startDate = request.getParameter("sDate");
    String endDate = request.getParameter("eDate");
    
    
    String query = "select stockname, sum(suppliedqty),supplierdid from stock where  supplieddate between '"+startDate+"' AND '"+endDate+"' group by stockname having (sum(suppliedqty)) order by sum(suppliedqty) desc" ; //Fetching data from table
       ps=conn.prepareStatement(query);                // executing query
       rs=ps.executeQuery();
      
    document.open();

    /* new paragraph instance initialized and add function write in pdf file*/
   	document.add(new Paragraph("---------------------------------------------------------REPORT---------------------------------------------------------\n\n"));
    document.add(new Paragraph("                              CREATED REPORT BY-KovishwaKarunya\n\n"));
    document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------"));
    document.addCreationDate();
   
    int count =1;
    
    while(rs.next())
    {
          // fetch & writing records in pdf files

        document.add(new Paragraph((count++) +"  "+"Stock Name :  " + rs.getString(1) + "\n" + "    Supplied Quantity :  " + rs.getInt(2) + "\n" + "    Supplier ID:  " + rs.getString(3) ));
           document.add(new Paragraph("\n"));

        
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