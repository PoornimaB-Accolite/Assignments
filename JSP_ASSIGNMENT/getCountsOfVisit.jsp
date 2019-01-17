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
Welcome&nbsp; 

<% out.println(request.getParameter("uname")); %>
<br>
You have visited this page.
<%
         Integer Counts = (Integer)application.getAttribute("Counts");
         if( Counts ==null || Counts == 0 ) {
            Counts = 1;
         } else {
            Counts += 1;
         }
         out.println("Number Of times Visited..");
      %>
	<%= Counts%>
	<h3>Your Details</h3>
	<br>Name :
	<c:out value="${param.uname}"/>
	<br>College:
	<c:out value="${param.age}"/>
	
</body>
</html>