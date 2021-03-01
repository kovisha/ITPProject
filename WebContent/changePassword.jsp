<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@include file="/header.jsp" %>
     
<!DOCTYPE html>
<html>

<head>

	<title>UDS SUPER ONLINE DELIVERY</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- Bootstrap CSS CDN -->
     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
	
    <!-- Our Custom CSS -->
    <link rel="stylesheet" href="css/UserProfile.css">
    
    <!-- Font Awesome JS -->
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>
	
</head>

<body style="background-color: #d9d9d9;">

<%
	String userImage = (String)session.getAttribute("UserImage");
%>
			 <!--Side Bar start-->  
      <nav id="sidebar" style="min-height:93.8%;">
        <!--Side Bar header start-->  
          <div class="sidebar-header">
                <h3>               
                <div class="profile clearfix" style="align-content: center">

                <div class="profile_info">
                </div>
                </div>
                </h3>
                <!-- Image Display -->
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
                        <!-- Font awsome icons -->
                        <i class="fas fa-eye"></i>
                       Loyalty Details
                    </a>
                </li>
                <li>
                    <!--Major A has no drop downs-->
                    <!--Link to page Major A-->
                    <a href="" style="text-decoration: none; color:white;">
                        <!-- Font awsome icons -->
                        <i class="fas fa-shopping-cart"></i>
                       Order Details
                    </a>
                </li>
                <li>
                    <!--Major A has no drop downs-->
                    <!--Link to page Major A-->
                    <a href="" style="text-decoration: none; color:white;">
                        <!-- Font awsome icons -->
                        <i class="fas fa-credit-card" ></i>
                       Payment Details
                    </a>
                </li>
                <li>
                    <!--Major A has no drop downs-->
                    <!--Link to page Major A-->
                    <a href="" style="text-decoration: none; color:white;">
                        <!-- Font awsome icons -->
                        <i class="fas fa-truck"></i>
                       Delivery Details
                    </a>
                </li>
                
                
                

            </ul>
            <!-- End list unstyled componenents -->


            
        </nav>


		
	<div id="bottomContent" style="background:#d9d9d9;">
	<div class = "container">
	
			 <div class="formMain">

	        <div class="formContainer">
	        <!-- form start -->
	        <a href="#" class="btn btn-green" onClick="autoFill(); return true;" style="background-color:green; margin-top:5%; margin-left:10%; text-decoration:none; color:#fff; font-size:15px;">Demo</a>
	            <form method="POST" action="changePassword" class="appointment-form" id="appointment-form">
	                <h2>Change Your Password</h2></br>
	                
	                <div class="form-group-1">
	                    <input type="password" name="pass" id="pass" placeholder="Current password" required /></br>
	                    <span style=" position: absolute; color: #7a797e; right:29%; transform: translate(0,-50%); top: 33%; cursor: pointer;">
				        <i class="fa fa-eye" id="eye" onclick="toggle()">
				        </i>
				    	</span>
				    	
	                    <input type="password" name="npass" id="npass" placeholder="New Password" required /></br>
	                     <!-- Show Password -->
	                    <span style=" position: absolute; color: #7a797e; right:29%; transform: translate(0,-50%); top: 46%; cursor: pointer;">
				        <i class="fa fa-eye" id="eye1" onclick="toggle1()">
				        </i>
				    	</span>
				    	
	                    <input type="password" name="renpass" id="renpass" placeholder="Confirm New Password" required /></br>
	                     <span style=" position: absolute; color: #7a797e; right:29%; transform: translate(0,-50%); top: 59%; cursor: pointer;">
				        <i class="fa fa-eye" id="eye2" onclick="toggle2()">
				        </i>
				    	</span>
				    	
				    	 <!-- Script for show password -->
				    	<script>
					    var state= false;
					    function toggle(){
					        if(state){
					    	document.getElementById("pass").setAttribute("type","password");
					    	document.getElementById("eye").style.color='#7a797e';
					    	state = false;
					         }
					         else{
					    	document.getElementById("pass").setAttribute("type","text");
					    	document.getElementById("eye").style.color='green';
					    	state = true;
					         }
					    }
				    </script>
				    
				    <script>
					    var state= false;
					    function toggle1(){
					        if(state){
					    	document.getElementById("npass").setAttribute("type","password");
					    	document.getElementById("eye1").style.color='#7a797e';
					    	state = false;
					         }
					         else{
					    	document.getElementById("npass").setAttribute("type","password");
					    	document.getElementById("eye1").style.color='green';
					    	state = true;
					         }
					    }
				    </script>
				    
				    <script>
					    var state= false;
					    function toggle2(){
					        if(state){
					    	document.getElementById("renpass").setAttribute("type","password");
					    	document.getElementById("eye2").style.color='#7a797e';
					    	state = false;
					         }
					         else{
					    	document.getElementById("renpass").setAttribute("type","password");
					    	document.getElementById("eye2").style.color='green';
					    	state = true;
					         }
					    }
				    </script>
				     <!-- End of script for show password -->
	                    </div></br>
	                <div class="form-submit">
	                    <input type="submit" name="submit" id="submit" class="submit" value="Change Password" />
	                </div>
	                 
	            </form>
	            
	        </div>
	
	    </div>


</div>

        </div>
</div>

         <!-- Page Content  End-->
			
			<!-- passing the values for user update -->
				<c:url value="updateUserProfile.jsp" var="cusUpdate">
					<c:param name="userID" value="${userID}" />
					<c:param name="uName" value="${uName}" />
					<c:param name="fName" value="${fName}" />
					<c:param name="lName" value="${lName}" />
					<c:param name="dob" value="${dob}" />
					<c:param name="anniversary" value="${anniversary}" />
					<c:param name="occupation" value="${occupation}" />
					<c:param name="email" value="${email}" />
					<c:param name="address" value="${address}" />
					<c:param name="phone" value="${phone}" />
					<c:param name="loyaltyCardNo" value="${loyaltyCardNo}" />
					<c:param name="loyaltyExpiry" value="${loyaltyExpiry}" />
					<c:param name="loyaltyPoints" value="${loyaltyPoints}" />

				</c:url>

			</div>
		</div>
	</div>




<br><br></br></br></br>
 
</body>
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
  			function autoFill() {
    			document.getElementById('pass').value = "krystu123";
    			document.getElementById('npass').value = "krystu123";
    			document.getElementById('renpass').value = "krystu123";
 
				
  			}
  			
	</script>

<%@ include file = "/footer.jsp" %>
</html>