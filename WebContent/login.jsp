<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Here</title>
<link href="css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<fieldset>
			<legend>Navigation menu</legend>
			<a href="index.jsp">Home</a> 
			<center><img src="images/a.jpg"
				class="img-responsive" alt="Responsive image" width="200px"></center>
			<sf:form action="doLogin.obj" modelAttribute="userBean">

				<sf:errors element="h4" class="text-danger" />
				<sf:label path="username">UserName:</sf:label>
				<sf:input path="username" class="form-control" />
				<sf:errors path="username" class="text-danger" element="h1" />


				<sf:label path="password">Password:</sf:label>
				<sf:password path="password" class="form-control" />
				<sf:errors path="password" class="text-danger" element="h1" />
				<br />
				<button type="submit" class="btn btn-primary btn-block">Submit</button>
			</sf:form>
		</fieldset>
	</div>

</body>
</html>