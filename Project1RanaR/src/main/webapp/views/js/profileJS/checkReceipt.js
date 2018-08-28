function populateTableWithPendingReceipts(xhr) {
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
	sendAjaxGet("http://localhost:8085/Project1RanaR/eums?entity=pending&get=3", populateTableWithPendingReceipts);
}