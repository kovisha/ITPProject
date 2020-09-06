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
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String description = request.getParameter("description");
	%>
	
	<form action="updatesupplier" method="post">
	
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
		
		Supplier Address<br>
		<input type="text" name="address" value="<%= address %>"><br>
		
		Supplier Email<br>
		<input type="text" name="email" value="<%= email %>"><br>
		
		Supplier Phone Number1<br>
		<input type="text" name="phone1" value="<%= phone1 %>"><br>
		
		Supplier Phone Number2<br>
		<input type="text" name="phone2" value="<%= phone2 %>"><br>
		
		Description<br>
		<input type="text" name="description" value="<%= description %>"><br>
		
		<input type="submit" name="submit" value="Update The Supplier">
	
	
	</form>

</body>
</html>