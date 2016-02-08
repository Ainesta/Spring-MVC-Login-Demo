<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<h1>Store ${storeName}</h1>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>ProductName</th>
				<th>Net Price</th>
				<th>VAT</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="listValue" items="${invoiceList}">
				<tr>
					<td>${listValue.getProduct().getPname()}</td>
					<td>${listValue.getProduct().getPrice()}</td>
					<td>${listValue.getVat()}</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h3>CalVat ${vat}</h3>
	

</body>
</html>