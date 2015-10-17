<!DOCTYPE HTML>
<html>
	<head>
		<title>Home Page</title>
		 <meta charset="utf-8">
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<link href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,700,500,900' rel='stylesheet' type='text/css'>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
		<script src="js/common/skel.min.js"></script>
		<script src="js/common/skel-panels.min.js"></script>
		<script src="js/common/init.js"></script>
	<style>
	.header{
	color: #669999;
	font-weight:bold;
	font-size:20px;
	
	}
	.imgSize{
	height:50px;
	width:50px;
	display: inline;
	}
	.pa{
	display: inline;
	}
	
	.imagepad{
	padding-left:100px;
	height:50px;
	width:50px;
	display: inline;
	}
	</style>
	</head>
	<body class="homepage">

	<!-- Header -->
		<div id="header">
			<div id="nav-wrapper"> 
				<!-- Nav -->
				<nav id="nav">
					<ul>
						<li><a href="home.jsp">Home</a></li>
						<li><a href="CheckLogin">Log In</a></li>
				        <li><a href="register.jsp">Register</a></li>
					</ul>
				</nav>
			</div>
			<div class="container"> 
				
				<!-- Logo -->
				<div id="logo">
				    <h1><a href="#">MyWay</a></h1>
					<span class="tag">Make Your Way Clear</span>
				</div>
				
			</div>
		</div>
	<!-- Content -->
	<div id="content" >
		<header style=background-color:white>
			<h2 class="header">About US</h2>
			<img src="images/qo.png" class="imgSize">
			<pre class="pa">MyWay is a project developed by Kuwaiti graduates undergoing a training course sponsored by the Public Institute For Social Security and powered by IBM. 
			The project targets locals and foreigners in Kuwait. It is a service that will help people find their way around Kuwait with different kinds of functions such as 
			finding the fastest route, saving preferred routes and notifying the user of favorite close by places. With this application,
			people can find their way around Kuwait much easier.</pre><pre>							    					 					<img src="images/qc.png" class="imgSize"></pre>
 
 <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=true"></script>
    
<br>
    <article >

    </article>
   
<script>
function success(position) {
  var mapcanvas = document.createElement('div');
  mapcanvas.id = 'mapcontainer';
  mapcanvas.style.height = '300px';
  mapcanvas.style.width = '100%';
  mapcanvas.style.marginleft = '50px';

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
 
		</header>
					
	</div>

	<!-- Copyright -->
		<!-- <div id="copyright">
			<div class="container">
				<h2>Copyright.PIFSS.Kuwait.</h2>
			</div> -->
		<!-- </div> -->
<%@include file="footer.jsp"%>
	</body>
</html>