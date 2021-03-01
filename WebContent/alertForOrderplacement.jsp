<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirm Order</title>
	<link rel = "stylesheet" type = "text/css" href = "css/login.css">
	<link rel="stylesheet" href="css/search_sample.css">
	 <link rel="stylesheet" href="new_sample.css">
	 
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
      
      <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>
    
    
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
		<br><br><br><br><br>
		
		<div class = "container ">
		
		 <c:forEach var="cart" items= "${cartDetails}">
	          			<%String qOut=(String)session.getAttribute("result2");%>
					
					<%if(qOut.equals("successorderplacement")){ %>
						<script>
							Swal.fire({
								title: 'Order placed successfully!!!',
								icon: 'success',
							}).then(function() {
								window.location = "finalcartretrieve";
								});
						</script>
					<%} %>
					<%if(qOut.equals("failedorderplacement")){ %>
						<script>
							Swal.fire({
								title: 'Order placed successfully!!!',
								icon: 'success',
							}).then(function() {
								window.location = "finalcartretrieve";
								});
						</script>
					<%} %>
	          		 </c:forEach>

      <div class = "row">
        <div class="col-sm-3"> 
          </div>         
          <div class="col-sm-6"> <p class = "welcome_msg" style= "font-size:25px">Order Placed successfully!!! <br>Check out and continue...</p></div>
          <div class = "col-sm-3">
           <%-- <center>
           <a href = "displayuserorders">
           <input  style = "width : 150px ; height : 50px" type="submit"  value="ORDER HISTORY"  class="btn btn-success btn-lg btn-block">
           </a>
           </center>   --%>
          </div>
       
      </div> <br>
      
    <%--    <%
   
    String name = request.getParameter("itemName");
    double size = Double.parseDouble(request.getParameter("size"));
	double price =Double.parseDouble(request.getParameter("price"));
	String category = request.getParameter("categoryName");
	String offer = request.getParameter("offerName");
   
   %> --%>
    <div class = "p-8 border border-info "> 
       <br>

<div class="row">
    <div class="col-md-3 order-md-2 mb-4" style = "font-size: 15px;">
    <center>   <h4 class="d-flex justify-content-between align-items-center mb-3">
      
      
       <span style = "font-weight: bold; font-size: 20px; font-family: georgia; color: whitesmoke;">Your cart</span>
        <span class="badge badge-secondary badge-pill"></span>
       
      </h4></center>
      <ul class="list-group mb-3">
     
       <c:forEach var="cart" items= "${cartDetails}">
        <li class="list-group-item d-flex justify-content-between lh-condensed">
       
          <div>
            <h5 class="my-0">${cart.itemName}</h6>
            
          </div>
          <span class="text-muted">RS.${cart.netAmount}</span>
        </li>
       </c:forEach>
      
        <li class="list-group-item d-flex justify-content-between">

        <c:forEach var="total" items="${total}">
         <strong> <span>Total Amount (RS)</span></strong>
          <strong>RS.${total.total}</strong>
       </c:forEach>
        </li>
        
        
      </ul>

     <!--   <form class="card p-2">
        <div class="input-group">
          <input type="text" class="form-control" placeholder="Promo code">
          <div class="input-group-append">
            <button type="submit" class="btn btn-secondary">Redeem</button>
          </div>
        </div>
      </form>-->
      <br><br> <br><br> <br><br> <br><br>
       <div class= "col" align = "right">
                <button onclick = "location.href='cashPayType.jsp' " type="button"class="btn btn-secondary btn-block"><center><p style="width: 80px; height : 15px ;font-size: 15px; font-family: Georgia;"><i class="fas fa-shopping-cart"></i>Check out</p></center></button>
            </div>
    </div>
    
   
    <div class="col-md-9 order-md-1">
      <center> <h4 class="mb-3" style="font-weight: bold; font-size: 20px; font-family: Georgia; color: whitesmoke;">Your Basket</h4></center> 
       <!--   <form name = "signINform" method = "post" action = "updatecart" >-->
           <center> <table class="table  table-striped table-hover text-center  " style="font-size: 15px;" >
                <thead>
                 <tr class="table-dark">
                 <th scope="col" class="col-xs-2"><p class="h5"></p></th>
                 
                   <th scope="col" class="col-xs-2"><p class="h5">Item</p></th>
                   <th scope="col" class="col-xs-2"><p class="h5">Quantity</p></th>
                   <th scope="col"class="col-xs-2"><p class="h5">Price(Rs.)</p></th>
                   <th scope="col" class="col-xs-2"><p class="h5">Discount</p></th>
                   <th scope="col"class="col-xs-2"><p class="h5">Subtotal</p></th>
                   <th scope="col"class="col-xs-2"><p class="h5"></p></th>
                   <th scope="col"class="col-xs-2"><p class="h5"></p></th>
                  
                 </tr>
               </thead>
               <tbody>
               <c:set var="Total" value="{0}"/>
               <c:forEach var="cart" items= "${cartDetails}">
             <!--     <c:set var="netTotal" value="{0}"/>-->
               
               <c:set var = "id" value ="${cart.id}"/>
        	   <c:set var = "name" value ="${cart.itemName}"/>
         	   <c:set var = "qty" value =" ${cart.qty}"/>
         	   <c:set var = "price" value ="${cart.price}"/>
         	   <c:set var = "discount" value ="${cart.discount}"/>
               
               
                 <tr class="table-light" style="font-weight: bold; font-size: 20px;">
                 
                  <td><p class="h5" align = "center" name = "id">${cart.id}</p></td>
                   <td><p class="h5" align = "left" name = "itemname">${cart.itemName}</p></td>
                   <td><p class="h5" name = "qty">${cart.qty}</p></td>
                    
                   <!-- <div class = "incret">
                      <input  type="button" onclick="decrementValue()" value="-" />
                      <input  type="text" name="quantity" value="1" maxlength="2" max="10" size="1" id="number" />
                      <input  type="button" onclick="incrementValue()" value="+" />
                      </div>-->
                
                
                   <td><p class="h5" name ="price">${cart.price}</p></td>
                   <td><p class="h5" name = "discount">${cart.discount}</p></td>
                   <c:set var="Total" value="{Total+cart.netAmount}"/>
                   <td><p class="h5" >RS.${cart.netAmount}</p></td>
                   <td><p class="h5">
                  <c:url value = "updateCartItem.jsp" var = "cartupdate">
           			<c:param name="id" value = "${id}"/>
           			<c:param name="name" value = "${name}"/>
           			<c:param name="qty" value = "${qty}"/>
           			<c:param name="price" value = "${price}"/>
           			<c:param name="discount" value = "${discount}"/>
           			</c:url>
          
                       <a href = "${cartupdate}" >
                   
                   
                   <div class= "col" align = "right">
               		<input type="button" class="btn btn-secondary btn-block" style = "font-size: 12px; width : 100px"value = "change quantity "disabled/>
              
               <!-- <center><p style="width: 80px; height : 15px ;font-size: 15px; font-family: Georgia;"><i class="fas fa-shopping-cart"></i>Update</p></center> -->
         		   </div>
         		   
         		   </a>
                   
                   </p>
                  <!--<div>
                   
                    <input  type="submit" onclick="decrementValue()" value="-" />
                      <input  style = "text-align:center" type="text" name="quantity" value ="1"  max="10" size="1" id="number" />
                      <input  type="submit" onclick="incrementValue()" value="+" />
                     </p>
                   
                </div>-->
                   
                   <td><p class="h5" align = "center">
                   
                   <script>
						    function myFunction() {
 							 alert("Do you want to Delete Item?");
								}
					</script>
                   
                   <div class= "col" align = "right">
                   <a href = "deletetempitem?&id=${cart.id}&qty=${cart.qty}&itemid=${cart.itemid}">
                   <input type="button" onclick="myFunction()" class="btn btn-secondary btn-block" style = "font-size: 12px; width : 100px"value = "Delete Item" disabled/>
                  </a>
                   </div>
                   </p></td>
                   
                 </tr>
                 
                 
                  
             </c:forEach>
             
             <c:forEach var="total" items="${total}">
             <tr  class="table-light" style="font-weight: bold; font-size: 20px;">
                 <td></td>
                 <td></td>
                 <td></td>
                 <td></td>
                 <td></td>
                  <td></td>
               <center><td colspan="2"><p  class="h4"  ><strong>Total Amount : </strong>
                 <strong>RS.${total.total}</strong></p></td></center>
                 </tr>
         
        

       <!-- </form>-->
       
       <tr class="table-light" style="font-weight: bold; font-size: 13px;">
       <td>
       
        </td>
         <td></td>
          <td></td>
          <td colspan="3">
          
          <script>
           function confirmOrder(){
        	  alert("Are you sure you want to place order ?");
        	  
          }
          
            /* document.querySelector(".first").addEventListener('click', function(){
        	  swal("Our First Alert", "With some body text and success icon!", "success");
        	}); */
          
          </script>
          
           <a href = "orderinsert?&total=${total.total}">
    <center><input type="button" id = "mybtn" onclick="confirmOrder()"  class="btn btn-secondary btn-block" style = "font-size: 15px; width : 150px"value = "PLACE ORDER" disabled/></center>
        </a>
          
          </td>
          
          
          <td></td>
           <td></td>
        
        </tr>
    </c:forEach>
    
    
    
                <tr   class="table-light" style="font-weight: bold; font-size: 13px;">
                 <td> 
                 <a href = "displayItem?category=MilkPowder">
                 <input type="button" class="btn btn-secondary btn-block" style = "font-size: 12px; width : 120px"value = "Add Items" disabled/>
                 </a>
                 
                 </td>
                 <td></td>
                 <td></td>
                 <td></td>
                 <td></td>
                  <td></td>
                 <td></td>
                 <td></td>
                 </tr>
         
           
      
              
             
             
    
     </tbody>
               
     </table></center>
    </div>
  </div>
</div>

  <br><br>
  
  <!--  <div class = "container">
        <div class = "row">
            <div class= "col">
                <button type="button" onclick = "location.href='ItemDisplay.jsp'" class="btn btn-success"><p style="width: 160px; font-size: 15px;"><i class="fas fa-shopping-basket"></i>Continue Shopping </p></button>
            </div>
            <div class= "col" align = "right">
                <button type="button" onclick = "location.href='OrderHistory.jsp'" class="btn btn-success"><p style="width: 160px; font-size: 15px;"><i class="fas fa-shopping-basket"></i> Place Order</p></button>
            </div>
            <div class= "col" align = "right">
                <button type="button" class="btn btn-success"><p style="width: 80px; font-size: 15px;">Check out </p></button>
            </div> 
        </div>
    </div>' -->
    <br>'


  </div><br>

		
		
		
		
	</br></br></br></br></br></br>
		<%@include file="/footer.jsp" %>
	

</body>
</html>