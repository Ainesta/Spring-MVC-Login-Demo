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
	<h1>All Product</h1>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>ProductCode</th>
				<th>ProductName</th>
				<th>Net Price</th>
				<th>IsActive</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="listValue" items="${productList}">
				<tr>
					<td>${listValue.getProductCode()}</td>
					<td>${listValue.getPname()}</td>
					<td>${listValue.getPrice()}</td>
					<td>${listValue.getIsactive()}</td>
					<c:choose>
						<c:when test="${listValue.getIsactive() == 'Y'}">
        				<td>
        				<a id="byParameter" class="textLink" href="<c:url value="doDeleteProduct?productCode=${listValue.getProductCode()}" />">Delete</a></td>
						</c:when>
						<c:otherwise>
    					<td>Sold</td>	
						</c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</body>
</html>