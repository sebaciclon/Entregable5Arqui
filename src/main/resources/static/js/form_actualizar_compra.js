'use strict';
    
    

    document.querySelector("#btn_volver_actualizar_compra").addEventListener("click", volver);
    document.querySelector("#btn_enviar_actualizar_compra").addEventListener("click", actualizar);
    
    function volver(){
        location.href="compra.html";
    }

    function actualizar(){
        
        alert("Actualizacion exitoso");
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