<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
        <link rel="stylesheet" href="css/userPay.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

		<script src="userPay.js"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
		<title>User Installment</title>
	</head>
	<header>
		<%@include file="/header1.jsp" %>
	</header>
	<body style="z-index:2;">
		
	   	
		<div class="main">
		
			<div class="container1">
			<br>
				<a class="btn btn-green" href="#" onClick="autoFill(); return true;" style="color:#fff;font-size:13px;height:30px;padding-top:4px;margin-left:9%;">Demo</a>
				<form method="post" action="enterInstall" class="appointment-form" id="appointment-form" name="intsallDet">
		    		<h3>Installment Details</h4>
		      		<div class="form-group-1">
			          	<div class="cont2">
			            	<label class="card-title">Choose your Installment Type</label>
			            	
			            	<c:forEach var="installType" items="${typeDetail}">
			            		<div class="form-check" style="margin-left:10%;">
				                	<input class="form-check-input" type="radio" name="installType" id="exampleRadios${installType.months}" value="${installType.months}">
				                  	<label class="form-check-label" for="exampleRadios${installType.months}">${installType.months} months</label>
			              		</div>
			            	</c:forEach>
			    
			               	<br>
			                <label class="card-title">Down Payment Amount</label>
			                
			                <label id=dpayDesc>(Should be more than 10% of Total Amount)</label>
			                <br>
			                <input id="inDpay" name="downPayAmount" type="text" placeholder="Enter Down Payment Amount">
			           	</div>
		   			</div>
		   		<br>
		  
		   	<button type="submit" class="submit">Next</button>
	   	</form>
			
			</div>
		
		</div>
	   	
	   	<script type="text/javascript">
			function autoFill() {
				document.getElementById('inDpay').value = "10000";
							 
				var radioElements = document.getElementsByName("installType");
							
							 
							
				for (var i=0; i<radioElements.length; i++) {
				if (radioElements[i].getAttribute('value') == '6') {
				radioElements[i].checked = true;
					}
				} 
			}
              
        </script>
        
	   	<br><br>
	   	<footer>
			<%@include file="/footer1.jsp" %>
		</footer>
	</body>
</html>