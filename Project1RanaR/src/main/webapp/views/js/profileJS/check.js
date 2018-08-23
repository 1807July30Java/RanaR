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
			document.getElementById("username").innerText = "you are logged in as " + res.username;
		}
		if (res.firstName && res.lastName) {
			document.getElementById("firstname").innerText = "Welcome, " + res.firstName + " " + res.lastName;
		}
		if (res.isManager) {
			if(res.isManager == 1)
				document.getElementById("isManager").innerText = "It seems that you are a manager. ";
			else
				document.getElementById("isManager").innerText = "You are not a manager ";
		}
		if(res.employeeEmail){
			document.getElementById("employeeEmail").innerText = "Your manager is: " + res.email;
		}
		if(res.id){
			document.getElementById("employeeId").innerText = "Your id is: " + res.id;
		}
		if (res.employeeManager) {
			document.getElementById("employeeManager").innerText = "Your manager is: " + res.employeeManager;
		}
		else{
			document.getElementById("employeeManager").innerText = "You do not have a manager. "
		}
	} else {
		window.location = "http://localhost:8085/Project1RanaR/login";
	}
};

window.onload = function() {
	sendAjaxGet("http://localhost:8085/Project1RanaR/session", populateUser);
}