'use strict';
    
    

    document.querySelector("#btn_volver_baja_compra").addEventListener("click", volver);
    document.querySelector("#btn_enviar_baja_compra").addEventListener("click", eliminar);
    
    function volver(){
        location.href="compra.html";
    }

    function eliminar(){
        
        alert("Borrado exitoso");
    }

    function cargarClientes(){
        var compras = new Array();
        var i 
        for (i = 0; i <= 10; i++) { 
            compras[i] = "id_compra_"+i;
        }
        const $select = document.querySelector("#select_compra");
        for (i = 0; i <= 10; i++) {
            const option = document.createElement('option');
            option.value = compras[i];
            option.text = compras[i];
            $select.appendChild(option);
        }
    }
    
  
    cargarClientes();

    //********************************************** */