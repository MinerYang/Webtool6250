<%-- 
    Document   : backpwd
    Created on : Apr 24, 2019, 8:54:50 AM
    Author     : cestdrama
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${result==1}">
        <h1>Dear ${user.username} your password is:</h1>
        <h1> ${user.password}</h1>
        </c:if>
        
        <c:if test="${result==0}">
            <p>Your information may not be correct</p>
            <p>Password not found</p>
         <a href="redirect.jsp"> Back to Main Page</a>
        </c:if>
    </body>
</html>
