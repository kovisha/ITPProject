<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="insertsupplier" method="post">
		Supplier ID<br>
		<input type="text" name="supplierid"><br>
		
		Supplier Name<br>
		<input type="text" name="suppliername"><br>
		
		Status<br>
		<select name="status">
			<option value="enabled">enabled</option>
			<option value="disabled">disabled</option>
		</select><br>
		<!-- <input type="text" name="status"><br>  -->
		
		Supplier Address<br>
		<input type="text" name="supplieraddress"><br>
		
		Supplier Email<br>
		<input type="text" name="supplieremail"><br>
		
		Supplier Phone Number1<br>
		<input type="text" name="supplierphone1"><br>
		
		Supplier Phone Number2<br>
		<input type="text" name="supplierphone2"><br>
		
		Description<br>
		<input type="text" name="description"><br>
		
		<input type="submit" name="submit" value="Add The Supplier">
	
	
	</form>

</body>
</html>