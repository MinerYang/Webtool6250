<%-- 
    Document   : patient
    Created on : Apr 19, 2019, 12:41:31 PM
    Author     : cestdrama
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <c:if test="${result==0}">
                <h1> Login Failed</h1>             
            </c:if>
            <c:if test="${result == 1}">
                ${result}
                <h1>Welcome ${user.getUsername()}</h1>
                <p>Below is your information</p>
                <form action="pUpdate.htm" method="post">
                    Id:
                    <input type="text" name="id" value="${user.getId()}" /><br/>
                    Username:
                    <input type="text" name="username" value="${user.getUsername()}"/><br/>
                    Password:
                    <input type="text" name="password" value="${user.getPassword()}"/><br/>
                    Email:
                    <input type="text" name="email" value="${user.getEmail()}"/><br/>
                    <input type="submit" value="Update"/>
                </form> 
            
                    
<!--                 <form action="pView.htm" method="post">
                 <input type="submit" name="View your record"/>
                 </form>-->
            
                
                 
            <p>*************************************</p>
            <form action="pView.htm" method="post">
                View your medical record
                <input type="hidden" name="id" value="${user.getId()}"/>
                <input type="hidden" name="username" value="${user.getUsername()}"/>   
                <input type="hidden" name="password" value="${user.getPassword()}"/>
                <input type="hidden" name="email" value="${user.getEmail()}"/><br/>
                <input type="submit" value="view MedRecord"/>
            </form>
            </c:if>
              
        <br/><a href="redirect.jsp">Go Back to Main Page</a>
    </body>
</html>
