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
					<h1 class="header">Pending Traffic Reports</h1>
					<form action="deleteTrafficReport" method="post">
						<table id="roadReports" class="CSSTableGenerator">
<!-- 						style="border-color: black; border-style: solid; border-width: 3px; border-collapse: collapse;"
 -->							<tr>
								<th>Report Type</th>
								<th>Report Comment</th>
								<th>Location</th>
								<th>Action</th>
							</tr>

							<%
 								TrafficReportsDao trafficReports = new TrafficReportsDaoImpl();
 								List<TrafficReport> list = trafficReports.getAllTrafficReports();
 								
								for (int i = 0; i < list.size(); i++) {

									out.println("<tr>");

									String reportType = "";
									int reportTypeId = list.get(i).getReportTypeId();
									
									switch (reportTypeId) {
						            case 1:  reportType = "Other";
						                     break;
						            case 2:  reportType = "Construction";
						                     break;
						            case 3:  reportType = "On Road";
						                     break;
						            case 4:  reportType = "Moderate";
						                     break;
						            case 5:  reportType = "Heavy";
						                     break;
						            case 6:  reportType = "stand Still";
						                     break;
						            case 7:  reportType = "Minor Accident";
						                     break;
						            case 8:  reportType = "Major Accident";
						                     break;
						            default: reportType = "other";
						                     break;
						        }
									
									out.print("<td><font size='3'>");
									out.print(reportType);
									out.print("</font></td>");


									out.print("<td><font size='3'>");
									out.print(list.get(i).getComment());
									out.print("</font></td>");



									out.print("<td>");

									out.print("<a href='/MyWayWeb/viewMapsbyCoordinates.jsp?lat="+list.get(i).getLat()+
											"&lon="+list.get(i).getLon()+"'><font size='4'>View Map</font></a>");

									out.print("</td>");


									out.print("<td>");
									
									out.print("<input type=\"radio\" name=\"delete"
													+ "\" value="+list.get(i).getReportId()+">Delete");
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