<%-- 
    Document   : newcrear
    Created on : 10-10-2019, 17:39:24
    Author     : yanis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>XXI</title>
        <meta name="viewport" content="width=device-width, user-scalable=no, inicial-scale=1.0, maximun-scale=1.0, minimum-scale=1.0">  
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <link rel="icon" href="img/icono.png">
        <link rel="stylesheet" href="css/carousel.css"> 
        <link rel="stylesheet" href="css/signin.css">
    </head>
    <body>
       <br> 
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <div class="well well-sm">
                        <form class="form-horizontal" method="post" action="crearServlet">
                            <fieldset>
                                <legend class="text-center header">Crear Usuario</legend>

                                <div class="form-group">
                                    <label class="control-label col-md-3" for="nombre">Nombre:</label>
                                    <div class="col-md-6">
                                        <input id="nombre" name="nombre" type="text" placeholder="" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3" for="apellidos">Apellido:</label>
                                    <div class="col-md-6">
                                        <input id="apellido" name="apellido" type="text" placeholder="" class="form-control">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label col-md-3" for="rut">Rut:</label>
                                    <div class="col-md-6">
                                        <input id="rut" name="rut" type="text" placeholder="" class="form-control">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label col-md-3" for="nombre">Correo:</label>
                                    <div class="col-md-6">
                                        <input id="correo" name="correo" type="text" placeholder="" class="form-control">
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label class="control-label col-md-3" for="contrasena">Contraseña:</label>
                                    <div class="col-md-6">
                                        <input id="contrasena" name="contrasena" type="password" placeholder="" class="form-control">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-md-12 text-center">
                                        <button type="submit" class="btn btn-primary btn-lg">Crear</button>
                                    </div>
                                </div>
                                
                                <a href="index.jsp" class="pull-right"> Cancelar</a>
                            </fieldset>
                        </form>
                        <c:if test="${resquestScope.mensaje != null}">
                            <p>${resquestScope.mensaje}</p>
                        </c:if>    
                    </div>
                </div>
                <div class="col-md-4">
                    <img class="featurette-image img-responsive center-block" src="img/usuario.jpg" alt="">
                </div>
            </div>
        </div>
        
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>
