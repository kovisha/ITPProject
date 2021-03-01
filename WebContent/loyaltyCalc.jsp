<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@include file="/header.jsp" %>
    
    <!DOCTYPE html>
<html>
<head>

 
	<meta charset="utf-8">
		 <title>UDS SUPER ONLINE DELIVERY</title>
	    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
		<!--Javascript-->
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
	
 	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	   
	    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,700,900" rel="stylesheet">
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700" rel="stylesheet">
	    
	    <link rel="stylesheet" href="css/loyaltyCalc.css">
	    
	  
	    
	    
	   
</head>

<body>

<%
	//Double totalAmt = 5000.00;
	Double totalAmt = (Double)session.getAttribute("netTotal");
%>

</br></br>

<c:forEach var="cust" items="${UserDetail}">

	<c:set var="loyaltyPoints" value="${cust.loyaltyPoints}" />
	
	<div class="formMain">
	
        <div class="formContainer">
            <form method="POST"  action="deductLoyalty" class="appointment-form" id="appointment-form" style="padding-bottom:10px;">
                <center><h2>Loyalty Exchange</h2></center></br>
                
                <div class="form-group-1">
                	<center><h3 style="font-family:Georgia;">Your Sub Total as calculated</h3></center>
                	
                	<input type="text" name = "totAmnt" value="<%=totalAmt%>" readonly style="font-family:Georgia; text-align:center;">
                	</br><h6 style="font-family:Georgia; color:#222;">Your total Loyalty points : ${cust.loyaltyPoints} </h6></br>
                	<h6 style="font-family:Georgia;">Do you prefer to deduct amount from your loyalty points?</h6></br>
                	
               	 	<legend style="border-style:groove; border-color:#bfbfbf; font-family:Georgia;">
               	 
		                 <div class="deductLoyalty" id="reduce" style="padding-left:15px; padding-right:15px; padding-top:7px; padding-bottom:9px; background-color:#e6e6e6;">
		                 
		                 	<center><h6 style="font-family:Georgia; text-decoration: underline;">REDUCE POINTS</h6></center>
		                  	<h6 style="font-family:Georgia; font-size:15px; color:#333333;">Please enter the amount to deduct and click continue</h6>
		                 
		                 	<input type = "text" placeholder="Enter an amount less than ${cust.loyaltyPoints}" name="ptAmnt" style="font-size:15px; padding-bottom:5px;">
	
							<div style="padding-top:9px;">
		                    	<button type="submit" class="submit" value="Deduct">Deduct</button>
		                	</div>
		                	
	                	</div>
                 </legend>
                </div>
                
                </form>
                
                 <form method="POST"  action="addLoyalty" class="appointment-form" id="appointment-form" style="padding-top:15px;">
	                <div class="form-group-1">
	                 <input type="text" name = "totAmnt" value="<%=totalAmt%>" readonly hidden style="font-family:Georgia; text-align:center;">
	                 <legend style="border-style:groove; border-color:#bfbfbf; font-family:Georgia;">
	               	 
		                 <div class="addLoyalty" id="add" style="padding-left:15px; padding-right:15px; padding-top:7px; padding-bottom:7px; background-color:#e6e6e6;">
		                 
		                 	<center><h6 style="font-family:Georgia; text-decoration: underline;">DO NOT REDUCE POINTS</h6></center>
		                  	<h6 style="font-family:Georgia; font-size:15px; color:#333333;">Click continue</h6>
		  
		                 	<div class="" style="padding-top:7px;">
		                    	<button type="submit" name="submit" id="submit" class="submit" value="Only Add">Only Add</button>
		                	</div>
		                	
		                </div>
		              </div>
	                 </legend>
	                 
                 
            </form>
        </div>

    </div>
	
	</c:forEach>
		<!-- Card -->
		
		
	
		
		
        
 <%@ include file = "/footer.jsp" %>
</body>


</html>