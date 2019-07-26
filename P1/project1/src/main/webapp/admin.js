/**
 * 
 */



let employee = {};

window.onload = function() {
	populateUser();
}

function populateUser() {
	// send a GET request to SessionServlet to obtain session information
	fetch("http://localhost:8082/project1/session").then(function(response) {
		return response.json(); // parsing json data in the response as a JS object
	}).then(function(data) {
		console.log(data);
		// check whether there is a valid session
		//define behavior for when there is no valid user
		if(data.session === null) {
			window.location = "http://localhost:8082/project1/Login"
		} else {
			//define behavior for when a user is returned
			eployee = data;
			document.getElementById("empid").innerText = "Employee ID: "+employee.empid;
			document.getElementById("emprole").innerText = "Employee role: "+employee.emprole;
			document.getElementById("firstname").innerText = "Lirstname: "+employee.firstname;
			document.getElementById("lastname").innerText = "Lastname: "+employee.lastname;
			document.getElementById("dept").innerText = "Department: "+employee.dept;
			session.setAttribute("managerid").innerText = "Manager ID: "+employee.managerid;
		}
	})
}

function getRequests() {
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let list = JSON.parse(xhttp.responseText);
			setValues(list);
		}
	}
	xhttp.open("GET", "/project1/Login.html", true);
	xhttp.send();
}

function setValues(list) {
    
    let table = document.getElementById("reimbtable");
    
    for (r in list) {
        let row = document.createElement("tr");
		let tdEmployeeId = document.createElement("td");
		let tdEmployeeRole = document.createElement("td");
        let tdFirstName = document.createElement("td");
        let tdLastName = document.createElement("td");
        let tdManagerID = document.createElement("td");
        let tdReimbursementType = document.createElement("td");
        let tdReimbursementAmount = document.createElement("td");
        let tdDatesubmitted = document.createElement("td");
        let tdReimbursementStatus = document.createElement("td");
        
        
        switch (list[r].type) {
        case 1:
        	tdType.innerHTML = "Relocation";
            break;
        case 2:
        	tdType.innerHTML = "Travel";
            break;
        case 3:
        	tdType.innerHTML = "Food";
            break;
        case 4:
        	tdType.innerHTML = "Certification";
			break;
		case 5:
        	tdType.innerHTML = "Other";
            break;
        }
        tdReimbursementAmount.innerHTML = "$" + list[r].ReimbursementAmount;
        tdReimbursementDate.innerHTML = list[r].ReimbursementDate;
        
		row.appendChild(tdEmployeeId);
		row.appendChild(tdEmployeeRole);
        row.appendChild(tdFirstName);
        row.appendChild(tdLastName);
        row.appendChild(tdManagerID);
        row.appendChild(tdReimbursementType);
        row.appendChild(tdReimbursementAmount);
        row.appendChild(tdDatesubmitted);
		row.appendChild(tdReimbursementStatus);
    }
}