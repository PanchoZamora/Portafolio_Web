<%-- 
    Document   : reserva
    Created on : 10-10-2019, 18:37:28
    Author     : yanis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <link rel="stylesheet" href="css/estilos.css">
    </head>
    <body>
        <div class="container">
        <div id="accordion">
            <div class="row">
                <div class="col-lg-12">
                    <div class="text-center">
                        <h3 style="color: cornflowerblue">Crear Reserva</h3>
                    </div>
                </div>
            </div>

            <div>
                <div class="card-header">
                    <h4 class="card-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">
                            <i class="glyphicon glyphicon-cutlery"></i>
                            <b> Ingrese los siguientes datos para crear su reserva</b>
                        </a>
                    </h4>
                </div>
                <div id="collapse1" class="collapse show">
                    <div class="card-body">
                        <br>
                        <div class="row">
                            <div class="col-md-3 col-lg-4">
                                <div class="form-group">
                                    <label class="control-label">Cantidad de personas</label>
                                    <select name='personas' class="form-control">
                                        <option>Seleccione una cantidad de personas</option>
                                        <option value="1" >1</option>
                                        <option value="2" >2</option>
                                        <option value="3" >3</option>
                                        <option value="4" >4</option>
                                        <option value="5" >5</option>
                                        <option value="6" >6</option>
                                        <option value="7" >7</option>
                                        <option value="8" >8</option>
                                        
                                    </select>
                                </div>
                            </div>

                            <div class="col-md-2 col-lg-3 col-md-offset-1">
                                <div class="form-group">
                                    <label class="control-label">Seleccionar Fecha</label>
                                    <div class="input-group date">
                                        <input type="date" id="start" name="trip-start" value="" min="2019-10-13" max="2019-12-31">
                                        <span class="glyphicon glyphicon-calendar" style="margin-left: 10px"></span>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="col-md-1 col-lg-4">
                                <div class="form-group">
                                    <label class="control-label">Horario</label>
                                    <select name='personas' class="form-control">
                                        <option>Seleccione un horario</option>
                                        <option value="" >13:00</option>
                                        <option value="" >13:30</option>
                                        <option value="" >14:00</option>
                                        <option value="" >14:30</option>
                                        <option value="" >15:00</option>
                                        <option value="" >15:30</option>
                                        <option style="font-size: 1pt; background-color: #000000;" disabled>&nbsp;</option>
                                        <option value="" >16:00</option>
                                        <option value="" >16:30</option>
                                        <option value="" >17:00</option>
                                        <option value="" >17:30</option>
                                        <option value="" >18:00</option>
                                        <option value="" >18:30</option>
                                        
                                    </select>
                                </div>
                            </div>
                        </div>

                        
                    </div>`
                </div>
            </div>
            <br />
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="pull-right">
                    <a href="#" class="btn btn-success btn-lg" id="btnSubmit"><i class="fa fa-save"></i> Guargar</a>
                    <a class="btn btn-warning btn-lg" href="index.jsp" id="btnToTop"><i class="fa fa-arrow-up"></i> Volver</a>
                </div>
            </div>
        </div>
        </div>
    <script src="js/mijs.js"></script>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>
