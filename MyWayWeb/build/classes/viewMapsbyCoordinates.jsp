<!DOCTYPE html>
<html>
  <head>
    <title>view Location Map</title>
    <%@include file="header.jsp" %>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    
    <% 

String lat = request.getParameter("lat"); 

String lon = request.getParameter("lon"); 

%>
    <style>
      html, body, #map-canvas {
        height: 100%;
        margin: 0px;
        padding: 0px
      }
    </style>
    <!-- <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&signed_in=true&libraries=places"></script> -->
    <script>
var map;
var infowindow;



function initialize() {
  var pyrmont = new google.maps.LatLng(<%= lat %>,<%= lon %>);

  map = new google.maps.Map(document.getElementById('map-canvas'), {
    center: pyrmont,
    zoom: 8
  });

  var marker = new google.maps.Marker({
      position: pyrmont,
      map: map,
      title: 'report Location'
  });

  
}
google.maps.event.addDomListener(window, 'load', initialize);

    </script>
  </head>
  <body>
	<div id="header">
		<div id="nav-wrapper">
			<!-- Nav -->
			<nav id="nav">
				<ul>
					<li><a href="#">View Map</a></li>
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
					<h1>Location</h1>
    				<div id="map-canvas" style="height: 500px;width: 800px;"></div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>

