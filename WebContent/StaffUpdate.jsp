<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>Staff Update</title>

    <!-- Bootstrap CSS CDN -->
     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous"> 

    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- Our Custom CSS -->
    <link rel="stylesheet" href="css/style.css">

    <!-- <link rel="stylesheet" href="css/style1.css"> -->

    <!-- Font Awesome JS -->
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>

		<!-- Custom JS -->
 	<script src="js/script.js"></script>

</head>

<body>
     

    <div class="wrapper">
            <!--Side Bar start-->  
      <nav id="sidebar">
        <!--Side Bar header start-->  
          <div class="sidebar-header">
                <h3>               
                <div class="profile clearfix" style="align-content: center">
                    <div class="profile_pic">
                        <img src="images/UDS_2.jpg" alt="..."  class="rounded-circle" width="100px" height="100px" >
                    </div>
                <div class="profile_info">
                    <!-- <p>online</p> -->
                    <!-- <span>Welcome,</span> -->
                    <!-- <h2>John Doe</h2> -->
                </div>
                </div>
                </h3>
                <strong><img src="images/UDS_2.jpg" alt="..."  class="rounded-circle" width="50px" height="50px" ></strong>
                 
           </div>
        <!--Side Bar header end-->
            <!-- Main start list unstyled componenets -->
            <ul class="list-unstyled components">
                <li>

                <li>
                    <!--Major A has no drop downs-->
                    <!--Link to page Major A-->
                    <a href="AdminDashBoard.jsp">
                        <!-- Font awsome icons -->
                        <i class="fas fa-tachometer-alt"></i>
                        Dash Board
                    </a>
                </li>
                
             
                <!-- Customer start -->
                <li>
                    <a href="#Customers" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                    <!--Major B with drop downs-->
                   <i class="fas fa-users"></i>
                       Customers
                    </a>
                    <!-- Subtitles and links to those -->
                    <!-- ID should be identical for each Submenu -->
                    <ul class="collapse list-unstyled" id="Customers">
                        <!-- <li>
                            <a href="#">
                                <i class="fas fa-plus-circle"></i>
                                Add
                            </a>
                        </li> -->
                        <li>
                            <a href="viewUsers.jsp">
                                <i class="fas fa-eye"></i>
                                View
                            </a>
                        </li>
                        <li>
                            <a href="customerReport.jsp">
                                <i class="fas fa-file-alt"></i>
                                Reports
                            </a>
                        </li>
                    </ul>
                    <!-- End subtitiles -->

                </li>
                <!-- Customer end -->




                <!-- Category start -->
                <li>
                    <a href="#Category" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                    <!--Major B with drop downs-->
                   <i class="fas fa-code-branch"></i>
                       Category
                    </a>
                    <!-- Subtitles and links to those -->
                    <!-- ID should be identical for each Submenu -->
                    <ul class="collapse list-unstyled" id="Category">
                        <li>
                            <a href="insertCategory.jsp">
                                <i class="fas fa-plus-circle"></i>
                                Add
                            </a>
                        </li>
                        <li>
                            <a href="ViewCategory.jsp">
                                <i class="fas fa-eye"></i>
                                View
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fas fa-file-alt"></i>
                                Reports
                            </a>
                        </li>
                    </ul>
                    <!-- End subtitiles -->

                </li>
                <!-- Customer end -->



                <!-- Stock start -->
                <li>
                    <a href="#Stock" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                    <!--Major B with drop downs-->
                   <i class="fas fa-warehouse"></i>
                       Stock
                    </a>
                    <!-- Subtitles and links to those -->
                    <!-- ID should be identical for each Submenu -->
                    <ul class="collapse list-unstyled" id="Stock">
                        <li>
                            <a href="insertNewStock.jsp">
                                <i class="fas fa-plus-circle"></i>
                                Add
                            </a>
                        </li>
                        <li>
                            <a href="ViewStock.jsp">
                                <i class="fas fa-eye"></i>
                                View
                            </a>
                        </li>
                        <li>
                            <a href="StockReport.jsp">
                                <i class="fas fa-file-alt"></i>
                                Reports
                            </a>
                        </li>
                    </ul>
                    <!-- End subtitiles -->

                </li>
                <!-- Stock end -->




                <!-- Stock start -->
                <li>
                    <a href="#Item" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                    <!--Major B with drop downs-->
                   <i class="fas fa-cubes"></i>
                       Item
                    </a>
                    <!-- Subtitles and links to those -->
                    <!-- ID should be identical for each Submenu -->
                    <ul class="collapse list-unstyled" id="Item">
                        <li>
                            <a href="InsertNewItem.jsp">
                                <i class="fas fa-plus-circle"></i>
                                Add
                            </a>
                        </li>
                        <li>
                            <a href="ViewItems.jsp">
                                <i class="fas fa-eye"></i>
                                View
                            </a>
                        </li>
                        <li>
                            <a href="ItemReport.jsp">
                                <i class="fas fa-file-alt"></i>
                                Reports
                            </a>
                        </li>
                    </ul>
                    <!-- End subtitiles -->

                </li>
                <!-- Item end -->




                <!-- Orders start -->
                <li>
                    <a href="#Orders" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                    <!--Major B with drop downs-->
                   <i class="fas fa-shopping-cart"></i>
                       Orders
                    </a>
                    <!-- Subtitles and links to those -->
                    <!-- ID should be identical for each Submenu -->
                    <ul class="collapse list-unstyled" id="Orders">
                        <!-- <li>
                            <a href="#">
                                <i class="fas fa-plus-circle"></i>
                                Add
                            </a>
                        </li> -->
                        <li>
                            <a href="orders_view.jsp">
                                <i class="fas fa-eye"></i>
                                View
                            </a>
                        </li>
                        <li>
                            <a href="Orderreport.jsp">
                                <i class="fas fa-file-alt"></i>
                                Reports
                            </a>
                        </li>
                    </ul>
                    <!-- End subtitiles -->

                </li>
                <!-- Orders end -->
                
                <!-- Delivery start -->
                <li>
                    <a href="#Delivery" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                    <!--Major B with drop downs-->
                   <i class="fas fa-truck"></i>
                       Delivery
                    </a>
                    <!-- Subtitles and links to those -->
                    <!-- ID should be identical for each Submenu -->
                    <ul class="collapse list-unstyled" id="Delivery">
                        <li>
                            <a href="ApointDeliveryStaff.jsp">
                                <i class="fas fa-hands-helping"></i>
                                Assign Delivery
                            </a>
                        </li>
                        <li>
                            <a href="AdminDeliveryType.jsp">
                                <i class="fas fa-motorcycle"></i>
                                Delivery Type
                            </a>
                        </li>
                        <li>
                            <a href="AdminDeliveryStaff.jsp">
                                <i class="fas fa-people-carry"></i>
                                Delivery Staff
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fas fa-file-alt"></i>
                                Reports
                            </a>
                        </li>
                    </ul>
                    <!-- End subtitiles -->

                </li>
                <!-- Delivery end -->



                                <!-- Offers start -->
                <li>
                    <a href="#Offers" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                    <!--Major B with drop downs-->
                   <i class="fas fa-gift"></i>
                       Offers
                    </a>
                    <!-- Subtitles and links to those -->
                    <!-- ID should be identical for each Submenu -->
                    <ul class="collapse list-unstyled" id="Offers">
                        <li>
                            <a href="insertOffer.jsp">
                                <i class="fas fa-plus-circle"></i>
                                Add
                            </a>
                        </li>
                        <li>
                            <a href="retrieveOffer">
                                <i class="fas fa-eye"></i>
                                View
                            </a>
                        </li>
                    </ul>
                    <!-- End subtitiles -->

                </li>
                <!-- Offers end -->




                <!-- Suppliers start -->
                <li>
                    <a href="#Suppliers" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                    <!--Major B with drop downs-->
                   <i class="fas fa-truck-loading"></i>
                       Suppliers
                    </a>
                    <!-- Subtitles and links to those -->
                    <!-- ID should be identical for each Submenu -->
                    <ul class="collapse list-unstyled" id="Suppliers">
                        <li>
                            <a href="SupplierInsert.jsp">
                                <i class="fas fa-plus-circle"></i>
                                Add
                            </a>
                        </li>
                        <li>
                            <a href="ViewSupplier.jsp">
                                <i class="fas fa-eye"></i>
                                View
                            </a>
                        </li>
                        <li>
                            <a href="SupplierReport.jsp">
                                <i class="fas fa-file-alt"></i>
                                Reports
                            </a>
                        </li>
                    </ul>
                    <!-- End subtitiles -->

                </li>
                <!-- Suppliers end -->


                <!-- Staff start -->
                <li>
                    <a href="#Staff" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                    <!--Major B with drop downs-->
                   <i class="fas fa-id-card"></i>
                       Staff
                    </a>
                    <!-- Subtitles and links to those -->
                    <!-- ID should be identical for each Submenu -->
                    <ul class="collapse list-unstyled" id="Staff">
                        <li>
                            <a href="StaffInsert.jsp">
                                <i class="fas fa-plus-circle"></i>
                                Add
                            </a>
                        </li>
                        <li>
                            <a href="StaffList.jsp">
                                <i class="fas fa-eye"></i>
                                View
                            </a>
                        </li>
                        <li>
                            <a href="SalaryDashBoard.jsp">
                                <i class="fas fa-file-alt"></i>
                                Reports
                            </a>
                        </li>
                    </ul>
                    <!-- End subtitiles -->

                </li>
                <!-- Staff end -->



                <!-- UserPayment start -->
                <li>
                    <a href="#UserPayment" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                    <!--Major B with drop downs-->
                   <i class="fas fa-credit-card"></i>
                       User Payment
                    </a>
                    <!-- Subtitles and links to those -->
                    <!-- ID should be identical for each Submenu -->
                    <ul class="collapse list-unstyled" id="UserPayment">
                        
                        <li>
                            <a href="retrieveUsPay">
                               <i class="fas fa-eye"></i>
                                View
                            </a>
                        </li>
                        
                    </ul>
                    <!-- End subtitiles -->

                </li>
                <!-- UserPayment end -->



                   <!-- SupplyPayment start -->
                <li>
                    <a href="#SupplyPayment" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                    <!--Major B with drop downs-->
                   <i class="fas fa-dollar-sign"></i>
                       Supplier Payment
                    </a>
                    <!-- Subtitles and links to those -->
                    <!-- ID should be identical for each Submenu -->
                    <ul class="collapse list-unstyled" id="SupplyPayment">
                        <li>
                            <a href="SupplierPaymentInsert.jsp">
                                <i class="fas fa-plus-circle"></i>
                                Add
                            </a>
                        </li>
                        <li>
                            <a href="ViewSupplierPayment.jsp">
                                <i class="fas fa-eye"></i>
                                View
                            </a>
                        </li>
                        
                    </ul>
                    <!-- End subtitiles -->

                </li>
                <!-- SupplyPayment end -->



                <!-- Installment start -->
                <li>
                    <a href="#Installment" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                    <!--Major B with drop downs-->
                   <i class="fas fa-money-check-alt"></i>
                       Installment
                    </a>
                    <!-- Subtitles and links to those -->
                    <!-- ID should be identical for each Submenu -->
                    <ul class="collapse list-unstyled" id="Installment">
                        <!-- <li>
                            <a href="#">
                                <i class="fas fa-plus-circle"></i>
                                Add
                            </a>
                        </li> -->
                        <li>
                            <a href="retrieveInstall">
                                <i class="fas fa-eye"></i>
                                View
                            </a>
                        </li>
                        <li>
                            <a href="installReport.jsp">
                                <i class="fas fa-file-alt"></i>
                                Reports
                            </a>
                        </li>
                    </ul>
                    <!-- End subtitiles -->

                </li>
                <!-- Installment end -->
                  

                </li>



            
            </ul>
            <!-- End list unstyled componenents -->


            
        </nav>
        <!--Side Bar end-->   
        <!-- Page Content  Start-->
       
        <div id="content">
  


        <!-- Header can be user to Display the topic in the page content if needed -->

<nav class="navbar navbar-expand-lg navbar-dark"    >


          <!-- Toggle button start -->
         <button type="button" id="sidebarCollapse" class="btn btn-info">
               <i class="fas fa-align-left"></i>
                        <span></span>
         </button>

                <button class="btn btn-dark d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <i class="fas fa-align-justify"></i>
                </button>
          <!-- Toggle button end -->


         <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
        </button>



  <div class="collapse navbar-collapse" id="navbarSupportedContent">

    <ul class="navbar-nav mr-auto">

     <!--  <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>

      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>

      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Dropdown
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>

      <li class="nav-item">
        <a class="nav-link disabled" href="#">Disabled</a>
      </li> -->

    </ul>


    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>

    </form>

    <ul class="navbar-nav">
                    <li class="nav-item icon-parent">
                                <a href="#" class="nav-link icon-bullet">
                                    <i class="fas fa-comments text-primary fa-lg"></i>        
                                </a>
                    </li>
                    <li class="nav-item icon-parent">
                                <a href="#" class="nav-link icon-bullet">
                                        <i class="fas fa-bell text-primary fa-lg"></i>
                                </a>
                    </li>
                    <li class="nav-item ml-md-auto">
                                <a href="#" class="nav-link" data-toggle="modal" data-target="#sign-out">
                                            <i class="fas fa-sign-out-alt text-danger fa-lg"></i>
                                </a>
                    </li>
    </ul>

  </div>
</nav>
        <!-- <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="#" class="navbar-brand">Book List</a>
                    </div>

                </nav>
            </header> -->


               <!-- navbar -->
 
    <!-- end of navbar -->
<div class = "container">
                                    <!--Start Page main content / Tables and Forms -->


<!--Form Heading -->
<div class="formHeading">
	<center>
		<h2>UPDATE STAFF</h2>
	</center>
</div>


<div class = "container">
	<div class = "row">
		<div class = "col-lg-3"></div>
		<div class = "col-lg-6">
					<ul>
                        <li><a href="<%=request.getContextPath()%>/StaffListServlet">
                        <button type="" class="btn btn-secondary btn-block btn-sm">
                        View Staff List
                        <i class="fas fa-eye"></i> 
                        </a>
                        </button>
                        </li>
                    </ul>
		</div>
		<div class = "col-lg-3"></div>
	</div>
</div>

<br>







					<%
		String id = request.getParameter("id");
		String staffID = request.getParameter("staffID");
		String staffFirstName = request.getParameter("staffFirstName");
		String staffLastName = request.getParameter("staffLastName");
		String staffUserName = request.getParameter("staffUserName");
		String staffPassword = request.getParameter("staffPassword");
		String staffAddress = request.getParameter("staffAddress");
		String staffemailAddress = request.getParameter("staffemailAddress");
 		String dob = request.getParameter("dob");
 		String staffNIC = request.getParameter("staffNIC");
		String categoryRel = request.getParameter("categoryRel");
		String staffGender = request.getParameter("staffGender");
 		String staffEPF = request.getParameter("staffEPF");	
 		String joinedDate = request.getParameter("joinedDate");
		String categoryJob = request.getParameter("categoryJob");
 		String staffBasicSalary = request.getParameter("staffBasicSalary");
 		String filename = request.getParameter("image");
 		String mobNo = request.getParameter("mobNo");
 		String homNo= request.getParameter("homNo");
 		
	
		
	%>
	
	
		<div class = "container">
		<div class = "card special-card text-light">
			<div class = "card-body">
					<form action="updateStaff" method ="post" enctype="multipart/form-data" >
					
						 <div class="form-group">
				    <label for="staffFirstName">First Name</label>
				    <input type="text" class="form-control" id="staffFirstName"  placeholder="Enter First Name" name = "staffFirstName" value = "<%= staffFirstName %>" required>
				 </div>
				 
				 
				 <div class="form-group">
				    <label for="staffLastName">Last Name</label>
				    <input type="text" class="form-control" id="staffLastName"  placeholder="Enter First Name" name = "staffLastName" value = "<%= staffLastName %>" required>
				 </div>
				 
				 
				  
				 
				 <div class = "row">
				 	<div class = "col-md-6">
				 		<div class="form-group">
						    <label for="id">Staff ID</label>
						    <input type="text" class="form-control" id="id"  placeholder="Enter Staff ID" name = "id" value = "<%= id %>" readonly>
					  	</div>
				 	</div>
				 	<div class = "col-md-6">
					 	<div class="form-group">
						    <label for="staffID">Staff ID</label>
						    <input type="text" class="form-control" id="staffID"  placeholder="Enter Staff ID" name = "staffID" value = "<%= staffID %>" readonly>
					  	</div> 
				 	</div>
				 </div>	
				 
				 <div class = "row">
				 	<div class = "col-md-6">
				 		<div class="form-group">
						    <label for="staffAddress">Address</label>
						    <input type="text" class="form-control" id="staffAddress" name="staffAddress" rows="3"  value = "<%= staffAddress %>"></input>
					  	</div>
				 	</div>
				 	<div class = "col-md-6">
					 	  <div class="form-group">
						    <label for="staffemailAddress">Email address</label>
						    <input type="email" class="form-control" id="staffemailAddress" name="staffemailAddress" placeholder="name@example.com" value = "<%= staffemailAddress %>">
						  </div>
				 	</div>
				 </div>	
				 
				 
				 
				 <div class = "row">
				 	<div class = "col-md-6">
				 		<div class="form-group">
						    <label for="`">Mobile Number</label>
						    <input type="text" class="form-control" id="mobNo"  placeholder="Enter First Name" name = "mobNo" required value = "<%= mobNo %>">
						 </div>
				 	</div>
				 	<div class = "col-md-6">
				 		<div class="form-group">
						    <label for="homNo">Home Number</label>
						    <input type="text" class="form-control" id="homNo"  placeholder="Enter First Name" name = "homNo" value = "<%= homNo %>">
						 </div>
				 	</div>
				 	
				 </div>
				 
				 
				 <div class = "row">
				 	<div class = "col-md-6">
				 		  <div class="form-group">
						    <label for="dob">Date of birth</label>
     						<input type="date" class="form-control" id="dob"  placeholder="Pick date of Birth" name = "dob" required value = "<%= dob %>"> 
    					  </div>
				 	</div>
				 	
			
				 	
			
				 	
				 	
				 	
				 	
				 	
				 		<div class="form-group col-md-6">
   
										  <label for="staffGender">Gender</label>
											<select name="staffGender" class="form-control" value = "<%= staffGender %>" >
											<option value = "<%= staffGender %>" disabled selected hidden><%= staffGender %></option>
											 <option value = "M">Male</option>
											 <option value = "F">Female</option>
											 
											 
										    <%-- <c:forEach items="${listCategory}" var="category">
										        <option value="${category.categoryNum}"> ${category.categoryNum}</option>
										    </c:forEach> --%>
										    
											</select>
						</div>
				 </div>	
			 
				 
				 <div class = "row">
				 	<div class = "col-md-6">
				 		  <div class="form-group">
 						    <label for="staffNIC">NIC number</label> 
						    <input type="text" class="form-control" name = "staffNIC" id="staffNIC" placeholder="Example the NIC number" required value = "<%= staffNIC %>">
						  </div>
				 	</div>
				 	<div class = "col-md-6">
				 		  <div class="form-group"></div> 	  
				 	</div>
				 </div>	



<!-- 
											* ==========================================
											* Profile image uploading
											* ==========================================
 -->


	
<div class = "form-row">
    <div class="form-group col-md-6">
            
   <style type="text/css">
    /*
*
* ==========================================
* CUSTOM UTIL CLASSES
* ==========================================
*
*/
#upload {
    opacity: 0;
}

#upload-label {
    position: absolute;
    top: 50%;
    left: 1rem;
    transform: translateY(-50%);
}

.image-area {
    border: 2px dashed rgba(255, 255, 255, 0.7);
    padding: 1rem;
    position: relative;
}

.image-area::before {
    content: 'Uploaded image result';
    color: #fff;
    font-weight: bold;
    text-transform: uppercase;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    font-size: 0.8rem;
    z-index: 1;
}

.image-area img {
    z-index: 2;
    position: relative;
}



/*
</style>

 <label for="validationDefault03">Choose a book image</label>
            Upload image input
            <div class="input-group rounded bg-white shadow-sm">
               id="upload"

                <label id="upload-label" for="upload" class="font-weight-light text-muted" ></label> 
                <input  id="upload" type="file" onchange="readURL(this);" class="form-control border-0" name="filename" value="filename" >
                




  <label id="upload-label" for="upload" class="font-weight-light text-muted" >Browse</label> 
   <input  id="upload" type="file" onchange="loadFile(event)" class="form-control border-0" class="form-control" name="filename" value="filename" >




                <div class="input-group-append">
                    <label for="upload" class="btn btn-light m-0 rounded-pill px-4"> <i class="fas fa-upload mr-2 text-muted"></i><small class="text-uppercase font-weight-bold text-muted"></small></label>
                </div>
            </div>

<!--             Uploaded image area -->
            <p class="font-italic text-white text-center">The image uploaded will be rendered inside the box below.</p>
            <div class="image-area mt-4">
             <img alt="img" src="data:image/jpeg;base64,<%= filename %>" value = "<%= filename %>" id="imageResult" class="img-fluid rounded shadow-sm mx-auto d-block" />
            </div>
 
	



	
	</div>
	<div class="form-group col-md-6">
   
					  <label for="categoryRel">Religion</label>
						<select name="categoryRel" class="form-control" value = "<%= categoryRel %>" >
						<option value = "<%= categoryRel %>" disabled selected hidden><%= categoryRel %></option>
						 <option>Bhudhist</option>
						 <option>Christian</option>
						 <option>Muslim</option>
						 <option>Hindu</option>
						 <option>Other</option>
						 
					    <%-- <c:forEach items="${listCategory}" var="category">
					        <option value="${category.categoryNum}"> ${category.categoryNum}</option>
					    </c:forEach> --%>
					    
						</select>
	</div>
</div>




			<div class = "row">
				 	<div class = "col-md-6">
				 		  <div class="form-group">
						    <label for="joinedDate">Joined Date</label>
     						<input type="date" class="form-control" id="joinedDate"  placeholder="Pick the joined date" name = "joinedDate" value = "<%= joinedDate %>"> 
				 		  </div>
				 	</div>
				 	<div class = "col-md-6">
						    <label for="staffEPF">EPF number</label>
						    <input type="text" class="form-control" id="staffEPF" name="staffEPF" placeholder="Enter the EPF number" value = "<%= staffEPF %>">
				 	</div>
			</div>	
			
			
			
			
			
			
			<div class = "row">
				 	<div class = "col-md-6">
				 		  <div class="form-group">
				 		  		   
					  <label for="categoryJob">Job Title</label>
						<select name="categoryJob" class="form-control"  value = "<%= categoryJob %>">
						<option value = "<%= categoryJob %>" disabled selected hidden><%= categoryJob %></option>
						 <option value = "Sales">Sales</option>
						 <option value = "Cashier">Cashier</option>
						 <option value = "Stock Manager"> Stock Manager</option>
						 <option value = "Center Manager">Center Manager</option>
						 <option value = "Admin">Admin</option>
						 <option value = "Delivery Staff">Delivery Staff</option>
						 
					    <%-- <c:forEach items="${listCategory}" var="category">
					        <option value="${category.categoryNum}"> ${category.categoryNum}</option>
					    </c:forEach> --%>
					    
						</select>
				 		  
				 		  </div>
				 	</div>
				 	<div class = "col-md-6">
						    <label for="staffBasicSalary">Basic Salary</label>
						    <input type="text" class="form-control" id="staffBasicSalary" name="staffBasicSalary" placeholder="Enter the basic salary" value = "<%= staffBasicSalary %>">
				 	</div>
			</div>	
			
			
			
			
			<div class = "row">
				 	<div class = "col-md-6">
				 		  <div class="form-group">
						    <label for="staffUserName"><i class="fa fa-user" aria-hidden="true"></i> User Name</label>
						    <input type="text" class="form-control" id="staffUserName" name = "staffUserName" placeholder="Enter User Name" value = "<%= staffUserName %>">
				 		  </div>
				 	</div>
				 	
				 	
				 	<div class = "col-md-6">
				 		  <div class="form-group">
						    <label for="staffPassword"><i class="fa fa-key" aria-hidden="true"></i> Password</label>
						    <input type="text" class="form-control" id="staffPassword" name = "staffPassword" placeholder="Enter the password" value = "<%= staffPassword %>">
				 		  </div>
				 	</div>
				 	
			</div>	

 
					
					
					
					








			<div class = "row">				 
					<div class = "form-group col-lg-4">
					
						<button  type="submit" name ="updateStaff" value = "Update profile" class="btn btn-success btn-block ">Submit</button>		
					</div>
					<div class = "form-group col-lg-4">
						
					</div>
					<div class = "form-group col-lg-4">
						<button type="reset" class="btn btn-info btn-block ">Reset</button>

					</div>
					
			<style>
				
.btn-primary:hover{color:#fff;background-color:#0a0943;border-color:#009a9a};

			</style>		
						
					</div>					
					
					</form>
			</div>
		</div>
		</div>	
	
	
	




                                    <!--End Page main content / Tables and Forms -->
</div>

        </div>
         <!-- Page Content  End-->

  
    </div>

    <!-- jQuery CDN - Slim version (=without AJAX) -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <!-- Popper.JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            $('#sidebarCollapse').on('click', function () {
                $('#sidebar').toggleClass('active');
            });
        });
    </script>




</body>

</html>