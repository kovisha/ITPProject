<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add to cart</title>
	<link rel = "stylesheet" type = "text/css" href = "css/login.css">
	<link rel="stylesheet" href="css/search_sample.css">
	 <link rel="stylesheet" href="new_sample.css">
	 
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
   

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous"> 
	    <link rel="stylesheet" href="css/bootstrap.css">
	    <link rel="stylesheet" href="css/bootstrap.min.css">
	    <!-- Our Custom CSS -->
	    <link rel="stylesheet" href="css/style.css">
	
	    <!-- Font Awesome JS -->
	    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
	    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
    
</head>
<body>

        <header>
			<%@include file="/ItemHeader2.jsp" %>
		</header>
		
		<img src = "images/bgg.jpg" class = "pic">
		
		<div class = "container">
	          		<!--Start Page main content / Tables and Forms -->
	          		<!-- View Table -->
	          		 <c:forEach var="items" items= "${itemDetails}">
	          			<%String qOut=(String)session.getAttribute("result1");%>
					
					<%if(qOut.equals("successItemInsert")){ %>
						<script>
							Swal.fire({
								title: 'Item Added to the cart !!!',
								icon: 'success',
							}).then(function() {
								window.location = "displayItem?category=${items.categoryName}";
								});
						</script>
					<%} %>
					<%if(qOut.equals("failedItemInsert")){ %>
						<script>
							Swal.fire({
								title: 'failed',
								icon: 'error',
							}).then(function() {
								window.location = "ItemDisplayafterCart.jsp";
								});
						</script>
					<%} %>
	          		 </c:forEach>
	          		    <div class = "row" id= "myTable">
     <c:forEach var="items" items= "${itemDetails}">
    
      <c:set var = "itemName" value ="${items.itemName}"/>
      <c:set var = "size" value ="${items.size}"/>
      <c:set var = "price" value ="${items.price}"/>
      <c:set var = "categoryName" value ="${items.categoryName}"/>
       <c:set var = "offerName" value ="${items.offerName}"/>
       
       <c:url value = "OrderSummary.jsp" var = "customizeitem">
       
       <c:param name="itemName" value = "${itemName}"/>
       <c:param name="size" value = "${size}"/>
       <c:param name="price" value = "${price}"/>
       <c:param name="categoryName" value = "${categoryName}"/>
       <c:param name="offerName" value = "${offerName}"/>
       </c:url>
       
       
    <div class="col-sm-4" >
      <div class="panel panel-primary">
        <!--  <div class="panel-heading"></div>-->
        <div class="flip-box">
            <div class="flip-box-inner">
              <div class="flip-box-front">
        <div class="panel-body"><img src="data:image/jpg;base64,${items.image}" class = "Img3"/> </div>
            <!--<img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">-->
           
    </div>
     <div class="flip-box-back" style="font-size: 15px;">
                    <h2>Quantity and prices</h2>
               <h3>    <center> <table style="font-size: 15px; font-weight: bold; width :100px" border = "1">
                        <tr>
                        <th>Size </th>
                        <th>Price</th>
                        <th>Category</th>
                        <th>Offer</th>
                        <th>Discount</th>
                    </tr>
                    <tr>
                    <td>${items.size}</td>
                    <td>RS.${items.price}</td>
                    <td>${items.categoryName}</td>
                     <td>${items.offerName}</td>
                     <td>${items.discount} %</td>
                    </tr>

                    </table></center><h3></h3>
                  </div>
    </div>
  </div>
        <div class="panel-footer text-center" >
            
             <label id = "alert"><div style = "font-size: 10px"><div class = "prom_msg">${items.itemName}</div></div></label><br>
             
           <!--    <div class = "col-sm-6">
              <label style= "font-size: 15px" >Select Quantity : </label></div>-->
              
                      <!--  <div class = "col-sm-6">
                   
                    <strong>  <input style = "width:34px ;font-size: 12px" " type="button" onclick="decrementValue()" value="-" />
                      <input   style = "width:54px ; text-align :center ;font-size: 12px" type="text" name="quantity"  maxlength="2" max="10" size="1" id="number" />
                      <input   style = "width:34px; font-size: 12px" type="button" onclick="incrementValue()" value="+" /></strong>
                    
                      </div>-->
                      
                       <script>
                             function myfunction(){
        	                 window.alert("Item Added to the cart !!!");
        	                 }         
                       </script>
                     
          <a href= "tempcartinsert?itemname=${items.itemName}&price=${items.price}&discount=${items.discount}&offername=${items.offerName}&category=${items.categoryName}&quantity=1">   
          <input style = "font-size: 15px" onclick="myfunction()" type = "button" class="btn btn-success btn-primary btn-block text-center"  value = "Add To Cart"/>   
          </a>
     
        
        </div>
      </div>
      
    </div>
   </c:forEach>
    </div>
   
  <%--   <div class = "row">
    <div class = "col-sm-4"></div>
    <div class  = "col-sm-4">
    <center>
    <a href = "tempcartRetrieve">
     <input style = "width : 170px ; height : 40px" type="submit"  value="View cart"  class="btn btn-success btn-lg btn-block">
     </a>
   </center>
    </div>
    </div> --%>
    
     	<!--End Page main content / Tables and Forms -->
				</div>
		
		
		
	</br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>	</br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>
		<%@include file="/footer.jsp" %>
	

</body>
</html>