window.onload = function(){
	checkTitle();
	getAllRequests();
	document.getElementById("searchSingleRSubmit").addEventListener("click", function(){
  	displayUserRequests();
   //window.location.reload();
	});
	document.getElementById("createEmployeeButton").addEventListener("click", function(){
  	createEmployee();
	});
	document.getElementById("acceptRequestButton").addEventListener("click", function(){
  	manageRequest(1);
	});
	document.getElementById("denyRequestButton").addEventListener("click", function(){
  	manageRequest(2);
	});
	document.getElementById("refreshViewButton").addEventListener("click", function(){
	  getAllRequests();
	  document.getElementById("messages").innerHTML = "Showing all Requests";
	});
	document.getElementById("getEmployeesButton").addEventListener("click", function(){
	  getAllUsers();
	  document.getElementById("messages").innerHTML = "Showing all Users";
	});
	document.getElementById("refreshMyEmployeesButton").addEventListener("click", function(){
	  getAllManagedRequests();
	  document.getElementById("messages").innerHTML = "Showing Only My Requests";
	});
};
function createEmployee(){
	
	var firstname = document.getElementById("createFirstname").value; 
	var lastname = document.getElementById("createLastname").value;
	var username = document.getElementById("createUsername").value;
	var pass = document.getElementById("createPassword").value;
	var email = document.getElementById("createEmail").value;
	var seesto = document.getElementById("createSeesto").value;
	var title = document.getElementById("createTitle").value;
	if(firstname != "" || lastname != "" || username != "" || pass != "" || email != "" || seesto != "" || title != ""){
		if(title == "Employee" || title == "employee" || title == "Manager" || title == "manager"){
			fetch("http://localhost:8082/p1/createEmployee?createFirstname=" + firstname + "&createLastname=" + lastname + "&createUsername=" + username + "&createPassword=" + pass + "&createEmail=" + email + "&createSeesto=" + seesto + "&titleselector=" + title).then(function(response) {
				return response.json(); // parsing json data in the response as a JS object
			}).then(function(data) {
				console.log(data);
			//define behavior for when a status is returned
			status = data;
			document.getElementById("messages").innerHTML = "User: " + username + " Creation Status: " + status;
	})
		}
	}else{
		document.getElementById("messages").innerHTML = "Please Input a value in all fields";
	}
}
function manageRequest(status){
	
	
	var reimbursementID = document.getElementById("reimbursementID").value;
	
	if(reimbursementID != ""){
		if(status == 1){
			var answerCode = status;
			fetch("http://localhost:8082/p1/manageReimbursements?reimbursementID=" + reimbursementID + "&answerCode=" + answerCode).then(function(response) {
				return response.json(); // parsing json data in the response as a JS object
			}).then(function(data) {
				console.log(data);
			//define behavior for when a status is returned
			message = data;
			document.getElementById("messages").innerHTML = "Request: " + reimbursementID + " Resolved Status: " + message;
			getAllRequests();
	})
		}else{
			var answerCode = status;
			fetch("http://localhost:8082/p1/manageReimbursements?reimbursementID=" + reimbursementID + "&answerCode=" + answerCode).then(function(response) {
				return response.json(); // parsing json data in the response as a JS object
			}).then(function(data) {
				console.log(data);
			//define behavior for when a status is returned
			message = data;
			document.getElementById("messages").innerHTML = "Request: " + reimbursementID + " Resolved Status: " + message;
			getAllRequests();
	})
		}
			
		
	}else{
		document.getElementById("messages").innerHTML = "Please Input a Reimbursement ID";
	}
	
}
function displayUserRequests() {
	// send a GET request to searchSingleRDisplay to get the array of reimbursements
	var firstname = document.getElementById("firstname").value; 
	var lastname = document.getElementById("lastname").value;
	if(firstname != "" && lastname != ""){
		//document.getElementById("searchSingleRDisplay").innerHTML = firstname + " " + lastname;
	
		
		// send a GET request to SessionServlet to obtain session information
	fetch("http://localhost:8082/p1/searchSingleR?firstname=" + firstname + "&lastname=" + lastname).then(function(response) {
		return response.json(); // parsing json data in the response as a JS object
	}).then(function(data) {
		console.log(data);
			
			//define behavior for when a user is returned
			requestList = data;
			document.getElementById("messages").innerHTML = "Viewing Requests for " + firstname + " " + lastname;
			document.getElementById("display").innerHTML = " <tr><th>ID</th><th>Employee ID</th> <th>Title</th><th>Description</th><th>Status</th><th>Resolved By ID</th></tr>";
			for(let i = 0; i < requestList.length; i++){
				let r = new Object();
				r = requestList[i];
				if(r.status == 0){
					r.status = "Unresolved";
				}else if(r.status == 1){
					r.status = "Accepted";
				}else{
					r.status = "Denied";
				}
				document.getElementById("display").innerHTML += "<tr> <td>" + r.reimbursement_id + "</td> <td>" + r.user_id + "</td><td>" + r.title + "</td><td>" + r.description + "</td><td>" + r.status + "</td><td>" + r.resolved_by + "</td> </tr>";
			}
	})
}else{
	document.getElementById("messages").innerHTML = "Please Input a first and last name";
}
}
function getAllRequests() {
	// send a GET request to get the array of reimbursements
	fetch("http://localhost:8082/p1/getAllRequests").then(function(response) {
		return response.json(); // parsing json data in the response as a JS object
	}).then(function(data) {
		console.log(data);
			//document.getElementById("messages").innerHTML = "Showing all Requests";
			document.getElementById("display").innerHTML = " <tr><th>ID</th><th>Employee ID</th> <th>Title</th><th>Description</th><th>Status</th><th>Resolved By ID</th></tr>";
			//define behavior for when a user is returned
			requestList = data;
			for(let i = 0; i < requestList.length; i++){
				let r = new Object();
				r = requestList[i];
				if(r.status == 0){
					r.status = "Unresolved";
				}else if(r.status == 1){
					r.status = "Accepted";
				}else{
					r.status = "Denied";
				}
				document.getElementById("display").innerHTML += "<tr> <td>" + r.reimbursement_id + "</td> <td>" + r.user_id + "</td><td>" + r.title + "</td><td>" + r.description + "</td><td>" + r.status + "</td><td>" + r.resolved_by + "</td> </tr>";
			}
				//document.getElementById("allRequests").innerHTML += "<br>";
	})
}
function getAllUsers() {
	// send a GET request to get the array of reimbursements
	fetch("http://localhost:8082/p1/getAllUsers").then(function(response) {
		return response.json(); // parsing json data in the response as a JS object
	}).then(function(users) {
		console.log(users);
		
			document.getElementById("display").innerHTML = " <tr><th>Employee ID</th> <th>First Name</th><th>Last Name</th><th>Email</th><th>Sees To ID</th><th>Title</th></tr>";
			//define behavior for when user information is generated
			userList = users;
			//alert(JSON.stringify(users));
			//alert(JSON.stringify(users[0].userID));
			for(let i = 0; i < userList.length; i++){
				document.getElementById("display").innerHTML += "<tr> <td>" + JSON.stringify(users[i].userID) + "</td> <td>" + JSON.stringify(users[i].firstName)+ "</td><td>" + JSON.stringify(users[i].lastName) + "</td><td>" + JSON.stringify(users[i].email) + "</td><td>" + JSON.stringify(users[i].seesTo) + "</td><td>" + JSON.stringify(users[i].title) + "</td></tr>";
			}
	})
}
function getAllManagedRequests() {
	// send a GET request to get the array of reimbursements
	fetch("http://localhost:8082/p1/getAllManagedRequests").then(function(response) {
		return response.json(); // parsing json data in the response as a JS object
	}).then(function(data) {
		console.log(data);
			//document.getElementById("messages").innerHTML = "Showing all Requests";
			document.getElementById("display").innerHTML = " <tr><th>ID</th><th>Employee ID</th> <th>Title</th><th>Description</th><th>Status</th><th>Resolved By ID</th></tr>";
			//define behavior for when a user is returned
			requestList = data;
			for(let i = 0; i < requestList.length; i++){
				let r = new Object();
				r = requestList[i];
				if(r.status == 0){
					r.status = "Unresolved";
				}else if(r.status == 1){
					r.status = "Accepted";
				}else{
					r.status = "Denied";
				}
				document.getElementById("display").innerHTML += "<tr> <td>" + r.reimbursement_id + "</td> <td>" + r.user_id + "</td><td>" + r.title + "</td><td>" + r.description + "</td><td>" + r.status + "</td><td>" + r.resolved_by + "</td> </tr>";
			}
				//document.getElementById("allRequests").innerHTML += "<br>";
	})
}
function checkTitle() {
	// send a GET request to SessionServlet to obtain session information
	fetch("http://localhost:8082/p1/session").then(function(response) {
		return response.json(); // parsing json data in the response as a JS object
	}).then(function(data) {
		console.log(data);
		// check whether there is a valid session
		//define behavior for when there is no valid user
		if(data.session === null) {
			window.location = "http://localhost:8082/p1/login"
		} else {
			//define behavior for when a user is returned
			user = data;
			if(user.title != "Manager"){
				document.getElementById("managerButton").className = "nav-item nav-link disabled";
			}else{
				document.getElementById("managerButton").className = "nav-item nav-link";
			}
			

		}
	})
}