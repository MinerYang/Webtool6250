<%-- 
    Document   : index
    Created on : Feb 21, 2019, 9:39:10 PM
    Author     : cestdrama
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <h1>Welcome to our Movie Store</h1>
        <p>Please make your selection below</p>
        <form action="transfer.htm" method="post">
        <select id="operation" name="selection">
            <option value="browse">Browse Movie</option>
            <option value="add">Add New Movie</option>
        </select>
         <input type="submit" name="submit" value="Send">
        </form>
    </body>
</html>

