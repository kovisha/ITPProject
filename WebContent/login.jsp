<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous"> 
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/user.css">
    
     <!-- Javascripts -->
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>
    <script src="js/validations.js"></script>
    

    
</head>
<body>

	<div>
        <div id="content">

        	<div id="topBar">
            
			<nav class="navbar navbar-expand navbar-dark lighten-1" style="background-color: #cf0000;font-family:Georgia;">
		  	<img src="images/UDS_5.png" width="90px" style="float: left ; margin-left: 50%">
        	</nav>
        	</div>
        </div>
       </div>
    </header>
            

    <div class="main">

        <div class="container" style="box-shadow: 5px 5px 5px grey;">
         <!-- Form Start -->
            <form method="POST" action="customerLogin" class="appointment-form" id="appointment-form" onsubmit="return signinValidate()">
                <h2>Login Here</h2>
                <div class="form-group-1">
                
                    <input type="text" name="uname" id="title" placeholder="User Name" required />
                    
                    <input type="password" name="password" id="name" placeholder="Password" required />
                    
                     <!-- Show Password -->
                    <span style=" position: absolute; color: #7a797e; right:30%; transform: translate(0,-50%); top: 42%; cursor: pointer;">
				        <i class="fa fa-eye" id="eye" onclick="toggle()"> </i>
				    </span>
				    
				     <!-- Script for show password -->
				    <script>
					    var state= false;
					    function toggle(){
					        if(state){
					    	document.getElementById("name").setAttribute("type","password");
					    	document.getElementById("eye").style.color='#7a797e';
					    	state = false;
					         }
					         else{
					    	document.getElementById("name").setAttribute("type","text");
					    	document.getElementById("eye").style.color='green';
					    	state = true;
					         }
					    }
				    </script>
                    
                <div class="form-submit">
                    <input type="submit" name="submit" id="submit" class="submit" value="Sign In" />
                </div>
                
                 
	            <div class="foot-lnk">
	                <a href="forgotPassword.jsp">Forgot Password?</a>
	            </div>
	            
	            <br>
	            <center><label style="color:#000000;">Not A Member?</label></center>
	            <div class="foot-lnk">
	                <a href="Register.jsp">Sign Up</a>
	            </div>
            </form>
             <!-- End of Form -->
             
        </div>

    </div>

    <!-- Java Scripts -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/main.js"></script>

</body>
</html>