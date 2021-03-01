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
      
      <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
      
   </head>
<body>

        <header>
			<%@include file="/ItemHeader2.jsp" %>
		</header>
		
		<img src = "images/bgg.jpg" class = "pic">
		<br><br><br><br>
		
		  
    <div class = "container">
 
  <div class="container--fluid">    
     <div class = "row">
   
         <div class="col-sm-3"> 
          </div>         
          <div class="col-sm-6"> <p class = "welcome_msg">Welcome to UDS Super Products</p></div><br>
          <div class = "col-sm-3">
           <%--  <center>
           <a href = "displayuserorders">
           <input  style = "width : 150px ; height : 50px" type="submit"  value="ORDER HISTORY"  class="btn btn-success btn-lg btn-block">
           </a>
           </center>   --%> 
          </div>
   
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
       
       
    <div class="col-sm-4" id="myTable" >
      <div class="panel panel-primary">
        <!--  <div class="panel-heading"></div>-->
        <div class="flip-box">
            <div class="flip-box-inner">
              <div class="flip-box-front">
        <div class="panel-body"> 
        
        <!-- <img src="img/milk_powder.jpg"  class = "Img3"> -->
        <img src="data:image/jpg;base64,${items.image}" class = "Img3"/>
         </div>
            <!--<img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">-->
           
    </div>
     <div class="flip-box-back">
                     <h1>Description</h1><br><br>
                   <%-- <center> <table  style="width:100px; " border = "1">
                        <tr class = "h4">
                     <th ><center> Size</center></th>
                        <th><center>Price</center></th>
                        <th><center>Category</center></th>
                        <th><center>Offer</center></th>
                        <th><center>Discount</center></th>
                    </tr>
                    <tr class = "h4" >
                    <td><center>${items.size}</center></td>
                    <td><center>RS.${items.price}</center></td>
                    <td><center>${items.categoryName}</center></td>
                     <td><center>${items.offerName}</center></td>
                     <td><center>${items.discount} %</center></td>
                    </tr>

                    </table></center> --%>
                    
                    <center>
						<div align="center">
						<div style="font-size: 15px; width : 80%;font-weight: bold; line-height:80%;text-align:left; font-famil:Georgia">			
  							<ul>
  								<li>Price  -  RS.${items.price}</li>
  								</br>
  								<li>Offer  -  ${items.offerName}</li>
 						    	</br>
 						    	<li>Discount  -  ${items.discount}% </li>
 						    	</br>
 						    </ul>		
						</div> 
						</div>
						</center>
                  </div>
    </div>
  </div>
        <div class="panel-footer text-center" >
            
             <label id = "alert"><div style = "font-size: 10px"><div class = "prom_msg"><h3>${items.itemName} - ${items.size}</h3></div></div></label><br>
             
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
           
            
                 <a href= "tempcartinsert?itemid=${items.itemId}&itemname=${items.itemName}&price=${items.price}&discount=${items.discount}&offername=${items.offerName}&category=${items.categoryName}&quantity=1">   
              <!--  <button class="btn btn-success btn-primary btn-block" ><input style = "font-size: 15px" onclick="myfunction()" type = "button"  value = "Add To Cart"/></button> -->
                <button  type="submit" class="btn btn-success btn-primary btn-block" style="width:100% ; height: 30px"><h4><i class="fa fa-shopping-cart"></i>Add To Cart</h4>
                                       </button>
                 </a>
           
         
        </div>
      </div>
      
    </div>
   </c:forEach>
    </div>
    
    
    <div class = "row">
      <div class = "col-sm-2"></div>
      <div class = "col-sm-8">
       <!-- <a href = "tempcartRetrieve">
     <input type="button" style = "font-size: 20px;" class="btn btn-secondary btn-lg btn-block" value = "View your cart"/>
     </a> -->
      </div>
      <div class = "col-sm-2"></div>
      
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
		
		
		 <script type="text/javascript">
       
        function myFunction() {
            var input, filter, table, tr, td, i, txtValue;
          input = document.getElementById("myInput");
          filter = input.value.toUpperCase();
          table = document.getElementById("myTable");
          tr = table.getElementsByTagName("div");
          for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("h3")[0];
            if (td) {
              txtValue = td.textContent || td.innerText;
              if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
              } else {
                tr[i].style.display = "none";
              }
            }      
          }
        }
        </script>
	

</body>
</html>