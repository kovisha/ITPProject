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
		String supplierID = request.getParameter("supplierID");
		String name = request.getParameter("name");
		String status = request.getParameter("status");
		%>

		<form action="deletesupplierpayment" method="post">
	
			Supplier ID<br>
			<input type="text" name="supplierID" value="<%= supplierID %>"><br>
			
			Supplier Name<br> 
 			<input type="text" name="name" value="<%= name %>"><br> 
			
 			Status<br> 
 			<select name="status" value="<%= status %>"> 
 				<option value="enabled">enabled</option> 
 				<option value="disabled">disabled</option> 
 			</select><br> 
 			<!-- <input type="text" name="status"><br>  --> 
			
			<input type="submit" name="submit" value="Delete The Supplier">
		
	
	</form>
		


</body>
</html>