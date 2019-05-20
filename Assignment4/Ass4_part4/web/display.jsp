<%-- 
    Document   : display
    Created on : Feb 22, 2019, 2:42:31 PM
    Author     : cestdrama
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/custom" prefix="ex"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Page</title>
    </head>
    <body>
       <ex:myTag csvname="${param.filename}"/>
    </body>
</html>
