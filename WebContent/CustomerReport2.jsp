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
<%@page import="Customer.DBManager"%>
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
    
    LocalDate ld = java.time.LocalDate.now();
    
   
    conn= DBManager.getConnection();
    String query = "select * from customer where loyalyPoints >= ALL(select max(loyalyPoints) from customer)";          //Fetching data from table
       ps=conn.prepareStatement(query);                // executing query
       rs=ps.executeQuery();
       

       
      
    document.open();
    

    /* new paragraph instance initialized and add function write in pdf file*/
    document.add(new Paragraph("------------------------------CUSTOMER WITH HIGHEST LOYALTY POINTS----------------------------------\n\n"));
    document.add(new Paragraph("                                                  DATE GENERATED : "+ld+"\n\n"));
    document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------\n\n"));
    document.addCreationDate();
   
    while(rs.next())
    {
          // fetch & writing records in pdf files
        document.add(new Paragraph("Customer ID                :  "+rs.getString(2)+"\nUsername                    :  "+rs.getString(3)+"\nFirst Name                   :  "+rs.getString(15)+"\nLast Name                   :  "+rs.getString(16)+"\nAddress                       :  "+rs.getString(5)+"\nEmail                           :  "+rs.getString(6)+"\nContact                        :  "+rs.getString(14)+"\nLoyalty Card Number  :  "+rs.getString(11)+"\nLoyalty Points              :  "+rs.getString(13)+"\nLoyalty Expiry Date     :  "+rs.getString(12)+"\n\n\n"));
    }
    
    
    document.close(); //document instance closed
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