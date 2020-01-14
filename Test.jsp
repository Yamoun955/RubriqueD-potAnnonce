<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<form method = "post" action="">
		<label for="titre"> Title</label>
		<br>
		<input  id="titre"  type="text"  name="title"  placeholder="Title" required>
		<br>
		<label for="desc">Description</label>
		<br>
		<textarea id="desc" name="description" rows="3" cols="20" required></textarea>
		<br>
		<label for="ad">Adress</label>
		<br>
		<input  id="ad"  type="text"  name="adress"  placeholder="Adress" required>
		<br>
		<label for="mail" >Mail</label>
		<br>
		<input  id="mail"  type="text"  name="mail"  placeholder="Mail" required>
		<br>
		<input type="submit" value="Save">
	</form>
	
	<table border=6 cellspacing=12 cellpadding=4  width=80%>
	<c:forEach var="annonce" items="${ annonces }">
		<tr> 
			<td><c:out value="${annonce.title }"/></td>
			<td><c:out value="${annonce.description }"></c:out></td>
			<td><c:out value="${annonce.adress }"/></td>
			<td><c:out value="${annonce.mail }"/></td>
			<td><c:out value="${annonce.date }"/></td>
		</tr>
	</c:forEach>
	</table>
	
</body>
</html>