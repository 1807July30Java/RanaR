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

function populateUser(xhr) {
	if (xhr.responseText) {
		var res = JSON.parse(xhr.responseText);
		console.log(res);
		if (res.username) {
			document.getElementById("username").innerText = "Username: " + res.username;
		}
		if (res.firstName && res.lastName) {
			document.getElementById("firstname").innerText = "Welcome, " + res.firstName + " " + res.lastName;
		}
		if (res.isManager) {
			if(res.isManager == 1)
				document.getElementById("isManager").innerText = "Manager ";
			else
				document.getElementById("isManager").innerText = "Not a manager ";
		}
		if(res.email){
			document.getElementById("employeeEmail").innerText = "Email: " + res.email;
		}
	} else {
		window.location = "http://localhost:8085/Project1RanaR/login";
	}
};

function populateTableWithEmployees(xhr) {
	if (xhr.responseText) {
		var res = JSON.parse(xhr.responseText);
		console.log(res);
		for (var i = 0; i < res.length; i++) {
            var table = document.getElementById("employeesUnderManager");
            
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
            
            table.append(employeeID, firstName, lastName);
        }
	} else {
		window.location = "http://localhost:8085/Project1RanaR/login";
	
	}
};


window.onload = function() {
	sendAjaxGet("http://localhost:8085/Project1RanaR/session", populateUser);
	sendAjaxGet("http://localhost:8085/Project1RanaR/eums?entity=employees&get=manager", populateTableWithEmployees);
}