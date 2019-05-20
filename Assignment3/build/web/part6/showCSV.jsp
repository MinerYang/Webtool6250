<%-- 
    Document   : showCSV
    Created on : Feb 13, 2019, 1:10:08 AM
    Author     : cestdrama
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show CSV</title>
    </head>
    <body>
        <c:set var="filename" value="${sessionScope.filename}"/>
        <c:set var="titles" value="${sessionScope.titles}"/>
        <c:set var="results" value="${sessionScope.results}"/>
        <h1 align="left">${filename}.csv</h1>
        <table border="1">
            <tr bgcolor="#FFAD00"/>
            <c:forEach var="columnName" items="${titles}">
                <th/>${columnName}
            </c:forEach>
            <c:forEach var="row" items="${results}">
                <tr/>
                <c:forEach var="cell" items="${row}">
                    <td/>${cell}
                </c:forEach>
            </c:forEach>
        </table>
      
    </body>
</html>