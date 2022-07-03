'use strict';

const base = "http://localhost:8080/api/";

let id_compra; 

function volver(){
    location.href="compra.html";
}

function cargarDatos(){
    id_compra = document.querySelector("#id_compra").value;
    let url = base + "orders/" + id_compra;
    fetch(url)
        .then(response => response.json())
        .then(data => {
            document.querySelector("#idCliente").setAttribute("value", data.cliente.id);
        })
        .catch(() => alert("Compra no encontrada"));
    
}

function guardarCambios(){
    let id_cliente = document.querySelector("#idCliente").value;
    
    let compra = {
        fk_client: id_cliente
    };
    
    let url = base + "orders/" + id_compra;
    fetch(url, {
        "method": 'PUT',
        "headers": { "Content-Type": "application/json" },
        "body": JSON.stringify(compra)
    }).then
    .catch(error => console.log(error.message))
    alert("Se guardó correctamente los cambios!");
}

document.querySelector("#btn_volver_compra").addEventListener("click", volver);
document.querySelector("#btn_editar_compra").addEventListener("click", cargarDatos);
document.querySelector("#btn_enviar_editar_compra").addEventListener("click", guardarCambios);