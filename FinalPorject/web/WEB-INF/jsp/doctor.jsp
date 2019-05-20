<%-- 
    Document   : doctor
    Created on : Apr 24, 2019, 1:00:51 AM
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
        <h1>Welcome doctor ${doc.getDocname()} </h1>
         <c:if test="${result == 0}">
             <p> Sorry,Login failed</p>
             <a href="redirect.jsp"> Back to Main Page</a>
         </c:if>
         <c:if test="${result == 1}">
                <p>Below is your personal information************************</p>
                <form action="dUpdate.htm" method="post">
                    Doctor id:
                    <input type="text" name="docid" value="${doc.docid}" /><br/>
                    Doctor name:
                    <input type="text" name="docname" value="${doc.docname}"/><br/>
                    Password:
                    <input type="text" name="pwd" value="${doc.pwd}"/><br/>
                    <input type="submit" value="Update"/>
                </form>  
                <p> Start to Write a Diagnosis*******************************</p>
                <form action="transToInsert.htm" method="post">
                     <input type="hidden" name="docid" value="${doc.docid}"/>
                     <input type="submit" value="Add Record"/>
                </form>
                <p> View Medical record**************************************</p>
                <form action="ViewRecord.htm" method="post">
                     <input type="submit" value="View My record"/>
                </form>
                
                <p> Search User Medical record**************************************</p>
                <form action="SearchUserRecord.htm" method="post">
                     User ID:<input type="number" name="userid"/><br/>
                     <input type="submit" value="Search User Record"/>
                </form> 
         </c:if>
         <br/>
            <a href="redirect.jsp"> Back to Main Page</a>
    </body>  
        
         
</html>
