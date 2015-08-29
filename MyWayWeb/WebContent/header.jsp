<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,700,500,900'
	rel='stylesheet' type='text/css'>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script type="text/javascript" src="js/common/dojo.js"></script>
<script
     src="http://maps.googleapis.com/maps/api/js">
</script>

<script src="js/common/skel.min.js"></script>
<script src="js/common/skel-panels.min.js"></script>
<script src="js/common/init.js"></script>
<style type="text/css">

#busy_indicator {
	z-index: 1000;
	position: fixed;
	top: 0;
	bottom: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background: #555;
	opacity: 0.2;
	-moz-opacity: 0.2;
	filter: alpha(opacity = 2);
	font-weight: bold;
	text-align: center;
	font-size: 2em;
	color: gray;
	visibility: hidden;
	display: table;
}

#span_img {
	display: table-cell;
	vertical-align: bottom;
	display: block;
	height: 50%;
}

#load_img {
	padding-top: 22%;
}
</style>
<div id="busy_indicator">
	<span id="span_img"><img id="load_img" src="images/busy.gif"
		height="35" width="43" alt="busy indicator" /></span>
</div>