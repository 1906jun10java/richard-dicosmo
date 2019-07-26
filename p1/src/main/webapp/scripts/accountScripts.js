window.onload = function(){
	checkTitle();
	displayUser();
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
			document.getElementById("username").innerText = "Username: "+user.username;
			document.getElementById("firstname").innerText = "First Name: "+user.firstName;
			document.getElementById("lastname").innerText = "Last Name: "+user.lastName;
			document.getElementById("email").innerText = "Email: "+user.email;
			document.getElementById("title").innerText = "Title: "+user.title;
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