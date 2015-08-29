function getJourneys() {
	dojo.xhrGet({
		url : "/MyWayWeb/ParentsMonitoring",
		timeout : 5000,
		headers : {
			"Content-Type" : "application/json"
		},
		preventCache : true,
		handleAs : "json",
		handle : function(journey, ioArgs) {
			
			for (var i = 0; i < journey.length; i++) {
				var table = document.getElementById("parentsMonitoringTable");
				var row = table.insertRow(1);
				var cell1 = row.insertCell(0);
				var cell2 = row.insertCell(1);
				var cell3 = row.insertCell(2);
				var cell4 = row.insertCell(3);
				var cell5 = row.insertCell(4);
				var cell6 = row.insertCell(5);
		
				cell1.innerHTML = journey[i].Username;
				
				var lat = journey[i].lat;
				var lon = journey[i].lon;
				
				cell2.innerHTML = "<a href='/MyWayWeb/viewMapsbyCoordinates.jsp?lat="+lat+"&lon="+lon+"'>View Map</a>";
				
				cell3.innerHTML = journey[i].FinalDestination;
				cell4.innerHTML = journey[i].Speed;
				cell5.innerHTML = journey[i].speedAverage;
				cell6.innerHTML = journey[i].stop;
			}

		}
	});
}
