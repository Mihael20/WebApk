let url = "http://localhost:8080/v1/rest/books/";

let init = {
    mode: 'cors',
    method: 'get',
    headers: {
        'Content-Type': 'application/json; charset=UTF-8',
    }
};

function loadAjaxBooks() {
    loadAjaxRequest(url, createTable);
}

function loadBooks() {
    fetch(url)
        .then(response => response.json())
        .then(json => createTable(json));
}

function createTable(response) {
    let result = "<table>";
    result += "<th>ID</th><th>Book Name</th><th>Format Name</th>";

    // the response is an array
    for (let i = 0; i < response.length; i++) {
        result += `<tr><td>${response[i].id}</td><td>${response[i].bookName}</td><td>${response[i].formatName}</td></tr>`;
    }

    result += "</table>";
    document.getElementById("list").innerHTML = result;
}

function loadOneBook() {
    let id = document.getElementById("book_id").value;

    fetch(url + id)
        .then(response => response.json())
        .then(json => prepareBook(json))
        .catch((json) => { if (!json.ok) clearForm() });
}

function prepareBook(json) {
    document.getElementById("book_name").value = json.bookName;
    document.getElementById("format_name").value = json.formatName;
}

function clearForm() {
    document.getElementById("book_name").value = '';
    document.getElementById("format_name").value = '';
}

function addBook() {
    let book = {
        "bookName": document.getElementById("book_name").value,
        "formatName": document.getElementById("format_name").value
    };

    init.method = 'post';
    init.body = JSON.stringify(book);

    fetch(url, init).then(() => loadBooks());
}

function updateBook() {
    let book = {
        "id": document.getElementById("book_id").value,
        "bookName": document.getElementById("book_name").value,
        "formatName": document.getElementById("format_name").value
    };

    init.method = 'put';
    init.body = JSON.stringify(book);

    fetch(url, init).then(() => loadBooks());
}

function deleteBook() {
    let id = document.getElementById("book_id").value;
    init.method = 'delete';
    fetch(url + id, init).then(() => loadBooks());
}