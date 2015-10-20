<!DOCTYPE HTML>
<html>
<head>
<title>Review Events</title>
<%@include file="header.jsp"%>
<script type="text/javascript" src="js/events.js"></script>
<link
	href='css/table.css'
	rel='stylesheet' type='text/css'>
<style type="text/css">
#pointsTable table, th, td {
	border: 1px solid black;
}


</style>
</head>
<body onload="loadEvents()">
	<!-- Header -->
	<div id="header">
		<div id="nav-wrapper">
			<!-- Nav -->
			<nav id="nav">
				<ul>
					<li><a href="#">Review Events</a></li>
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
				<form id="formApprove" action="reviewEvents" method="post">
					<table id="eventsTable" class="CSSTableGenerator">
						<thead>
							<tr>
								<td>Event Name</td>
								<td>Description</td>
								<td>Category</td>
								<td>Start Date</td>
								<td>End Date</td>
								<td>location</td>
								<td>Approval</td>
							</tr>
						</thead>
						<tbody>
							<tr id="hiddenid"></tr>
							<tr id="hiddenChoice"></tr>
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

