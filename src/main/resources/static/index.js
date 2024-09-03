const baseUrl = "http://localhost:8080/persons";
 
// to get all persons
function getItems() {
    fetch(baseUrl)
        .then(response => response.json())
        .then(data => console.log(data))
        .catch(error => console.error("Unable to get items", error));
}
function createPerson(person) {
    fetch(baseUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(person)
    })
    .then(response => response.json())
    .then(data => console.log("Person created:", data))
    .catch(error => console.error("Unable to create person", error));
}
function updatePerson(id, person) {
    fetch(`${baseUrl}/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(person)
    })
    .then(response => response.json())
    .then(data => console.log("Person updated:", data))
    .catch(error => console.error("Unable to update person", error));
}
 
function deletePerson(id) {
    fetch(`${baseUrl}/${id}`, {
        method: 'DELETE'
    })
    .then(() => console.log("Person deleted"))
    .catch(error => console.error("Unable to delete person", error));
}