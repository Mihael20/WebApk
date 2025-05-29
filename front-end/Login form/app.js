
  function login(event) {
    event.preventDefault();

    const email = document.getElementById("login-email").value;
    const password = document.getElementById("login-password").value;

    fetch("/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({ email, password })
    })
      .then(res => {
        if (res.ok) {
          window.location.href = "/homepage.html"; // This works if homepage.html is in /public
        } else {
          return res.text().then(text => { throw new Error(text); });
        }
      })
      .catch(err => {
        alert("Login failed: " + err.message);
      });
  }