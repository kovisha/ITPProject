<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upadet Quantity</title>
	<link rel = "stylesheet" type = "text/css" href = "css/login.css">
	<link rel="stylesheet" href="css/search_sample.css">
	 <link rel="stylesheet" href="new_sample.css">
	 <link rel = "stylesheet" type = "text/css" href = "css/updatecart.css">
	 
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
      
      
       
      
      <script>
function incrementValue()
{
    var value = parseInt(document.getElementById('number').value, 10);
    value = isNaN(value) ? 0 : value;
    if(value<10){
        value++;
            document.getElementById('number').value = value;
    }
}
function decrementValue()
{
    var value = parseInt(document.getElementById('number').value, 10);
    value = isNaN(value) ? 0 : value;
    if(value>1){
        value--;
            document.getElementById('number').value = value;
    }

}

</script>
    
</head>
<body>

        <header>
			<%@include file="/header.jsp" %>
		</header>
		
		<img src = "images/bgg.jpg" class = "pic">
		
		<br></br><br></br><br>
<!-- The content of your page would go here. -->

        <% String id = request.getParameter("id") ;
           String name = request.getParameter("name") ;
           String qty = request.getParameter("qty") ;
           String price = request.getParameter("price") ;
           String discount = request.getParameter("discount") ;
           
        %>



<div class="login-wraper" >
<br>
  <center> <label for="tab-1" class="tab" style = "font-size:20px">Select ur Quantity</label>
     
    <div style = "width:90%">
  
    <div class="login-form">
        <div class="sign-in-htm">
        <form name = "signINform" method = "post" action = "updatecart" >
           
            <div class="group">
                <label for="user" class="label">ID</label>
                <input  type="text" class="input" name = "id" value = "<%= id %>" readonly >
            </div>
            
            <div class="group">
                <label for="pass" class="label">Item Name</label>
                <input type="text" class="input"  name = "itemname" value = "<%= name %>" readonly >
            </div>
            
             <div class="group">
                <label for="pass" class="label">Price</label>
                <input type="text" class="input"  name = "price" value = "<%= price %>" readonly >
            </div>
            
             <div class="group">
                <label for="pass" class="label">Discount percentage</label>
                <input type="text" class="input"  name = "discount" value = "<%= discount %>" readonly >
            </div>
            
            <div class="group">
                <label for="pass" class="label">Quantity</label>
                <!--<input id="pwd" type="password" class="input" data-type="password" name = "password" required>-->
                
                
                      <input  type="button" onclick="decrementValue()" value="-" />
                      <input  style = "text-align:center" type="text" name="quantity" value="<%= qty %>" maxlength="2" max="10" size="1" id="number" />
                      <input  type="button" onclick="incrementValue()" value="+" />
                      
            </div> 
            
             <div class="group">
           
                <input type="submit" class="button" value="Done">
              
            </div>
        
            <div class="hr"></div>
     
            </form>
            
            
        </div>
      
        </div>
   
        </div>
        
        </center>
</div>
		
	</br></br></br></br></br></br></br></br></br>
		<%@include file="/footer.jsp" %>
	

</body>
</html>