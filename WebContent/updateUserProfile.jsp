<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@include file="/header.jsp" %>
     
<!DOCTYPE html>
<html>

<head>
		<meta charset="ISO-8859-1">
		<title>Update Profile</title>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		 <!-- styling the form -->
		 <link rel = "stylesheet" type = "text/css" href = "css/login.css"> 

</head>


<body>

<img src = "images/bgg.jpg" class = "pic">

<br></br>
<!-- The content of your page would go here. -->

<!-- retrieving the passed parameters to update form -->
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

<div class="login-wrap">
    <div class="login-html">
        <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label
            for="tab-1" class="tab">Update your profile</label>
        <div class="login-form">
            <form name="updateForm" method="post" action="userUpdateServlet"
                onsubmit=" validateSignUpForm()">
                
                <div class="group">
                    <label for="pass" class="label">User name</label> <input
                        id="pass" type="text" class="input" name="uname" value="<%=uName%>" readonly>
                </div>

                <div class="group">
                    <label for="pass" class="label">First Name</label> <input id="pass"
                        type="text" class="input" name="fname" value="<%=fName%>">
                </div>

                <div class="group">
                    <label for="pass" class="label">Last Name</label> <input id="pass"
                        type="text" class="input" name="lname" value="<%=lName%>">
                </div>
                
                <div class="group">
                    <label for="pass" class="label">Email Address</label> <input
                        id="pass" type="text" class="input" name="email" 
                        value="<%=email%>">
                </div>

                <div class="group">
                    <label for="pass" class="label">Address</label> <input
                        id="pass" type="text" class="input" name="address" value="<%=address%>"></input>
                </div>

                <div class="group">
                    <label for="pass" class="label">Date Of Birth</label> <input
                        id="pass" type="date" class="input" name="dob" data-language='en' data-date-format="yyyy M dd" value="<%=dob%>">
                </div>

                <div class="group">
                    <label for="pass" class="label">Anniversary Date</label> <input
                        id="pass" type="date" class="input" name="doa" data-language='en' data-date-format="yyyy M dd" value="<%=anniversary%>">
                </div>

                <div class="group">
                    <label for="pass" class="label">Occupation</label> <input
                        id="pass" type="text" class="input" name="job" value="<%=occupation%>">
                </div>
                
                <div class="group">
                    <label for="pass" class="label">Contact Number</label> <input
                        id="pass" type="text" class="input" name="phone" value="<%=phone%>">
                </div>

                <div class="group">
                    <label for="pass" class="label">Enter password to confirm its you!</label> 
                    <input id="pass" type="password" class="input"
                        name="pass">
                </div>


                <div class="group">
                    <input type="submit" class="button" value="Update My Info">
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
<br><br><br>
<%@ include file = "/footer.jsp" %> 


</body>
</html>