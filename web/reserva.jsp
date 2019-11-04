<%-- 
    Document   : index
    Created on : 21-10-2019, 17:22:34
    Author     : yanis
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                                                <form action="crearReservaServlet" method="post">
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<span class="form-label">Fecha de la reserva</span>
										<input class="form-control" type="date" name="fecha" required>
                                                                                <input type="hidden" name="idcliente" value="${sessionScope.idCliente}" >
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
                                                                                <span class="form-label">Horario de la reserva</span>
                                                                                <select class="form-control" name="hora" required>
                                                                                        <option value="" selected hidden>Seleccione una hora</option>
                                                                                        <option value="13:00" >13:00</option>
                                                                                        <option value="13:30" >13:30</option>
                                                                                        <option value="14:00" >14:00</option>
                                                                                        <option value="14:30" >14:30</option>
                                                                                        <option value="15:00" >15:00</option>
                                                                                        <option value="15:30" >15:30</option>
                                                                                        <option style="font-size: 1pt; background-color: #000000;" disabled>&nbsp;</option>
                                                                                        <option value="16:00" >16:00</option>
                                                                                        <option value="16:30" >16:30</option>
                                                                                        <option value="17:00" >17:00</option>
                                                                                        <option value="17:30" >17:30</option>
                                                                                        <option value="18:00" >18:00</option>
                                                                                        <option value="18:30" >18:30</option>
                                                                                </select>
                                                                                <span class="select-arrow"></span>
                                                                        </div>
								</div>
							</div>
                                                        <div class="form-group">
                                                                <span class="form-label">Mesa</span>
                                                                <select class="form-control" name="mesa" required>
                                                                    <c:choose>
                                                                        <c:when test="${not empty sessionScope.mesasDisponibles}">
                                                                            <option value="" selected hidden>Seleccione mesa</option>
                                                                            <c:forEach items="${sessionScope.mesasDisponibles}" var="mesa">
                                                                                <option value="${mesa.id}">Mesa: ${mesa.id} | Capacidad: ${mesa.capacidad}</option>
                                                                            </c:forEach> 
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <option value="" selected hidden>No hay mesas disponibles</option>
                                                                        </c:otherwise>
                                                                    </c:choose>
								</select>
                                                                <span class="select-arrow"></span>
                                                        </div>
							<div class="form-group">
								<span class="form-label">Tipo de reserva</span>
								<select class="form-control" name="tipo" required>
                                                                    
									<option value="" selected hidden>Seleccione tipo de reserva</option>
									<option value="individual">Individual</option>
									<option value="doble">Doble</option>
                                                                        <option value="otro">Otro (3 o mas personas)</option>
								</select>
								<span class="select-arrow"></span>
							</div>
							<div class="form-btn">
                                                            <input type="submit" class="submit-btn" value="Reservar">
							</div>
                                                    <br>
                                                    <div class="col-md-12 ">
                                                            <div class="form-group">
                                                               <p class="text-right"><a href="index.jsp" >Volver al inicio</a></p>
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