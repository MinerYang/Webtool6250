<%-- 
    Document   : medmanage
    Created on : Apr 24, 2019, 2:11:07 PM
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
        <h1>Welcome to manage Medical Record</h1>
       <c:if test="${list != null}">
           <form action="deletemed.htm" method="post">
               input the record id you want to delete:<input type="number" name="medid"/><br/>
               <input type="submit" value="delete"/>
           </form>
           <p>Below is a Medical Record list in this hospital*********************************</p>
           <p>record count: ${list.size()}</p>
            <table border=1 align="left">
                <tr/><th/>Record ID<th/>Disease Description<th/>Treatment<th/>Doctor ID               
                    <c:forEach var="item" items="${list}">                        
                        <tr/>
                        <td/>${item.getMedid()}
                        <td/>${item.getDescription()}
                        <td/>${item.getTreatment()}
                        <td/>${item.getDocid()}
                    </c:forEach>
                
            </table>
       </c:if>
    </body>
    <br/><a href="redirect.jsp">Go Back to Main Page</a>
</html>
