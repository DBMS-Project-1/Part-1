<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

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
            <c:forEach var="user" items="${get_user}">
                <tr style="text-align:center">
                    <td>"${user.FirstName}" </td>
                    <td>"${user.LastName}"</td>
                    <td>"${user.Address}"</td>
                    <td>"${user.City}"</td>
                    <td>"${user.State}"</td>
                    <td>"${user.ZipCode}"</td>
                    <td>"${user.CreditCardNumber}"</td>
                    <td>"${user.ExpirationDate}"</td>
                    <td>"${user.CVV}"</td>
                    <td>"${user.PhoneNumber}"</td>
                    <td>"${user.Email}"</td>
                    <td>"${user.Password}"</td>
                 </tr>
            </c:forEach>
          </table>
	</div>
<body>

</body>
</html>