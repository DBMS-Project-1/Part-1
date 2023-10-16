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
					<th>First Name: </th>
					<td align="center" colspan="3">
						<input type="text" name="FirstName" size="45" value="FirstName" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Last Name: </th>
					<td align="center" colspan="3">
						<input type="text" name="LastName" size="45" value="LastName" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Address: </th>
					<td align="center" colspan="3">
						<input type="text" name="Address" size="45" value="123 Main St." onfocus="this.value=''">
					</td>
				</tr>

				<tr>
					<th>City: </th>
					<td align="center" colspan="3">
						<input type="text" name="City" size="45" value="Detroit" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>State: </th>
					<td align="center" colspan="3">
						<input type="text" name="State" size="45" value="MI" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>ZIP Code: </th>
					<td align="center" colspan="3">
						<input type="text" name="ZipCode" size="45" value="48202" onfocus="this.value=''">
					</td>
				</tr>
				
				<tr>
					<th>Credit Card Number: </th>
					<td align="center" colspan="3">
						<input type="text" name="CreditCardNumber" size="45" value="1234 5678 9101 1121" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Expiration Data: </th>
					<td align="center" colspan="3">
						<input type="text" name="ExpirationDate" size="45" value="10/2024" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>CVV: </th>
					<td align="center" colspan="3">
						<input type="text" name="CVV" size="45" value="123" onfocus="this.value=''">
					</td>
				</tr>
				
				<tr>
					<th>Phone Number: </th>
					<td align="center" colspan="3">
						<input type="text" name="PhoneNumber" size="45" value="123-456-7890" onfocus="this.value=''">
					</td>
				</tr>
				
				<tr>
					<th>Email: </th>
					<td align="center" colspan="3">
						<input type="text" name="Email" size="45" value="example@wayne.edu" onfocus="this.value=''">
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
					<td align="center" colspan="5">
						<input type="submit" value="Register"/>
					</td>
				</tr>
			</table>
			<a href="login.jsp" target="_self">Return to Login Page</a>
		</form>
	</div>
</body>