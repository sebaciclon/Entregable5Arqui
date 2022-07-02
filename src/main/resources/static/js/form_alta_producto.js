'use strict';
    
// ALTA DE PRODUCTO
function registrarProducto(){
        
    let name = document.querySelector("#productName").value;
    let price = document.querySelector("#productPrice").value;
    let quantity = document.querySelector("#productQuantity").value;
    let producto = {
        nombre: name,
        precio: price,
        stock: quantity
    };
    fetch(base + "productos", {
        "method": 'POST',
        "mode": 'cors',
        "headers": { "Content-Type": "application/json" },
        "body": JSON.stringify(producto)
    })
    alert("Se registró correctamente el producto!");
}

function volver(){
    location.href="producto.html";
}

document.querySelector("#btn_volver_producto").addEventListener("click", volver);
document.querySelector("#btn_enviar_alta_producto").addEventListener("click", registrarProducto);
    
    

    