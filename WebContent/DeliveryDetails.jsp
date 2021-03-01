<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Delivery Details</title>		
		
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<!-- Bootstrap CSS CDN -->
     	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    	
    	<!-- Custom CSS -->
    	<link rel = "stylesheet" type = "text/css" href = "css/login.css">
    	<link rel = "stylesheet" type = "text/css" href = "css/delivery.css">
    	
    	<!-- Java Script -->
    	<script type="text/javascript" src = "JS/delivery.js" async></script>
				
	</head>
	
	<header>
		<%@include file="header.jsp" %>
	</header>
	
	<body>
		<br><br><br>
		
		<div class ="container-sm">
			<div class = "card border-dark mb-3 text-black special-card" >
				<div class = "card-body">					
					<div class="card text-white bg-dark mb-3 card-header text-center">Delivery Details</div>
					
					<form name ="deliveryDetails" method="post" action="insertCusDelDetails">
						
						<br>
						<div class="form-group">
					 		<label>Delivery Type</label>
							<select class="form-control" name="dtype">
								<%
						      	try{ 		
						      		String Query= "select * from deliverytype";
						      		
						      		Class.forName("com.mysql.jdbc.Driver").newInstance();
						      		Connection conn =DriverManager.getConnection( "jdbc:mysql://localhost:3306/udssuper","root","M@ng@th@9093");
						      		Statement stm = conn.createStatement();
						      		ResultSet rs = stm.executeQuery(Query);
						      		
						      		while(rs.next()){
						      			
						      			%> 
						      			<option value="<%=rs.getString("typeName")%>"><%=rs.getString("typeName") %></option>
						      			<%
						      		}
						      	}catch(Exception ex){
						      		ex.printStackTrace();
						      		out.println("Error" + ex.getMessage());
						      	}
						      	
						     %>
						      	
			      			</select>
			      			
			      			
			      			
					 	</div>
						
		      			<!-- <div class="form-group">
			      			<label>Delivery Charges</label>
			      			<input class="form-control" type ="text" name="charges">
		      			</div> -->
		      			
		      			<div class="form-check"> 
						 	<input class="form-check-input" type="checkbox" id="addressCheck" onclick="EnableDisableTextBox(this)">
							<label class="form-check-label" for="defaultCheck1">
							 	My Delivery address is different than the Billing address
							</label> 
						</div>
						
						<br>
		      			
		      			<div class="form-group">
			      			<label>Delivery Address</label>
			      			<textarea class="form-control" rows="2" id="address" name ="address" disabled="disabled"> 	</textarea>
		      			</div>
		      			
		      			
		      			<div class="form-group text-center">
		      				<label> *Delivery charges may vary according to the distance</label>
		      			</div>
		      		
		      			<!-- <h4 class="card-price text-center">Order Total &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Rs 540.00</h4> -->
		      			
		      			<div class="text-center">
		      				<button type="submit" class="btn btn-success">Place Order</button>
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