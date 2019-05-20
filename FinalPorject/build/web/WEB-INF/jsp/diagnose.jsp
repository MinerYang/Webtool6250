<%-- 
    Document   : diagnose
    Created on : Apr 24, 2019, 3:14:27 AM
    Author     : cestdrama
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Please write your diagnosis here </h1>
        <form action="diagnosis.htm" method="post">
                    <input type="hidden" name="docid" value="${docid}"/>
                    Patient id:
                    <input type="number" name="userid"/><br/>
                    Disease Description:
                    <input type="text" name="des" /><br/>
                    Relevant Treatment
                    <input type="text" name="treatment"/><br/>
                    <input type="submit" value="Create a record"/>
        </form> 
    </body>
</html>
