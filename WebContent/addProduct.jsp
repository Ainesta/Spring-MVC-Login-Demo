<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<sf:form action="doAddProduct.obj" modelAttribute="product">
		Product Code<sf:input path="productCode" class="form-control" /><br>
		Product Name<sf:input path="pname" class="form-control" /><br>
		Price <sf:input path="price" class="form-control" /><br>
		<br />
		<button type="submit" class="btn btn-primary btn-block">Submit</button>
	</sf:form>

</body>
</html>