'use strict';

const base = "http://localhost:8080/api/";

let id_producto; 

function volver(){
    location.href="producto.html";
}

function cargarDatos(){
    id_producto = document.querySelector("#id_producto").value;
    let url = base + "products/" + id_producto;
    fetch(url)
        .then(response => response.json())
        .then(data => {
            document.querySelector("#productName").setAttribute("value", data.name);
            document.querySelector("#productPrice").setAttribute("value", data.price);
            document.querySelector("#productQuantity").setAttribute("value", data.quantity);
        })
        .catch(() => alert("Producto no encontrado"));
    
}

function guardarCambios(){
    let nombre = document.querySelector("#productName").value;
    let precio = document.querySelector("#productPrice").value;
    let stock = document.querySelector("#productQuantity").value;
    
    let producto = {
        name: nombre,
        price: precio,
        quantity: stock
    };
    let url = base + "products/" + id_producto;
    fetch(url, {
        "method": 'PUT',
        "headers": { "Content-Type": "application/json" },
        "body": JSON.stringify(producto)
    }).then
    .catch(error => console.log(error.message))
    alert("Se guardó correctamente los cambios!");
}

document.querySelector("#btn_volver_producto").addEventListener("click", volver);
document.querySelector("#btn_editar_producto").addEventListener("click", cargarDatos);
document.querySelector("#btn_enviar_editar_producto").addEventListener("click", guardarCambios);