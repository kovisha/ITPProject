<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
    
    <!DOCTYPE html>
<html>
<head>
 <%@include file="/header.jsp" %>
 
	<meta charset="utf-8">
		 <title>UDS SUPER ONLINE DELIVERY</title>
		 <link rel = "icon" href = "images/UDS_2.jpg"   class="rounded-circle" width="100px" height="100px">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <link rel = "stylesheet" href ="headerFooter.css">
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
</head>

<body>
		<div id="carousel-example-1z" class="carousel slide carousel-fade" data-ride="carousel">
		  <!--Indicators-->
		  <ol class="carousel-indicators">
		    <li data-target="#carousel-example-1z" data-slide-to="0" class="active"></li>
		    <li data-target="#carousel-example-1z" data-slide-to="1"></li>
		    <li data-target="#carousel-example-1z" data-slide-to="2"></li>
		  </ol>
		  <!--/.Indicators-->
		  <!--Slides-->
		  <div class="carousel-inner" role="listbox">
		    <!--First slide-->
		    <div class="carousel-item active">
		       <img class="d-block w-100" src="images/bg_3.jpg"
		        alt="First slide">
		    </div>
		    <!--/First slide-->
		    <!--Second slide-->
		    <div class="carousel-item">
		      <img class="d-block w-100" src="images/background2.jpg"
		        alt="Second slide">
		    </div>
		    <!--/Second slide-->
		    <!--Third slide-->
		    <div class="carousel-item">
		      <img class="d-block w-100" src="images/bg_5.jpg"
		        alt="Third slide">
		    </div>
		    <!--/Third slide-->
		  </div>
		  <!--/.Slides-->
		  <!--Controls-->
		  <a class="carousel-control-prev" href="#carousel-example-1z" role="button" data-slide="prev">
		    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		    <span class="sr-only">Previous</span>
		  </a>
		  <a class="carousel-control-next" href="#carousel-example-1z" role="button" data-slide="next">
		    <span class="carousel-control-next-icon" aria-hidden="true"></span>
		    <span class="sr-only">Next</span>
		  </a>
		  <!--/.Controls-->
		</div>
		<!--/.Carousel Wrapper-->
		<br>
		<center>
		<!-- Card -->
		<div class="card" style="width:275px;height:315px;">
		
		  <!-- Card image -->
		  <img class="card-img-top" src="images/summerSale.jpg" alt="Card image cap">
		
		  <!-- Card content -->
		  <div class="card-body">
		
		    <!-- Title -->
		    <h4 class="card-title"><a>Summer Sale</a></h4>
		    <!-- Text -->
		    <p class="card-text">There is a 25% discount on selected items for September and October.</p>
		    <!-- Button -->
		
		  </div>
		
		</div>
		</center>
		<!-- Card -->
		<br>
        </br>
        <%@ include file = "/footer.jsp" %> 

</body>


</html>