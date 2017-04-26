<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Books here</title>
</head>
<body>
	<h1>Books</h1>
 	
 	<c:url var="addUrl" value="/books/add" />
	<table style="border: 1px solid; width: 500px; text-align:center">
 	<thead style="background:#fcf">
  		<tr>
   			<th>Name</th>
   			<th>Pages</th>
   			<th>Genre</th>
   			<th colspan="3"></th>
  		</tr>
 	</thead>
 	<tbody>
 	<c:forEach items="${books}" var="book">
   		<c:url var="deleteUrl" value="/books/delete?id=${book.id}" />
			<tr>
   				<td><c:out value="${book.name}" /></td>
   				<td><c:out value="${book.pages}" /></td>
   				<td><c:out value="${book.genre}" /></td>
  				<td><a href="${deleteUrl}">Delete</a></td>
   				<td><a href="${addUrl}">Add</a></td>
  			</tr>
 	</c:forEach>
	</tbody>
	</table>
	
	<c:if test="${empty books}">
 		There are currently no books in the list. <a href="${addUrl}">Add</a> a book.
	</c:if>
</body>
</html>