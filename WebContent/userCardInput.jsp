<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="userPay.css">
	 	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	
		<script src="userPay.js"></script>
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	  	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
	    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
	<title>Insert title here</title>
	</head>
	<body>
		<header>
			<%@include file="/header.jsp" %>
		</header>
		<br>
		<form method="post" action="cardDet" name="pay2">
			<center>
		   		<div class="card border-dark">
		      		<div class="card-header bg-dark">
		          		Card Details
		          	</div>
		        	<div class="card-body" style="margin-left: 8%;">
		           		<h6 class="card-title">Card Type</h6>
		               	<div class="form-check" style="padding-bottom: 2%;">
		                	<input class="form-check-input" type="radio" name="cardType" id="exampleRadios1" value="VISA">
		             		<label class="form-check-label" for="exampleRadios1">VISA</label>
		               	</div>
		            	<div class="form-check" style="padding-bottom: 2%;">
		             		<input class="form-check-input" type="radio" name="cardType" id="exampleRadios2" value="MCard">
		                  	<label class="form-check-label" for="exampleRadios2">Master Card</label>
		             	</div>
		              	<div class="form-check" style="padding-bottom: 2%;">
		            		<input class="form-check-input" type="radio" name="cardType" id="exampleRadios3" value="AmericanExp">
		              		<label class="form-check-label" for="exampleRadios3">American Express</label>
		              	</div>
		         		<label class="card-title">Card Number:</label><br>
		            	<input name="cNum" id="inCardNo" type="text" placeholder="Enter Your Card Number" required><br>
		           		
		           		<label class="card-title">Expiry Details</label><br>
		           		<input name="expMonth" id="inCardMM" type="number" placeholder="MM" min="1" max="12" required>
		         		<input name="expYear" id="inCardYYYY" type="number" placeholder="YYYY" min="2020" required><br>
		         		
		         		<label class="card-title">Card Verification Code</label><br>
		             	<input name="cvc" id="CVC" type="text" placeholder="Enter CVC Code" pattern="[0-9]{4}" required>
		       		</div>
		  		</div><br><br>
			</center>
		  	<button type="submit" class="btn btn-dark" id="confBtn" onclick="return validateCardDetails()">Confirm</button>
		</form>
	  	<br><br>
	   	<footer>
			<%@include file="/footer.jsp" %>
		</footer>
	</body>
</html>