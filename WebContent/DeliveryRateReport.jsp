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
<%@page import="package1.DBConnect"%>
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

</head>
<body>

<%
String str="pdf1";

Connection conn=null;
PreparedStatement ps1=null;
ResultSet rs1=null;

try
{
    Document document1=new Document();
    if(str.equals("pdf1"))
    {
        response.setContentType("application/pdf");
        PdfWriter.getInstance(document1,response.getOutputStream());
    }
    
    LocalDate ld = java.time.LocalDate.now();
    
    String month = request.getParameter("month");
    String year = request.getParameter("year");
    
   
    conn= DBConnect.getConnection();
    String query = "SELECT SID, name, rating, ordDelivered FROM delstaff group by SID having rating > 4.5 ORDER BY ordDelivered desc";          //Fetching data from table
       ps1=conn.prepareStatement(query);                // executing query
       rs1=ps1.executeQuery();
       

       
      
    document1.open();
    

    /* new paragraph instance initialized and add function write in pdf file*/
    document1.add(new Paragraph("--------------------------BEST RATED DELIVERY STAFF FOR THE MONTH -------------------\n\n"));
    document1.add(new Paragraph("DATE GENERATED - "+ld+"\n\n"));
    document1.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------\n\n"));
    document1.addCreationDate();
   
    while(rs1.next())
    {
          // fetch & writing records in pdf files
        document1.add(new Paragraph("Staff ID - "+rs1.getString(1)+"\nStaff Name - "+rs1.getString(2)+"\nRating - "+rs1.getString(3)+"\nTotal Orders Delivered - "+rs1.getString(4)+"\n\n\n"));
    }
    
    
    document1.close(); //document instance closed
    conn.close();  //db connection close
}
catch(Exception de)
{
        de.printStackTrace();
            System.err.println("document: " + de.getMessage());
           
}


%>

</body>
</html>