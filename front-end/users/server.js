const express = require('express');
const fs = require('fs');
const cors = require('cors');

const app = express();
app.use(cors());
app.use(express.json());

// Only these users are allowed to register
const allowedUsers = [
  'marija@example.com',
  'ivan@example.com',
  'elena@example.com',
  'marko@example.com'
];

// Registered users stored here (in memory)
let registeredUsers = [];

function logAttempt(type, email, status) {
  const line = `[${new Date().toISOString()}] ${type.toUpperCase()} attempt: ${email} => ${status}\n`;
  fs.appendFileSync('log.txt', line);
}

// Registration route
app.post('/register', (req, res) => {
  const { email, password } = req.body;

  if (!allowedUsers.includes(email)) {
    logAttempt('register', email, 'DENIED');
    return res.status(403).json({ error: 'This email is not allowed to register.' });
  }

  const exists = registeredUsers.find(u => u.email === email);
  if (exists) {
    logAttempt('register', email, 'ALREADY REGISTERED');
    return res.status(400).json({ error: 'User already registered.' });
  }

  registeredUsers.push({ email, password });
  logAttempt('register', email, 'SUCCESS');
  res.json({ message: 'Registered successfully.' });
});

// Login route
app.post('/login', (req, res) => {
  const { email, password } = req.body;

  const user = registeredUsers.find(u => u.email === email && u.password === password);
  if (!user) {
    logAttempt('login', email, 'FAILED');
    return res.status(401).json({ error: 'Invalid credentials.' });
  }

  logAttempt('login', email, 'SUCCESS');
  res.json({ message: 'Login successful.' });
});

// Optional: see log
app.get('/logs', (req, res) => {
  if (!fs.existsSync('log.txt')) return res.send("No logs yet.");
  const log = fs.readFileSync('log.txt', 'utf-8');
  res.type('text').send(log);
});

app.listen(3000, () => console.log('✅ Server running at http://localhost:3000'));
