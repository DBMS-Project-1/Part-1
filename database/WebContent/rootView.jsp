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
				<th>First Name</th>
                <th>Last Name</th>
                <th>Address</th>
                <th>City</th>
                <th>State</th>
                <th>ZIP Code</th>
                <th>Credit Card Number</th>
                <th>Expiration Date</th>
                <th>CVV</th>
                <th>Phone Number</th>
                <th>Email</th>
                <th>Password</th>
            </tr>
            <c:forEach var="users" items="${listUser}">
                <tr style="text-align:center">
                    <td><c:out value="${user.FirstName}" /></td>
                    <td><c:out value="${user.LastName}" /></td>   
                    <td><c:out value="${user.Address}" /></td>
                    <td><c:out value="${user.City}" /></td>
                    <td><c:out value="${user.State}" /></td>
                    <td><c:out value="${user.CreditCardNumber}" /></td>
                    <td><c:out value="${user.ExpirationDate}" /></td>
                    <td><c:out value="${user.CVV}"/></td>
                    <td><c:out value="${user.PhoneNumber}" /></td>
                    <td><c:out value="${user.Email}" /></td>
                    <td><c:out value="${user.Password}" /></td>
            </c:forEach>
        </table>
	</div>
	</div>

</body>
</html>