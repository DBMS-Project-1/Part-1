<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login to Database</title>
</head>
<body>
 <center>	<h1> Welcome to ppswap Login page </h1> </center>
	<div align="center">
		<p> ${loginFailedStr} </p>
		<form action="login" method="post">
			<table border="1" cellpadding="5">
				<li>
					<span class="role-label">ROLES:</span>
					
					<input type="radio" name="role" value="user" id="userRole">
					<label for="userRole">User</label>
					
					<input type="radio" name="role" value="root" id="rootRole">
					<label for="rootRole">Root</label>
					
					<input type="radio" name="role" value="davidsmith" id="davidsmithRole">
					<label for="davidsmithRole">David Smith</label>
				</li>
				<tr>
					<th>Email: </th>
					<td>
						<input type="text" name="username" size="45" autofocus>
					</td>
				</tr>
				<tr>
					<th>Password: </th>
					<td> 
						<input type="password" name="password" size="45">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="Login"/>
					</td>
				</tr>
			</table>
			<a href="register.jsp" target="_self">Register Here</a>
		</form>
	</div>
</body>
</html>