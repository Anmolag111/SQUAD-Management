<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

	<link rel="stylesheet" href="css/responsive.css" type="text/css" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />

	<!-- Document Title
	============================================= -->
	<title>Super-Admin Panel</title>

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
		<section id="page-title">

			<div class="container clearfix">
				<h1>Super-Admin Panel</h1>
				
			</div>

		</section><!-- #page-title end -->

		<!-- Content
		============================================= -->
		<section id="content">
			<%
				HttpSession user=request.getSession(false);
		
		
				if(user.getAttribute("superAdmin")!=null)
				{
					
				}
				else if(user.getAttribute("teaching")!=null || user.getAttribute("non-teaching")!=null)
				{
					RequestDispatcher rd=request.getRequestDispatcher("/Employee_Main.jsp");
					rd.forward(request, response);
				}
				else if(user.getAttribute("admin")!=null)
				{
					RequestDispatcher rd=request.getRequestDispatcher("/Admin_Main.jsp");
					rd.forward(request, response);
				}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
				}
	
			%>

			<div class="content-wrap">

				<div class="container clearfix">

					<div class="tabs divcenter nobottommargin clearfix" id="tab-login-register" style="max-width: 500px;">


						<div class="tab-container">

							<div class="tab-content clearfix" id="tab-login">
								<div class="card nobottommargin">
									
								</div>
							</div>
							<span style="color:red"><%=(request.getAttribute("successMessageDeleteSA") == null) ? "" : request.getAttribute("successMessageDeleteSA")%></span>
							<span style="color:red"><%=(request.getAttribute("errorMessageDeleteSA") == null) ? "" : request.getAttribute("errorMessageDeleteSA")%></span>
							

							<div class="tab-content clearfix" id="tab-register">
								<div class="card nobottommargin">
									<div class="card-body" style="padding: 40px;">
										<h3>Delete Employee Record</h3>

										<form id="register-form" name="register-form" class="nobottommargin" action="DeleteUserLeavesSA_Servlet" method="post">
												
											

											<div class="col_full">
												<label for="register-form-email">Employee Id:</label>
												<input type="text" id="register-form-email" name="Eid" value="" class="form-control" required/>
											</div>
											
										
											<div class="col_full">
																						
												<label>Role:</label><br>
												<label>ADMIN<input type="radio" id="register-form-phone" name="Role" value="ADMIN" class="form-control"  checked/></label>
												<label>TEACHING<input type="radio" id="register-form-phone" name="Role" value="TEACHING" class="form-control"  /></label>
												<label>NON-TEACHING<input type="radio" id="register-form-phone" name="Role" value="NON-TEACHING" class="form-control"  /></label>
												
											</div>

											<div id="showADMIN" class=Roles>

												<label>Type Of Leave:</label><br>
												<label>ML<input type="radio" id="register-form-phone" name="type_of_leave_ADMIN" value="ML" class="form-control"  checked/></label>
												<label>CL<input type="radio" id="register-form-phone" name="type_of_leave_ADMIN" value="CL" class="form-control"  /></label>
												<label>EL<input type="radio" id="register-form-phone" name="type_of_leave_ADMIN" value="EL" class="form-control"  /></label>
												<br>
												<br>

											</div>

											<div id="showTEACHING" class=Roles>

												<label>Type Of Leave:</label><br>
												<label>ML<input type="radio" id="register-form-phone" name="type_of_leave_TEACHING" value="ML" class="form-control"  checked/></label>
												<label>CL<input type="radio" id="register-form-phone" name="type_of_leave_TEACHING" value="CL" class="form-control"  /></label>
												<label>SCL<input type="radio" id="register-form-phone" name="type_of_leave_TEACHING" value="SCL" class="form-control"  /></label>
												<label>OD<input type="radio" id="register-form-phone" name="type_of_leave_TEACHING" value="OD" class="form-control"  /></label>
												<br>
												<br>
												
											</div>

											<div id="showNON-TEACHING" class=Roles>

												<label>Type Of Leave:</label><br>
												<label>ML<input type="radio" id="register-form-phone" name="type_of_leave_NON-TEACHING" value="ML" class="form-control"  checked/></label>
												<label>CL<input type="radio" id="register-form-phone" name="type_of_leave_NON-TEACHING" value="CL" class="form-control"  /></label>
												<label>EL<input type="radio" id="register-form-phone" name="type_of_leave_NON-TEACHING" value="EL" class="form-control"  /></label>
												<br>
												<br>

											</div>


											

											<div class="col_full">
																						
												<label>Duration:</label><br>
												<label>Full Day<input type="radio" id="register-form-phone" name="duration" value="FULL_DAY" class="form-control"  checked /></label>
												<label>Half Day<input type="radio" id="register-form-phone" name="duration" value="HALF_DAY" class="form-control"  /></label>
												
											</div>

											<div id="seeFULL_DAY" class="Duration">
												
												<div class="col_full">
													<label for="register-form-phone">Start Date:</label>
												    <input type="date" id="register-form-phone" name="start_date_FULLDAY"  class="form-control"  />
												</div>
												
												<div class="col_full">
													<label for="register-form-phone">End Date:</label>
												    <input type="date" id="register-form-phone" name="end_date_FULLDAY"  class="form-control"  />
												</div>
												
												

											</div>


											<div id="seeHALF_DAY" class="Duration">

												<div class="col_full">
													<label for="register-form-phone">Start Date:</label>
												    <input type="date" id="register-form-phone" name="start_date_HALFDAY"  class="form-control"  />
												</div>
												
												
											</div>


											<!-- <div class="col_full nobottommargin">

												 <button class="button button-border button-rounded button-fill fill-from-bottom button-black" ><span>Add new Employee</span><a href="#"></a></button>
											</div> -->

											<div class="col_full nobottommargin">
												
												 <button type="submit" form="register-form" class="button button-border button-rounded button-fill fill-from-bottom button-black"><span>Delete Employee Leaves</span></button>
											</div>


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