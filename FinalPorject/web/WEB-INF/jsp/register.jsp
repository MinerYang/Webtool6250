<%-- 
    Document   : add
    Created on : 2019-4-19, 18:03:33
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Please register</h1>
        <div>
            <c:if test="${type==1}">
            <form action="HandelRegister.htm" method="post">
                Username:<input type="text" name="username"/><br/>
                Password:<input type="text" name="password"/><br/>
                Email:<input type="text" name="email"/><br>
                <input type="submit" value="Register" /><br/>
            </form>
            </c:if>
            
            <c:if test="${type==2}">
            <form action="DoRegister.htm" method="post">
                Doctor name:<input type="text" name="docname"/><br/>
                Password:<input type="text" name="pwd"/><br/>
                <input type="submit" value="Register" /><br/>
            </form>
            </c:if>
        </div>
    </body>
</html>
