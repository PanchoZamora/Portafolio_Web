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
	<!-- Google font -->
	<link href="http://fonts.googleapis.com/css?family=Playfair+Display:900" rel="stylesheet" type="text/css" />
	<link href="http://fonts.googleapis.com/css?family=Alice:400,700" rel="stylesheet" type="text/css" />

	<!-- Bootstrap -->
	<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />

	<!-- Custom stlylesheet -->
	<link type="text/css" rel="stylesheet" href="css/style.css" />
        
</head>

<body>
	<div id="booking" class="section">
		<div class="section-center">
			<div class="container">
				<div class="row">
					<div class="booking-form">
						<div class="booking-bg">
							<div class="form-header">
								<h2>Haz tu reserva aqui</h2>
								<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Cupiditate laboriosam numquam at</p>
							</div>
						</div>
                                                <form action="" method="">
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<span class="form-label">Fecha de la reserva</span>
										<input class="form-control" type="date" required>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
                                                                                <span class="form-label">Horario de la reserva</span>
                                                                                <select class="form-control" name="hora" required>
                                                                                        <option value="" selected hidden>Seleccione una hora</option>
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
                                                                                <span class="select-arrow"></span>
                                                                        </div>
								</div>
							</div>
                                                        <div class="form-group">
                                                                <span class="form-label">Tipo de mesa</span>
                                                                <select class="form-control" name="mesa" required>
                                                                        <option value="" selected hidden>Seleccione mesa</option>
									<option>Private Room (1 to 2 People)</option>
									<option>Family Room (1 to 4 People)</option>
                                                                </select>
                                                                <span class="select-arrow"></span>
                                                        </div>
							<div class="form-group">
								<span class="form-label">Tipo de reserva</span>
								<select class="form-control" name="tipo" required>
									<option value="" selected hidden>Seleccione tipo de reserva</option>
									<option>Private Room (1 to 2 People)</option>
									<option>Family Room (1 to 4 People)</option>
								</select>
								<span class="select-arrow"></span>
							</div>
							<div class="form-btn">
								<button class="submit-btn">Reservar</button>
							</div>
                                                    <br>
                                                    <div class="col-md-12 ">
                                                            <div class="form-group">
                                                               <p class="text-right"><a href="index.jsp">Volver a la pagina</a></p>
                                                            </div>
                                                      </div>
						</form>
                                             
					</div>
				</div>
			</div>
		</div>
	</div>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>