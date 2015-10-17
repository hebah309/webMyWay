function loadEvents() {
	dojo
			.xhrGet({
				url : "/MyWayWeb/reviewEvents",
				timeout : 5000,
				headers : {
					"Content-Type" : "application/json"
				},
				preventCache : true,
				handleAs : "json",
				handle : function(events, ioArgs) {
					for (var i = 0; i < events.length; i++) {
						var eventsTableVar = document
								.getElementById("eventsTable");
						var eventsTableLength = eventsTableVar.rows.length;
						var row = eventsTableVar.insertRow(eventsTableLength);

						var id = events[i].id;

						var cell1 = row.insertCell(0);
						var cell2 = row.insertCell(1);
						var cell3 = row.insertCell(2);
						var cell4 = row.insertCell(3);
						var cell5 = row.insertCell(4);
						var cell6 = row.insertCell(5);
						var cell7 = row.insertCell(6);
						var cell8 = row.insertCell(7);

						cell1.innerHTML = '<font size="3">'+events[i].name+'</font>';
						cell2.innerHTML = '<font size="3">'+events[i].description+'</font>';
						cell3.innerHTML = '<font size="3">'+events[i].category+'</font>';
						cell4.innerHTML = '<font size="3">'+events[i].startDate+'</font>';
						cell5.innerHTML = '<font size="3">'+events[i].endDate+'</font>';
												
						cell6.innerHTML ="<a href='/MyWayWeb/viewImage.jsp?image="+events[i].image+"'><font size='4'>View Image</font></a>";
						cell7.innerHTML = "<a href='/MyWayWeb/viewMapsbyCoordinates.jsp?lat="+events[i].latitude+"&lon="+events[i].longitude+"'><font size='4'>View Map</font></a>";
						cell8.innerHTML = ('<input type="radio" name="choice" value="approve" id="choiceA'
								+ id
								+ '">'
								+ 'Approve <br>'
								+ '<input type="radio" name="choice" value="reject" id="choiceR'
								+ id + '">' + 'Reject <br>'
						);
					}
				}
			});
}
function submitReviewForm() {

	var checkBox = document.getElementsByName("choice");
	var temp="";
	for (var i = 0; i < checkBox.length; i++) {

		if (checkBox[i].checked) {
			temp = checkBox[i].id;
		}

	}
	if(temp==""){
		document.getElementById("checkedError").innerHTML = "you Did not review any events";
	}else{
		var tempId = temp.slice(7);
		document.getElementById("hiddenid").innerHTML = '<input name ="selectedId" type="hidden" value="'
				+ tempId + '" />';
		var tempC = temp.slice(6,7);
		document.getElementById("hiddenChoice").innerHTML = '<input name ="selectedChoice" type="hidden" value="'
			+ tempC + '" />';
		
		document.forms["formApprove"].submit();
	}
	
}