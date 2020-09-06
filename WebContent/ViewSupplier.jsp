<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="supplier" method="post">
<center><input type="submit"  value="Click here to view the event details" ></center>
</form>



<table cellpadding="5" cellspacing="5" border="5">

<tr>
<td><b>SupplierId</b></td>
<td><b>Supplier-Name</b></td>
<td><b>Status</b></td>
<td><b>Address</b></td>
<td><b>Email</b></td>
<td><b>Phone1</b></td> 
<td><b>Phone2</b></td> 
<td><b>Description</b></td>
 <td><b>Update</b></td> 
 <td><b>Delete</b></td> 
</tr>

 	<c:forEach var="supplier" items="${supplierDetails}">  

 		<c:set var="supplierID" value="${supplier.supplierID}"/> 
  		<c:set var="name" value="${supplier.name}"/> 
  		<c:set var="status" value="${supplier.status}"/> 
  		<c:set var="address" value="${supplier.address}"/> 
  		<c:set var="email" value="${supplier.email}"/> 
  		<c:set var="phone1" value="${supplier.phone1}"/>   
   		<c:set var="phone2" value="${supplier.phone2}"/>  
 		<c:set var="description" value="${supplier.description}"/> 

<tr>
<td>${supplier.supplierID}</td>
<td>${supplier.name}</td>
<td>${supplier.status}</td>
<td>${supplier.address}</td>
<td>${supplier.email}</td>
 <td>${supplier.phone1}</td> 
 <td>${supplier.phone2}</td> 
<td>${supplier.description}</td>

<td>
	 <c:url value="SupplierUpdate.jsp" var="supplierupdate"> 
 		<c:param name="supplierID" value="${supplierID}"/> 
 		<c:param name="name" value="${name}"/> 
 		<c:param name="status" value="${status}"/>
 		<c:param name="address" value="${address}"/> 
 		<c:param name="email" value="${email}"/> 
  		<c:param name="phone1" value="${phone1}"/>  
 		<c:param name="phone2" value="${phone2}"/>  
 		<c:param name="description" value="${description}"/> 
 	</c:url> 
	
	
	
	<a href="${supplierupdate}">
	<input type="button" name="updatesupplier" value="Update">
	</a></td>
	
	<td> 
 	<c:url value="SupplierDelete.jsp" var="supplierdelete"> 
 		<c:param name="supplierID" value="${supplierID}"/> 
		<c:param name="name" value="${name}"/> 
  		<c:param name="status" value="${status}"/> 
 	</c:url> 
	
	<a href="${supplierdelete}">
	<input type="button" name="deletesupplier" value="Delete">
	</a></td>
	


	</c:forEach><br>
</table><br><br>

</body>
</html>