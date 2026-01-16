// Variables 

let mensaje = document.getElementById("mensaje");
let btnCambiar = document.getElementById("btnCambiar");
let nombreInput = document.getElementById("nombre");
let btnSaludar = document.getElementById("btnSaludar");
let saludo = document.getElementById("saludo");

// Eventos 

btnCambiar.addEventListener("click", function() {
    

    mensaje.textContent = "¡El texto ha sido cambiado!";

});

// Evento con estructura de control 

btnSaludar.addEventListener("click", function() {

    let nombre = nombreInput.value;

    if (nombre === "") {
        saludo.textContent = "Por favor, ingresa tu nombre.";
    }else{
        saludo.textContent = " Hola " + nombre +  " , ¡bienvenido/a!";
    }

});

    



    