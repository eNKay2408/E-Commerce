document.getElementById("login-form").addEventListener("submit", (event) => {
	event.preventDefault();

	const formData = new FormData(event.target);

	fetch("/login", {
		method: "POST",
		body: new URLSearchParams(formData),
		headers: {
			"Content-Type": "application/x-www-form-urlencoded",
		},
	})
		.then((response) => {
			const contentType = response.headers.get("content-type");
			if (!contentType.includes("application/json")) {
				window.location.href = "/login?error";
			}

			return response.json();
		})
		.then((data) => {
			localStorage.setItem("jwtToken", data.token);
			window.location.href = "/";
		})
		.catch((error) => {
			console.error("Error: ", error);
		});
});

document.addEventListener("DOMContentLoaded", () => {
	const token = localStorage.getItem("jwtToken");
	if (token) {
		alert("You are already logged in. Please log out first.");
		window.location.href = "/";
	}
});
