<%-- 
    Document   : add
    Created on : 2019-3-7, 18:03:33
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Please enter the details below:</h1>
        <div>
        <form:form commandName="movie" method="post">
            <label>Movie Title: </label>
            <form:input path="title"/><font color="red"><form:errors path="title"/></font><br/>
            <label>Lead Actor: </label>
            <form:input path="actor"/><font color="red"><form:errors path="actor"/></font><br/>
            <label>Lead Actress: </label>
            <form:input path="actress"/><font color="red"><form:errors path="actress"/></font><br/>
            <label>Genre: </label>
            <form:input path="genre"/><font color="red"><form:errors path="genre"/></font><br/>
            <label>Year: </label>
            <form:input path="year"/><font color="red"><form:errors path="year"/></font><br/>
            <input type="submit" name="submit" value="Add Movie"/>
        </form:form>
        </div>
    </body>
</html>
