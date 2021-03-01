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
<%@page import="Staff.DBConnect"%>
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
   // String query = "select s.suppliername, s.supplierID, sum(sp.totalAmount) as 'total' from uds_ex.supplier s, uds_ex.supplierpayment sp, uds_ex.stock st where s.supplierID = st.supplierdid and st.stockid = sp.stockid and month(st.supplieddate) = '"+month+"' and year(st.supplieddate) = '"+year+"' group by s.suppliername, s.supplierID having sum(sp.totalAmount) order by total desc";          //Fetching data from table
    
    
    String query = "select s.fname,s.lanme,o.userId,o.otSUM,o.OTMonth,l.leaveSUM,l.halfSUM,l.leaveMonth,s.basicSal,l.workingDays,s.nic,s.EPFNo\r\n" + 
			"from ot_month o,leave_month l,udssuper.staff s\r\n" + 
			"where o.userId = l.userId and o.userId = s.userID and month(o.OTMonth) = '"+month+"' and year(o.OTMonth) = '"+year+"' and month(l.leaveMonth) = '"+month+"' and year(l.leaveMonth) = '"+year+"'";
    
    
    
    
       ps1=conn.prepareStatement(query); // executing query
       rs1=ps1.executeQuery();
       

       
      
    document1.open();
    

    /* new paragraph instance initialized and add function write in pdf file*/
    document1.add(new Paragraph("-----------------------------------------UDS Employee Monthly Salary Sheet--------------------------------------\n\n"));
    document1.add(new Paragraph("                                                                                                         Date Genereted - "+ld+"\n\n"));
    document1.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------\n\n"));
    document1.addCreationDate();
   
    
 
    
    while(rs1.next())
    {
    	//Full Name
    	double basicSalary =  rs1.getDouble(9);
    	String userID = rs1.getString(3);
    	String nic = rs1.getString(11);
    	String epfNo = rs1.getString(12);
    	
    	String fullname = rs1.getString(1) +" "+ rs1.getString(2);
    	
		//OT Amount
    	double otAmount = rs1.getInt(4) * basicSalary * (1.5 /240);

    	String strotAmount = String.format("%1.2f", otAmount);
    	otAmount = Double.valueOf(strotAmount);
    	
    	//Leave Deduction
    	double leaveAmount = (basicSalary * rs1.getInt(6)) / rs1.getInt(10);
    	
    	String strleaveAmount= String.format("%1.2f", leaveAmount);
    	leaveAmount = Double.valueOf(strleaveAmount);
    	
    	
    	//Half day deduction
    	//halfdayAmount = basicSalary * No of leaves / workingDaysofTheMonth * 2;
    	double halfdayAmount =  (basicSalary * rs1.getInt(7)) /( rs1.getInt(10) * 2);
    	
    	String strhalfdayAmount= String.format("%1.2f", halfdayAmount);
    	halfdayAmount = Double.valueOf(strhalfdayAmount);
    	
    	
    	//epfEmployeeContribution 
    	
    	double epfEmployeeContribution = basicSalary * 8 / 100;
    	
    	
    	//Salary
    	double salary = basicSalary + otAmount - leaveAmount - halfdayAmount - epfEmployeeContribution;
    	
    	
    	//double num = (staffBasicSalary - epfEmployeeContribution) + otAmount - (leaveDeductAmnt + halfdayDeductAmnt);
    	
    	
    	
    	
    	
    	
    	
    	
    	String strsalary= String.format("%1.2f", salary);
    	salary = Double.valueOf(strsalary);
    	
          // fetch & writing records in pdf files
        /* document1.add(new Paragraph(fullname+"     "+userID+"        "+nic+"      "+otAmount+"         "+leaveAmount+"      "+halfdayAmount+"        "+salary));
         */  
          
          
        document1.add(new Paragraph("Full Name                  : "+fullname+
        		"\nUser ID                      : "+userID+
        		"\nNIC           	                 : "+nic+
        		"\nBasic Salary              : "+basicSalary+
        		"\nOT Amount                : "+otAmount+
        		"\nEPF contribution        : "+epfEmployeeContribution+
        		"\nLeave Deductions     : "+leaveAmount+
        		"\nHalf Day deductions  : "+halfdayAmount+
        		"\n Net Salary                 : "+salary+"\n\n"));
         
    
         
         
        document1.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------\n\n"));
        
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