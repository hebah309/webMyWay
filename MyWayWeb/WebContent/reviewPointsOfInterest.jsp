<!DOCTYPE HTML>
<html>
<head>
<title>Review PointsOfInterest</title>
<%@include file="header.jsp"%>
<script type="text/javascript" src="js/PointsOfInterest.js"></script>
<link
	href='css/table.css'
	rel='stylesheet' type='text/css'>
<style type="text/css">
#pointsTable table, th, td {
	border: 1px solid black;
}


</style>
</head>
<body onload="loadPOIs()">
	<!-- Header -->
	<div id="header">
		<div id="nav-wrapper">
			<!-- Nav -->
			<nav id="nav">
				<ul>
					<li><a href="#">Review Points</a></li>
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
				<form id="formApprove" action="PointsOfInterest" method="post">
					<table id="pointsTable" class="CSSTableGenerator">
						<thead>
							<tr>
								<td>point of Interest Name</td>
								<td>Location</td>
								<td>Approval</td>
							</tr>
						</thead>
						<tbody>
							<tr id="hiddenid"></tr>
							<tr id="hiddenChoice"></tr>
							<tr id="action"><td><input type="hidden" name="action" value="ReviewPOI"></td></tr>
						</tbody>
					</table>
					<br/>
					<br/>
					<p><input type="button" value="submit" onclick="submitReviewForm();"></p><p id= "checkedError"></p>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>

