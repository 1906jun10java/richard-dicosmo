window.onload = function(){
	checkTitle();
	getAllRequests();
	document.getElementById("createRequestButton").addEventListener("click", function(){
	  createRequest();
	});
	document.getElementById("refreshViewButton").addEventListener("click", function(){
		document.getElementById("messages").innerHTML = "Showing all Requests";
	  getAllRequests();
	});
}
function createRequest(){
	

	var title = document.getElementById("createTitle").value;
	var description = document.getElementById("createDescription").value;
	
	if(title != "" || description != "" ){
		
			fetch("http://localhost:8082/p1/createRequest?createTitle=" + title + "&createDescription=" + description).then(function(response) {
				return response.json(); // parsing json data in the response as a JS object
			}).then(function(data) {
				console.log(data);
			//define behavior for when a status is returned
			status = data;
			document.getElementById("messages").innerHTML = "Request: " + title + " Creation Status: " + status;
	})
		
	}else{
		document.getElementById("messages").innerHTML = "Please Input a value in all fields";
	}
	getAllRequests();
}
function displayUser() {
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
			document.getElementById("message").innerText = "Welcome "+ user.username + ", please select a menu item at the top of the screen.";

		}
	})
}
function getAllRequests() {
	// send a GET request to get the array of reimbursements
	fetch("http://localhost:8082/p1/getAllPersonalRequests").then(function(response) {
		return response.json(); // parsing json data in the response as a JS object
	}).then(function(data) {
		console.log(data);
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