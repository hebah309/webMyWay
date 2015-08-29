<!DOCTYPE HTML>
<html>
<head>
<title>add report test</title>
<%@include file="header.jsp"%>
<script type="text/javascript" src="js/reports.js"></script>
</head>
<body>
	<!-- Header -->
	<div id="header">
		<div id="nav-wrapper">
			<!-- Nav -->
			<nav id="nav">
				<ul>
					<li><a href="#">add report test</a></li>
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
					<h1>Add Report</h1>
					<form>
						Report Type: <br> <select id="type">
							<option value="Accident">Accident</option>
							<option value="Traffic">Traffic Jam</option>
							<option value="Blocked">Blocked Road</option>
							<option value="Construction">Road Constructions</option>
						</select> <br> Report Description: <br> <input type="text"
							id="description"> <br> Traffic Density: <br> <select
							id="density">
							<option value="Extreme">Extreme</option>
							<option value="High">High</option>
							<option value="Moderate">Moderate</option>
							<option value="Low">Low</option>
						</select> <br> longtitude: <br> <input type="text"
							id="longtitude"> <br> latitude: <br> <input
							type="text" id="latitude"> <br>
						<button type="button" name="submit" onClick="addJSONReport();">Submit</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>