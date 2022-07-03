'use strict';
    
    const base = "http://localhost:8080/api/";

    // ALTA DE COMPRA
    function registrarCompra(){
        let id_cliente = document.querySelector("#cliente_compra").value;
        let compra = {
            fk_client: id_cliente
        };
        let url = base + "orders";
        fetch(url, {
            "method": 'POST',
            "mode": 'cors',
            "headers": { "Content-Type": "application/json" },
            "body": JSON.stringify(compra)
        }).then
        .catch(error => console.log(error.message))
        alert("Se registró correctamente la compra!");
    }

    function volver(){
        location.href="compra.html";
    }

    document.querySelector("#btn_volver_alta_compra").addEventListener("click", volver);
    document.querySelector("#btn_enviar_alta_compra").addEventListener("click", registrarCompra);
    
    
