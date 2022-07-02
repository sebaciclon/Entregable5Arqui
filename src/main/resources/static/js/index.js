'use strict';
    
    document.querySelector("#btn_cliente").addEventListener("click", irCliente);
    document.querySelector("#btn_producto").addEventListener("click", irProducto);
    document.querySelector("#btn_compra").addEventListener("click", irCompra);
    document.querySelector("#btn_reportes").addEventListener("click", irReportes);
    
    function irCliente(){
        location.href="cliente.html";
    }

    function irProducto(){
        location.href="producto.html";
    }

    function irCompra(){
        location.href="compra.html";
    }

    function irReportes(){
        location.href="reportes.html";
    }

    