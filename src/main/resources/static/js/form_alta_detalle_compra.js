'use strict';
    
document.querySelector("#btn_volver_detalle_compra").addEventListener("click", volver);
document.querySelector("#btn_fin_compra").addEventListener("click", volver); 
document.querySelector("#btn_add_producto").addEventListener("click", agregarProducto);

function volver(){
    location.href="compra.html";
}

function agregarProducto(){
    alert("Agregado el producto!!!!!");
}

function cargarProductos(){
    var productos = new Array();
    var i 
    for (i = 0; i <= 10; i++) { 
        productos[i] = "id_prod_"+i;
    }
    const $select = document.querySelector("#select_producto");
    for (i = 0; i <= 10; i++) {
        const option = document.createElement('option');
        option.value = productos[i];
        option.text = productos[i];
        $select.appendChild(option);
    }
}


cargarProductos();