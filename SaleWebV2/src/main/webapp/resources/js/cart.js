/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

function addItemToCart(endpoint, id, name, price) {
    fetch(endpoint, {
        method: "post",
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
        console.info(data);
        let eles = document.getElementsByClassName('cart-counter');
        for (let e of eles)
            e.innerText = data.totalQuantity;
    });
    
}

function updateCart(endpoint, obj) {
    fetch(endpoint, {
        method: "put",
        body: JSON.stringify({
            "quantity": parseInt(obj.value)
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(res => res.json()).then(data => {
        let eles = document.getElementsByClassName('cart-counter');
        for (let e of eles)
            e.innerText = data.totalQuantity;
    });
}

function deleteCart(endpoint, id) {
    if (confirm("Bạn chắc chắn xóa không?") == true) {
        fetch(endpoint, {
            method: "delete"
        }).then(res => res.json()).then(data => {
            let d = document.getElementById(`cart${id}`)
            d.style.display = "none";

            let eles = document.getElementsByClassName('cart-counter');
            for (let e of eles)
                e.innerText = data.totalQuantity;
        });
    }
}
