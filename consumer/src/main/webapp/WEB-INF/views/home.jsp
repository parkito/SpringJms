<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>

<h1>User List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr>
        <th>Email</th>
        <th>First name</th>
        <th>Second name</th>
        <th>Role</th>
    </tr>
    <c:forEach var="user" items="${result}">
        <tr>
            <td>${user.email}</td>
            <td>${user.firstName}</td>
            <td>${user.secondName}</td>
            <td>${user.role}</td>
        </tr>
    </c:forEach>
</table>
<br/>
</html>