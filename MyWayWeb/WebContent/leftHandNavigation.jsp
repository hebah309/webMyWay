

<div class="row">
	<section class="6u">
	
		<c:choose>
			<c:when test="${sessionScope.isAdmin == 'true'}">
				<ul class="default">
					<li><a href="admin.jsp">Admin home</a></li>
					<li><a href="reviewEvents.jsp">Review Events</a></li>
					<li><a href="ReviewTrafficReports.jsp">Review Traffic Reports </a></li>
					<li><a href="Logout">Log out</a></li>
				</ul>
			</c:when>
			<c:otherwise>
				<ul class="default">
					<li><a href="userHome.jsp">Home</a></li>
					<li><a href="viewApprovedEvents.jsp">View Events</a></li>
					<li><a href="viewTrafficReports.jsp">view Traffic Reports</a></li>
					<li><a href="Logout">Log out</a></li>
				</ul>
			</c:otherwise>
		</c:choose>


	</section>

</div>