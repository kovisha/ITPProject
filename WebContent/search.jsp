<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
		<title>Promos and Offers</title>

		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>



		<link rel = "stylesheet" type = "text/css" href = "css/login.css">
		<link rel = "stylesheet" type = "text/css" href = "css/search_sample.css">
</head>
<body>

<header>

<%@include file="/ItemHeader.jsp" %>
</header>

  
<img src = "images/bgg.jpg" class = "pic">


    <!--serach code Search form -->
   <br><br><br><br>
 <div class = "container">
  
     <div class="col-md-12 form-group text-center ">
         <label><div class = "prom_msg" style = " font-size: 28px; color: whitesmoke;">Offers and Promos</div></label>
        <br>  
         <hr style="width:35% ; height:10px; color: black;" align="center" >
     </div>
     
       
   
    
    
     
    <table style="width:85%">
         
         
     <div class="container">   
        <div class = "row">
    
            <c:forEach var="offer" items= "${offDetails}">
    
               <div class="col-sm-4">
                 <div class="panel panel-primary">
                     <div class="flip-box">
                       <div class="flip-box-inner">
                         <div class="flip-box-front">
                            <div class="panel-body"> 
                            
                          <!--   <img src="images/offer.jpg" class = "Img3">  -->
                          <img src="data:image/jpg;base64,${offer.image}" class = "Img3"/>
                            
                            </div>
                         </div>
                         <div class="flip-box-back">
                         <br>
                         <div class = "prom_msg">
                         <br><br>
                         <h4>${offer.desc}</h4>
                         <p >Discount : ${offer.discount} % </p>
                         </div>
                         </div>
                       </div>
                      </div>
                       
        <div class="panel-footer text-center" >
        <div class = "prom_msg">
        <div class = "h4"  style = " font-weight: bold;">${offer.offfname}</div>
        </div>
        </div>
     </div>
      
    </div>
    </c:forEach>
    </div></div>
        </table>

      </div>
 

<br><br><br>

<%@ include file = "/footer.jsp" %> 

</body>
</html>