<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
		<!-- Google Fonts -->
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
		<!-- Bootstrap core CSS -->
		<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
		<!-- Material Design Bootstrap -->
		<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css" rel="stylesheet">
		
		<!-- JQuery -->
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<!-- Bootstrap tooltips -->
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
		<!-- Bootstrap core JavaScript -->
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/js/bootstrap.min.js"></script>
		<!-- MDB core JavaScript -->
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/js/mdb.min.js"></script>
	</head>
	<body>
		<nav class="mb-1 navbar navbar-expand-lg navbar-dark lighten-1" style="background-color: #cf0000;font-family:Georgia;position: fixed;">
		  <img src="images/UDS_5.png" height="35" style="padding-right:1%;">
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-555"
		    aria-controls="navbarSupportedContent-555" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		  <div class="collapse navbar-collapse" id="navbarSupportedContent-555">
		    <ul class="navbar-nav mr-auto">
		      <li class="nav-item active">
		        <a class="nav-link" href="Home.jsp"><i class="fas fa-home"></i>Home
		          <span class="sr-only">(current)</span>
		        </a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="#"><i class="fas fa-info-circle"></i>About Us</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="tempcart"><i class="fas fa-shopping-cart"></i>Shop With Us</a>
		      </li>
		      <li class="nav-item dropdown">
		        <a class="nav-link" href="#"><i class="fas fa-envelope"></i>Contact Us</a>
		      </li>
		      <li class="nav-item dropdown">
		      	<%if(session.getAttribute("LoggedUser") == null){ %>
		        <a class="nav-link" href="login.jsp"><i class="fas fa-sign-in-alt"></i>Login</a>
		         <%}else{ %>
		         <a class="nav-link" href="userLogout"><i class="fas fa-sign-out-alt"></i>Logout</a>
		         <%} %>
		      </li>
		       <li class="nav-item dropdown">
		      	<%if(session.getAttribute("LoggedUser") != null){ %>
		        <a class="nav-link" href="UserProfile"><i class="fas fa-user-alt"></i>User Profile</a>
		         <%} %>
		      </li>
		    </ul>
		    <ul class="navbar-nav ml-auto nav-flex-icons">
		    	<!-- only for login page -->
		      <!-- <li class="nav-item">
		          <button type="button" class="btn btn-sm btn-grey"><i class="fas fa-sign-in-alt"></i> LOGIN</button>
		      </li> -->
		      <!--  <li class="nav-item avatar dropdown">
		        <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-55" data-toggle="dropdown"
		          aria-haspopup="true" aria-expanded="false">
		          <img src="images/chris.jfif" height="33" class="rounded-circle"
		            alt="">
		        </a>-->
		        <!-- <div class="dropdown-menu dropdown-menu-lg-right dropdown-secondary"
		          aria-labelledby="navbarDropdownMenuLink-55">
		          <a class="dropdown-item linkhover" href="#">User Profile</a>
		          <a class="dropdown-item linkhover" href="#">Logout</a>
		          <style>
		          	.linkhover:hover{
		          		background-color:#cf0000;
		          	}
		          </style>
		        </div>-->
		      </li>
		    </ul>
		  </div>
		</nav>
		</br></br>

</body>
</html>