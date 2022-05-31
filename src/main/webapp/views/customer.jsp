<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vista Cliente</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<link rel="stylesheet"
	href="https://cdn.datatables.net/1.12.0/css/jquery.dataTables.min.css">

<script
	src="https://cdn.datatables.net/1.12.0/js/jquery.dataTables.min.js"></script>
<script src="https://kit.fontawesome.com/81a2ed02b0.js"
	crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">

		<%@include file="/views/menu.jsp"%>


		<h1>Vista de Cliente</h1>

		<form class="form"
			action="${pageContext.request.contextPath}/customers" method="post">

			<input type="hidden" value="${customer.getCustomer_id()}">

			<div class="mb-3 row">
				<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="nombre"
						value="${customer.getFirst_name()}">
				</div>
			</div>
			<div class="mb-3 row">
				<label for="apellido" class="col-sm-2 col-form-label">Apellido</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="apellido"
						value="${customer.getLast_name()}">

				</div>
			</div>
			<div class="mb-3 row">
				<label for="email" class="col-sm-2 col-form-label">Email</label>
				<div class="col-sm-10">
					<input type="email" class="form-control" id="email"
						value="${customer.getEmail()}">
				</div>
			</div>
			<div class="mb-3 row">
				<label for="direccion" class="col-sm-2 col-form-label">Direccion</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="direccion"
						value="${customer.getAddress()}">
				</div>
			</div>
			<div class="mb-3 row">
				<label for="ciudad" class="col-sm-2 col-form-label">Ciudad</label>
				<div class="col-sm-10">
					<input type="text" class="form-control-plaintext" readonly id="ciudad" 
						value="${customer.getCity()}">
				</div>
			</div>
			<div class="mb-3 row">
				<label for="pais" class="col-sm-2 col-form-label">País</label>
				<div class="col-sm-10">
					<input type="text" class="form-control-plaintext" readonly id="pais" 
						value="${customer.getCountry()}">
				</div>
			</div>
			<div class="mb-3 row">
				<label for="activo" class="col-sm-2 col-form-label">Activo</label>
				<div class="col-sm-10">
					<c:if test="${customer.isActive()}">
						<input class="form-check-input" type="checkbox" name="activo"
							id="activo" checked="checked">
					</c:if>
					<c:if test="${!customer.isActive()}">
						<input class="form-check-input" type="checkbox" name="activo"
							id="activo">
					</c:if>
				</div>
			</div>

			<button type="submit" class="btn btn-success">Guardar</button>
		</form>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"
		integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js"
		integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy"
		crossorigin="anonymous"></script>


</body>
</html>