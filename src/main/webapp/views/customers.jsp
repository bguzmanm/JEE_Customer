<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de Clientes</title>
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
<script src="https://kit.fontawesome.com/81a2ed02b0.js" crossorigin="anonymous"></script>	
	
</head>
<body>
	<div class="container">

		<%@include file="/views/menu.jsp"%>

		<h1>Listado de Clientes</h1>
		<table class="table" id="tblCustomers">
			<thead class="table-dark">
				<tr>
					<th>#</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Email</th>
					<th>Activo</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="c" items="${customer}">
					<tr>
						<td><c:out value="${c.getCustomer_id()}"></c:out></td>
						<td><c:out value="${c.getFirst_name()}"></c:out></td>
						<td><c:out value="${c.getLast_name()}"></c:out></td>
						<td><c:out value="${c.getEmail()}"></c:out></td>
						<td>
						
						<c:if test="${c.isActive()}">
							<input class="form-check-input" type="checkbox" id="active" disabled checked="checked">
						</c:if>
						<c:if test="${!c.isActive()}">
							<input class="form-check-input" type="checkbox" id="active" disabled>
						</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$('#tblCustomers').DataTable();
		})
	</script>
	
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