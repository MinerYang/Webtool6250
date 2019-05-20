<%-- 
    Document   : patmanage
    Created on : Apr 24, 2019, 1:55:07 PM
    Author     : cestdrama
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <h1>Welcome to manage Patient</h1>
       <c:if test="${list != null}">
           <form action="deletepat.htm" method="post">
               input the patient id you want to delete:<input type="number" name="id"/><br/>
               <input type="submit" value="delete"/>
           </form>
           <p>Below is a Patients list in this hospital*********************************</p>
           <p>record count: ${list.size()}</p>
           <table border=1 align="left">
               <tr/><th/>Patient ID<th/>Name<th/>Email Address
               <c:forEach var="item" items="${list}">                        
                        <tr/>
                        <td/>${item.getId()}
                        <td/>${item.getUsername()}
                        <td/>${item.getEmail()}
                </c:forEach> 
           </table>
       </c:if>
        
    </body>
</html>
