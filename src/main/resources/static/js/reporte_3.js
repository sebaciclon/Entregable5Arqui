'use strict';

const base = "http://localhost:8080/Entregable5Arqui/api/";

document.querySelector("#btn_volver_reporte_3").addEventListener("click", volver);
document.querySelector("#btn_crear_reporte_3").addEventListener("click", crearReporte);

async function crearReporte() {
    alert("Generado reporte 3");
    /*
    const response = await fetch(base + "", {
        "method": 'GET',
        "mode": 'no-cors'
    });
    const data = await response.json();
    let lista_resultados = document.querySelector("#DOM_reporte_3");
    let lista = "";
    data.forEach(resultado => {
        lista += 
        `<li class="list-group-item">
            <div class="name">
                <h2><b>${resultado.cliente.nombre} ${resultado.valor}</b></h2>
            </div>
        </li>`;
    lista_resultados.innerHTML = lista;
    });
    */

    let lista_resultados = document.querySelector("#DOM_reporte_3");
    let lista = "";
    
        lista += 
        `<li class="list-group-item">
            <div class="name">
                <h2><b>Leonardo Esains 456</b></h2>
            </div>
        </li>
        <li class="list-group-item">
            <div class="name">
                <h2><b>Juan María Cabral 6987</b></h2>
            </div>
        </li>`;
    lista_resultados.innerHTML = lista;
   
    
}

function volver(){
    location.href="reportes.html";
}
        