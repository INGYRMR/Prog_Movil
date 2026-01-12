// ===== Variables =====
let mensaje = document.getElementById("mensaje");
let btnCambiar = document.getElementById("btnCambiar");
let btnAlerta = document.getElementById("btnAlerta");
let btnSaludar = document.getElementById("btnSaludar");
let nombreInput = document.getElementById("nombre");
let saludo = document.getElementById("saludo");

// ===== Evento: cambiar texto =====
btnCambiar.addEventListener("click", function () {
  mensaje.textContent = "¡Este texto fue cambiado con JavaScript!";
});

// ===== Evento: mostrar alerta =====
btnAlerta.addEventListener("click", function () {
  alert("Hola, esto es JavaScript en acción 🚀");
});

// ===== Evento: saludar =====
btnSaludar.addEventListener("click", function () {
  let nombre = nombreInput.value;

  if (nombre === "") {
    saludo.textContent = "Por favor escribe tu nombre.";
  } else {
    saludo.textContent = "Hola " + nombre + ", bienvenido a JavaScript 👋";
  }
});
