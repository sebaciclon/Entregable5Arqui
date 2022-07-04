'use strict';
    
const base = "http://localhost:8080/api/";
   
function eliminarCompra(){
    let id_compra = document.querySelector("#id_compra").value;
    let url = base + "orders/" + id_compra;
    
    fetch(url, {
        "method": "DELETE",
        "mode": "cors"
    })
    .catch(error => console.log(error.message))
    alert("Se eliminó correctamente la compra!");
} 

    
    function volver(){
        location.href="compra.html";
    }

    document.querySelector("#btn_volver_baja_compra").addEventListener("click", volver);
    document.querySelector("#btn_enviar_baja_compra").addEventListener("click", eliminarCompra);
    

    