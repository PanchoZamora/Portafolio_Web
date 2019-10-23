<%-- 
    Document   : index
    Created on : 21-10-2019, 17:22:34
    Author     : yanis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

	<title>XXI</title>

        <link rel="icon" href="img/icono.png">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->

        <script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
        <link href="https://fonts.googleapis.com/css?family=Kaushan+Script" rel="stylesheet">
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link rel="stylesheet" href="css/logincss.css">
        
      </head>
<body>
    <div class="container">
        <div class="row">
	<div class="col-md-5 mx-auto">
<!-- Iniciar sesion -->
		<div id="first">
                    <div class="myform form ">
                        <div class="logo mb-3">
                                <div class="col-md-12 text-center">
                               <h1>Iniciar Sesion</h1>
                       </div>
                    </div>
                        <form action="loginServlet" method="post" name="login">
                           <div class="form-group">
                              <label for="exampleInputEmail1">Correo Electronico</label>
                              <input type="email" name="correo"  class="form-control" id="email" aria-describedby="emailHelp" placeholder="Ingrese correo">
                           </div>
                           <div class="form-group">
                              <label for="exampleInputEmail1">Clave</label>
                              <input type="password" name="contrasena" id="password"  class="form-control" aria-describedby="emailHelp" placeholder="Ingrese clave">
                           </div>
                           <div class="col-md-12 text-center ">
                               <input type="submit" class=" btn btn-block mybtn btn-primary tx-tfm" value="Ingresar">
                           </div>
                           <div class="col-md-12 ">
                              <div class="login-or">
                                 <hr class="hr-or">
                                 <span class="span-or">or</span>
                              </div>
                           </div>
                           <div class="form-group">
                              <p class="text-center">¿No tienes cuenta? <a href="#" id="signup">Registrate aqui</a></p>
                           </div>
                        </form>
                        <div class="col-md-12 ">
                              <div class="form-group">
                                 <p class="text-center"><a href="index.jsp">Ir a la pagina</a></p>
                              </div>
                           </div>
			</div>
			</div>
                    <!-- Crear Cuenta -->        
			<div id="second">
			      <div class="myform form ">
                        <div class="logo mb-3">
                           <div class="col-md-12 text-center">
                              <h1 >Registrate</h1>
                           </div>
                        </div>
                            <form action="crearServlet" method="post" name="registration">
                           <div class="form-group">
                              <label for="exampleInputEmail1">Nombre</label>
                              <input type="text"  name="nombre" class="form-control" id="firstname" aria-describedby="emailHelp" placeholder="Ingrese nombre">
                           </div>
                           <div class="form-group">
                              <label for="exampleInputEmail1">Apellido</label>
                              <input type="text"  name="apellido" class="form-control" id="lastname" aria-describedby="emailHelp" placeholder="Ingrese apellido">
                           </div>
                            <div class="form-group">
                              <label for="exampleInputEmail1">Rut</label>
                              <input type="text" name="rut"  class="form-control" id="rut" aria-describedby="emailHelp" placeholder="Ingrese rut">
                           </div>
                           <div class="form-group">
                              <label for="exampleInputEmail1">Correo Electronico</label>
                              <input type="email" name="correo"  class="form-control" id="email" aria-describedby="emailHelp" placeholder="Ingrese correo">
                           </div>
                            
                           <div class="form-group">
                              <label for="exampleInputEmail1">Clave</label>
                              <input type="password" name="contrasena" id="password"  class="form-control" aria-describedby="emailHelp" placeholder="Ingrese clave">
                           </div>
                           <div class="col-md-12 text-center mb-3">
                               <input type="submit" class=" btn btn-block mybtn btn-primary tx-tfm" value="Registrarme">
                           </div>
                           <div class="col-md-12 ">
                              <div class="form-group">
                                 <p class="text-center"><a href="#" id="signin">Ya tengo una cuenta</a></p>
                              </div>
                           </div>
                            <div class="col-md-12 ">
                              <div class="form-group">
                                 <p class="text-center"><a href="index.jsp">Ir a la pagina</a></p>
                              </div>
                        </div>
                        </form>

                        </div>
                            
                                 
                     </div>
		</div>
		</div>
      </div>   
    <script src="js/loginjs.js"></script>     
</body>
</html>