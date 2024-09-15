function fetchJwt(url) {
	const token = localStorage.getItem("jwtToken");
	if (!token) {
		window.location.href = "/login";
		return;
	}

	fetch(url, {
		method: "GET",
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
			const newUrl = url.split("/").slice(0, 5).join("/");
			window.history.pushState({}, "", newUrl);

			document.open();
			document.write(html);
			document.close();
		})
		.catch((error) => {
			console.error("Error:", error);
		});
}

if (typeof links === "undefined") {
	const links = document.getElementsByClassName("jwt-link");

	for (let i = 0; i < links.length; i++) {
		links[i].addEventListener("click", (event) => {
			event.preventDefault();

			const url = event.currentTarget.href;

			fetchJwt(url);
		});
	}
}

window.addEventListener("popstate", (event) => {
	fetchJwt(window.location.href);
});
