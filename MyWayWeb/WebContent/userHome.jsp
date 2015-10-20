<!DOCTYPE HTML>
<html>
<head>
<title>User Home</title>
<%@include file="header.jsp" %>

<style>
.title{
color: #FF6600;
font-weight: bold;
}
</style>
</head>
<body>
	<!-- Header -->
	<div id="header">
		<div id="nav-wrapper">
			<!-- Nav -->
			<nav id="nav">
				<ul>
					<li><a href="#">User Home</a></li>
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
							<h2>Welcome <c:out value="${sessionScope.user.userName}"></c:out></h2>
						</header>
								<img alt="" src="images/uploadedImages/avatar.jpg">
							
								<h3 class="title"> User Name:</h3>
								<h3><c:out value="${sessionScope.user.userName}"></c:out></h3>
								<h3 class="title"> E-mail:</h3>
								<h3><c:out value="${sessionScope.user.email}"></c:out></h3>
							
						<br/><br/>
						<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=true"></script>
    
<br>
    <article >

    </article>
   
<script>
function success(position) {
  var mapcanvas = document.createElement('div');
  mapcanvas.id = 'mapcontainer';
  mapcanvas.style.height = '300px';
  mapcanvas.style.width = '400px';
/*   mapcanvas.style.marginleft = '50px'; */

  document.querySelector('article').appendChild(mapcanvas);

  var coords = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
  
  var options = {
    zoom: 15,
    center: coords,
    mapTypeControl: false,
    navigationControlOptions: {
    	style: google.maps.NavigationControlStyle.SMALL
    },
    mapTypeId: google.maps.MapTypeId.ROADMAP
  };
  var map = new google.maps.Map(document.getElementById("mapcontainer"), options);

  var marker = new google.maps.Marker({
      position: coords,
      map: map,
      title:"You are here!"
  });
}

if (navigator.geolocation) {
  navigator.geolocation.getCurrentPosition(success);
} else {
  error('Geo Location is not supported');
}

</script>
					</section>
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>