'use strict';
    
const base = "http://localhost:8080/api/";

async function crearReporte(){
    let url = base + "orders/" + "report";
    let tabla= document.getElementById("DOM_reporte_4");
    try {
        let r= await fetch (url);
        let respuesta= await r.json();
        for (let data of respuesta){
            tabla.innerHTML += `
            <tr id="fila">
                <td>${data.fecha}</td>
                <td>${data.producto}</td>
                <td>${data.cantidadgit}</td>
            </tr>`
        }
    }
    catch(e){
        console.log(e);
    }
}

function volver(){
    location.href="reportes.html";
}
       
document.querySelector("#btn_volver_reporte_4").addEventListener("click", volver);
document.querySelector("#btn_crear_reporte_4").addEventListener("click", crearReporte);
