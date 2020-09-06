<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UDS Super</title>
  <!--  <meta charset="utf-8">-->
  <meta name="viewport" content="width=device-width,  initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <link rel = "stylesheet" href ="css/userHeaderFooter.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="css/search_sample.css">

  <!--Javascript-->
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script> -->
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,700,900" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700" rel="stylesheet">
     <!--  <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet"> -->
      <!-- <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css" rel="stylesheet"> -->
      
       <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>
      

<style>


th, td {
  padding: 15px;
}

</style>
</head>

<header>
	<%@include file="header.jsp" %>
</header>

<body>

  <br><br>
  <img src = "images/bgg.jpg"class = "pic1">
  
  
   
  

    <!--serach code
    Search form -->
 <div class = "container">
    <br><br>
    
    <div class="col-md-12 form-group text-center">
      <div class= "row">
        <div class = "col-sm-4"></div>
        <div class = "col-sm-4">
    <center>
    <form class="form-inline ml-auto">
      <input   type="text" class="form-control mr-sm-2" placeholder="Search" style = "width: 150px; height: 30px;">
      <button  onclick = "location.href='ItemDisplay.jsp'" class="btn btn-secondary btn-lg  btn-rounded btn-sm my-0 text-center border border-dark" type="submit"><div class= "h5" style = "width: 70px; height: 8px; margin:8px auto"><center><bold>Search</bold></center></div></button>
      <button class="btn btn-secondary btn-lg btn-rounded btn-sm my-0 text-center border border-dark" type="submit"><div class= "h5" style = "width: 70px; height: 8px;margin:8px auto"><center><bold>Clear</bold></center></div></button>
     
     
      </form></center> <br><br>
      
       <center><button  style = "width:250px ; height: 40px" onclick = "location.href='ItemDisplay.jsp'" type="button" class="btn btn-success btn-lg btn-block">VIEW ITEMS
       <i class="fas fa-eye"></i></button></center>
      
      </div>
    
      <div class = "col-sm-4"></div>
    </div></div><br><br>
      

    <hr>
      <!-- label and take it in center-->

       
    
        <div class="col-md-12 form-group text-center ">
         
         
        <label><div class = "h4"><div class = "prom_msg">Promos</div></div></label>
        <br>  
        <form action = "offerDisplay" method = "post">
        <center>	 <input type="submit"  value="SPECIAL DEALS..."  class="btn btn-success btn-lg btn-block"></center>
        
      </form>  
      </div>
        <bold><hr style="width:35% ; height:10px; color: black;" align="center" ></bold>

     <center><table style="width:80%">
         
         
     <div class="container">   
    <div class = "row">
    
    <c:forEach var="offer" items= "${offDetails}">
    
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <!--<div class="panel-heading">BLACK FRIDAY DEAL</div>-->
        <div class="flip-box">
            <div class="flip-box-inner">
              <div class="flip-box-front">
        <div class="panel-body"> <img src="images/offer.jpg"  class = "Img3"> </div>
            <!--<img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">-->
           
    </div>
    <div class="flip-box-back">
    <div class = "prom_msg">
        <h2>${offer.desc}</h2>
        <p >Discount : ${offer.discount} % </p>
        </div>
      </div>
      
    </div>
  </div>
        <div class="panel-footer text-center" >
        <div class = "prom_msg">
        <bold>  <div class = "h5" >${offer.offfname}</div></bold> 
        </div></div>
      </div>
      
    </div>
    </c:forEach>
    </div></div>
        </table></center>

      </div>


<br><br><br><br><br><br><br><br><br><br><br><br>
      <footer class="container-fluid bg-grey py-5">
        <div class="container">
           <div class="row">
                <div class="col-md-6">
                    <div class="row">
                        <div class="col-md-6 ">
                           <div class="logo-part">
                              <img src="images/UDS_3.png" class="w-50 logo-footer" >
                              <p>20/1 A, Wattegama Road,, Madawala 20260.</p>
                              <p>For more information contact 077-7828512.</p>
                              <p>(Daily operating hours 8.00a.m to 9.00p.m)</p>
                           </div>
                        </div>
                        <div class="col-md-6 px-4">
                           <h6> About Company</h6>
                           <p>Now you can order online and get a delivery to your doorstep.</p>
                           <a href="#" class="btn-footer"> More Info </a><br>
                           <a href="#" class="btn-footer"> Contact Us</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="row">
                        <div class="col-md-6 px-4">
                               <h6> Help us</h6>
                               <div class="row ">
                                  <div class="col-md-6">
                                     <ul>
                                        <li> <a href="#"> Home</a> </li>
                                        <li> <a href="#"> About</a> </li>
                                        <li> <a href="#"> Shop With Us</a> </li>
                                        <li> <a href="#"> Contact</a> </li>
                                        <li> <a href="#"> Logout</a> </li>
                                     </ul>
                                  </div>
                               </div>
                        </div>
                        <div class="col-md-6 ">
                               <h6> Social Media Links</h6>
                               <div class="social">
                                <a href="#" class="fa fa-facebook"></a>
                                <a href="#" class="fa fa-whatsapp"></a> 
                                <a href="#" class="fa fa-instagram"></a>
                               </div>
                               <p>Copyright © 2020 UDS Super (Pvt) Ltd. All Rights Reserved</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>

</body>
</html>