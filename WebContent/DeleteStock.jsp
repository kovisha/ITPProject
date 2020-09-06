<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
		String id = request.getParameter("id");
		String stockName = request.getParameter("stockname");
		//int qtyAvailable = Integer.parseInt(request.getParameter("qtyAvailable"));
		double stockSize = Double.parseDouble(request.getParameter("stockSize"));
		//int reOrderLevel =Integer.parseInt(request.getParameter("reOrderLevel"));
		int qtySupplied = Integer.parseInt(request.getParameter("qtySupplied"));
		String suppliedDate = request.getParameter("suppliedDate");
		int storeQty =Integer.parseInt(request.getParameter("storeQty"));
		String supplierName = request.getParameter("supplierName");
		String categoryName = request.getParameter("categoryName");
		
		
	%>

		<div class = "container">
		<div class = "card text-light special-card mb-3">  <!--Outer form grid -->
			<div class = "card-body">
					<form action="StockDelete" method ="post" >


<div class="form-group"> <!-- Drop downs -->
      <label for="category">CategoryName</label>
     <input type="text" class="form-control" id="categoryName"  placeholder="Name" name = "catname" value = "<%= categoryName %>" readonly>
    </div>
    
 <div class="form-group">
    <label for="stockID"> Stock ID</label>
    <input type="text" class="form-control" id="stockID"  placeholder="Name" name = "id" value = "<%= id %>" readonly>
 </div>  
 
 <div class="form-group">
    <label for="stockName"> Stock Name</label>
    <input type="text" class="form-control" id="stockName"  placeholder="Name" name = "stockName"  value = "<%= stockName %>" readonly>
 </div>
 
<!--  <div class="form-group"> -->
<!--     <label for="stockName"> Available Quantity</label> -->
<%--     <input type="text" class="form-control" id="qtyAvail"  placeholder="Name" name = "qtyAvaialable"  value = "<%= qtyAvailable %>" readonly> --%>
<!--  </div> -->
 
  <div class="form-group">
    <label for="stockSize">Stock Size</label>
    <input type="text" class="form-control" id="sSize"  placeholder="Size" name = "sSize" value = "<%= stockSize %>" readonly>
 </div>
 
<!--  <div class="form-group"> -->
<!--     <label for="stockSize">ReOrder level</label> -->
<%--     <input type="text" class="form-control" id="sSize"  placeholder="reorder" name = "reOrder" value = "<%= reOrderLevel %>" readonly> --%>
<!--  </div> -->
 
  <div class="form-group">
    <label for="supQty">Quantity Supplied</label>
    <input type="text" class="form-control" id="supQty"  placeholder="Quantitye" name = "supQty" value = "<%= qtySupplied %>" readonly>
 </div>
 
   <div class="form-group">
    <label for="supDate">Supplied Date</label>
    <input type="date" class="form-control datepicker-here" data-language = 'en' data-date-format = "yyyy M dd" id="supDate"  placeholder="SuppliedDate" name = "supDate" value = "<%= suppliedDate %>" readonly>
 </div>
 
   <div class="form-group">
    <label for="qtySent">Store Quantity</label>
    <input type="text" class="form-control" id="qtySent"  placeholder="Quantity" name = "qtySent" value = "<%= storeQty %>" readonly>
 </div>
 
   <div class="form-group">
      <label for="supName"> Supplier Name</label>
      <input type="text" class="form-control" id="supplierrName"  placeholder="Name" name = "supname" value = "<%= supplierName %>" readonly>
    </div>
    

  <div class="form-group col-md-4">  </div>
			<div class = "row">				 
					<div class = "form-group col-lg-4">
					
						<button type="submit" class="btn btn-success btn-block ">Delete Stock</button>		
					</div>
			</div>

 </form>
 </div>
 </div>
 </div>


</body>
</html>