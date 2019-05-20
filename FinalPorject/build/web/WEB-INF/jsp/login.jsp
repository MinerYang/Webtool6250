<%-- 
    Document   : add
    Created on : 2019-3-7, 18:03:33
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
        <h1>Hi! Welcome to Login</h1>
        <div> 
        <c:if test="${type==1}">
            <p>Please login here</p>
            <form action="pLogin.htm" method="post">
            <label>username: </label>
            <input type="text" name="username"><br/>
            <label>password </label>
            <input type="text" name="password"><br/>
            <input type="submit" name="submit" value="Login"/>
            </form>
            
            <p>Forgot you pass word? Click here</p>
            <form action="findpwd.htm" method="post">
                Username:<input type="text" name="username"/><br/>
                email:<input type="text" name="email"/><br/>
                <input type="submit" value="find my password"/>
            </form>
            
        </c:if>
        <c:if test="${type==2}">
            <form action="dLogin.htm" method="post">
            <label>Doctor name: </label>
            <input type="text" name="docname"><br/>
            <label>Password: </label>
            <input type="text" name="password"><br/>
            <input type="submit" name="submit" value="Login"/>
            </form>
        </c:if>
        
        <c:if test="${type==3}">
            <form action="aLogin.htm" method="post">
            <label>Admin name: </label>
            <input type="text" name="adminname"><br/>
            <label>Password: </label>
            <input type="text" name="apwd"><br/>
            <input type="submit" name="submit" value="Login"/>
            </form>
        </c:if>
        
        </div>
        <br/>
            <a href="redirect.jsp"> Back to Main Page</a>
    </body>
</html>
