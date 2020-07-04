<!DOCTYPE html>
<html dir="ltr" lang="en-US">
<head>
	<style type="text/css" media="all">
	  p{margin-top: 300px;}
	</style>
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
	<title>View Panel</title>

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
				<h1>View Your Employees</h1>
				
			</div>

		</section><!-- #page-title end -->

		<!-- Content
		============================================= -->
		<section >
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

			<div class="content-wrap">

				<div class="container clearfix">

						<div class="clear"></div><div class="line"></div>

								
													
								<form   action="View_User" method="post">
									<span style="color:red"><%=(request.getAttribute("errormessage") == null) ? "" : request.getAttribute("errormessage")%></span>
										
										<label for="inputform" style="padding-left: 26%;">Eid:</label>
										<div class="col-md-12 ">

											
												<div class="col-md-12" style="padding-left: 25%; padding-right: 25%;">
												
												<input  id="inputform" class="form-control mr-sm-0 bg-light navbar-primary" type="number"  aria-label="Search" name="Eid" placeholder="Enter Eid To Continue" required />

											
											</div>
											
											
										</div>
										<br>
									
										<div class="col-md-12 center">
											<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
										</div>	

							

												
									
										
								</form>	
								
						<div class="clear"></div><div class="line"></div>
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