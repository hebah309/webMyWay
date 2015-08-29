<!DOCTYPE HTML>
<html>
<head>
<title>view Points of interest</title>
<%@include file="header.jsp" %>
<script type="text/javascript" src="js/PointsOfInterest.js"></script>
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
					<li><a href="#">view Points of interest</a></li>
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
						<p class="header">Type:</p>
								<select id="TypeSelection" name="TypeSelection">
										<option selected value=""></option>
												<!-- GET FROM DB -->
								</select> <span class="error">*</span>
						<br/><br/>
						<p class="header">Points of interest:</p>
								<table id="pois" class="CSSTableGenerator">
									<thead>
										<tr>
											<td>point of Interest Name</td>
											<td>Location</td>
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
	    console.log( "ready!" );
	
	    	$.getJSON( "/MyWayWeb/PointsOfInterest?action=loadPointOfInterest", function( resp ) {
	    		var $selected= $("#TypeSelection");
	    		var $myOpt = $("#PointsOfInterest ul li");
	    		var $pois = $("#pois");
 					$( "#TypeSelection").on('change', function (e) {
 						   var optionSelected = $("option:selected", this);
 						   var valueSelected = this.value;
 						   $.each( resp, function( key, value ) {
 							   if(optionSelected.text() == value.poiType){
 								  	var table = document.getElementById("pois");
 								  	var tableLength = table.rows.length;
 									var row = table.insertRow(tableLength);
 									var cell1 = row.insertCell(0);
 									var cell2 = row.insertCell(1);
 									cell1.innerHTML = value.namePOI;
 									cell2.innerHTML = "</td><td><a href='/MyWayWeb/viewMapsbyKeyWord.jsp?POI="+value.namePOI+"'>View Map</a>";   
 							   }		   
 						  });			    
 					});
	    	});
	}); 
	</script>
	
</body>
</html>