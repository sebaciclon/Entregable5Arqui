'use strict';

const base = "http://localhost:8080/api/";

let id_cliente; 

function volver(){
    location.href="cliente.html";
}

function cargarDatos(){
    id_cliente = document.querySelector("#id_cliente").value;
    let url = base + "clients/" + id_cliente;
    fetch(url)
        .then(response => response.json())
        .then(data => {
            document.querySelector("#clientEmail").setAttribute("value", data.email);
            document.querySelector("#clientName").setAttribute("value", data.name);
            document.querySelector("#clientSurname").setAttribute("value", data.surname);
        })
        .catch(() => alert("Cliente no encontrado"));
    
}

function guardarCambios(){
    let email = document.querySelector("#clientEmail").value;
    let name = document.querySelector("#clientName").value;
    let surname = document.querySelector("#clientSurname").value;
    let cliente = {
        name: name,
        surname: surname,
        email: email
    };
    let url = base + "clients/" + id_cliente;
    fetch(url, {
        "method": 'PUT',
        "headers": { "Content-Type": "application/json" },
        "body": JSON.stringify(cliente)
    }).then
    .catch(error => console.log(error.message))
    alert("Se guardó correctamente el cliente!");
}

document.querySelector("#btn_volver_cliente").addEventListener("click", volver);
document.querySelector("#btn_editar_cliente").addEventListener("click", cargarDatos);
document.querySelector("#btn_enviar_editar_cliente").addEventListener("click", guardarCambios);