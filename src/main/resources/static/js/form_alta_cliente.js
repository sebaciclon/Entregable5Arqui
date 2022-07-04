'use strict';
    
    const base = "http://localhost:8080/api/";

    // ALTA DE CLIENTE
    function registrarCliente(){

        let email = document.querySelector("#clientEmail").value;
        let name = document.querySelector("#clientName").value;
        let surname = document.querySelector("#clientSurname").value;
        let cliente = {
            name: name,
            surname: surname,
            email: email
        };
        console.log(cliente);
        let url = base + "clients";
        fetch(url, {
            "method": 'POST',
            "mode": 'cors',
            "headers": { "Content-Type": "application/json" },
            "body": JSON.stringify(cliente)
        })
        .catch(error => console.log(error.message))
        alert("Se registró correctamente el cliente!");
    }


    
    function volver(){
        location.href="cliente.html";
    }

    document.querySelector("#btn_enviar_alta_cliente").addEventListener("click", registrarCliente);
    document.querySelector("#btn_volver_cliente").addEventListener("click", volver);