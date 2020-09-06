<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="/header.jsp" %>
<!DOCTYPE html>
<html>
<head>

		
		<meta charset="ISO-8859-1">
		<title>Login | Register</title>

		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<!-- styling login and sign up form -->
		<link rel = "stylesheet" type = "text/css" href = "css/login.css">
		<link rel = "stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel = "stylesheet" href ="css/userHeaderFooter.css">
		<!--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">  -->
		
		<!--Javascript-->
		<!-- <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
 		<script src="js/validate.js"></script> -->
 		
 		<!-- validating form fields -->
		<!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>-->
		<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script> -->
		<!-- <script src="js/validate.js"></script> -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>



<body>

<img src = "images/bgg.jpg" class = "pic">

<br></br>
<!-- The content of your page would go here. -->

<div class="login-wrap">
<div class="login-html">
    <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Sign In</label>
    <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Sign Up</label>
    <div class="login-form">
        <div class="sign-in-htm">
        <form name = "signINform" method = "post" action = "loginServlet" onsubmit="return signinValidate()">
           
            <div class="group">
                <label for="user" class="label">User Name</label>
                <input id="user" type="text" class="input" name = "uname" required >
            </div>
            
            <div class="group">
                <label for="pass" class="label">Password</label>
                <input id="pwd" type="password" class="input" data-type="password" name = "password" required>
            </div> 
            
            <div class="group">
                <input id="check" type="checkbox" class="check" >
                <label for="check"><span class="icon"></span> Keep me Signed in</label>
            </div>
            
            <div class="group">
                <input type="submit" class="button" value="Sign In">
            </div>
            
            <div class="hr"></div>
            <div class="foot-lnk">
                <a href="#">Forgot Password?</a>
            </div>
            </form>
        </div>
        
        
        
            <div class="sign-up-htm">
                <form name="signUPform" method="post" action="registerServlet" onsubmit="return validation()">
                    <div class="group">
                        <label for="pass" class="label">First Name</label> <input id="pass"
                            type="text" class="input" name="fname" onblur="onlyletter()" required>
                    </div>

                    <div class="group">
                        <label for="pass" class="label">Last Name</label> <input id="pass"
                            type="text" class="input" name="lname" onblur="onlyletter1()" required>
                    </div>
                    
                    <div class="group">
                        <label for="pass" class="label">User Name</label> <input id="pass"
                            type="text" class="input" name="uname" required>
                    </div>
                    <div class="group">
                        <label for="pass" class="label">Email Address</label> <input
                            id="pass" type="text" class="input" name="email" required>
                    </div>

                    <div class="group">
                        <label for="pass" class="label">Address</label> <textarea
                            id="pass" type="text" class="input" name="address" required></textarea>
                    </div>

                    <div class="group">
                        <label for="pass" class="label">Contact Number</label> <input
                            id="pass" type="text" class="input" name="phone" onblur="phoneNumber()" required>
                    </div>

                    <div class="group">
                        <label for="pass" class="label">Date Of Birth</label> <input
                            id="pass" type="date" class="input" name="dob" data-language='en' data-date-format="yyyy M dd" >
                    </div>

                    <div class="group">
                        <label for="pass" class="label">Anniversary Date</label> <input
                            id="pass" type="date" class="input" name="doa" data-language='en' data-date-format="yyyy M dd" >
                    </div>

                    <div class="group">
                        <label for="pass" class="label">Occupation</label> <input
                            id="pass" type="text" class="input" name="job" >
                    </div>

                    <div class="group">
                        <label for="pass" class="label">Password</label> <input
                            id="txtPassword" type="password" class="input"
                            data-type="password" name="pass" onblur = "CheckPassword()" required>
                    </div>
                    <div class="group">
                        <label for="pass" class="label">Repeat Password</label> <input
                            id="txtConfirmPassword" type="password" class="input"
                            data-type="password" name="conpass" required>
                    </div>


                    <div class="group">
                        <input type="submit" class="button" value="Sign Up"
                            id="btnSubmit">
                    </div>
                    <div class="group">
                        <input type="submit" class="button2" value="CANCEL"
                            id="btnSubmit">
                    </div>
                    <div class="hr"></div>
                    
                </form>
            </div>
        </div>
</div>
</div>
<br><br><br>
<%@ include file = "/footer.jsp" %> 

</body>
</html>