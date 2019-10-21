/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$("#signup").click(function() {
$("#first").fadeOut("fast", function() {
$("#second").fadeIn("fast");
});
});

$("#signin").click(function() {
$("#second").fadeOut("fast", function() {
$("#first").fadeIn("fast");
});
});


  
         $(function() {
           $("form[name='login']").validate({
             rules: {
               
               correo: {
                 required: true,
                 email: true
               },
               contrasena: {
                 required: true,
                 
               }
             },
              messages: {
               correo: "Por favor ingrese un correo valido",
              
               contrasena: {
                 required: "Por favor ingrese una clave",
                
               }
               
             },
             submitHandler: function(form) {
               form.submit();
             }
           });
         });
         


$(function() {
  
  $("form[name='registration']").validate({
    rules: {
      nombre: "required",
      apellido: "required",
      rut: "required",
      correo: {
        required: true,
        email: true
      },
      contrasena: {
        required: true,
        minlength: 5
      }
    },
    
    messages: {
      nombre: "Por favor ingrese su nombre",
      apellido: "Por favor ingrese su apellido",
      rut: "Por favor ingrese su rut",
      contrasena: {
        required: "Por favor ingrese una clave",
        minlength: "Tu clave debe tener al menos 5 caracteres"
      },
      correo: "Por favor ingrese un correo valido"
    },
  
    submitHandler: function(form) {
      form.submit();
    }
  });
});
