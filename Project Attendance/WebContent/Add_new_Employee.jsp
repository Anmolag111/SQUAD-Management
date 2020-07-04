<!DOCTYPE html>
<html dir="ltr" lang="en-US">
<head>

	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<meta name="author" content="SemiColonWeb" />

	<!-- Stylesheets
	============================================= -->
	<link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i,700|Raleway:300,400,500,600,700|Crete+Round:400i" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="css/bootstrap.css" type="text/css" />
	<link rel="stylesheet" href="style.css" type="text/css" />
	<link rel="stylesheet" href="css/dark.css" type="text/css" />
	<link rel="stylesheet" href="css/font-icons.css" type="text/css" />
	<link rel="stylesheet" href="css/animate.css" type="text/css" />
	<link rel="stylesheet" href="css/magnific-popup.css" type="text/css" />

	<link rel="stylesheet" href="css/responsive.css" type="text/css" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />

	<!-- Document Title
	============================================= -->
	<title>Add New Employee</title>

</head>

<body class="stretched">

	<!-- Document Wrapper
	============================================= -->
	<div id="wrapper" class="clearfix">

		<!-- Header
		============================================= -->
		<header id="header" class="full-header">

			<div id="header-wrap">

				<div class="container clearfix">

					<div id="primary-menu-trigger"><i class="icon-reorder"></i></div>

					<!-- Logo
					============================================= -->
					<div id="logo">
						<a href="index.jsp" class="standard-logo" data-dark-logo="images/logo-dark.png"><img src="images/LOGO1.png" alt="SQUAD Logo"></a>
						<a href="index.jsp" class="retina-logo" data-dark-logo="images/logo-dark@2x.png"><img src="images/logo@2x.png" alt="SQUAD Logo"></a>
					</div><!-- #logo end -->

					<!-- Primary Navigation
					============================================= -->
					<nav id="primary-menu">
						<ul>
							<li class="current"><a href="index.jsp"><div>Home</div></a></li>
							<li><a href="About_us.jsp"><div>About Us</div></a></li>
							<li class="mega-menu"><a href="Contact_Us.jsp"><div>Contact Us</div></a></li>
							<% if(session.getAttribute("user")!=null) {%>
							<li><a href="Employee_Main.jsp"><div>Profile</div></a></li>
							<% }else if(session.getAttribute("admin")!=null) { %><li><a href="Admin_Main.jsp"><div>Profile</div></a></li>
							<% } else {%><li><a href="Super_Admin_Main.jsp"><div>Profile</div></a></li><%} %>
							 <li class="current"><a href="Change_Settings.jsp"><div>Change password</div></a></li>
							<li><a href="logout"><div>Logout</div></a></li> 
						</ul>	
					</nav>
				</div>
			</div>			
							
		</header><!-- #header end -->

		<!-- Page Title
		============================================= -->
		<%
				HttpSession user=request.getSession(false);
		
		
			if(user.getAttribute("admin")!=null)
			{
				
			}
			else if(user.getAttribute("teaching")!=null || user.getAttribute("non-teaching")!=null)
			{
				RequestDispatcher rd=request.getRequestDispatcher("/Employee_Main.jsp");
				rd.forward(request, response);
			}
			else if(user.getAttribute("superAdmin")!=null)
			{
				RequestDispatcher rd=request.getRequestDispatcher("/Super_Admin_Main.jsp");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
			}
	
		%>
		<section id="page-title">

			<div class="container clearfix">
				<h1>Add New Employee</h1>
				
			</div>

		</section><!-- #page-title end -->

		<!-- Content
		============================================= -->
		<section id="content">
			

			<div class="content-wrap">

				<div class="container clearfix">

					<div class="tabs divcenter nobottommargin clearfix" id="tab-login-register" style="max-width: 500px;">

						<ul class="tab-nav tab-nav2 center clearfix">
						

							
						</ul>

						<div class="tab-container">

							<div class="tab-content clearfix" id="tab-login">
								<div class="card nobottommargin">
									
								</div>
							</div>

							<div class="tab-content clearfix" id="tab-register">
								<div class="card nobottommargin">
									<div class="card-body" style="padding: 40px;">
										<h3>Add New Employee</h3>

										<form id="register-form" name="register-form" class="nobottommargin" action="Add_new_Employee" method="post">
												
											<span style="color:red"><%=(request.getAttribute("errormessage") == null) ? "" : request.getAttribute("errormessage")%></span>
											<span style="color:red"><%=(request.getAttribute("successmessage") == null) ? "" : request.getAttribute("successmessage")%></span>
												
											<div class="col_full">
												<label for="register-form-name">First Name:</label>
												<input type="text" id="register-form-name" name="Fname" value="" class="form-control" />
											</div>

											<div class="col_full">
												<label for="register-form-name">Last Name:</label>
												<input type="text" id="register-form-name" name="Lname" value="" class="form-control" />
											</div>

											<div class="col_full">
												<label for="register-form-email">EmployeeId:</label>
												<input type="text" id="register-form-email" name="Eid" value="" class="form-control" required/>
											</div>
											
											<div class="col_full">
												<label for="register-form-email">Email Address:</label>
												<input type="Email" id="register-form-email" name="Email" value="" class="form-control" required/>
											</div>

												<div class="col_full">
												<label for="register-form-password">Choose Password:</label>
												<input type="password" id="register-form-password" name="Password" value="" class="form-control" required />
											</div>

											<div class="col_full">
												<label for="register-form-phone">Phone Number:</label>
												<input type="Phone" id="register-form-phone" name="Phone_no" value="" class="form-control" />
											</div>

											<div class="col_full">
												<label for="register-form-phone">Date Of Joining:</label>
												<input type="date" id="register-form-phone" name="DOJ" value="" class="form-control" />
											</div>
											
											<div class="col_full">
											
												<label>Role:</label><br>
												<label>ADMIN<input type="radio" id="register-form-phone" name="Role" value="ADMIN" class="form-control"  checked/></label>
												
												<label>TEACHING<input type="radio" id="register-form-phone" name="Role" value="TEACHING" class="form-control"  /></label>
												
												<label>NON-TEACHING<input type="radio" id="register-form-phone" name="Role" value="NON-TEACHING" class="form-control"  /></label>
	
												
												
											 </div>


											<div id="showADMIN" class="Roles">
														<div class="col_full">
															<label for="register-form-repassword">Designation:</label>
															<select class="form-control" id="exampleFormControlSelect1" name="DesignationNonTeaching">
																<option>Account Officer</option>
																<option>Admin Officer</option>
																<option>Librarian</option>
																<option>Assistant Librarian</option>
																<option>Professional Librarian</option>
																<option>Library Assistant</option>
																<option>General Assistant</option>
																<option>Office Assistant</option>
																<option>Accounts Assistant</option>
																<option>Technical Assistant</option>
																<option>Lab Assistant</option>
																<option>Assistant</option>
																<option>Receptionist</option>
																<option>Attendant</option>
																

																
															</select>
														</div>

														

														<div class="col_full">
															<label for="register-form-phone">Casual Leaves:</label>
															<input type="number" id="register-form-phone" name="CasualLeaveNonTeaching"  class="form-control" value="8" />
														</div>


														

														<div class="col_full">
															<label for="register-form-phone">Medical Leaves:</label>
															<input type="number" id="register-form-phone" name="MedicalLeavesNonTeaching" value="10" class="form-control" />
														</div>


														<div class="col_full">
															<label for="register-form-phone">EL Leaves:</label>
															<input type="number" id="register-form-phone" name="ElLeavesNonTeaching" value="15" class="form-control" />
														</div>


											</div>

											<div id="showTEACHING" class="Roles">


														<div class="col_full">
															<label for="register-form-repassword">Designation:</label>
															<select class="form-control" id="exampleFormControlSelect1" name="DesignationTeaching">
																<option>HOD</option>
																<option>Assistant Professor</option>
																<option>Associate Professor</option>
																<option>Reader</option>
																<option>Professor</option>
																
															</select>
														</div>

														<div class="col_full">
															<label for="register-form-repassword">Branch:</label>
															<select class="form-control" id="exampleFormControlSelect1" name="BranchTeaching">
																<option>CSE-M</option>
																<option>CSE-E</option>
																<option>IT-M</option>
																<option>IT-E</option>
																<option>ECE-M</option>
																<option>ECE-E</option>
																<option>EEE</option>
															</select>
														</div>
														

														<div class="col_full">
															<label for="register-form-phone">Casual Leaves:</label>
															<input type="number" id="register-form-phone" name="CasualLeaveTeaching"  class="form-control" value="8" />
														</div>


														

														<div class="col_full">
															<label for="register-form-phone">Medical Leaves:</label>
															<input type="number" id="register-form-phone" name="MedicalLeavesTeaching" value="10" class="form-control" />
														</div>

														<div class="col_full">
															<label for="register-form-phone">Special Causual Leaves:</label>
															<input type="number" id="register-form-phone" name="SpecialCasualLeaveTeaching" value="8" class="form-control" />
														</div>

														

														<div class="col_full">
															<label for="register-form-phone">On Duty Leave:</label>
															<input type="number" id="register-form-phone" name="OnDutyLeaveTeaching" value="4" class="form-control" />
														</div>
											</div>

											<div id="showNON-TEACHING" class="Roles">
												<div class="col_full">
													<label for="register-form-repassword">Designation:</label>
													<select class="form-control" id="exampleFormControlSelect1" name="DesignationNonTeaching">
														<option>Account Officer</option>
														<option>Admin Officer</option>
														<option>Librarian</option>
														<option>Assistant Librarian</option>
														<option>Professional Librarian</option>
														<option>Library Assistant</option>
														<option>General Assistant</option>
														<option>Office Assistant</option>
														<option>Accounts Assistant</option>
														<option>Technical Assistant</option>
														<option>Lab Assistant</option>
														<option>Assistant</option>
														<option>Receptionist</option>
														<option>Attendant</option>
														

														
													</select>
												</div>

												

												<div class="col_full">
													<label for="register-form-phone">Casual Leaves:</label>
													<input type="number" id="register-form-phone" name="CasualLeaveNonTeaching"  class="form-control" value="8" />
												</div>


												

												<div class="col_full">
													<label for="register-form-phone">Medical Leaves:</label>
													<input type="number" id="register-form-phone" name="MedicalLeavesNonTeaching" value="10" class="form-control" />
												</div>


												<div class="col_full">
													<label for="register-form-phone">EL Leaves:</label>
													<input type="number" id="register-form-phone" name="ElLeavesNonTeaching" value="15" class="form-control" />
												</div>

											</div>
											

											

											<!-- <div class="col_full nobottommargin">

												 <button class="button button-border button-rounded button-fill fill-from-bottom button-black" ><span>Add new Employee</span><a href="#"></a></button>
											</div> -->

											<div class="col_full nobottommargin">

												 <button type="submit" form="register-form" class="button button-border button-rounded button-fill fill-from-bottom button-black"><span>Add new Employee</span></button>
											</div>

											<!-- <div class="col_full nobottommargin">
												<button class="button button-border button-rounded button-fill fill-from-bottom button-black"   data-notify-type="success" data-notify-msg="<i class=icon-ok-sign></i> User Added Successfully!" onclick="SEMICOLON.widget.notifications(this);setTimeout(function() {window.location='#'}, 3000);return false;"><span>Add new Employee</span><a href="#"></a></button>
											</div> -->

										</form>
									</div>
								</div>
							</div>

						</div>

					</div>

				</div>

			</div>

		</section><!-- #content end -->

		<!-- Footer
		============================================= -->
		<footer id="footer">
			<!-- Copyrights
			============================================= -->
			<div id="footer">

				<div class="container clearfix">

					<div class="col_half">
						
						<div class="copyright-links"><a href="index.jsp">Home</a> / <a href="About_us.jsp">About Us</a>/ <a href="Contact_Us.jsp">Contact Us</a> <% if((session.getAttribute("non-teaching")!=null)||(session.getAttribute("teaching")!=null)||(session.getAttribute("admin")!=null) ||(session.getAttribute("superAdmin")!=null)) {%>/ <a href="Change_Settings.jsp">Change Password</a> / <a href="logout">Logout</a><% }%></div>
					</div>

					<div class="col_half col_last tright">
						<div class="fright clearfix">
							
						</div>

						<div class="clear"></div>

						<i class="icon-envelope2"></i> msitlm.19@gmail.com <span class="middot">&middot;</span> <i class="icon-headphones"></i> +91-7889595329<span class="middot">&middot;</span> 
					</div>

				</div>

			</div><!-- #copyrights end -->

		</footer><!-- #footer end -->

	</div><!-- #wrapper end -->

	<!-- Go To Top
	============================================= -->
	<div id="gotoTop" class="icon-angle-up"></div>

	<!-- External JavaScripts
	============================================= -->
	<script src="js/jquery.js"></script>
	<script src="js/plugins.js"></script>

	<!-- Footer Scripts
	============================================= -->
	<script src="js/functions.js"></script>

</body>
</html>