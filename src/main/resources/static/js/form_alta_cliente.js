'use strict';
    
    const base = "http://localhost:8080/api/";

    // ALTA DE CLIENTE
    function registrarCliente(){
        
        let email = document.querySelector("#clientEmail").value;
        let name = document.querySelector("#clientName").value;
        let surname = document.querySelector("#clientSurname").value;
        //alert(email + name + surname);
        let cliente = {
            email: email,
            name: name,
            surname: surname
        };
        //alert(cliente.email);
        let path = base + "clients/";
        alert(path);
        fetch(path, {
            "method": 'POST',
            //"mode": 'cors',
            "headers": { "Content-Type": "application/json" },
            "body": JSON.stringify(cliente)
        })
        //alert("Se registró correctamente el cliente!");
    }
    
    function volver(){
        location.href="cliente.html";
    }

    document.querySelector("#btn_enviar_alta_cliente").addEventListener("click", registrarCliente);
    document.querySelector("#btn_volver_cliente").addEventListener("click", volver);