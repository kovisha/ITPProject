<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<title>Card Details</title>
	</head>
	<header>
		<%@include file="/header1.jsp" %>
	</header>
	<body style="z-index:2;">
		
		<div class="main">
		
			<div class="container1">
			<br>
				<a class="btn btn-green" href="#" onClick="autoFill(); return true;" style="color:#fff;font-size:13px;height:30px;padding-top:4px;margin-left:9%;">Demo</a>
				<form method="post" action="cardDet" class="appointment-form" id="appointment-form" name="pay2">
					<h3>Card Details</h4>
					<div class="form-group-1">
						<div class="cont2">
				           	<label class="card-title">Card Type:</label><br>
				            <div class="form-check" style="margin-left:10%;">
				                <input class="form-check-input" type="radio" name="cardType" id="exampleRadios1" value="VISA">
				             	<label class="form-check-label" for="exampleRadios1">VISA</label>
				            </div>
				            <div class="form-check" style="margin-left:10%;">
				             	<input class="form-check-input" type="radio" name="cardType" id="exampleRadios2" value="MCard">
				                <label class="form-check-label" for="exampleRadios2">Master Card</label>
				            </div>
				            <div class="form-check" style="margin-left:10%;">
				            	<input class="form-check-input" type="radio" name="cardType" id="exampleRadios3" value="AmericanExp">
				             	<label class="form-check-label" for="exampleRadios3">American Express</label>
				            </div><br>
				         	<label class="card-title">Card Number:</label><br>
				           	<input name="cNum" id="inCardNo" type="text" placeholder="Enter Your Card Number" required><br>
				           	<br>	
				          	<label class="card-title">Expiry Details</label><br>
				           	<input name="expMonth" id="inCardMM" type="number" placeholder="MM" min="1" max="12" required>
				         	<input name="expYear" id="inCardYYYY" type="number" placeholder="YYYY" min="2020" required><br>
				         	<br>	
				         	<label class="card-title">Card Verification Code</label><br>
				            <input name="cvc" id="CVC" type="password" placeholder="Enter CVC Code" pattern="[0-9]{4}" required>
				       		<span style=" position: absolute; color: #7a797e; right:50%; transform: translate(0,-50%); top: 73%; cursor: pointer;">
				        		<i class="fa fa-eye" id="eye" onclick="toggle()"></i>
				    		</span>
							<br><br><br>
						</div>
					</div>
				  	<button type="submit" class="submit" onclick="return validateCardDetails()">Confirm</button>
				</form>
			
			</div>
		
		</div>
		<script>
			var state= false;
			function toggle(){
				if(state){
					document.getElementById("CVC").setAttribute("type","password");
					document.getElementById("eye").style.color='#7a797e';
					state = false;
				}
				else{
					document.getElementById("CVC").setAttribute("type","text");
					document.getElementById("eye").style.color='green';
					state = true;
				}
			}
		</script>
	   	
	   	<script type="text/javascript">
			function autoFill() {
				document.getElementById('inCardNo').value = "5468432567891253";
				document.getElementById('inCardMM').value = "06";
				document.getElementById('inCardYYYY').value = "2025";
				document.getElementById('CVC').value = "9057";
	
							 
				var radioElements = document.getElementsByName("cardType");
							
							 
							
				for (var i=0; i<radioElements.length; i++) {
				if (radioElements[i].getAttribute('value') == 'MCard') {
				radioElements[i].checked = true;
					}
				} 
			}
              
        </script>
	   	
	</body>
	<footer>
		<%@include file="/footer1.jsp" %>
	</footer>
</html>