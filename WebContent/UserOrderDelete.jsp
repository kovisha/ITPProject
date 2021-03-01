<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirm Deletion</title>
	<link rel = "stylesheet" type = "text/css" href = "css/login.css">
	<link rel="stylesheet" href="css/search_sample.css">
	 <link rel="stylesheet" href="new_sample.css">
	 
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
      
      
    
</head>
<body>

        <header>
			<%@include file="/header.jsp" %>
		</header>
		
		<img src = "images/bgg.jpg" class = "pic">
		
		
		<br><br><br><br>
		
	<%--  <c:forEach var="items" items= "${itemDetails}"> --%>
	          			<%String qOut=(String)session.getAttribute("result4");%>
					
					<%if(qOut.equals("successUserOrderDelete")){ %>
						<script>
							Swal.fire({
								title: 'Order Deleted Successfully !!!',
								icon: 'success',
							}).then(function() {
								window.location = "displayuserorders";
								});
						</script>
					<%} %>
					<%if(qOut.equals("failedUserOrderDelete")){ %>
						<script>
							Swal.fire({
								title: 'Deletetion failed',
								icon: 'error',
							}).then(function() {
								window.location = "displayuserorders";
								});
						</script>
					<%} %>
	          		 
       
    <br>
     <div class = "row">
   
         <div class="col-sm-3"> 
          </div>         
          <div class="col-sm-6"> <p class = "welcome_msg">Your Orders On Progress</p></div>
          <div class = "col-sm-3">
          </div>
   
      </div>
    
    
    
    
    <div class = "row">
    <div class = "col-sm-2"></div>
    <div class = "col-sm-8">

      <table class="table  table-striped table-hover text-center  " style="font-size: 15px;" >
       <thead>
        <tr class="table-dark">
          <th scope="col" class="col-xs-2"><p class="h4">Order ID</p></th>
          <th scope="col"class="col-xs-2"><p class="h4">Total amount</p></th>
          <th scope="col" class="col-xs-2"><p class="h4">Date</p></th>
          <th scope="col"class="col-xs-2"><p class="h4">Offer ID</p></th>
          <th scope="col"class="col-xs-2"><p class="h4"></p></th>
          
        </tr>
      </thead>
      <tbody>
       <c:forEach var="orderhis" items= "${orderHisto}">
        <tr class="table-success" style="font-weight: bold; font-size: 20px;">
          <td><p class="h4">${orderhis.orderID}</p></td>
          <td><p class="h4">RS. ${orderhis.total}</p></td>
          <td><p class="h4">${orderhis.date}</p></td>
          <td><p class="h4">${orderhis.off_id}</p></td>
          <td><h3><strong>
           <a href = "userorderDelete?&id=${orderhis.id}">
          <input  style = "width:100px; height:40px ;" type="button" class="btn btn-success btn-primary btn-block text-center" value = "Delete Order"/>
          </a>
          </strong>
           </h3></td>
          
        </tr>
       </c:forEach>
      </tbody>
      
    </table>
    
     <!-- <form action="#" method="POST"  >
        <center><button type="button" onclick = "location.href='search.jsp'" class="btn btn-success"><p style="width: 160px; font-size: 15px;">
        Continue Shopping </p></button></center>
       </form> <br> -->

    </div>
    <div class = "col-sm-2"></div></div>
    
    
     <div class = "row">
   
         <div class="col-sm-3"> 
          </div>         
          <div class="col-sm-6"> <p class = "welcome_msg">Delivered Orders</p></div>
          <div class = "col-sm-3">
          </div>
   
      </div>
      
          
    <div class = "row">
    <div class = "col-sm-2"></div>
    <div class = "col-sm-8">

      <table class="table  table-striped table-hover text-center  " style="font-size: 15px;" >
       <thead>
        <tr class="table-dark">
          <th scope="col" class="col-xs-2"><p class="h4">Order ID</p></th>
          <th scope="col"class="col-xs-2"><p class="h4">Total amount</p></th>
          <th scope="col" class="col-xs-2"><p class="h4">Date</p></th>
          <th scope="col"class="col-xs-2"><p class="h4">Offer ID</p></th>
          
          
        </tr>
      </thead>
      <tbody>
       <c:forEach var="orderhisdis" items= "${orderHistoDispatch}">
        <tr class="table-success" style="font-weight: bold; font-size: 20px;">
          <td><p class="h4">${orderhisdis.orderID}</p></td>
          <td><p class="h4">RS. ${orderhisdis.total}</p></td>
          <td><p class="h4">${orderhisdis.date}</p></td>
          <td><p class="h4">${orderhisdis.off_id}</p></td>
          
          
        </tr>
       </c:forEach>
      </tbody>
      
    </table>
    
     <!-- <form action="#" method="POST"  >
        <center><button type="button" onclick = "location.href='search.jsp'" class="btn btn-success"><p style="width: 160px; font-size: 15px;">
        Continue Shopping </p></button></center>
       </form> <br> -->

    </div>
    <div class = "col-sm-2"></div></div>
  
  
    
   <br>
		
		
		
		
	</br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>
		<%@include file="/footer.jsp" %>
	

</body>
</html>