<!DOCTYPE HTML>
<html>
<head>
<title>view Events</title>
<%@include file="header.jsp" %>
<link
	href='css/table.css'
	rel='stylesheet' type='text/css'>
<style type="text/css">
#pois table, th, td {
	border: 1px solid black;
}
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
					<li><a href="#">view Events</a></li>
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
								<table id="approvedEventsTable" class="CSSTableGenerator">
									<thead>		
										<tr>
											<td>Event Name</td>
											<td>Description</td>
											<td>Category</td>
											<td>Start Date</td>
											<td>End Date</td>
											<td>location</td>
										</tr>
									</thead>
								</table><br>
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp" %>
	
		<script type="text/javascript">
	
	$( document ).ready(function() {
		dojo
		.xhrGet({
			url : "/MyWayWeb/viewEvents",
			timeout : 5000,
			headers : {
				"Content-Type" : "application/json"
			},
			preventCache : true,
			handleAs : "json",
			handle : function(events, ioArgs) {
				for (var i = 0; i < events.length; i++) {
					var eventsTableVar = document
							.getElementById("approvedEventsTable");
					var eventsTableLength = eventsTableVar.rows.length;
					var row = eventsTableVar.insertRow(eventsTableLength);

					var id = events[i].id;

					var cell1 = row.insertCell(0);
					var cell2 = row.insertCell(1);
					var cell3 = row.insertCell(2);
					var cell4 = row.insertCell(3);
					var cell5 = row.insertCell(4);
					//var cell6 = row.insertCell(5);
					var cell6 = row.insertCell(5);
					
					cell1.innerHTML = '<font size="3">'+events[i].name+'</font>';
					cell2.innerHTML = '<font size="3">'+events[i].description+'</font>';
					cell3.innerHTML = '<font size="3">'+events[i].category+'</font>';
					cell4.innerHTML = '<font size="3">'+events[i].startDate+'</font>';
					cell5.innerHTML = '<font size="3">'+events[i].endDate+'</font>';
				
					//cell6.innerHTML ="<a href='/MyWayWeb/viewImage.jsp?image="+events[i].image+"'><font size='4'>View Image</font></a>";
					cell6.innerHTML = "<a href='/MyWayWeb/viewMapsbyCoordinates.jsp?lat="+events[i].latitude+"&lon="+events[i].longitude+"'><font size='4'>View Map</font></a>";
				}
			}
		});
	}); 
	</script>
	
</body>
</html>