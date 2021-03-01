<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous"> 
    <!-- <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/bootstrap.min.css"> -->
    
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>
    
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>

    <link rel="stylesheet" href="css/user.css">
</head>
<body>
<img src="images/bgg1.jpg">

<div>
        <div id="content">

        <div id="topBar">
            
		<nav class="navbar navbar-expand navbar-dark lighten-1" style="background-color: #cf0000;font-family:Georgia;">
		  <img src="images/UDS_5.png" width="90px" style="float: left ; margin-left: 50%">
        </nav>
        </div>
        </div>
        </div>
    </header>
            

        
        
        		<%String qOut=(String)session.getAttribute("result");%>
					<!-- Alerts for login -->
					<%if(qOut.equals("LoginSuccess")){ %>
						<script>
							Swal.fire({
								title: 'Login Sucessfull!!!',
								icon: 'success',
							}).then(function() {
								window.location = "Home.jsp";
								});
						</script>
					<%} %>
					<%if(qOut.equals("LoginFail")){ %>
						<script>
							Swal.fire({
								title: 'Incorrect Username Or Password!!!',
								icon: 'error',
							}).then(function() {
								window.location = "login.jsp";
								});
						</script>
					<%} %>
					
					<!-- Alerts for registration -->
					<%if(qOut.equals("RegistrationSuccess")){ %>
						<script>
							Swal.fire({
								title: 'Registration Sucessfull!!!',
								icon: 'success',
							}).then(function() {
								window.location = "Home.jsp";
								});
						</script>
					<%} %>
					<%if(qOut.equals("RegistrationFailed")){ %>
						<script>
							Swal.fire({
								title: 'Registration Failed!!!',
								icon: 'error',
							}).then(function() {
								window.location = "login.jsp";
								});
						</script>
					<%} %>
					
					<!-- Alerts for password reset -->
					<%if(qOut.equals("ResetSuccess")){ %>
						<script>
							Swal.fire({
								title: 'Password Reset Success',
								icon: 'success',
							}).then(function() {
								window.location = "login.jsp";
								});
						</script>
					<%} %>
					<%if(qOut.equals("ResetFailed")){ %>
						<script>
							Swal.fire({
								title: 'Password Reset Success',
								icon: 'error',
							}).then(function() {
								window.location = "forgotPassword.jsp";
								});
						</script>
					<%} %>
					
					<!-- Alerts for changing password -->
					<%if(qOut.equals("ChangeSuccess")){ %>
						<script>
							Swal.fire({
								title: 'Password Changed Successfully!!!',
								icon: 'success',
							}).then(function() {
								window.location = "logoutServlet";
								});
						</script>
					<%} %>
					<%if(qOut.equals("ChangeFailed")){ %>
						<script>
							Swal.fire({
								title: 'Password Change Failed!!!',
								icon: 'error',
							}).then(function() {
								window.location = "changePassword.jsp";
								});
						</script>
					<%} %>
					
					<!-- Alerts for update -->
					<%if(qOut.equals("updateSuccess")){ %>
						<script>
							Swal.fire({
								title: 'Updated Successfully!!!',
								icon: 'success',
							}).then(function() {
								window.location = "userProfileServlet";
								});
						</script>
					<%} %>
					<%if(qOut.equals("updateFailed")){ %>
						<script>
							Swal.fire({
								title: 'Update Failed!!!',
								icon: 'error',
							}).then(function() {
								window.location = "userProfileServlet";
								});
						</script>
					<%} %>
					
					
					<!-- Alerts for calculation -->
					<%if(qOut.equals("CalcSuccess")){ %>
						<script>
							Swal.fire({
								title: 'Calculated Successfully!!!',
								icon: 'success',
							}).then(function() {
								window.location = "DeliveryDetails.jsp";
								});
						</script>
					<%} %>
					<%if(qOut.equals("updateFailed")){ %>
						<script>
							Swal.fire({
								title: 'Calculation Failed!!!',
								icon: 'error',
							}).then(function() {
								window.location = "loyaltyCalc.jsp";
								});
						</script>
					<%} %>
            
 

</body>
</html>