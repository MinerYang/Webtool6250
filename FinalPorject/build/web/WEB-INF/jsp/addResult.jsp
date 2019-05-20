 <%-- 
    Document   : addResult
    Created on : 2019-3-7, 18:03:44
    Author     : Administrator
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${result == 1}">
                ${result}
                <h1>1  Added Successfully</h1>
            </c:when>
            <c:otherwise>
                <h1> Added Failed</h1>
            </c:otherwise>
        </c:choose>
        <a href="redirect.jsp">Go Back to Main Page</a>
    </body>
</html>
