<%-- 
    Document   : login
    Created on : Feb 13, 2019, 11:04:08 AM
    Author     : cestdrama
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>




<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="j_security_check" method="post">
            User Name: <input type="text" name="j_username"/><br/>
            Password: <input type="password" name="j_password"/><br/>
            <input type="submit" value="Log in"/>
        </form>
    </body>
</html>
