<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
        <link rel="stylesheet" href="userPay.css">
        <link rel = "stylesheet" type = "text/css" href = "css/login.css">
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
	<body>
		<img src = "images/bgg.jpg" class = "pic">
		
		<br><br>
		<%String output = (String) session.getAttribute("out"); %>
		<%if(output.equals("failDownpay")) {%>
			<script>
			Swal.fire({
				title: 'Invalid Down Payment Amount!!!',
				text:'Down Payment Should be more than 10% of Total Installment Amount',
				icon: 'error',
			}).then(function() {
				window.location = "cardDet";
				});
		</script>
		<%} %>
		<%if(output.equals("success")) {%>
			<script>
			Swal.fire({
				title: 'Your Payment Transcation is Succesfull!!!',
				icon: 'success',
			}).then(function() {
				window.location = "home.jsp";
				});
		</script>
		<%} %>
		<%if(output.equals("fail")) {%>
			<script>
			Swal.fire({
				title: 'Your Payment Transcation is Failed!!!',
				icon: 'error',
			}).then(function() {
				window.location = "home.jsp";
				});
		</script>
		<%} %>
		<br><br>
		<br><br>
		<br><br>
		<br><br>
		<br><br>
		<br><br>
		<br><br>
		<br><br>
		<br><br>
	   	<br><br>
	   	
	</body>
	<footer>
		<%@include file="/footer1.jsp" %>
	</footer>
</html>