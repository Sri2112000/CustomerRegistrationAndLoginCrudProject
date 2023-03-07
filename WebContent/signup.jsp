<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up Page</title>
</head>
<body>
<h1>Welcome to Custemer Registration or Sign Up Page</h1>
<form action="regCustomer">
Name : <input type="text" name="tbName" id="tbName"/>
<br/>
Email : <input type="email" name="tbEmail" id="tbEmail">
<br/>
Mobile : <input type="tel" name="tbMobile" id="tbMobile"/>
<br/>
Password : <input type="password" name="tbPass" id="tbPass"/>
<br/>
State : <select name="ddlStates">
			<option>--Select--</option>
			<option value="Karnataka">KARNATAKA</option>
			<option value="Kerala">KERALA</option>
			<option value="Goa">GOA</option>
			<option value="Delhi">DELHI</option>
			<option value="AndraPradesh">ANDRAPRADESH</option>
</select>
<br/>
<input type="submit" value="Register"/>

</form>
</body>
</html>