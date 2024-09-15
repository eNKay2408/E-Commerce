document.getElementById("logout").addEventListener("click", (event) => {
	event.preventDefault();

	const token = localStorage.getItem("jwtToken");
	if (!token) {
		alert("You are not logged in.");
		window.location.href = "/login";
		return;
	}

	fetch("/logout", {
		method: "GET",
	})
		.then((response) => {
			localStorage.removeItem("jwtToken");

			window.location.href = "/login";
		})
		.catch((error) => {
			console.error("Error: ", error);
		});
});
