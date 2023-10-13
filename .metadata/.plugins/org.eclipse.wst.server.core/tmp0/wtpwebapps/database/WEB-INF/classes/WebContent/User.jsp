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
                <th>Email</th>
                <th>First name</th>
                <th>Last name</th>
                <th>Adress</th>
                <th>Password</th>
                <th>Birthday</th>
                <th>cash_bal($)</th>
                <th>PPS_bal</th>
            </tr>
            <c:forEach var="user" items="${get_user}">
                <tr style="text-align:center">
                    <td>"${user.email}" </td>
                    <td>"${user.firstName}"</td>
                    <td>"${user.lastName}"</td>
                    <td>"${user.adress_street_num} ${users.adress_street} ${users.adress_city} ${users.adress_state} ${users.adress_zip_code}"</td>
                    <td>"${user.password}"</td>
                    <td>"${user.birthday}"</td>
                    <td>"${user.cash_bal}"</td>
                    <td>"${user.PPS_bal}"</td>
                 </tr>
            </c:forEach>
          </table>
	</div>
<body>

</body>
</html>