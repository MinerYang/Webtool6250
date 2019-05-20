<%-- 
    Document   : admin
    Created on : Apr 24, 2019, 10:46:41 AM
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
        <c:if test="${result == 0}">
             <h1>You are not an administrator!</h1>
             <p> Sorry,Login failed</p>
             <a href="redirect.jsp"> Back to Main Page</a>
         </c:if>
        <c:if test="${result == 1}">
            <h1>You are an administrator!</h1>
                <p>Manage Doctor**********************************************</p>
                <form action="mngdoc.htm" method="post">
                     <input type="submit" value="Manage Doctor"/>
                </form>
                <p>Manage Patient*********************************************</p>
                <form action="mngpatient.htm" method="post">
                     <input type="submit" value="Manage Patient"/>
                </form>
                
                <p> Manage Medical record**************************************</p>
                <form action="mngmed.htm" method="post">
                     <input type="submit" value="Manage Record"/>
                </form> 
         </c:if>
    </body>
</html>
