'use strict';
    
    const base = "http://localhost:8080/api/";
   
    function eliminarCliente(){
        let id_cliente = document.querySelector("#id_cliente").value;
        let url = base + "clients/" + id_cliente;
        
        fetch(url, {
            "method": "DELETE",
            "mode": "cors"
        })
        .catch(error => console.log(error.message))
        alert("Se eliminó correctamente el cliente!");
    } 

    function volver(){
        location.href="cliente.html";
    }

    document.querySelector("#btn_volver_baja_cliente").addEventListener("click", volver);
    document.querySelector("#btn_enviar_baja_cliente").addEventListener("click", eliminarCliente);
    
    
    
   

    
    