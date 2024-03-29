<%-- 
    Document   : index
    Created on : 29-09-2019, 20:00:05
    Author     : yanis
    navbar-fixed-top (para que el header quede arriba siempre)
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
        <link rel="stylesheet" href="css/listacss.css">
    </head>
    <body>
        
        <hr>
        <div class="container bootstrap snippet">
            <div class="row">
                <div class="col-sm-10"><h1>Usuario (${sessionScope.idUsuario}): ${sessionScope.nombreUsuario}&nbsp;${sessionScope.apellidoUsuario}</h1></div><br>
                <div class="col-sm-2"><a href="index.jsp" class="pull-right"><img title="Restauramte Siglo XXI" class="img-circle img-responsive" src="img/icono.png" height="50" width="60"></a></div>
            </div>
            <div class="row">
                <div class="col-sm-3"><!--left col-->
                    <div class="text-center">
                      <img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png" class="avatar img-circle img-thumbnail" alt="avatar">
                      <h6>Subir nueva foto...</h6>
                      <input type="file" class="text-center center-block file-upload">
                    </div></hr><br>
                    <a href="salirServlet" class="pull-left">Cerrar sesion</a>
                    <br><br>
                    <a href="index.jsp" class="pull-left">Volver al inicio</a>
                </div><!--/col-3-->
                <br><br>
                <div class="col-sm-9">
                    <ul class="nav nav-tabs">
                        <li class="active"><a data-toggle="tab" href="#reservas">Reservas</a></li>
                        <li><a data-toggle="tab" href="#actualizar">Actulizar datos</a></li>
                    </ul>

                  <div class="tab-content">
                    <div class="tab-pane active" id="reservas">
                        <hr>
                        <c:choose>
                            <c:when test="${not empty sessionScope.reservasCliente}">
                                <br>
                                <a href="reserva.jsp" class="btn btn-success btn-xs"><b>+</b> Agregar reserva</a>
                                <br>
                                <div class="container">
                                    <div class="table-responsive row col-md-8 custyle">
                                    <table class="table table-striped custab">
                                    <thead>
                                        <tr>
                                            <th>Fecha reserva</th>
                                            <th>Hora Reserva</th>
                                            <th>Tipo de reserva</th>
                                            <th>Mesa</th>
                                            <th class="text-center">Accion</th>
                                        </tr>
                                    </thead>
                                    <c:forEach items="${sessionScope.reservasCliente}" var="reserva">
                                        <tr>
                                            <td>${reserva.fechaReserva}</td>
                                            <td>${reserva.horaReserva}</td>
                                            <td>${reserva.tipoReserva}</td>
                                            <td>${reserva.idmesa}</td>
                                            <td class="text-center">
                                                <a class='btn btn-info btn-xs' href="actualizarMesasServlet?idreserva=${reserva.idReserva}&idmesa=${reserva.idmesa}"><span class="glyphicon glyphicon-edit"></span> Editar</a> 
                                                <a href="cancelarReservaServlet?idreserva=${reserva.idReserva}&idmesa=${reserva.idmesa}&idcliente=${sessionScope.idCliente}" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Cancelar</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </table>
                                    </div>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <h2>Reservas</h2>
                                <p>No hay reservas</p>
                                <br>
                                <a href="reserva.jsp" class="btn btn-success btn-xs"><b>+</b> Agregar reserva</a>
                                <br>
                            </c:otherwise>
                        </c:choose>
                        
                    </div><!--/tab-pane-->
                    
                    <div class="tab-pane" id="actualizar">
                        <hr>
                        <form class="form" action="actualizarUsuarioServlet" method="post" id="registrationForm">
                            <input type="hidden" name="idusuario" value="${sessionScope.idUsuario}">
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label for="nombre"><h4>Nombre</h4></label>
                                    <input type="text" class="form-control" name="nombre" id="nombre" value="${sessionScope.nombreUsuario}">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label for="apellido"><h4>Apellido</h4></label>
                                    <input type="text" class="form-control" name="apellido" id="apellido" value="${sessionScope.apellidoUsuario}">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-6">
                                      <label for="rut"><h4>Rut</h4></label>
                                      <input type="text" class="form-control" name="rut" id="rut" value="${sessionScope.rutUsuario}">
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label for="correo"><h4>Correo</h4></label>
                                    <input type="email" class="form-control" name="correo" id="correo" value="${sessionScope.correoUsuario}">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label for="fono"><h4>Fono</h4></label>
                                    <input type="number" class="form-control" name="fono" id="fono" value="${sessionScope.fonoCliente}">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label for="contrasena"><h4>Contraseña</h4></label>
                                    <input type="password" class="form-control" name="contrasena" id="contrasena" value="${sessionScope.claveUsuario}">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-12">
                                    <br>
                                    <button class="btn btn-lg btn-success pull-right" type="submit"><i class="glyphicon glyphicon-ok-sign"></i> Actualizar</button>
                                </div>
                            </div>
                        </form>
                        
                      <hr>
                    
                    
                    </div><!--/tab-pane-->
                  </div><!--/tab-content-->
                  
              </div><!--/col-sm-9-->
              
            </div><!--/row-->
        </div>
    </body>

    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</html>
