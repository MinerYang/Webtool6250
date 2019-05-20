<%-- 
    Document   : doctorView
    Created on : Apr 24, 2019, 3:38:47 AM
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
        <h1>Welcome to view the medical record</h1>
        <c:if test="${type==1}">
        <p>Below is basic info of Patient*************************************</p>
        <b>Patient ID:</b> ${user.id}<br/>
        <b>Patient name:</b> ${user.username}<br/>
        <b>Patient email:</b> ${user.email}<br/>
        </c:if>
        
        <c:if test="${list != null}">
        <p>Below is Medical record of Patient*********************************</p>
        record count: ${list.size()}<br/>
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
        <br/>
            <a href="redirect.jsp"> Back to Main Page</a>
    </body>
</html>
