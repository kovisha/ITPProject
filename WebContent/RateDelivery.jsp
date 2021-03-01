<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Rate our delivery</title>		
		
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<!-- Bootstrap CSS CDN -->
     	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    	
    	<!-- Custom CSS -->
    	<link rel = "stylesheet" type = "text/css" href = "css/login.css">
    	
    	<!-- Custom Java Script -->
    	<script type="text/javascript" src = "JS/delivery.js" async></script>
    	
    	<!-- Bootstrap JS CDN -->
    	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

		
				
	</head>
	
	<header>
		<%@include file="header.jsp" %>
	</header>
	
	<body>
		<br><br><br>
		
		<div class ="container-sm">
			<div class = "card border-dark mb-3 text-black special-card" >
				<div class = "card-body">					
					<div class="card text-white bg-dark mb-3 card-header text-center">We appreciate your Suggestions !!!</div>
					
					<form name ="RateDelivery" method="post" action="home.jsp">
						
						<!-- Rating -->
						<div class="form-group">
					 		<label>How is our delivery ??</label>
							<select class="form-control" name="dtype">
								<option>Excellent</option>
						     	<option>Good</option>
						      	<option>Ok</option>
						      	<option>Poor</option>
						      	<option>Very Poor</option>
			      			</select>
					 	</div>
						
		      			
		      			<div class="form-group">
			      			<label>Suggestions</label>
			      			<textarea class="form-control" rows="2" id="address" name ="address"></textarea>
		      			</div>
		      			
		      			<div class="form-group">
			      			<label>Complaints</label>
			      			<textarea class="form-control" rows="2" id="address" name ="address"></textarea>
		      			</div>
		      					      		
		      			<h4 class="card-price text-center">Thank you for Shopping with us !!!</h4>
		      			
		      			<div class="text-center">
		      				<button type="submit" class="btn btn-success">Submit</button>
						</div>
						
					</form>
					
				</div>
			</div>
		</div>

			
		
	
	<br>
	<br>	
	</body>
	
	<footer>
		<%@include file="UserFooter.jsp" %>
	</footer>	
	
</html>