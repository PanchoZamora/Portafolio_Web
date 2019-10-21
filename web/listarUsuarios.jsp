<%-- 
    Document   : listarUsuarios
    Created on : 30-09-2019, 20:00:42
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
        <div class='container'>
            <br>
            <div class="card-header col-md-offset-5">
                <h3>Usuarios</h3>
            </div>
            <br>
            <div class="form-group">
                <form>
                    <label class="control-label">Buscar: <label>
                    <input id="searchTerm" type="text" onkeyup="doSearch()" />
                </form>
            </div>
            <div class="table-responsive">
                <table class="table table-bordered table-hover" id="datos">
                    <tr class="success">
                        <th class="col-md-2">Nombre</th>
                        <th class="col-md-2">Apellido</th>
                        <th class="col-md-3">Rut</th>
                        <th class="col-md-3">Correo</th>
                        <th class="col-md-2"></th>
                    </tr>
                    <tr>
                        <td>nombre 1</td>
                        <td>apellido 1</td>
                        <td>rut 1</td>
                        <td>correo 1</td>
                        <td>
                            <form>
                                <div class="col-md-offset-3">
                                    <input class="btn btn-danger" type="button" onclick="alerta('nombre1')" value="Eliminar">
                                </div>
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td>nombre2</td>
                        <td>apellido 2</td>
                        <td>rut 2</td>
                        <td>correo 2</td>
                        <td>
                            <form>
                                <div class="col-md-offset-3">
                                    <input class="btn btn-danger" type="button" onclick="alerta('nombre2')" value="Eliminar">
                                </div>
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td>nombre3</td>
                        <td>apellido 3</td>
                        <td>rut 3</td>
                        <td>correo 3</td>
                        <td>
                            <form>
                                <div class="col-md-offset-3">
                                    <input class="btn btn-danger" type="button" onclick="alerta('nombre2')" value="Eliminar">
                                </div>
                            </form>
                        </td>
                    </tr>
                    <tr class='noSearch hide'>
                        <td colspan="5"></td>
                    </tr>
                </table>
            </div>
        </div>
        
        <script type="text/javascript" src="js/mijs.js"></script>
        c
    </body>
</html>
