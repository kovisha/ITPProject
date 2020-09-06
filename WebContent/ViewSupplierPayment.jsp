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

	<form action="supplierpayment" method="post">
		<center><input type="submit"  value="Click here to view the event details" ></center>
	</form>
	
	<table cellpadding="5" cellspacing="5" border="5">

		<tr>
		<td><b>Supplier Pay ID</b></td>
		<td><b>Stock ID</b></td>
		<td><b>Total Amount</b></td>
		<td><b>Paid Amount</b></td>
		<td><b>Last Payed Date</b></td>
		<td><b>Invoice Number</b></td>
		<td><b>Discount Type</b></td>
		<td><b>Discount Percent</b></td>
		<td><b>Pay Supplier</b></td> 
		<td><b>Delete</b></td> 
		</tr>
		
		<c:forEach var="supplierpayment" items="${supplierPaymentDetails}">  
		
		<c:set var="suppPayID" value="${supplierpayment.suppPayID}"/> 
  		<c:set var="stockid" value="${supplierpayment.stockid}"/> 
  		<c:set var="totalAmount" value="${supplierpayment.totalAmount}"/> 
  		<c:set var="paidAmount" value="${supplierpayment.paidAmount}"/> 
  		<c:set var="lastPayDate" value="${supplierpayment.lastPayDate}"/> 
  		<c:set var="invoiceNo" value="${supplierpayment.invoiceNo}"/>   
   		<c:set var="type" value="${supplierpayment.type}"/>  
 		<c:set var="discpercent" value="${supplierpayment.discpercent}"/> 
		
		
			<tr>
			<td>${supplierpayment.suppPayID}</td>
			<td>${supplierpayment.stockid}</td>
			<td>${supplierpayment.totalAmount}</td>
			<td>${supplierpayment.paidAmount}</td>
			<td>${supplierpayment.lastPayDate}</td>
			<td>${supplierpayment.invoiceNo}</td>  
			<td>${supplierpayment.type}</td>  
			<td>${supplierpayment.discpercent}</td>
	
 			<td>		 
				<c:url value="SupplierPayNowInsert.jsp" var="supplierpaynow">  
					<c:param name="suppPayID" value="${suppPayID}"/>  
 				</c:url> 
  			<a href="${supplierpaynow}"> 
			<input type="button" name="pays" value="Pay Supplier"></a></td>
			
			
			
			<td>
			<c:url value="SupplierPayNowDelete.jsp" var="supplierpaynowdelete">  
					<c:param name="suppPayID" value="${suppPayID}"/>  
					<c:param name="stockid" value="${stockid}"/>  
					<c:param name="totalAmount" value="${totalAmount}"/>  
					<c:param name="paidAmount" value="${paidAmount}"/>  
 			</c:url> 
  			<a href="${supplierpaynowdelete}"> 
			<input type="button" name="deletes" value="Delete This Payment"></a></td>	
		
		
		</c:forEach>
		
		
		</table>

</body>
</html>