'use strict';
    
    //const base = "http://localhost:8080/Entregable2/rest/";
    
    

    
    document.querySelector("#btn_volver_reportes").addEventListener("click", volver);
    document.querySelector("#btn_reporte3").addEventListener("click", reporte3);
    document.querySelector("#btn_reporte4").addEventListener("click", reporte4);
    document.querySelector("#btn_reporte5").addEventListener("click", reporte5);
    
    function volver(){
        location.href="index.html";
    }

    function reporte3(){
        location.href="reporte_3.html";
    }

    function reporte4(){
        location.href="reporte_4.html";
    }

    function reporte5(){
        location.href="reporte_5.html";
    }

    