<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     <%@include file="/header.jsp" %>
     
<!DOCTYPE html>
<html>

<head>

	<title>User Profile</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- styling user profile -->
	 <link rel = "stylesheet" type = "text/css" href = "css/login.css"> 
	
</head>

<body >
<img src = "images/bgg.jpg" class = "pic">

<br></br>
<!-- The content of your page would go here. -->

	<div class="login-wrap">
		<div class="login-html">
			<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label
				for="tab-1" class="tab">User Profile</label>
			<!-- retrieve data -->
			<div class="login-form" >
			
				<!-- name of user class is used -->
				<c:forEach var="cust" items="${UserDetail}">
				
				<c:set var="iD" value="${cust.iD}" />
				
				<c:set var="userID" value="${cust.userID}" />
				<h4 style="color:#6a6f8c;margin-bottom:15px;font:600 16px/18px 'Open Sans',sans-serif;">User ID : ${cust.userID}</h4>

				<c:set var="uName" value="${cust.uName}" />
				<h4 style="color:#6a6f8c;margin-bottom:15px;font:600 16px/18px 'Open Sans',sans-serif;">User Name : ${cust.uName}</h4>

				<hr color="#57b846">
				
				<c:set var="fName" value="${cust.fName}" />
                <h4 style="color:#6a6f8c;margin-bottom:15px;font:600 16px/18px 'Open Sans',sans-serif;"><!--${name}-->First Name : ${fName}</h4>
                
                <c:set var="lName" value="${cust.lName}" />
				<h4 style="color:#6a6f8c;margin-bottom:15px;font:600 16px/18px 'Open Sans',sans-serif;"><!--${name}-->Last Name : ${lName}</h4>

				<c:set var="dob" value="${cust.dob}" />
                <h4 style="color:#6a6f8c;margin-bottom:15px;font:600 16px/18px 'Open Sans',sans-serif;"><!--${name}-->Date Of Birth : ${dob}</h4>
                
                <c:set var="anniversary" value="${cust.anniversary}" />
                <h4 style="color:#6a6f8c;margin-bottom:15px;font:600 16px/18px 'Open Sans',sans-serif;"><!--${name}-->Anniversary : ${anniversary}</h4>
                
                <c:set var="occupation" value="${cust.occupation}" />
				<h4 style="color:#6a6f8c;margin-bottom:15px;font:600 16px/18px 'Open Sans',sans-serif;"><!--${name}-->Occupation : ${occupation}</h4>

				<hr color="#57b846">
				
				<c:set var="email" value="${cust.email}" />
                <h4 style="color:#6a6f8c;margin-bottom:15px;font:600 16px/18px 'Open Sans',sans-serif;"><!--${email}-->Email : ${email}</h4>
                
                <c:set var="address" value="${cust.address}" />
				<h4 style="color:#6a6f8c;margin-bottom:15px;font:600 16px/18px 'Open Sans',sans-serif;"><!--${name}-->Address : ${address}</h4>

				<c:set var="phone" value="${cust.phone}" />
				<h4 style="color:#6a6f8c;margin-bottom:15px;font:600 16px/18px 'Open Sans',sans-serif;"><!--${phone}-->Contact Number : ${phone}</h4>
				
				<hr color="#57b846">
                
                <c:set var="loyaltyCardNo" value="${cust.loyaltyCardNo}" />
				<h4 style="color:#6a6f8c;margin-bottom:15px;font:600 16px/18px 'Open Sans',sans-serif;"><!--${phone}-->Loyalty Card Number : ${loyaltyCardNo}</h4>

				<c:set var="loyaltyExpiry" value="${cust.loyaltyExpiry}" />
				<h4 style="color:#6a6f8c;margin-bottom:15px;font:600 16px/18px 'Open Sans',sans-serif;"><!--${phone}-->Loyalty Expiry Date : ${loyaltyExpiry}</h4>

				<c:set var="loyaltyPoints" value="${cust.loyaltyPoints}" />
				<h4 style="color:#6a6f8c;margin-bottom:15px;font:600 16px/18px 'Open Sans',sans-serif;"><!--${phone}-->Loyalty Points : ${loyaltyPoints}</h4>

</c:forEach>
		
				
				<br>
			
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


				<div class="group">
					<a href="${cusUpdate}"><button name="edit" class="button"
							value="Submit">Edit My Details</button></a>
				</div>

				<div class="group">
					<a href="changePassword.jsp"><button name="edit" class="button"
							value="Submit">Change password</button></a>
                </div>
                
                <div class="group">
					<a href="${cusupdate}"><button name="edit" class="button"
							value="Submit">View Order Information</button></a>
                </div>
                
                <div class="group">
					<a href="${cusupdate}"><button name="edit" class="button"
							value="Submit">View Payment Information</button></a>
				</div>
				<div class="hr"></div>



			</div>
		</div>
	</div>




<br><br><br>
<%@ include file = "/footer.jsp" %> 
</body>

 




</html>