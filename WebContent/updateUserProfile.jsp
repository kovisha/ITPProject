<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Update</title>

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

<%
	String userID = request.getParameter("userID");
	String uName =  request.getParameter("uName");
	String fName = request.getParameter("fName");
	String lName = request.getParameter("lName");
	String dob = request.getParameter("dob");
	String anniversary = request.getParameter("anniversary");
	String occupation = request.getParameter("occupation");
	String email = request.getParameter("email");
	String address = request.getParameter("address");
	String phone = request.getParameter("phone");
	
%>

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
            <form method="POST" action="UpdateUserProfile" class="appointment-form" id="appointment-form">
                <h2>Update Here</h2>
                <div class="form-group-1">
                
                <div>
	                <div class="left">
	                <label style="color:#737373;">User ID</label>
	                    <input type="text" name="userID" value="<%=userID%>" onblur="onlyletter()" id="title" placeholder="Last Name" readonly />
	                </div>
                	 <div class = "right">
                	<label style="color:#737373;">User Name</label>
	                <input type="text" name="uname" value="<%=uName%>" onblur="onlyletter()" id="title" readonly/>
	                </div>
                 </div>
                
                <div>
	                <div class = "left">
	                <label style="color:#737373;">First Name</label>
	                    <input type="text" name="fname" value="<%=fName%>" onblur="onlyletter()" id="title" required/>
	                </div>
	                <div class="right">
	                <label style="color:#737373;">Last Name</label>
	                    <input type="text" name="lname" value="<%=lName%>" onblur="onlyletter()" id="title" placeholder="Last Name" required />
	                </div>
                 </div>
                 
                 <div>
	                <div class = "left">
	               	 <label style="color:#737373;">Email</label>
	                    <input type="text" name="email" value="<%=email%>" onblur="checkMail()" id="title" placeholder="Email" required />
	                </div>
	                <div class="right">
	                	<label style="color:#737373;">Address</label>
	                	<input type="text" name="address" value="<%=address%>" id="title" placeholder="Address" required />
	                </div>
                 </div>
                
                <div>
                	<div class = "left">
                	<label style="color:#737373;">Occupation</label>
	                    <input type="text" name="job" value="<%=occupation%>" id="title" placeholder="Occupation" required />
                    </div>
                	<div class="right">
                	<label style="color:#737373;">Contact Number</label>
                    	<input type="text" name="phone" value="<%=phone%>" onblur="phoneNumber()" id="title" placeholder="Contact Number" required />
                    </div>
                </div><br>
                
                
                
                
                 <div>
                	<div class = "left">
                	<label style="color:#737373;">Date Of Birth</label>
                    	<input type="date" name="dob" value="<%=dob%>" id="title" placeholder="Date Of Birth" required />
                    	 </div>
                	<div class="right">
                	<label style="color:#737373;">Date Of Anniversary</label>
                    	<input type="date" name="doa" value="<%=anniversary%>" id="title" placeholder="Anniversary" required />
                    </div>
                </div>
                     
                		<label style="color:#737373;" for="userImage">Choose A Profile Picture</label>
                		<input type="file" name="userImage" id="userImage">
                    	
                <div>
                    <input type="password" name="pass" onblur = "CheckPassword()" id="name" placeholder="Enter Password To Confirm its You" required />
                	   <span style=" position: absolute; color: #7a797e; right:30%; transform: translate(0,-50%); top: 69%; cursor: pointer;">
				        <i class="fa fa-eye" id="eye" onclick="toggle()">
				        </i>
				    </span>
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
                </div>
                    
                    
                    
                <div class="form-submit">
                    <input type="submit" name="submit" id="submit" class="submit" value="Update" />
                </div>
               
            </form>
            
            <div class="form-submit">
           		 <a href="Home.jsp" style="text-decoration: none;">
                    <input type="submit" name="submit" id="submit" class="submit" value="Cancel" style="background:#d50015;"/>
                  </a>  
             </div>
        </div>
        

    </div>

    <!-- JS -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/main.js"></script>

</body>
</html>