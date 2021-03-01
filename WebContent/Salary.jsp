<%@page import="Staff.Staff"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>Salary</title>

    <!-- Bootstrap CSS CDN -->
     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous"> 

    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- Our Custom CSS -->
    <link rel="stylesheet" href="css/style.css">

    <!-- Font Awesome JS -->
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>

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

               <!-- navbar -->
 
    <!-- end of navbar -->
	<!-- Start card to select month and year of salary -->
<div class = "container">

	
		<div class = "card special-card text-light">
			<div class = "card-body">
					<form action="salaryRetrieve" method ="post" >
					
						<div class = "row">
						<div class="form-group col-md-3">
							<label for="Month">Select Salary Month</label>
						</div>
						<div class="form-group col-md-9">
   
					  
						<select name="categoryMonth" class="form-control bd-dark" required >
						 <option value="" disabled selected hidden>Select a month</option>
						 <option value = "1">January</option>
						 <option value = "2">February</option>
						 <option value = "3">March</option>
						 <option value = "4">April</option>
						 <option value = "5">May</option>
						 <option value = "6">June</option>
						 <option value = "7">July</option>
						 <option value = "8">August</option>
						 <option value = "9">September</option>
						 <option value = "10">October</option>
						 <option value = "11">November</option>
						 <option value = "12">December</option>
						 </select>
						 
					   
						</div>
						</div>
						<div class = "row">
						<div class = "col-md-3">
							<label for="Month">Select Year</label>
						</div>
						<div class="form-group col-md-9">
   
					  
							<select name="categoryYear" class="form-control bd-dark" required >
							 <option value="" disabled selected hidden>Select an Year</option>
							 
							 <option value = "2019">2019</option>
							 <option value = "2020">2020</option>
							 <option value = "2021">2021</option>
							
							</select>
						</div>
						</div>




					<div class = "row">				 
					<div class = "form-group col-lg-4">
					
						<button  type="submit" name ="updateStaff" value = "Update profile" class="btn-sm btn-primary btn-block "><i class="fas fa-file-alt"></i> Generate Salary</button>
					</div>
					<div class = "form-group col-lg-4">
								
					</div>
					<div class = "form-group col-lg-4">
						<button  type="submit" name ="updateStaff" value = "Update profile" class="btn-sm btn-primary btn-block "><a href="SalaryReportSelect.jsp"><i class="fas fa-download"></i>Salary Reports</a></button>
						
					</div>
						
						
						
						
						
					</div>	
					</form>
			</div>
		</div>			
					


</div>   
	<!-- End card to select month and year of salary -->

<div class = "container">

                                    <!--Start Page main content / Tables and Forms -->


<!-- View Table -->

		<!--Start Table to display final salary of employees -->
         <table class = "table table-hover table-dark table-bordered table-sm text-center table-stripped" id = "table">
         
         			 <thead>
                            <tr>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Staff ID</th>
                                <th>Basic Salary</th>
                                <th>(EPF) Employer</th>
                                <th>(EPF) Employee</th>
                                <th>EPF</th>
                                <th>ETF</th>
                                <th>OT Hours</th>
                                <th>OT Rate</th> 
                                <th>OT Amount</th>
                                <th>Leaves</th>
                                <th>Leave deducts</th>
                                <th>Halfdays</th>
                                <th>Halfday deducts</th>
                                <th>Salary</th>
                                 
                                
                                   
                            </tr>
                        </thead>
       
         
         
         <!-- Retieve Details from the servlet StaffSalaryListServlet -->
         <c:forEach var="staffSalary" items="${listStaffSalary}">
					<tbody>
					
					
					
					
								
  		<c:url value = "SalaryReport.jsp" var = "staffSalaryReport">
			<c:param name="staffFirstName" value = "${staffSalary.staffFirstName}"/>
			<c:param name="staffLastName" value = "${staffSalary.staffLastName}"/>
			<c:param name="staffID" value = "${staffSalary.staffID}"/>
			<c:param name="staffBasicSalary" value = "${staffSalary.staffBasicSalary}"/>
			<c:param name="epfEmployerContribution" value = "${staffSalary.epfEmployerContribution}"/>
			<c:param name="epfEmployeeContribution" value = "${staffSalary.epfEmployeeContribution}"/>
			
			
		</c:url>					
					
					
					
					
					
					
                                <tr class = "tableRow">
                                 	<td>
                                        <div class = "tableRowww">
                                               ${staffSalary.staffFirstName}
                                        </div>    
                                    </td>
                                    <td>
                                        <div class = "tableRowww">
                                               ${staffSalary.staffLastName}
                                        </div>    
                                    </td>
                                    <td>
                                        <div class = "tableRowww">
                                            ${staffSalary.staffID}
                                        </div>    
                                    </td>
                                    
                                    
                                    <td>
                                        <div class = "tableRowww">
                                               ${staffSalary.staffBasicSalary}
                                        </div>    
                                    </td>
                                    
                                    <td>
                                        <div class = "tableRowww">
                                               ${staffSalary.epfEmployerContribution}
                                                <c:set var="totalEPFemployer" value="${totalEPFemployer + staffSalary.epfEmployerContribution}" />
                                        </div>    
                                    </td>
                                    <td>
                                        <div class = "tableRowww">
                                               ${staffSalary.epfEmployeeContribution}
                                        </div>    
                                    </td>
                                    <td>
                                        <div class = "tableRowww">
                                               ${staffSalary.epf}
                                        </div>    
                                    </td>
                                    <td>
                                        <div class = "tableRowww">
                                               ${staffSalary.etf}
                                               <c:set var="totalETF" value="${totalETF + staffSalary.etf}" />
                                        </div>    
                                    </td>
                                    <td>
                                        <div class = "tableRowww">
                                               ${staffSalary.totOThours}
                                        </div>    
                                    </td>
                                    <td>
                                        <div class = "tableRowww">
                                               ${staffSalary.otRate}
                                        </div>    
                                    </td> 
                                    <td>
                                        <div class = "tableRowww">
                                               ${staffSalary.otAmount}
                                        </div>    
                                    </td>
                                    <td>
                                        <div class = "tableRowww">
                                               ${staffSalary.totLeaveDays}
                                        </div>    
                                    </td> 
                                    <td>
                                        <div class = "tableRowww">
                                               ${staffSalary.leaveDeductAmnt}
                                        </div>    
                                    </td> 
                                    <td>
                                        <div class = "tableRowww">
                                               ${staffSalary.totHalfDays}
                                        </div>    
                                    </td>
                                    <td>
                                        <div class = "tableRowww">
                                               ${staffSalary.halfdayDeductAmnt}
                                        </div>    
                                    </td> 
                                    <td>
                                        <div class = "tableRowww">
                                               ${staffSalary.salary}
                                                <c:set var="salaryTotal" value="${salaryTotal + staffSalary.salary}" />
                                        </div>    
                                    </td> 
                                     
                                    
                                  
		
 								</tr>
 					
 					</tbody>
 					</c:forEach>
 					
   			</table>
   			<!--End Table to display final salary of employees -->
   			
   			<div class = "container">
   				<div class = "row">
   					<div class = "col-lg-4">
   					<!--Button to display total EPF  -->
   					 <button type="button" class = "btn btn-secondary btn-block btn-sm" onclick="totalEPFemployerCalc()">View Total (EPF)Employer Contribution</button>

						<p id="value_epf_e"></p> 
   					</div>
   					<div class = "col-lg-4">
   					<!--Button to display total ETF  -->
   						<button type="button" class = "btn btn-secondary btn-block btn-sm" onclick="totalETFCalc()">View Total ETF</button>

						<p id="value_etf"></p> 
   					</div>
   					<div class = "col-lg-4">
   					<!--Button to display total Salary  -->
   						<button type="button" class = "btn btn-secondary btn-block btn-sm" onclick="totalSalaryCalc()">View Total Salary</button>

						<p id="value_salary_sum"></p>
   					</div>
   				</div>
   		
   			</div>


<button type="button" class = "btn btn-secondary btn-block btn-sm" onclick="grossOutFlow()">View Gross Out Flow</button>

						<p class = "value_outflow" id="value_outflow"></p>
<style>

p{
	font-size: 20px;
	font-family: Calibri;
	color: white;
	align-content: center;
	text-align: center;
}


.value_outflow{
font-size: 25px;
	font-family: Calibri;
	color: white;
	background-color : rgb(230, 6, 6,0.4);;
	align-content: center;
	text-align: center;
}

</style>



<script>
/* Salary total calculation */
function totalSalaryCalc() {
  document.getElementById("value_salary_sum").innerHTML = ${salaryTotal}.toFixed(2);
}

/* EPF total calculation */
 function totalEPFemployerCalc() {
	  document.getElementById("value_epf_e").innerHTML = ${totalEPFemployer}.toFixed(2);
	}
 
 /* ETF total calculation */ 
 function totalETFCalc() {
	  document.getElementById("value_etf").innerHTML = ${totalETF}.toFixed(2);
	}
 
 /* Gross out flow total calculation */
 function grossOutFlow() {
	 
	 var grossOutFlow = ${totalETF} + ${totalEPFemployer} + ${salaryTotal};
	 
	  document.getElementById("value_outflow").innerHTML = grossOutFlow.toFixed(2);
	}

 
 
 

</script>

                    <br><br>
                 <!-- Button to download the report	 -->   
			

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