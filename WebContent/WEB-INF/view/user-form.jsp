<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
    <%@include file="/resources/styles.css" %>
</style>
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
	<div class="container">
		<div class="row">

			<div class="col-md-4">
				<br>
				<h3>
					<i>Dodaj użytkownika</i>
				</h3>
				<br>
				<form:form action="saveUser" modelAttribute="user" method="POST">
					<form:hidden path="id" />
					<form:hidden path="address.id" />

					<div class="form-group">
						<label>Imię: </label>
						<form:input class="form-control" path="firstName" placeholder="Imię"/>
						<form:errors class="error" path="firstName"/>
					</div>
					<div class="form-group">
						<label>Nazwisko: </label>
						<form:input class="form-control" path="lastName" placeholder="Nazwisko"/>
							<form:errors class="error" path="lastName"/>
					</div>
					<div class="form-group">
						<label>Ulica: </label>
						<form:input class="form-control" path="address.street" placeholder="Ulica"/>
						<form:errors class="error" path="address.street"/>
					</div>
					<div class="form-group">
						<label>Miasto: </label>
						<form:input class="form-control" path="address.city" placeholder="Miasto"/>
						<form:errors class="error" path="address.city"/>
					</div>
					<div class="form-group">
						<label>Kod pocztowy: </label>
						<form:input class="form-control" path="address.zipCode" placeholder="Kod pocztowy"/>
						<form:errors class="error" path="address.zipCode"/>
					</div>

					<input type="submit" class="btn btn-success" value="Zapisz" />
					<a class="btn btn-primary"
						href="${pageContext.request.contextPath}/user/list">Powrót do
						listy</a>
				</form:form>
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