'use strict';

const base = "http://localhost:8080/api/";



async function crearReporte(){
    let url = base + "clients/" + "report";
    let tabla= document.getElementById("DOM_reporte_3");
    try {
        let r= await fetch (url);
        let json= await r.json();
        for (let data of json){
            tabla.innerHTML += `
            <tr id="fila">
                <td>${data.nombre}</td>
                <td>${data.monto}</td>
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
       
document.querySelector("#btn_volver_reporte_3").addEventListener("click", volver);
document.querySelector("#btn_crear_reporte_3").addEventListener("click", crearReporte);
