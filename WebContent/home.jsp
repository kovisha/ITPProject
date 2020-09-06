<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
 	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,700,900" rel="stylesheet">
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700" rel="stylesheet">
		<title>Home</title>
	</head>
	<body>
		<header>
			<%@include file="/header.jsp" %>
		</header>	
		
		<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
	  		<div class="carousel-inner">
	    		<div class="carousel-item active">
	      			<img class="d-block w-100" src="img/slide1.jfif" height="650px" alt="First slide">
	    		</div>
	    		<div class="carousel-item">
	      			<img class="d-block w-100" src="img/slide2.jpg" height="650px" alt="Second slide">
	    		</div>
	    		<div class="carousel-item">
	     			 <img class="d-block w-100" src="img/slide3.jpg" height="650px" alt="Third slide">
	          	</div>
	          	<div class="carousel-item">
	            	<img class="d-block w-100" src="img/slide4.jpg" height="650px" alt="Third slide">
	            </div>
	           	<div class="carousel-item">
	            	<img class="d-block w-100" src="img/slide5.jpg" height="650px" alt="Third slide">
	           	</div>
	  		</div>
			<a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a>
	  		<a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
	    		<span class="carousel-control-next-icon" aria-hidden="true"></span>
	    		<span class="sr-only">Next</span>
	  		</a>
	  	</div>
	    <br>
	    <center>
	    	<div class="card" style="width: 18rem;">
	        	<img class="card-img-top" src="img/summerSale.jpg" alt="Card image cap">
	            <div class="card-body">
	            	<h5 class="card-title">Summer Sale</h5>
	                <p class="card-text">There is a 25% discount on selected items for July and August.</p>
	          	</div>
	      	</div>
	 	</center>  
	    <br>  
		
		<footer>
			<%@include file="/footer.jsp" %>
		</footer>	
	</body>
</html>