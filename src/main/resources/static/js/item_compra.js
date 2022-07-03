'use strict';
    
    document.querySelector("#btn_volver_item_compra").addEventListener("click", volver);
    document.querySelector("#btn_alta_item_compra").addEventListener("click", altaItemCompra);
    document.querySelector("#btn_baja_item_compra").addEventListener("click", bajaItemCompra);
    document.querySelector("#btn_editar_item_compra").addEventListener("click", actualizarItemCompra);
    

    function volver(){
        location.href="index.html";
    }

    function altaItemCompra(){
        location.href="form_alta_item_compra.html";
    }

    function bajaItemCompra(){
        location.href="form_baja_item_compra.html";
    }

    function actualizarItemCompra(){
        location.href="form_editar_item_compra.html";
    }

    