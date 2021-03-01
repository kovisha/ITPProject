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
		<title>User Payment</title>
	</head>
	<header>
		<%@include file="/header1.jsp" %>
	</header>
	<body style="z-index:2;">
		
		<br><br><br>
		<%String qOut=(String)session.getAttribute("resultMonth");%>
					
					<%if(qOut.equals("successMonthInstall")){ %>
						<script>
							Swal.fire({
								title: 'Monthly Installment Payment Successful!!!',
								icon: 'success',
							});
						</script>
					<%} %>
					<%if(qOut.equals("failMonthInstall")){ %>
						<script>
							Swal.fire({
								title: 'Monthly Installment Payment Failed!!!',
								icon: 'error',
							});
						</script>
					<%} 
					else { 
						session.setAttribute("resultMonth","error");
					}%>
		<center>
			<c:forEach var="yourPay" items="${yourPayDetail}">
					<c:set var="lastOrderPayDate" value="${yourPay.lastOrderPayDate}"/>
					<c:set var="lastOrderPayValue" value="${yourPay.lastOrderPayValue}"/>
					<c:set var="dueInstall" value="${yourPay.dueInstall}"/>
					<c:set var="monthlyInstall" value="${yourPay.monthlyInstall}"/>
			<table class="table table-striped table-light" id="payTable">
			  <thead>
			    <tr>
			      <label class="card-header bg-dark" id="tableH">Your Payment Details</label>
			    </tr>
			  </thead>	
			  			
			  <tbody>
			  	
			    <tr>
			      <th>Last Order Payment Date</th>
			      <td>${lastOrderPayDate} </td>
			    </tr>
			    <tr>
			      <th>Last Order Payment Value</th>
			      <td>${lastOrderPayValue}</td>
			    </tr>
			    <tr>
			      <th>Due Installment Amount</th>
			      <td>${dueInstall}</td>
			    </tr>
			     <tr>
			      <th>Monthly Installment Amount</th>
			      <td>${monthlyInstall}</td>
			    </tr>
			  </tbody>
			</table>
			</c:forEach>
			<%
			double val = (double)pageContext.getAttribute("dueInstall");
			if(val!=0){ %>
			<button type="button" class="submit" id="payBtn" onclick="confPayMonthInstall()">Pay Monthly Installment</button>
			<%} %>
	      	
	   	</center>
	   	<br><br><br>
	</body>
	<footer>
		<%@include file="/footer1.jsp" %>
	</footer>
</html>