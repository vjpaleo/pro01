<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create An Account</title>
</head>
<body>
	<h1>Add Account Details:</h1>
	
	<form:form commandName="aNewAccount" action="createAccount">
	  First name:<br>
	  <form:input type="text" name="firstname" path="firstName"></form:input><br>
	  Last name:<br>
	  <form:input type="text" name="lastname" path="lastName"></form:input><br>
	   Email:<br>
	  <form:input type="email" name="email" path="email"></form:input><br>
	   Address:<br>
	  <form:input type="text" name="address" path="address"></form:input><br>
	  <input type="submit" value="Create"/>
	</form:form>
</body>
</html>