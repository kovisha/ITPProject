<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="userPay.css">
	 	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	
	  	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	 	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
	   	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
		<title>Insert title here</title>
	</head>
	<body>
		<header>
				<%@include file="/header.jsp" %>
		</header>
		<br><br><br>
		<center>
	   		<div class="card border-dark">
	       		<div class="card-header bg-dark">Payment Summary</div>
	            <div class="paySumDis"><br>
	         		<label>Installment(Down Payment for Household Products)</label><br><br>
	               	<label>Total Amount(Non Installment Products)</label><br><br>
	               	<label>XX% Discount</label><br><br>
	             	<label style="font-weight: bold;">Final Bill Amount</label><br><br>
	           	</div>
	          	<div class="paySumAmount">
	        		<label>xx,xxx.xx</label><br><br>
	             	<label>xx,xxx.xx</label><br><br>
	             	<label>xx</label><br><br>
	              	<label style="font-weight: bold;">xx,xxx.xx</label><br><br>
	           	</div>    
	       	</div><br><br>		
		</center>
	  	<button type="button" class="btn btn-dark" id="confBtn">Confirm</button>
	  	<br><br>
		<footer>
			<%@include file="/footer.jsp" %>
		</footer>
	</body>
</html>