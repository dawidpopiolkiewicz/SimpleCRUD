<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<title>SimpleCRUD</title>
</head>
<body>

	<nav class="navbar navbar-dark bg-primary" style="color: white">
		<h3>
			<i>SimpleCRUD</i>
			<h3>
	</nav>

	<div class="container-fluid text-center">
		<div class="row">
			<div class="col-md-12">
				<br>
				<h3>
					<i>Lista użytkowników</i>
				</h3>
				<br>
				<table class="table table-sm text-center">
					<thead>
						<tr>
							<th>Imię</th>
							<th>Nazwisko</th>
							<th>Ulica</th>
							<th>Miasto</th>
							<th>Kod pocztowy</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="tempUser" items="${users}">

							<c:url var="updateLink" value="/user/showFormForUpdate">
								<c:param name="userId" value="${tempUser.id}" />
							</c:url>
							<c:url var="deleteLink" value="/user/delete">
								<c:param name="userId" value="${tempUser.id}" />
							</c:url>
							<tr>
								<td>${tempUser.firstName}</td>
								<td>${tempUser.lastName}</td>
								<td>${tempUser.address.street}</td>
								<td>${tempUser.address.city}</td>
								<td>${tempUser.address.zipCode}</td>
								<td><a href="${updateLink}">Aktualizuj</a> | <a
									href="${deleteLink}"
									onclick="if(!(confirm('Usunąć użytkownika z bazy?'))) return false">Usuń</a></td>
							</tr>

						</c:forEach>
					</tbody>
					<p><i>Liczba użytkowników: ${fn:length(users)}</p>
				</table>
				<button type="button" class="btn btn-primary"
					onclick="window.location.href='showFormForAdd'; return false;">Dodaj
					użytkownika</button>
			</div>

		</div>
	</div>
	<footer>
		<br>
		<hr>
		<center>
			<i>SimpleCRUD 2018</i>
		</center>
	</footer>
</body>
</html>