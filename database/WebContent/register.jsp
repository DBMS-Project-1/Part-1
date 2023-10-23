<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head><title>Registration</title></head>
<body>
	<div align="center">
		<p> ${errorOne } </p>
		<p> ${errorTwo } </p>
		<form action="register">
			<table border="1" cellpadding="5">
				<tr>
					<th>Username: </th>
					<td align="center" colspan="3">
						<input type="text" name="Username" size="45" value="example@wayne.edu" onfocus="this.value=''">
					</td>
				</tr>
				
				<tr>
					<th>Password: </th>
					<td align="center" colspan="3"> 
						<input type="password" name="Password" size="45" value="password" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Password Confirmation: </th>
					<td align="center" colspan="3">
						<input type="password" name="Confirmation" size="45" value="password" onfocus="this.value=''">
					</td>
				<tr>
								<li>
					<span class="role-label">ROLES:</span>
					
					<input type="radio" name="role" value="user" id="userRole">
					<label for="userRole">User</label>
					
					<input type="radio" name="role" value="root" id="rootRole">
					<label for="rootRole">Root</label>
					
					<input type="radio" name="role" value="davidsmith" id="davidsmithRole">
					<label for="davidsmithRole">David Smith</label>
				</li>
					<td align="center" colspan="5">
						<input type="submit" value="Register"/>
					</td>
				</tr>
			</table>
			<a href="login.jsp" target="_self">Return to Login Page</a>
		</form>
	</div>
</body>