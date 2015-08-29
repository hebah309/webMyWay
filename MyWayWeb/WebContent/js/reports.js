function addJSONReport()
{
	
	var report = {
			reportType : document.getElementById("type").value,
			reportDescription : document.getElementById("description").value,
			reportDate : new Date().getTime(),
			trafficDensity : document.getElementById("density").value,
			longtitude : document.getElementById("longtitude").value,
			latitude : document.getElementById("latitude").value
		};
	dojo.xhrPost({
		url : "/MyWayWeb/Reports",
		timeout : 5000,
		content: {
			action: "add",
			jsonReport: JSON.stringify(report)
			},
		handle : function(data) {
				alert("your report has been added")
			}
	});
}