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
		
		<title>User Payment</title>
	</head>
	<body>
		<header>
			<%@include file="/header.jsp" %>
		</header>
		<br>
		<form method="post" action="paySelect" name="pay1" >
			<center>
				<div class="card border-dark">
			    	<div class="card-header bg-dark">
			        	Choose your Payment Type
			        </div>
			        <div class="card-body">
			        	<div class="form-check">
			            	<input class="form-check-input" type="radio" name="payType" id="exampleRadios1" value="card">
			                <label class="form-check-label" for="exampleRadios1">Card</label>
			          	</div>
			          	<br>
			            <div class="form-check">
			            	<input class="form-check-input" type="radio" name="payType" id="exampleRadios2" value="cash">
			                <label class="form-check-label" for="exampleRadios2">Cash</label>
			            </div>
			      	</div>
				</div>
				<br><br>
				<% 
				String install= (String) session.getAttribute("install");
				if(install=="yes"){ %>
			    <div class="card border-dark">
			    	<div class="card-header bg-dark">
			     		Choose your Paying Type for Household Appliances
			       	</div>
			       	<div class="card-body">
			        	<div class="form-check">
			            	<input class="form-check-input" type="radio" name="installType" id="exampleRadios1" value="install">
			                <label class="form-check-label" for="exampleRadios1">Installment</label>
			          	</div>
			          	<br>
			            <div class="form-check">
			            	<input class="form-check-input" type="radio" name="installType" id="exampleRadios2" value="normal">
			                <label class="form-check-label" for="exampleRadios2">Normal Payment</label>
			          	</div>
			     	</div>
			 	</div>
			 	<%} %>
			</center>
			<br> 
		    <button type="submit" class="btn btn-dark" id="nxtBtn">Next</button>
		</form>
	    <br><br>
	    <footer>
			<%@include file="/footer.jsp" %>
		</footer>
	</body>
</html>