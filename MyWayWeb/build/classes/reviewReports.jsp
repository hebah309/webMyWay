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
					<li><a href="#">Review Reports</a></li>
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
					<h1 class="header">Pending Road Reports</h1>
					<form action="Reports" method="POST">
						<table id="roadReports" class="CSSTableGenerator">
<!-- 						style="border-color: black; border-style: solid; border-width: 3px; border-collapse: collapse;"
 -->							<tr>
								<th>Report ID</th>
								<th>Report Type</th>
								<th>Report Description</th>
								<th>Traffic Density</th>
								<th>Voice Notification</th>
								<th>Location</th>
								<th>Date And Time</th>
								<th>Set Status</th>
							</tr>

							<%
								ReportsDao reportsDao = new ReportsDoaImpl();
								List<IncidentReport> list = reportsDao.getAllPendingReports();

								for (int i = 0; i < list.size(); i++) {

									out.println("<tr>");

									out.print("<td>");
									out.print(list.get(i).getId());
									out.print("</td>");

									out.print("<td>");
									out.print(list.get(i).getReportType());
									out.print("</td>");

									out.print("<td>");
									out.print(list.get(i).getReportDescription());
									out.print("</td>");

									out.print("<td>");
									out.print(list.get(i).getTrafficDensity());
									out.print("</td>");
									
									out.print("<td>");

									if (list.get(i).getVoiceNotificationPath() == null)
										out.print("None");
									else {
										out.print("<audio controls>");
										out.print("<source src=\""
												+ list.get(i).getVoiceNotificationPath()
												+ "\" type=\"audio/mpeg\">");
										out.print("</audio>");
									}

									out.print("</td>");

									out.print("<td>");

									out.print("<a href='/MyWayWeb/viewMapsbyCoordinates.jsp?lat="+list.get(i).getLocation().getLatitude()+
											"&lon="+list.get(i).getLocation().getLongtitude()+"'>View Map</a>");

									out.print("</td>");

									out.print("<td>");
									out.print(list.get(i).getReportTime());
									out.print("</td>");

									out.print("<td>");

									out.print("<input type=\"radio\" name=\"" + list.get(i).getId()
											+ "\" value=\"approve\" checked>Approve");
									out.print("<input type=\"radio\" name=\"" + list.get(i).getId()
											+ "\" value=\"decline\">Decline");

									out.print("</td>");

									out.println("</tr>");
								}
							%>
						</table>
						<br>
						<button type="submit" name="submit">Submit</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>