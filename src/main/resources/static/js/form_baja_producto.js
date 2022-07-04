'use strict';
    
const base = "http://localhost:8080/api/";
   
    function eliminarProducto(){
        let id_producto = document.querySelector("#id_producto").value;
        let url = base + "products/" + id_producto;
        
        fetch(url, {
            "method": "DELETE",
            "mode": "cors"
        })
        .catch(error => console.log(error.message))
        alert("Se eliminó correctamente el producto!");
    }    
  
    function volver(){
        location.href="producto.html";
    }

  
document.querySelector("#btn_volver_baja_producto").addEventListener("click", volver);
document.querySelector("#btn_eliminar_producto").addEventListener("click", eliminarProducto);
