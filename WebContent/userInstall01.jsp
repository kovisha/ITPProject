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
		<title>User Installment</title>
	</head>
	<body>
		<header>
			<%@include file="/header.jsp" %>
		</header>
		<br>
		<center>
	    	<div class="card border-dark">
	      		<div class="card-header bg-dark">
	          		Installment Details
	          	</div>
	          	<div class="card-body" style="margin-left: 8%;">
	            	<h6 class="card-title">Choose your Installment Type</h6>
	                <div class="form-check" style="padding-bottom: 2%;">
	                	<input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="option1">
	                  	<label class="form-check-label" for="exampleRadios1">2 months</label>
	              	</div>
	              	<div class="form-check" style="padding-bottom: 2%;">
	         			<input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios2" value="option2">
	                   	<label class="form-check-label" for="exampleRadios2">3 months</label>
	              	</div>
	              	<div class="form-check" style="padding-bottom: 2%;">
	                	<input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios2" value="option2">
	                   	<label class="form-check-label" for="exampleRadios2">4 months</label>
	                </div>
	                <div class="form-check" style="padding-bottom: 2%;">
	                	<input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios2" value="option2">
	                 	<label class="form-check-label" for="exampleRadios2">6 months</label>
	               	</div>
	               	<br>
	                <label class="card-title">Down Payment Amount</label>
	                <br>
	                <label id=dpayDesc>(Should be more than 10% of Total Amount)</label>
	                <br><br>
	                <input id="inDpay" type="text" placeholder="Enter Down Payment Amount">
	           	</div>
	   		</div>
	   		<br>
	   	</center>
	   	<button type="button" class="btn btn-dark" id="nxtBtn">Next</button>
	   	<br><br>
	   	<footer>
			<%@include file="/footer.jsp" %>
		</footer>
	</body>
</html>