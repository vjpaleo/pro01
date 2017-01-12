<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create An Account</title>
</head>
<body>
	<h1>Add Account Details:</h1>
	
	<form:form commandName="aNewAccount" method="post" action="accountCreated.html">
	  First name:<br>
	  <form:input type="text" name="firstname" path="firstName"></form:input>
	  <form:errors path="firstName"></form:errors><br>
	  Last name:<br>
	  <form:input type="text" name="lastname" path="lastName"></form:input>
	  <form:errors path="lastName"></form:errors><br>
	   Email:<br>
	  <form:input type="email" name="email" path="email"></form:input>
	  <form:errors path="email"></form:errors><br>
	   Age:<br>
	  <form:input type="text" name="age" path="age"></form:input>
	  <form:errors path="age"></form:errors><br>
	   Address:<br>
	  <form:input type="text" name="address" path="address"></form:input>
	  <form:errors path="address"></form:errors><br>
	  <input type="submit" value="Create"/>
	</form:form>
</body>
</html>