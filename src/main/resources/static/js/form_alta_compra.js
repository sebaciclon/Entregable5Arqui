'use strict';
    
    const base = "localhost:8080/api/";

    document.querySelector("#btn_volver_alta_compra").addEventListener("click", volver);
    document.querySelector("#btn_enviar_alta_compra").addEventListener("click", generarCompraIrADetalle);
    
    function volver(){
        location.href="compra.html";
    }

    function generarCompraIrADetalle(){
        
        location.href="form_alta_detalle_compra.html";
    }

    async function getClientes() {
        
        const response = await fetch(base + "clients", {
            "method": 'GET',
            "mode": 'no-cors'
        });
        const data = await response.json();
        alert(data);
        /*
        data.forEach(cliente => {
            lista += 
            `<li class="list-group-item">
                <div class="name">
                    <h2><b>${estudiante.nombres} ${estudiante.apellidos}</b></h2>
                </div>
                <div class="name">
                    <h3>LU: ${estudiante.lu} Edad: ${estudiante.edad} DNI: ${estudiante.dni} Género: ${estudiante.genero}</h3>
                </div>
            </li>`;
        lista_estudiantes.innerHTML = lista;
        });*/
    }

    function cargarClientes(){
        var clientes = new Array();
        var i 
        for (i = 0; i <= 10; i++) { 
            clientes[i] = "id_"+i;
        }
        const $select = document.querySelector("#select_cliente");
        for (i = 0; i <= 10; i++) {
            const option = document.createElement('option');
            option.value = clientes[i];
            option.text = clientes[i];
            $select.appendChild(option);
        }
    }
    
  
    cargarClientes();
    getClientes();

    //********************************************** */