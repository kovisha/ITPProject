<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		
		<link rel="stylesheet" href="css/userPay.css">
		<link rel = "stylesheet" type = "text/css" href = "css/login.css">
		<link rel="stylesheet" href="css/bootstrap.css">
	    <link rel="stylesheet" href="css/bootstrap.min.css">
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
		
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
		
		<title>User Payment</title>
	</head>
	<header>
			<%@include file="/header1.jsp" %>
	</header>
	<body>
		
	        <div class="main">

        <div class="container1"></br>
        
        <!-- Autofill -->
         <a class="btn btn-green" href="#" onClick="autoFill(); return true;" style="color:#fff;font-size:13px;height:30px;padding-top:4px;margin-left:9%;">Demo</a>
         <!-- Form Start -->
            <form method="post" action="paySelect" class="appointment-form" name="pay1" id="appointment-form">
                <h3>Choose your Payment Type</h3><br>
                <div class="form-group-1">
                
             		<div class="cont2">
			        	<div class="form-check">
			            	<input class="form-check-input" type="radio" name="payType" id="exampleRadios1" value="card" required>
			                <label class="form-check-label" for="exampleRadios1">Card Payment</label>
			          	</div>
			          
			            <div class="form-check">
			            	<input class="form-check-input" type="radio" name="payType" id="exampleRadios2" value="cash" required>
			                <label class="form-check-label" for="exampleRadios2">Cash Payment</label>
			            </div>
			      	</div>
             	
               </div><br><br>
               
               <h3>Choose your Paying Type for Household Appliances</h3><br>
                <div class="form-group-1">
                
             		<div class="cont2">
			        	<div class="form-check">
			            	<input class="form-check-input" type="radio" name="installType" id="exampleRadios1" value="install">
			                <label class="form-check-label" for="exampleRadios1">Installment Payment</label>
			          	</div>
			          	
			            <div class="form-check">
			            	<input class="form-check-input" type="radio" name="installType" id="exampleRadios2" value="normal">
			                <label class="form-check-label" for="exampleRadios2">Normal Payment</label>
			          	</div>
			      	</div>
             	
               </div><br><br>
               
               <button type="submit" class="submit">Next</button>
            
            </form>
            
        </div>
        

    </div>
	    
	    <script type="text/javascript">
			function autoFill() {
							 
				var radioElements1 = document.getElementsByName("payType");
				var radioElements2 = document.getElementsByName("installType");
							
				for (var i=0; i<radioElements1.length; i++) {
					if (radioElements1[i].getAttribute('value') == 'card') {
						radioElements1[i].checked = true;
					}
				}		 
							
				for (var i=0; i<radioElements2.length; i++) {
					if (radioElements2[i].getAttribute('value') == 'install') {
						radioElements2[i].checked = true;
					}
				}
			}
              
        </script>
    
	    
	</body>
	<footer>
			<%@include file="/footer1.jsp" %>
	</footer>
</html>