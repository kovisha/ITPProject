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
    
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>
    
    

    <link rel="stylesheet" href="css/user.css">
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

        <div class="container">
        <a href="#" class="btn btn-green" onClick="autoFill(); return true;" style="background-color:green; margin-top:5%; margin-left:10%; text-decoration:none; color:#fff; font-size:15px;">Demo</a>
            <form method="POST" action="resetPassword" class="appointment-form" id="appointment-form">
                <h2>Reset Your Password</h2>
                <div class="form-group-1">
                    <input type="text" name="email" id="email" placeholder="Email" required />
                    <input type="password" name="npass" id="npass" placeholder="New Password" required />
                    
                <div class="form-submit">
                    <input type="submit" name="submit" id="submit" class="submit" value="Reset Password" />
                </div>
                 
            </form>
            
        </div>

    </div>

    <!-- JS -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/main.js"></script>
        <script type="text/javascript">
  			function autoFill() {
    			document.getElementById('email').value = "amila.c@gmail.com";
    			document.getElementById('npass').value = "amila123";
 
				
  			}
  			
	</script>

</body>
</html>