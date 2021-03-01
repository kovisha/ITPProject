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
PreparedStatement ps1=null;
ResultSet rs1=null;

try
{
    Document document1=new Document();
    if(str.equals("pdf"))
    {
        response.setContentType("application/pdf");
        PdfWriter.getInstance(document1,response.getOutputStream());
    }
    
    LocalDate ld = java.time.LocalDate.now();
    
    String month = request.getParameter("month");
    String year = request.getParameter("year");
    
   
    conn= DBManager.getConnection();
    String query = "select * from customer where UserID =(select uid from uds_super_db.order where Month(date)='"+month+"' && YEAR(date)='"+year+"' group by uid having (count(uid)>=2))";          //Fetching data from table
       ps1=conn.prepareStatement(query);                // executing query
       rs1=ps1.executeQuery();
       

       
      
    document1.open();
    

    /* new paragraph instance initialized and add function write in pdf file*/
    document1.add(new Paragraph("------------------------------------FREQUENTLY ORDERED CUSTOMERS-------------------------------------\n\n"));
    document1.add(new Paragraph("                                              DATE GENERATED - "+ld+"\n\n"));
    document1.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------\n\n"));
    document1.addCreationDate();
   
    while(rs1.next())
    {
          // fetch & writing records in pdf files
        document1.add(new Paragraph("Customer ID                :  "+rs1.getString(2)+"\nUsername                    :  "+rs1.getString(3)+"\nFirst Name                   :  "+rs1.getString(15)+"\nLast Name                   :  "+rs1.getString(16)+"\nAddress                       :  "+rs1.getString(5)+"\nEmail                           :  "+rs1.getString(6)+"\nContact                        :  "+rs1.getString(14)+"\nLoyalty Card Number  :  "+rs1.getString(11)+"\nLoyalty Points              :  "+rs1.getString(13)+"\nLoyalty Expiry Date     :  "+rs1.getString(12)+"\n\n\n"));
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