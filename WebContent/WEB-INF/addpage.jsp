<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Book here</title>
</head>
<body>
	<h1>Create New Book</h1>
	<c:url var="saveUrl" value="/books/add" />
	<form:form modelAttribute="bookAttribute" method="POST" action="${saveUrl}">
		<table>
			<tr>
				<td><form:label path="name">Name:</form:label></td>
				<td><form:input path="name"/></td>
			</tr>
 
			<tr>
   				<td><form:label path="pages">Pages</form:label></td>
   				<td><form:input path="pages"/></td>
  			</tr>
   
  			<tr>
   				<td><form:label path="genre">Genre</form:label></td>
   				<td><form:input path="genre"/></td>
  			</tr>
  		</table>
  
		<input type="submit" value="Save" />
	</form:form>
</body>
</html>