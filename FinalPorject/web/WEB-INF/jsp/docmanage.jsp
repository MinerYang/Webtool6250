<%-- 
    Document   : docmanage
    Created on : Apr 24, 2019, 1:09:19 PM
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
        <h1>Welcom to manage Doctor</h1>
        
        <c:if test="${list != null}">
         <form action="deleteDoc.htm" method="post">
        input the doctor id you want to delete:<input type="number" name="docid"/><br/>
        <input type="submit" value="delete"/>
        </form>
        <p>Below is a Doctors list in this hospital*********************************</p>
        record count: ${list.size()}<br/>
        <table border=1 align="left">
                <tr/><th/>Doctor ID<th/>Doctor Name               
                    <c:forEach var="item" items="${list}">                        
                        <tr/>
                        <td/>${item.getDocid()}
                        <td/>${item.getDocname()}
                    </c:forEach> 
        </table>
        </c:if>
        <br/>
            <a href="redirect.jsp"> Back to Main Page</a>
    </body>
</html>
