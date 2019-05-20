<%-- 
    Document   : ViewCart
    Created on : Feb 13, 2019, 12:05:55 AM
    Author     : cestdrama
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart</title>
    </head>
    <body>
        <c:set var="cart" value="${sessionScope.cart}"/>
        <h2 align="center">This is your Shopping Cart</h2>
        <form action="../mycart" method="get">
            <table border=1 align="center">
                <tr/><th/>Object<th/>Amount
                <c:if test="${cart != null}">
                    <c:forEach var="item" items="${cart.cart}">                        
                        <tr/><td/>${item.name}
                        <td/><input type="text" name="${item.name}" value="${item.count}"/>
                    </c:forEach>
                </c:if>
            </table>
            <br/>
            <div align="center">
                <input type="submit" name="submit" value="Submit">
            </div>
        </form>
        <p>
            [<a href="books.html">Go to Books Page</a>] 
            [<a href="music.html">Go to Music Page</a>] 
            [<a href="computers.html">Go to Computers Page</a>] 
        </p>
    </body>
</html>
