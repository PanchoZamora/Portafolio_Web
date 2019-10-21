<%-- 
    Document   : editarUsuario
    Created on : 30-09-2019, 16:47:07
    Author     : yanis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, user-scalable=no, inicial-scale=1.0, maximun-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="css/estilos.css">    
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body>
        <div class="container-fluid">
            <header>
                Restaurante Siglo XXI
                <button type="button" class="btn btn-default" aria-label="Left Align">
                    <span class="glyphicon glyphicon-align-left" aria-hidden="true"></span>
                </button>
            </header>
        </div>
        <div class='container'>
            <br>
            <div class="card-header col-md-offset-2">
                <h4>Modificar Usuario</h4>
            </div>
            <br>
            <form class='form-horizontal' action='' method="">
                <div class='form-group'>
                    <label for='nombre' class='control-label col-md-2'>Nombre:</label>
                    <div class="col-md-4">
                        <input class='form-control' id='nombre' type='text' required>
                    </div>
                </div>
                <div class='form-group'>
                    <label for='apellido' class='control-label col-md-2'>Apellido:</label>
                    <div class="col-md-4">
                        <input class='form-control' id='apellido' type='text' required>
                    </div>
                </div>
                <div class='form-group'>
                    <label for='rut' class='control-label col-md-2'>Rut:</label>
                    <div class="col-md-4">
                        <input class='form-control' id='rut' type='text' required>
                    </div>
                </div>
                <div class='form-group'>
                    <label for='correo' class='control-label col-md-2'>Correo:</label>
                    <div class="col-md-4">
                        <input class='form-control' id='correo' type='text' required>
                    </div>
                </div>
                <div class='form-group'>
                    <label for='contrasena' class='control-label col-md-2'>Contraseña:</label>
                    <div class="col-md-4">
                        <input class='form-control' id='contrasena' type='text' required>
                    </div>
                </div>
                
                <div class='form-group'>
                    <div class="col-md-6 col-md-offset-2">
                        <input class='btn btn-primary' type='submit' value='Registrar'>
                    </div>
                </div>
            </form>
        </div>
        
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>
