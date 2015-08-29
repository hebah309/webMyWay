function loadPOITypes() {
	dojo.xhrGet({
				url : "/MyWayWeb/PointsOfInterest",
				timeout : 5000,
				content : {action:"loadPOITypes"},
				headers : {
					"Content-Type" : "application/json"
				},
				preventCache : true,
				handleAs : "json",
				handle : function(types, ioArgs) {
					for (var i = 0; i < types.length; i++) {
						var TypeSelectionVar = document.getElementById("TypeSelection");
						var option = document.createElement("option");
						option.text = types[i].type;
						option.value = types[i].typeID;
						TypeSelectionVar.add(option);
					}
				}
			});
}
function submitPOIForm() {
	if (validateForm()) {
		document.forms["poiForm"].submit();
	}
}

function validateForm() {

	var valid = true;
	var name = document.getElementById("Name").value;
	var type = document.getElementById("TypeSelection").value;

	if (name == "") {
		document.getElementById('nameError').innerHTML = "Field Cannot Be Empty";
		valid = false;
	} else {
		document.getElementById('nameError').innerHTML = "";
	}

	if (type == "") {
		document.getElementById('typeError').innerHTML = "Field Cannot Be Empty";
		valid = false;
	} else {
		document.getElementById('typeError').innerHTML = "";
	}

	return valid;
}

function resetfields() {

	document.getElementById('nameError').innerHTML = "";
	document.getElementById('typeError').innerHTML = "";

}
function loadPOIs() {
	dojo
			.xhrGet({
				url : "/MyWayWeb/PointsOfInterest",
				timeout : 5000,
				content : {
					action : "loadPointsOfInterests"
				},
				headers : {
					"Content-Type" : "application/json"
				},
				preventCache : true,
				handleAs : "json",
				handle : function(pois, ioArgs) {
					for (var i = 0; i < pois.length; i++) {
						var pointsTableVar = document
								.getElementById("pointsTable");
						var pointsTableLength = pointsTableVar.rows.length;
						var row = pointsTableVar.insertRow(pointsTableLength);

						var id = pois[i].id;

						var cell1 = row.insertCell(0);
						var cell2 = row.insertCell(1);
						var cell3 = row.insertCell(2);
//						var cell4 = row.insertCell(3);
//						var cell5 = row.insertCell(4);

						cell1.innerHTML = pois[i].POIName;
						cell2.innerHTML = "</td><td><a href='/MyWayWeb/viewMapsbyKeyWord.jsp?POI="+pois[i].POIName+"'>View Map</a>";;
						cell3.innerHTML = ('<input type="radio" name="choice" value="approve" id="choiceA'
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
		document.getElementById("checkedError").innerHTML = "Did not review a point of interest!";
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