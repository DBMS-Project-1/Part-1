<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Root page</title>
</head>
<body>

<div align = "center">
	
	<form action = "initialize">
		<input type = "submit" value = "Initialize the Database"/>
	</form>
	<a href="login.jsp"target ="_self" > logout</a><br><br> 

<h1>List all users</h1>
    <div align="center">
        <table border="1" cellpadding="6">
            <caption><h2>List of Users</h2></caption>
            <tr>
				<th>FirstName</th>
                <th>LastName</th>
                <th>Address</th>
                <th>City</th>
                <th>State</th>
                <th>ZipCode</th>
                <th>CreditCardNumber</th>
                <th>ExpirationDate</th>
                <th>CVV</th>
                <th>PhoneNumber</th>
                <th>Email</th>
                <th>Password</th>
            </tr>
            <c:forEach var="users" items="${listUser}">
                <tr style="text-align:center">
                    <td><c:out value="${users.FirstName}" /></td>
                    <td><c:out value="${users.LastName}" /></td>   
                    <td><c:out value="${users.Address}" /></td>
                    <td><c:out value="${users.City}" /></td>
                    <td><c:out value="${users.State}" /></td>
                    <td><c:out value="${users.CreditCardNumber}" /></td>
                    <td><c:out value="${users.ExpirationDate}" /></td>
                    <td><c:out value="${users.CVV}"/></td>
                    <td><c:out value="${users.PhoneNumber}" /></td>
                    <td><c:out value="${users.Email}" /></td>
                    <td><c:out value="${users.Password}" /></td>
            </c:forEach>
        </table>
	</div>
	</div>

</body>
</html>