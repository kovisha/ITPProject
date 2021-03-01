<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Register</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous"> 
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/user.css">
    
    <!-- Scripts -->
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

        <div class="container"></br>
        
        <!-- Autofill -->
        <a href="#" class="btn btn-green" onClick="autoFill(); return true;" style="background-color:green; margin-top:5%; margin-left:10%; text-decoration:none; color:#fff; font-size:15px;">Demo</a>         
         <!-- Form Start -->
            <form method="POST" action="customerRegister" class="appointment-form" name="signUPform" id="appointment-form" enctype="multipart/form-data" onsubmit="return validation()">
                <h2>Enter Your Details To Register</h2>
                <div class="form-group-1">
                <div>
	                <div class = "left">
	                    <input type="text" name="fname" onblur="onlyletter()" id="fname" placeholder="First Name" required />
	                </div>
	                <div class="right">
	                    <input type="text" name="lname" onblur="onlyletter()" id="lname" placeholder="Last Name" required />
	                </div>
                 </div>
                 	
                 <div>
                	<div class = "left"> 	
                    	<input type="text" name="uname" id="uname" placeholder="Username" required />
                    </div>
                	<div class="right">
                    	<input type="text" name="email" onblur="checkMail()" id="email" placeholder="Email" required />
                    </div>
                </div>
                	
                <div>
                	<div class = "left">    
                    	<input type="text" name="address" id="address" placeholder="Address" required />
                    </div>
                	<div class="right">
                    	<input type="text" name="phone" onblur="phoneNumber()" id="phone" placeholder="Contact Number" required />
                    </div>
                </div>
                
                <input type="text" name="job" id="job" placeholder="Occupation" required />
                
                 <div>
                	<div class = "left">
                	<label style="color:#222;">Date Of Birth</label>
                    	<input type="date" name="dob" id="dob" placeholder="Date Of Birth" required />
                    	 </div>
                	<div class="right">
                	<label style="color:#222;">Date Of Anniversary</label>
                    	<input type="date" name="doa" id="doa" placeholder="Anniversary" required />
                    </div>
                </div>
                     
                		<label style="color:#222;" for="userImage">Choose A Profile Picture</label>
                		<input type="file" name="userImage" id="userImage">
                    	
                <div>
                	<div class = "left"> 
                    <input type="password" name="pass" onblur = "CheckPassword()" id="name" placeholder="Password" required />
                    
                     <span style=" position: absolute; color: #7a797e; right:51%; transform: translate(0,-50%); top: 67%; cursor: pointer;">
				        <i class="fa fa-eye" id="eye" onclick="toggle()">
				        </i>
				    </span>
                    </div>
                	<div class="right">
                    <input type="password" name="conpass" id="name1" placeholder="Repeat Password" required />
                    <!-- Show Password -->
                    <span style=" position: absolute; color: #7a797e; right:30%; transform: translate(0,-50%); top: 67%; cursor: pointer;">
				        <i class="fa fa-eye" id="eye1" onclick="toggle1()">
				        </i>
				    </span>
                    </div>
                    
                   
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
				    
				    <script>
					    var state= false;
					    function toggle1(){
					        if(state){
					    	document.getElementById("name1").setAttribute("type","password");
					    	document.getElementById("eye1").style.color='#7a797e';
					    	state = false;
					         }
					         else{
					    	document.getElementById("name1").setAttribute("type","text");
					    	document.getElementById("eye1").style.color='green';
					    	state = true;
					         }
					    }
				    </script>
				    <!-- End of Script for show password -->
				   
				    
                </div>
                    
                    
                    
                <div class="form-submit">
                    <input type="submit" name="submit" id="submit" class="submit" value="Sign Up" />
                </div>
               
            </form>
            
            <div class="form-submit">
           		 <a href="Home.jsp">
                    <input type="submit" name="submit" id="submit" class="submit" value="Cancel" style="background:#d50015;"/>
                  </a>  
             </div>
        </div>
        

    </div>

    <!-- JS -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/main.js"></script>
    
    <!-- Script for autofill -->
    <script type="text/javascript">
  			function autoFill() {
    			document.getElementById('fname').value = "Mark";
    			document.getElementById('lname').value = "Avon";
    			document.getElementById('uname').value = "avon_mark";
    			document.getElementById('email').value = "mark.a@gmail.com";
    			document.getElementById('address').value = "45, Barnes Place, Kandy";
    			document.getElementById('phone').value = "0771478931";
    			document.getElementById('dob').value = "1990-05-06";
    			document.getElementById('doa').value = "2011-09-16";
    			document.getElementById('job').value = "System Analyst";
    			document.getElementById('name').value = "avon123";
    			document.getElementById('name1').value = "avon123";
 
				
  			}
  			
	</script>

</body>
</html>