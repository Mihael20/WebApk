const express = require("express");
const sqlite3 = require("sqlite3").verbose();
const bodyParser = require("body-parser");
const app = express();
const PORT = 3000;

// Serve all files in the same directory
app.use(express.static(__dirname));

app.use(bodyParser.json());

const db = new sqlite3.Database("users.db");

db.run(`
  CREATE TABLE IF NOT EXISTS users (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    email TEXT UNIQUE,
    password TEXT
  )
`);

app.post("/register", (req, res) => {
  const { email, password } = req.body;
  db.run("INSERT INTO users (email, password) VALUES (?, ?)", [email, password], (err) => {
    if (err) return res.status(400).json({ error: "User already exists" });
    res.json({ message: "User registered!" });
  });
});

app.post("/login", (req, res) => {
  const { email, password } = req.body;
  db.get("SELECT * FROM users WHERE email = ? AND password = ?", [email, password], (err, row) => {
    if (err) return res.status(500).json({ error: "Server error" });
    if (!row) return res.status(401).json({ error: "Invalid credentials" });
    res.json({ message: "Login successful" });
  });
});

app.listen(PORT, () => {
  console.log(` Server running at http://localhost:${PORT}`);
});
