<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.ResultSet"%>
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
	<title>Review Update Empolyee Records</title>

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
				<h1>Review Updated Employee Leaves</h1>
			</div>

		</section><!-- #page-title end -->

		<!-- Content
		============================================= -->
		<section id="content">
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
				<div class="container clearfix">
					<%
						HttpSession s1=request.getSession(false);
						ResultSet rs=(ResultSet)session.getAttribute("ReviewResultSet");
					%> 

				

			 			&nbsp;
			 			&nbsp;

						<% if(rs.next()==true){ rs.previous(); %>
						 	<table class="table table-bordered table-striped">
							    <thead>
									<tr>
									   <th>Eid </th>
									   <th>Type Of Leave </th>
									   <th>Start Date</th>
									   <th>End Date</th>
									   <th>Start Time</th>
									   <th>End Time</th>
									   <th>No Of Days</th>
									   <th>Reason</th>
									   <th>Reject Approval</th>
									</tr>
							  	</thead>
					  			
								<% int count=1; %>
					  
								<% while(rs.next()){%>
									<tbody>
										<form action="ReviewUpdatedLeavesDeleter_Admin_Servlet" method="post">
										 <tr>
										 	<td><code><strong><% out.println(rs.getString("Eid"));  %></strong></code><input type="hidden" name="Eid<%= count %>" value="<%= rs.getString("Eid")%>"></td>
										 	<td><% out.println(rs.getString("Type_Of_Leave"));  %><input type="hidden" name="Type_Of_Leave<%= count %>" value="<%= rs.getString("Type_Of_Leave")%>"></td>
										  	<td><% out.println(rs.getString("Start_Date")); %><input type="hidden" name="Start_Date<%= count %>" value="<%= rs.getString("Start_Date")%>"></td>
										   	<td><% out.println(rs.getString("End_Date"));  %><input type="hidden" name="End_Date<%= count %>" value="<%= rs.getString("End_Date")%>"></td>
										    <td><% out.println(rs.getString("Begin_Time"));%></td>
										    <td><% out.println(rs.getString("End_Time"));%></td>
										  	<td><% out.println(rs.getFloat("No_Of_Days"));  %></td>
										    <td><% out.println(rs.getString("Remarks"));  %></td>
											<td><button  class="button button-border button-rounded button-fill fill-from-bottom button-black" value="<%= count%>" name="counterValue"><i class="fas fa-user-minus"></i><span> Click to Remove this Approval</span></button></td>
										 	<% count++; %>
										 </tr>
										</form>
									</tbody>
							
								<% } %>
							</table>
							&nbsp;
			 				&nbsp;
						<% }else{%>
							<div class="divcenter border-color " data-animate="rubberBand" >
								<center><h1><span>No Leaves To Approve.</span></h1></center>

							</div>
							
						<% } %>
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