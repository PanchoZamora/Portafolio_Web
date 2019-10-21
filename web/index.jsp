
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
        <link rel="stylesheet" href="css/estilos.css">
    </head>
<!-- NAVBAR
================================================== -->
  <body data-spy="scroll" data-target="#navegacion">
    <div class="navbar-wrapper">
      <div class="container">
        <nav class="navbar navbar-inverse navbar-fixed-top navigation">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navegacion" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Menu</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="#">
                  <span class="glyphicon glyphicon-grain" aria-hidden="true"></span> Restaurante Siglo XXI
              </a>
            </div>
            <div id="navegacion" class="navbar-collapse collapse">
              <ul class="nav navbar-nav" role="tablist">
                <li class="active"><a href="#seccion1">Inicio</a></li>
                <li><a href="#seccion2">Nosotros</a></li>
                <li><a href="#seccion3">Ubicacion</a></li>
                <li><a href="#seccion4">Contacto</a></li>
              </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="perfil.jsp" >Perfil</a></li>
                </ul>    
                <a href="#iniciar" class="btn btn-default navbar-btn navbar-right btn-primary" data-toggle="modal">
                    Mi cuenta <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                </a>
            </div>
          </div>
        </nav>
      </div>
    </div>
    <!-- Iniciar Sesion -->
    <div class="modal fade " id="iniciar">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button class="close" type="button" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h3 style="text-align: center">Iniciar sesion</h3>
                </div>
                <div class="modal-body">
                    <form class="form-signin">
                        <label for="inputEmail" class="sr-only">Correo Electronico</label>
                        <input type="email" id="inputEmail" class="form-control" placeholder="Correo Electronico" required autofocus>
                        <br>
                        <label for="inputPassword" class="sr-only">Contraseña</label>
                        <input type="password" id="inputPassword" class="form-control" placeholder="Contraseña" required>
                        <div class="checkbox">
                          <label>
                            <input type="checkbox" value="remember-me"> Recuerdame
                          </label>
                        </div>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Ingresar</button>
                    </form>
                    <br>
                    <a href="crearUsuario.jsp" >Crear una cuenta</a>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-default" type="button" data-dismiss="modal"> Cancelar</button>
                </div>
            </div>
        </div>
    </div>
    <!-- Carousel
    ================================================== -->
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
          <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
          <li data-target="#myCarousel" data-slide-to="1"></li>
          <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        
        <div class="carousel-inner" role="listbox">
          <div class="item active">
            <img class="first-slide" src="img/entrada.jpg" alt="First slide">
            <div class="container" >
              <div class="carousel-caption">
                <h1>Example headline.</h1>
                <p>Note: If you're viewing this page via a, the "next" and "previous" Glyphicon buttons on the left and right might not load/display properly due to web browser security rules.</p>
                <p><a class="btn btn-lg btn-success" href="#iniciar" data-toggle="modal">Reservar</a></p>
              </div>
            </div>
          </div>
            
          <div class="item">
            <img class="second-slide" src="img/adentro.jpg" alt="Second slide">
            <div class="container">
              <div class="carousel-caption">
                <h1>Another example headline.</h1>
                <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
              </div>
            </div>
          </div>
            
          <div class="item">
            <img class="third-slide" src="img/comida.jpg" alt="Third slide">
            <div class="container">
              <div class="carousel-caption">
                <h1>One more for good measure.</h1>
                <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
              </div>
            </div>
          </div>
            
        </div>
        
        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
          <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
          <span class="sr-only">Anterior</span>
        </a>
        
        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
          <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
          <span class="sr-only">Siguiente</span>
        </a>
        
      </div><!-- /.carousel -->

          <!-- Marketing messaging and featurettes
          ================================================== -->
          <!-- Wrap the rest of the page in another container to center all the content. -->


          <div class="container marketing">
              <div class="seccion1">
                  <div class="row">
                    <div class="col-lg-4">
                      <img class="img-circle" src="img/platillo.jpg" alt="Generic placeholder image" width="140" height="140">
                      <h2>Platos</h2>
                      <p>Donec sed odio dui. Etiam porta sem malesuada magna mollis euismod. Nullam id dolor id nibh ultricies vehicula ut id elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Praesent commodo cursus magna.</p>

                    </div><!-- /.col-lg-4 -->
                    <div class="col-lg-4">
                      <img class="img-circle" src="img/postre.jpg" alt="Generic placeholder image" width="140" height="140">
                      <h2>Postres</h2>
                      <p>Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh.</p>

                    </div><!-- /.col-lg-4 -->
                    <div class="col-lg-4">
                      <img class="img-circle" src="img/tragos.jpg" alt="Generic placeholder image" width="140" height="140">
                      <h2>Tragos</h2>
                      <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>

                    </div><!-- /.col-lg-4 -->
                  </div><!-- /.row -->
              </div>
            <!-- Three columns of text below the carousel -->
            
      <!-- START THE FEATURETTES -->

        <hr class="featurette-divider">
        
        <div class="seccion" id="seccion2">
            <div class="row featurette">
              <div class="col-md-5">
                <img class="featurette-image img-responsive center-block" src="img/ambientes-llenos-de-lujo.jpg" alt="Ambiente de lujo" style="margin-left: 10px;">
              </div>
              <div class="col-md-6">
                <h2 class="featurette-heading">Restaurante del Siglo XXI<br><small> A tu medida</small></h2>
                <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
                <p><a class="btn btn-lg btn-success col-md-offset-4" href="reserva.jsp">Reservar</a></p>
              </div>
            </div>
        </div>

        <hr class="featurette-divider">
        
        <div class="seccion" id="seccion3">
            <div class="row featurette">
              <div class="col-md-6 col-md-offset-1">
                <h2 class="featurette-heading">Nos ubicamos en Las Condes<br><small>Linneo 1358,Las Condes,Santiago</small></h2>
                <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
              </div>
              <div class="col-md-5">
                  <img class="featurette-image img-responsive center-block" src="img/ubicacion.JPG" alt="Generic placeholder image">
              </div>
            </div>
        </div>
        <hr class="featurette-divider">
        <div class="seccion" id="seccion4">
            <div class="row featurette">
              <div class="col-md-7 col-md-offset-1">
                <h2 class="featurette-heading">¿Tienes alguna duda o consulta? <br><small>Contactanos</small></h2>
                <p class="lead">Ingresa tu nombre, correo electronico y lo que quieras decirnos abajo.<br> Tambien puedes llamarnos a nuestro numero de telefono <strong>+56954637482</strong></p>
                <form class='form-horizontal col-md-offset-1' action='' method="">
                    <div class='form-group'>
                        <label for='nombre' class='control-label col-md-2'>Nombre:</label>
                        <div class="col-md-6">
                            <input class='form-control' id='nombre' type='text' required>
                        </div>
                    </div>
                    <div class='form-group'>
                        <label for='correo' class='control-label col-md-2'>Correo:</label>
                        <div class="col-md-6">
                            <input class='form-control' id='correo' type='text' required>
                        </div>
                    </div>
                    <div class='form-group'>
                        <label for='consulta' class='control-label col-md-2'>Consulta:</label>
                        <div class="col-md-7">
                            <textarea class='form-control' id='consulta' rows="10" cols="70" required></textarea>
                        </div>
                    </div>

                    <div class='form-group'>
                        <div class="col-md-6 col-md-offset-2">
                            <input class='btn btn-danger btn-block' type='submit' value='Enviar'>
                        </div>
                    </div>
                </form>
              </div>
              <div class="col-md-2" >
                <img class="img-circle img-responsive center-block" src="img/correo.jpg" alt="Generic placeholder image" width="140" height="140">
              </div>
            </div>
        </div>
        <hr class="featurette-divider">

            <!-- /END THE FEATURETTES -->
      </div>
    
      <!-- FOOTER -->
      <footer>
        <p class="pull-right" style="margin-right: 20px"><a href="#">Volver</a></p>
        <p class="textfooter">&copy; 2019 Restaurante Siglo XXI &middot; </p>
      </footer>

    </div><!-- /.container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  </body>
</html>
