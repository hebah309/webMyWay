<!DOCTYPE HTML>
<html>
<head>
<title>Post Point of interest</title>
<%@include file="header.jsp"%>
<script type="text/javascript" src="js/PointsOfInterest.js"></script>
<link
	href='css/table.css'
	rel='stylesheet' type='text/css'>
	
	<style>
	.header{
	color: #669999;
	text-decoration: underline;
	font-weight:bold;
	font-size:20px;
	
	}
	
	</style>
</head>
<body onload="loadPOITypes()">
	<!-- Header -->
	<div id="header">
		<div id="nav-wrapper">
			<!-- Nav -->
			<nav id="nav">
				<ul>
					<li><a href="#">Post Point of interest</a></li>
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
					<form action="PointsOfInterest" method="post" id="poiForm" >

						<fieldset id="Address">
							<legend class="header">Address</legend>
							<p>
								<span class="error">* required field.</span>
							</p>
							<table class="CSSTableGenerator">
								<tbody>
									<tr>
										<td>Name :</td>
										<td><input id="Name" name="Name" type="text"
											placeholder="Type a Name"><span class="error">*</span></td>
										<td id="nameError" style="color: red"></td>
									</tr>
									<tr>
										<td>Type:</td>
										<td><select id="TypeSelection" name="TypeSelection">
												<option selected value=""></option>
												<!-- GET FROM DB -->
										</select> <span class="error">*</span></td>
										<td id="typeError" style="color: red"></td>
									</tr>
									<tr>
										<td>Description :</td>
										<td><input id="Description" name="Description"
											type="text" placeholder="Description"></td>
										<td></td>
									</tr>
								</tbody>
							</table>
							<br> <br>
							<input type="hidden" name="action" value="PostPOI" />
							<input type="button" value="Submit" onclick="submitPOIForm();"/>
							<input type="reset" value="Reset" onclick="resetfields();" />
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>