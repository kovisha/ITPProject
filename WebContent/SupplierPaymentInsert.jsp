<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		
		<form action="insertsupplierpayment" method="post">
			Supplier Pay ID<br>
			<input type="text" name="supplierpayid"><br>
			
			Stock ID<br>
			<input type="text" name="stockid"><br>
			
			Discount ID<br>
			<input type="text" name="discountid"><br>
			
			Discount Type<br>
			<select name="discounttype">
				<option value="discount">discount</option>
				<option value="free">free</option>
			</select><br>	
		
			Discount Percentage<br>
			<input type="text" name="discountpercentage"><br>
			
			Total Amount<br>
			<input type="text" name="totalamount"><br>
			
			<input type="submit" name="submit" value="Add The Supplier Payment">
			
		</form>
		
</body>
</html>