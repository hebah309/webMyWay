<%@ page import="model.*,java.util.*,dao.*" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Review Reports</title>
<%@include file="header.jsp"%>
<style>
#roadReports table, th, td {
	border: 1px solid black;
}

	.header{
	color: #669999;
	text-decoration: underline;
	font-weight:bold;
	font-size:20px;
	
	}
</style>
<link
	href='css/table.css'
	rel='stylesheet' type='text/css'>
</head>
<body>
	<!-- Header -->
	<div id="header">
		<div id="nav-wrapper">
			<!-- Nav -->
			<nav id="nav">
				<ul>
					<li><a href="#">Traffic Reports</a></li>
				</ul>
			</nav>
		</div>
	</div>
	<div id="main">
		<div class="container">
			<div class="row">
				<div id="sidebar" class="4u">
					<section>
						<header>
							<h2>Menu</h2>
						</header>
						<%@include file="leftHandNavigation.jsp"%>
					</section>
				</div>
				<!-- Content -->
				<div id="content" class="8u skel-cell-important">
					<h1 class="header">Traffic Reports</h1>
						<table id="roadReports" class="CSSTableGenerator">
<!-- 						style="border-color: black; border-style: solid; border-width: 3px; border-collapse: collapse;"
 -->							<tr>
								<th>Report ID</th>
								<th>Report Type</th>
								<th>Report Comment</th>
								<th>Location</th>
							</tr>

							<%
 								TrafficReportsDao trafficReports = new TrafficReportsDaoImpl();
 								List<TrafficReport> list = trafficReports.getAllTrafficReports();
 								
								for (int i = 0; i < list.size(); i++) {

									out.println("<tr>");

									out.print("<td><font size='3'>");
									out.print(list.get(i).getReportId());
									out.print("</font></td>");

									out.print("<td><font size='3'>");
									out.print(list.get(i).getReportTypeId());
									out.print("</font></td>");

									out.print("<td><font size='3'>");
									out.print(list.get(i).getComment());
									out.print("</font></td>");



									out.print("<td>");

									out.print("<a href='/MyWayWeb/viewMapsbyCoordinates.jsp?lat="+list.get(i).getLat()+
											"&lon="+list.get(i).getLon()+"'><font size='4'>View Map</font></a>");

									out.print("</td>");

									out.println("</tr>");
								}
							%>
							
						</table>
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>