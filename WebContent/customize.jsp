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

<style>


th, td {
  padding: 15px;
}

</style>
</head>
<body>

  
  <img src = "images/bgg.jpg"class = "pic1">
  
  
  
  <div class="header">
    <nav class="navbar navbar-expand-lg" >
      <img src="images/UDS_3.png" width="4%" height="4%"> 
      

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto" >
          <li class="nav-item">
            <a class="nav-link" href="#">Home</a>
                      </li>
          <li class="nav-item">
            <a class="nav-link" href="#">About Us</a>
                      </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Shop With Us</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Contact Us</a>
          </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
          <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-dark" type="submit" style="color: #ffffff">Search</button>
        </form>
        <div class="userImage">
          <a href=""><img src="images/profile.png" style="width:50px" height="50px"></a>
        </div>
        <button type="button" class="btn btn-dark" style="margin-left: 2%;">Logout</button>
      </div>
    </nav>
  </div> 
  
   <%
   
    String name = request.getParameter("itemName");
    double size = Double.parseDouble(request.getParameter("size"));
	double price =Double.parseDouble(request.getParameter("price"));
	String category = request.getParameter("categoryName");
	String offer = request.getParameter("offerName");
   
   %>
  

      <div class = "container">
        <div class="container--fluid">    
            <div class = "row">
             <div class="col-sm-3">
             </div>
             <div class="col-sm-7"> <p class = "welcome_msg">Welcome to UDS Super Products</p></div>
             <div class="col-sm-2" ></div> 
            </div>

            <div class = "row">
                <div class="col-sm-6">
                    <div class = "row">
                        <div class = "col-sm-2"></div>
                        <div class = "col-sm-10">
                     <center>   
                    <div  style="width:300px;">
                     <div class="panel panel panel-success">
                    <div class="flip-box">
                        <div class="flip-box-inner">
                          <div class="flip-box-front">
                    <div class="panel-body"> <img src="images/flour.png"  class = "Img3"> </div>
                  </div>

                  <div class="flip-box-back">
                    <h2>Quantity and prices</h2>
                   <center> <table style="font-size: 8px; font-weight: bold;" border = "1">
                        <tr>
                        <th>Size </th>
                        <th>Price</th>
                        <th>Category</th>
                        <th>Offer</th>
                    </tr>
                    <tr>
                    <td><%=  size  %></td>
                    <td><%=  price  %></td>
                    <td><%=  category  %></td>
                    <td><%=  offer  %></td>offer
                    </tr>

                    
                    </table></center>
                  </div>
                  </div>
                  </div>

                  <div class="panel-footer"><p style="text-align: center; font-size: 15px; font-weight: bold;"><%=  name  %></p></div>

                  </div>
                
                </div>
                </center>
            </div>
                </div>
               
               

        </div><br><br>

        <div class="col-sm-6"> 
            <div class = "row">
            <div class = "col-sm-10">
               
             <center> 
            <div class = "border border-primary bg-light rounded text-center " style="background-color: #DCDCDC; width: 260px; height: 250px;" align = "right" >
              <form><br>
    <!--   <img src = "item_size.jpg" class = "img_item_size">-->
            <p class = "size_select">Select the size*</p>
            <div class = "h4" style="font-weight: bold; font-family: Georgia;">
            <label class="radio-inline" style="font-weight: bold;"><input type="radio" name="optradio" checked>Option 1</label><br>
            <label class="radio-inline" style="font-weight: bold;"><input type="radio" name="optradio">Option 2</label><br>
            <label class="radio-inline" style="font-weight: bold;"><input type="radio" name="optradio">Option 3</label><br><br><br>

            <button type="button" class="btn btn-success btn-lg"><p style = "width:55px; font-size :15px; height: 15px;">ADD</p></button><br>
            </div>
        </form>
            </div>
        </center>  
        </div>
        <div class = "col-sm-2"></div>
            </div>
           
        </div>

      </div>
    
    <!--<div> <button type="button" class="btn btn-success"><p style="width: 80px; font-size: 15px;">Continue </p></button></div>
    <div align = "right"> <button type="button" class="btn btn-success"><p style="width: 80px; font-size: 15px;">Check out </p></button>
    </div><br>-->

    <div class = "container">
        <div class = "row">
            <div class= "col">
                <button type="button" class="btn btn-success"><p style="width: 80px; font-size: 15px;">Continue </p></button>
            </div>
            <div class= "col" align = "right">
                <button type="button" class="btn btn-success"><p style="width: 80px; font-size: 15px;">Check out </p></button>
            </div>
        </div>
    </div>'
    <br>'
    </div>
    </div>
 
 


<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
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