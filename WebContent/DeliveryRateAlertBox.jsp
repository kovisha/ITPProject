<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     
     
<!DOCTYPE html>
<html>

<head>

	<title>RATE DELIVERY</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- Bootstrap CSS CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
	<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	 -->
    <!-- Our Custom CSS -->
    <link rel="stylesheet" href="css/UserProfile.css">
    
    <!-- Font Awesome JS -->
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
	
</head>

<header>
	<%@include file="header.jsp" %>
</header>


<body style="background-color: #d9d9d9;">

<%
	String userImage = (String)session.getAttribute("UserImage");
%>

					
					<%String qOut=(String)session.getAttribute("result");%>
					<%if(qOut.equals("successInsertdeliveryRating")){ %>
						<script>
							Swal.fire({
								title: 'Thank You for your Feedback!!!',
								icon: 'success',
							}).then(function() {
								window.location = "UserProfileDeliverDetails.jsp";
								});
						</script>
					<%} %>
					<%if(qOut.equals("failedInsertdeliveryRating")){ %>
						<script>
							Swal.fire({
								title: 'We ran into a Problem!!!!!!',
								icon: 'error',
							}).then(function() {
								window.location = "UserProfileDeliverDetails.jsp";
								});
						</script>
					<%} %>


			 <!--Side Bar start-->  
      <nav id="sidebar" style="min-height:117%;">
        <!--Side Bar header start-->  
          <div class="sidebar-header">
                <h3>               
                <div class="profile clearfix" style="align-content: center">

                <div class="profile_info">
                </div>
                </div>
                </h3>
                
   				<!-- Image display -->
                <strong><img src="data:image/jpg;base64,<%=userImage%>" alt="..."  class="rounded-circle" width="100px" height="100px" ></strong>
                 
           </div>
        <!--Side Bar header end-->
            <!-- Main start list unstyled componenets -->
            <ul class="list-unstyled components">
                

                <li>
                    <a href="UserProfile" style="text-decoration: none; color:white;">
                        <!-- Font awsome icons -->
                        <i class="fas fa-eye"></i>
                       My Profile
                    </a>
                </li>
                <li>
                    <a href="changePassword.jsp" style="text-decoration: none; color:white;">
                        <!-- Font awsome icons -->
                       <i class="fas fa-key"></i>
                      Change password
                    </a>
                </li>
                <li>
                    <!--Major A has no drop downs-->
                    <!--Link to page Major A-->
                    <a href="viewLoyalty" style="text-decoration: none; color:white;">
                        <!-- Font awesome icons -->
                        <i class="fas fa-eye"></i>
                       Loyalty Details
                    </a>
                </li>
                <li>
                    <!--Major A has no drop downs-->
                    <!--Link to page Major A-->
                    <a href="" style="text-decoration: none; color:white;">
                        <!-- Font awesome icons -->
                        <i class="fas fa-shopping-cart"></i>
                       Order Details
                    </a>
                </li>
                <li>
                    <!--Major A has no drop downs-->
                    <!--Link to page Major A-->
                    <a href="" style="text-decoration: none; color:white;">
                        <!-- Font awesome icons -->
                        <i class="fas fa-credit-card" ></i>
                       Payment Details
                    </a>
                </li>
                <li>
                    <!--Major A has no drop downs-->
                    <!--Link to page Major A-->
                    <a href="UserProfileDeliveryDetails" style="text-decoration: none; color:white;">
                        <!-- Font awesome icons -->
                        <i class="fas fa-truck"></i>
                       Delivery Details
                    </a>
                </li>
                
                

            </ul>
            <!-- End list unstyled componenents -->


            
        </nav>
        
        
        
        

<div id="bottomContent" style="background:#d9d9d9;">
	<div class = "container">
	

		
	  
	    <div class ="container-sm">
			<div class = "card border-dark mb-3 text-black special-card" >
				<div class = "card-body">					
					<div class="card text-white bg-dark mb-3 card-header text-center">We appreciate your Suggestions !!!</div>
					
					
					<form name ="RateDelivery" method="post" action="DelRatingInsert">
						
						
						<!-- Rating -->
						<div class="form-group">
					 		<label>How is our delivery ??</label>
							<select class="form-control" name="drate" id="drate">
								<option value = "5">Excellent</option>
						     	<option value = "4">Good</option>
						      	<option value = "3">Ok</option>
						      	<option value = "2">Poor</option>
						      	<option value = "1">Very Poor</option>
			      			</select>
					 	</div>
						
		      			
		      			<div class="form-group">
			      			<label>Suggestions</label>
			      			<textarea class="form-control" rows="2" id="sugg" name ="sugg"></textarea>
		      			</div>
		      			
		      			<div class="form-group">
			      			<label>Complaints</label>
			      			<textarea class="form-control" rows="2" id="comp" name ="comp"></textarea>
		      			</div>
		      					      		
		      			<h4 class="card-price text-center">Thank you for Shopping with us !!!</h4>
		      			
		      			<div class="text-center">
		      				<button type="submit" class="btn btn-success">Submit</button>
						</div>
						
						
					</form>
					
				</div>
			</div>
		</div>		
	

	</div>

    </div>
	</div>
	
	</div>
	</div>
</div>

<br><br></br></br></br></br><br><br>

</body>

<footer>
	<%@ include file = "footer.jsp" %> 
</footer>

<!-- jQuery CDN - Slim version (=without AJAX) -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <!-- Popper.JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            $('#sidebarCollapse').on('click', function () {
                $('#sidebar').toggleClass('active');
            });
        });

</script>

<script type="text/javascript">
        $(document).ready(function () {
            $('#sidebarCollapse').on('click', function () {
                $('#sidebar').toggleClass('active');
            });
        });
    </script>
    
    

</html>