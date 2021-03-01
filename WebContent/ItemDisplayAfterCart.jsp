<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UDS Products</title>
	<link rel = "stylesheet" type = "text/css" href = "css/login.css">
	 <link rel="stylesheet" href="css/search_sample.css">
	 <meta name="viewport" content="width=device-width, initial-scale=1">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    
</head>
<body>

        <header>
			<%@include file="/ItemHeader2.jsp" %>
		</header>
		
		<img src = "images/bgg.jpg" class = "pic">
		<br><br><br>
		 <div class = "container">
 
  <div class="container--fluid">    
     <div class = "row">
   
         <div class="col-sm-3"> 
          </div>         
         <div class="col-sm-6"> <p class = "welcome_msg">Welcome to UDS Super Products</p></div>
         <div class = "col-sm-3"></div>
          <%-- <div class = "col-sm-4">
           <center><input onclick = "location.href='OrderHistory.jsp'" style = "width : 150px ; height : 50px" type="submit"  value="ORDER HISTORY"  class="btn btn-success btn-lg btn-block">
           </center>  
          </div> --%>
   
      </div><br><br>
      <div class = "row">
      <div class = "col-sm-2"></div>
      <div class = "col-sm-8">
       <a href = "tempcartRetrieve">
     <input type="button" style = "font-size: 20px;" class="btn btn-secondary btn-lg btn-block" value = "View your cart"/>
     </a>
      </div>
      <div class = "col-sm-2"></div>
      
      </div>
      

 <%-- <form action = "ItemDisplay" method = "post">
      <div class = "row">
      
     
      <div class = "col-sm-3"></div>
      <div class = "col-sm-6">
         
               	<div class="form-wrapper">
						<center>	<label><div class = "h3"><div class = "prom_msg">Category</div></div></label></center>
							<div style = "font-size: 15px"><center><select class="btn btn-success" style = "width:200px ; height:40px " name="category" id="" class="form-control">
								
								<option value="rice" style = "font-size: 15px">Oil</option>
								<option value="MilkPowder" style = "font-size: 15px"> MilkPowder </option>
								<option value="oil" style = "font-size: 15px">Suger</option>
								<option value="flour" style = "font-size: 15px">Powder</option>
								
								
								<option value="rice" style = "font-size: 15px">ToothPaste</option>
								<option value="Soap" style = "font-size: 15px"> Soap </option>
								<option value="Shampoo" style = "font-size: 15px"> Shampoo </option>
								<option value="Butter" style = "font-size: 15px"> Butter </option>
								<option value="Biscuit" style = "font-size: 15px"> Biscuit </option>
								<option value="Chocolate" style = "font-size: 15px"> Chocolate </option>
								<option value="Noodles" style = "font-size: 15px"> Noodles </option>
								
								

							</select></center></div>
							<i class="zmdi zmdi-chevron-down"></i></div>
							
							<br>
							
							 <center><input type="submit"  style = "width:200px"  value="Go"  class="btn btn-success btn-lg btn-block"></center>   
      </div>
      
     
     
     
      
      
      <div class = "col-sm-3"></div>
                 
             					
      </div>
       </form>  --%>
   </div>
   </div>
   <br><br>

   <div class="container" >   
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
        <div class="panel-body"> <img src="img/milk_powder.jpg"  class = "Img3"> </div>
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
    
  </div>
  
    

<br><br>
		
		
	</br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>
		<%@include file="/footer.jsp" %>
	

</body>
</html>