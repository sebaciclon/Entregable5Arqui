'use strict';
 
const base = "http://localhost:8080/api/";

async function crearReporte(){
    let url = base + "products/" + "report";
    let tabla= document.getElementById("DOM_reporte_5");
    try {
        let r= await fetch (url);
        let respuesta= await r.json();
        tabla.innerHTML += `
            <tr id="fila">
                <td>${respuesta.producto.name}</td>
                <td>${respuesta.cantidad}</td>
            </tr>`
        
    }
    catch(e){
        console.log(e);
    }
}

function volver(){
    location.href="reportes.html";
}
  
document.querySelector("#btn_volver_reporte_5").addEventListener("click", volver);
document.querySelector("#btn_crear_reporte_5").addEventListener("click", crearReporte);

