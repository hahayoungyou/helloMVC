<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%-- jstl core uri--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--jsp expression lanugage 객체property접근 --%>
<ul>
<li> id: ${customer.id}</li>
<li> id: ${customer.name}</li>
<li> id: ${customer.email}</li>
</ul>

<%--jstl --%>
<table>
<c:forEach var="customer" items="${customers}">
<tr>
<td> id: ${customer.id}</td>
<td>id: ${customer.name}<td>
<td>id: ${customer.email}</td>
</c:forEach>
</table>
</body>
</html>