/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

function addToCart(endpoint, id, name, price) {
    fetch(endpoint, {
        method: "POST",
        body: JSON.stringify({
            "id": id, 
            "name": name,
            "price": price,
            "quantity": 1
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(res => res.json()).then(data => {
        console.info(data)
    })
}

function updateItem(endpoint, obj) {
    fetch(endpoint, {
        method: "put", 
        body: JSON.stringify({
            "quantity": obj.value
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(res => res.json()).then(data => {
        console.info(data)
    })
}

function deleteItem(endpoint) {
    fetch(endpoint, {
        method: "delete"
    }).then(res => res.json()).then(data => {
        console.info(data);
    });
}
