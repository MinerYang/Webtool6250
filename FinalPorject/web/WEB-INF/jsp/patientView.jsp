<%-- 
    Document   : patientView
    Created on : Apr 23, 2019, 7:36:51 PM
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
        <h1>Welcome to view your medical record</h1>
        <p>records number: ${result.size()}</p>
        <c:if test="${result != null}">
        <table border=1 align="center">
                <tr/><th/>Record ID<th/>Disease Description<th/>Treatment<th/>Doctor ID
                
                    <c:forEach var="item" items="${result}">                        
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
