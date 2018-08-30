/**
 * 
 */

function sendAjaxGet(url, func) {
	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		}
	};
	xhr.open("GET", url, true);
	xhr.send();
};

function populateTableWithAllEmployees(xhr) {
	if (xhr.responseText) {
		var res = JSON.parse(xhr.responseText);
		console.log(res);
		for (var i = 0; i < res.length; i++) {
            var table = document.getElementById("allEmployees");
            
            var row = document.createElement("tr");
            row.setAttribute("class", "clickable-row");
            row.setAttribute("id", res[i].employeeID);
            table.appendChild(row);
            
            var employeeID = document.createElement("td");
            employeeID.innerText = res[i].employeeID;
            
            var firstName = document.createElement("td");
            firstName.innerText = res[i].firstName;
            
            var lastName = document.createElement("td");
            lastName.innerText = res[i].lastName;
            
            var employeeManager = document.createElement("td");
            employeeManager.innerText = res[i].employeeManager;
         
            table.append(employeeID, firstName, lastName, employeeManager);
        }
	} else {
		window.location = "http://localhost:8085/Project1RanaR/login";
	
	}
};

window.onload = function() {
	sendAjaxGet("http://localhost:8085/Project1RanaR/eums?entity=all&get=employees", populateTableWithAllEmployees);
}