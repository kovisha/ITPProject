<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="css/userPay.css">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	 	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>	
	 	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
	<title>User Installment</title>
	</head>
	<header>
		<%@include file="/header1.jsp" %>
	</header>
	<body style="z-index:2;">
		
		<div class="main">
		
			<div class="container1" style="height:380px;">
			<br>
				<h3 style="margin-left:10%;padding-top:17px;">Installment Details Summary</h3>
	       		<div class="summaryDisplay1">
		           	<div class="left"><br>
		             	<label>Installment Item Value:</label><br><br>
		                <label>Installment Period:</label><br><br>
		             	<label>Monthly Installment:</label><br><br>
		           	</div>
		           	<div class="right"><br>
		           		<label>Rs.${installmentValue}</label><br><br>
		             	<label>${installType} months</label><br><br>
		            	<label>Rs.${monthlyInstall}</label><br><br>
		       		</div>  
		       	
		       		<a href="calOffer"><button type="button" class="submit" style="margin-top:5%;margin-left:15%;">Confirm</button></a>  
	       		</div>
	    	
			</div>
		
		</div>
	   	
	</body>
	<footer>
		<%@include file="/footer1.jsp" %>
	</footer>
</html>