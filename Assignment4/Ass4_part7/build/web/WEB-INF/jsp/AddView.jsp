<%-- 
    Document   : AddView
    Created on : Feb 22, 2019, 1:32:52 AM
    Author     : cestdrama
--%>

<%-- 
    Document   : AddView
    Created on : Feb 21, 2019, 10:49:21 PM
    Author     : cestdrama
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Result</title>
    </head>
    <body>
       <h2>${year}<h2>
        <c:choose>
            <c:when test="${result > 0}">
                <h1>1 Movie Added Successfully</h1>
            </c:when>
            <c:otherwise>
                <h1>Movie Added Failed</h1>
                <h2>${result}</h2>
            </c:otherwise>
        </c:choose>
        <a href="redirect.jsp">Click here to go back to the main page</a>
    </body>
</html>
