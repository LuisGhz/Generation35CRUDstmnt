<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="readIndividualServlet" method="post">
	<select name="individual">
	<c:forEach var="p" items="${myProducts}">
	<p>1</p>
	<option value="${p.getIdProduct()}">${p.getProductName()}</option>		
	</c:forEach>
	</select>
	<input type="submit" value="Mostrar producto" />
	</form>
	
</body>
</html>