<!DOCTYPE HTML>
<html>
<head>
<title>Parents Monitoring</title>
<%@include file="header.jsp" %>
<script type="text/javascript" src="js/parentsMonitoring.js"></script>
<style type="text/css">
#parentsMonitoringTable table, th, td {
	border: 1px solid black;
}
</style>
<link
	href='css/table.css'
	rel='stylesheet' type='text/css'>
</head>
<body onload="getJourneys()">
	<!-- Header -->
	<div id="header">
		<div id="nav-wrapper">
			<!-- Nav -->
			<nav id="nav">
				<ul>
					<li><a href="#">Parents Monitoring</a></li>
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
						<%@include file="leftHandNavigation.jsp" %>
					</section>
				</div>
				<!-- Content -->
				<div id="content" class="8u skel-cell-important">
					<section>
						<header>
							<h2>Parents Monitoring</h2>
						</header>
						<br/><br/>
						<table id="parentsMonitoringTable" class="CSSTableGenerator">
							<tr>
								<th>User name</th>
								<th>Current Location</th>
								<th>Final Destination</th>
								<th>Speed</th>
								<th>Speed Average</th>
								<th>Stops</th>
							</tr>
						</table>
					</section>
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>