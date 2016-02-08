<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
		Welcome ${userBean.username}.
		<br>
		<a href="toAddProduct.obj" style="margin: 50:">Add Products</a><br>
		<a href="toDeleteProduct.obj" style="margin: 50:">Delete Product</a><br>
		<a href="doViewVat.obj" style="margin: 50:">View Vat</a><br>
</body>
</html>