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

				<div class="container clearfix" >
					<div class="row">
						<div class="col-sm-12">

							<div class="col_full center" style="margin-top: 10%;" data-animate="pulse">

								

									<a href="#myModal1" data-lightbox="inline"><button  class="button button-border button-rounded button-fill fill-from-bottom button-black"><i class="fas fa-user-check"></i><span> Review User's Leave</span></button></a>

									<!-- Modal 1 -->
									<div class="modal1 mfp-hide" id="myModal1">
										<div class="block divcenter" style="background-color: #FFF; max-width: 500px;">
											<div class="feature-box fbox-center fbox-effect nobottomborder nobottommargin" style="padding: 40px;">
												<div class="fbox-icon">
													<i class="icon-screen i-alt"></i>
												</div>
												<h3>Review User's Leave<span class="subtitle">Leaves applied by Employees can be reviewed here.</span></h3>
											</div>
											<div class="section center nomargin" style="padding: 30px;">
												<a href="Review_Leaves.jsp" class="button" >Click To Review User's Leaves.</a>
											</div>
										</div>
									</div>
									
									<a href="#myModal2" data-lightbox="inline"><button  class="button button-border button-rounded button-fill fill-from-bottom button-black"><i class="fas fa-user-minus"></i><span> Delete User's Leave</span></button></a>

									<!-- Modal 2 -->
									<div class="modal1 mfp-hide" id="myModal2">
										<div class="block divcenter" style="background-color: #FFF; max-width: 500px;">
											<div class="feature-box fbox-center fbox-effect nobottomborder nobottommargin" style="padding: 40px;">
												<div class="fbox-icon">
													<i class="icon-screen i-alt"></i>
												</div>
												<h3>Delete User's Leave<span class="subtitle">Leaves applied by Employees can be deleted here.</span></h3>
											</div>
											<div class="section center nomargin" style="padding: 30px;">
												<a href="DeleteUserLeaves_SA.jsp" class="button" >Click To Delete User's Leaves.</a>
											</div>
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
			<div id="copyrights">

				<div class="container clearfix">

					<div class="col_half">
						
						<div class="copyright-links"><a href="index.jsp">Home</a> / <a href="About_us.jsp">About Us</a>/ <a href="Contact_Us.jsp">Contact Us</a> <% if((session.getAttribute("non-teaching")!=null)||(session.getAttribute("teaching")!=null)||(session.getAttribute("admin")!=null)||(session.getAttribute("superAdmin")!=null)) {%>/ <a href="Change_Settings.jsp">Change Password</a> / <a href="logout">Logout</a><% }%></div>
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