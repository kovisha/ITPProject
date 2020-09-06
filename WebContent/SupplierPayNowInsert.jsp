<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	String suppPayID = request.getParameter("suppPayID"); 
	 %>

	<form action="insertsupplierpaynow" method="post">
			Supplier Pay ID<br>
			<input type="text" name="suppPayID" value="<%= suppPayID %>" readonly><br>
			
			Paying Date<br>
			<input type="text" name="payingdate"><br>
			
			Cheque Number<br>
			<input type="text" name="chequenumber"><br>
			
			Payment Amount<br>
			<input type="text" name="payamount"><br>
			
			Invoice Number<br>
			<input type="text" name="invoicenumber"><br>
			
			<input type="submit" name="submit" value="Add The Supplier Payment">
			
	</form>
	
</body>
</html>