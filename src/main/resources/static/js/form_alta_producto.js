'use strict';

    const base = "http://localhost:8080/api/";

    // ALTA DE PRODUCTO
    function registrarProducto(){
        let nombre = document.querySelector("#productName").value;
        let precio = document.querySelector("#productPrice").value;
        let stock = document.querySelector("#productQuantity").value;
        let producto = {
            name: nombre,
            price: precio,
            quantity: stock
        };
        let url = base + "products";
        fetch(url, {
            "method": 'POST',
            "mode": 'cors',
            "headers": { "Content-Type": "application/json" },
            "body": JSON.stringify(producto)
        }).then
        .catch(error => console.log(error.message))
        alert("Se registró correctamente el producto!");
    }

    function volver(){
        location.href="producto.html";
    }

    document.querySelector("#btn_volver_producto").addEventListener("click", volver);
    document.querySelector("#btn_enviar_alta_producto").addEventListener("click", registrarProducto);
        
        

        