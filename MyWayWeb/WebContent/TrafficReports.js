function addJSONReport()
{
	
	var report = {
			reportType : document.getElementById("type").value,
			comment : document.getElementById("description").value,
			longtitude : document.getElementById("longtitude").value,
			latitude : document.getElementById("latitude").value
		
		};
	dojo.xhrPost({
		url : "/MyWayWeb/getTrafficReport",
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