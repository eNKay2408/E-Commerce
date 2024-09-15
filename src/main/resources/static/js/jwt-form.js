document.getElementById("form").addEventListener("submit", (event) => {
	event.preventDefault();

	const token = localStorage.getItem("jwtToken");
	if (!token) {
		window.location.href = "/login";
		return;
	}

	const form = event.target;
	const formData = new FormData(form);

	fetch(form.action, {
		method: "POST",
		body: formData,
		headers: {
			Authorization: `Bearer ${token}`,
		},
	})
		.then((response) => {
			if (response.status === 401) {
				alert("Jwt token expired. Please login again.");
				localStorage.removeItem("jwtToken");
				window.location.href = "/login";

				throw new Error("Unauthorized");
			}

			return response.text();
		})
		.then((html) => {
			const newUrl = form.action.split("/").slice(0, 5);

			if (newUrl[3] !== "cart") {
				window.history.pushState({}, "", newUrl.join("/"));
			}

			document.open();
			document.write(html);
			document.close();
		})
		.catch((error) => {
			console.error("Error:", error);
		});
});

window.addEventListener("popstate", (event) => {
	location.reload();
});
