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

function populateTableWithPendingReceipts(xhr) {
	if (xhr.responseText) {
		var res = JSON.parse(xhr.responseText);
		console.log(res);
		for (var i = 0; i < res.length; i++) {
            var table = document.getElementById("ticketsPending");
            
            var row = document.createElement("tr");
            row.setAttribute("class", "clickable-row");
            row.setAttribute("id", res[i].reimbursementID);
            table.appendChild(row);
            
            var reimbursementId = document.createElement("td");
            reimbursementId.innerText = res[i].reimbursementID;
            
            var reimbursementAmount = document.createElement("td");
            reimbursementAmount.innerText = res[i].reimbursementAmount;
            
            var reimbursementDescription = document.createElement("td");
            reimbursementDescription.innerText = res[i].reimbursementDescription;
            
            var viewImgButton = document.createElement("td");
            var imgLink = document.createElement("a");
            imgLink.setAttribute("class", "btn btn-primary");
            imgLink.setAttribute("target", "_blank");
            imgLink.setAttribute("href", "http://localhost:8085/Project1RanaR/rifds?ticketId=" + res[i].reimbursementID);
            imgLink.innerHTML = "View Receipt";
            viewImgButton.appendChild(imgLink);
            
            var acceptButton = document.createElement("td");
            var acceptLink = document.createElement("a");
            acceptLink.setAttribute("class", "btn btn-primary");
            acceptLink.setAttribute("href", "http://localhost:8085/Project1RanaR/approve?requestID=" + res[i].reimbursementID);
            acceptLink.innerHTML = "Accept";
            acceptButton.appendChild(acceptLink);
            
            var rejectButton = document.createElement("td");
            var rejectLink = document.createElement("a");
            rejectLink.setAttribute("class", "btn btn-primary");
            rejectLink.setAttribute("href", "http://localhost:8085/Project1RanaR/reject?requestId=" + res[i].reimbursementID);
            rejectLink.innerHTML = "Reject";
            rejectButton.appendChild(rejectLink);
            
            table.append(reimbursementId, reimbursementAmount, reimbursementDescription, viewImgButton, acceptButton, rejectButton);
        }
	} else {
		window.location = "http://localhost:8085/Project1RanaR/login";
	
	}
};


window.onload = function() {
	sendAjaxGet("http://localhost:8085/Project1RanaR/eums?entity=employee&get=requests", populateTableWithPendingReceipts);
}
