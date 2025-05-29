function loadAjaxRequest(callback) {
	let xhr;
	if (window.XMLHttpRequest) {
		// code for modern browsers
		xhr = new XMLHttpRequest();
	} else {
		// code for IE6, IE5
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			// callback function
			if (callback != undefined) {
				callback(this.responseText);
			}
		}
	};
	
	xhr.open("GET", "http://localhost:8080/authors/1", true);
	xhr.send();
}
