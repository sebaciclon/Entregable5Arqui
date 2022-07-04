'use strict';
    
const base = "http://localhost:8080/api/";

    // ALTA ITEM DE COMPRA
    function agregarItemCompra(){
        let id_compra = document.querySelector("#id_compra").value;
        let id_producto = document.querySelector("#id_producto").value;
        let cantidad = document.querySelector("#cantidad").value;
        let item_compra = {
            cantidad: cantidad,
            product_product_id: id_producto,
            orden_order_id: id_compra
        };
        let url = base + "orderDetails";
        fetch(url, {
            "method": 'POST',
            "mode": 'cors',
            "headers": { "Content-Type": "application/json" },
            "body": JSON.stringify(item_compra)
        })
        .catch(error => console.log(error.message))
        //alert("Se registró correctamente el item de compra!");
    }

document.querySelector("#btn_volver_item_compra").addEventListener("click", volver);
document.querySelector("#btn_add_item_compra").addEventListener("click", agregarItemCompra);

function volver(){
    location.href="item_compra.html";
}