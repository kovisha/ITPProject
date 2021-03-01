<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <link rel = "stylesheet" href ="css/headerFooter.css">
         <link rel = "stylesheet" href ="css/itemHeader.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
		
		<!--Javascript-->
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
	
 	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	   
	    <!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script> -->
	    
	    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,700,900" rel="stylesheet">
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	    
	    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700" rel="stylesheet">
       <!--  <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet"> -->
        <!-- <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css" rel="stylesheet"> -->
    </head>
    
    
   <body>
        <div class="header">
			<nav class="navbar navbar-expand-lg" style="position: fixed;">
				<img src="images/UDS_3.png" width="4%" height="4%"> 
				

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav mr-auto" >
						<li class="nav-item">
							<a class="nav-link" href="#">Home</a>
                        </li>
						<li class="nav-item">
							<a class="nav-link" href="#">About Us</a>
                        </li>
						<li class="nav-item">
						<div class="dropdown">
						 <a class="nav-link" href="displaycat2">Categories</a>
						  <div class="dropdown-content">
						    <c:forEach var="cat" items= "${category}">
						  <a href = "displayItem?category=${cat.catName}">${cat.catName}</a>
						  </c:forEach>
						   
						  </div>
						  </div>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="#">Contact Us</a>
						</li>
						
						<li class="nav-item">
							<a class="nav-link" href="tempcartRetrieve">Your Cart</a>
                        </li>
						
		      <li class="nav-item dropdown">
		      	<%if(session.getAttribute("LoggedUser") == null){ %>
		        <a class="nav-link" href="login.jsp"><i class="fas fa-sign-in-alt"></i>Login</a>
		         <%}else{ %>
		         <a class="nav-link" href="logoutServlet"><i class="fas fa-sign-out-alt"></i>Logout</a>
		         <%} %>
		      </li>
		       <li class="nav-item dropdown">
		      	<%if(session.getAttribute("LoggedUser") != null){ %>
		        <a class="nav-link" href="userProfileServlet"><i class="fas fa-user-alt"></i>User Profile</a>
		         <%} %>
		      </li>
					</ul>
					 <form class="form-inline my-2 my-lg-0">
                      <input style = "width : 180px; height:35px;font-size: 15px;" class="form-control mr-sm-2" type="text" placeholder="Search" id = "myInput" onkeyup="myFunction()" placeholder="Search" aria-label="Search">
                      </form>
					<%--<div class="userImage">
					<%if(session.getAttribute("LoggedUser") != null){ %>
						<a href="userProfileServlet"><img src="images/profile.png" style="width:50px" height="50px"></a>
						<%}else{ %>
						<a href=""><img src="images/profile.png" style="width:50px" height="50px"></a>
						<%} %>
					</div>
					
					<%if(session.getAttribute("LoggedUser") == null){ %>
					<a href="login.jsp"><button type="button" class="btn btn-dark" style="margin-left: 2%;">Login</button></a>
					 <%}else{ %>
					<a href="logoutServlet"><button type="button" class="btn btn-dark" style="margin-left: 2%;">Logout</button></a> 
					 <%} %>
					 --%>
					
				</div>
			</nav>
		</div></br></br>

</body>
</html>