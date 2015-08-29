<!DOCTYPE HTML>
<html>
<head>
<title>Login</title>
<%@include file="header.jsp"%>
</head>
<body>
	<!-- Header -->
	<div id="header">
		<div id="nav-wrapper">
			<!-- Nav -->
			<nav id="nav">
				<ul>
					<li><a href="home.jsp">Home</a></li>
					<li><a href="#">Login</a></li>
				</ul>
			</nav>
		</div>

	</div>
	<!-- Header -->

	<!-- Main -->
	<div id="main">
		<div class="container">
			<div class="row">
				<!-- Content -->
				<div id="content" class="8u skel-cell-important">
					<section>
						<header>
							<h2>User Login</h2>
						</header>
					<!-- 	<div class="row">
							<section class="6u">
								<ul class="default">
									<li><a href="register.jsp">Register from here</a></li>
								</ul>
							</section>
						</div> -->
						<form action="Login" method="post">
							<h3>Enter user name</h3>
							<input type="text" name="userName" required><br>
							<h3>Enter Password</h3>
							<input type="hidden" name="loginType" value="webLogin" />
							<input type="password" name="passWord" required><br>
							<input value="submit" type="submit">
							<%
								boolean fl = Boolean.valueOf((request.getParameter("invalidLogin")));

								String msg = "";

								if (fl == true) {
									msg = "Username or password doesn't exist";
								}
							%>
						</form><br/>
						<div style="color: red;"><%=msg%></div>
					</section>
				</div>

			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>