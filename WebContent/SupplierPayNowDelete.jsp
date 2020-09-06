<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<%
		String suppPayID = request.getParameter("suppPayID");
		String stockid = request.getParameter("stockid");
		double totalAmount = Double.parseDouble(request.getParameter("totalAmount"));
		double paidAmount = Double.parseDouble(request.getParameter("paidAmount"));
		%>
		
		<form action="deletesupplierpayment" method="post">
	
			Supplier Pay ID<br>
			<input type="text" name="suppPayID" value="<%= suppPayID %>"><br>
			
			Stock ID<br> 
 			<input type="text" name="stockid" value="<%= stockid %>"><br> 
 			
 			Total Amount<br> 
 			<input type="text" name="totalAmount" value="<%= totalAmount %>"><br> 
 			
 			Payed Amount<br> 
 			<input type="text" name="paidAmount" value="<%= paidAmount %>"><br> 
			
			<input type="submit" name="submit" value="Delete The Supplier">
		
	
	</form>
		


</body>
</html>