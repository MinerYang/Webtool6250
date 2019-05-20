<%-- 
    Document   : browse
    Created on : Feb 21, 2019, 7:25:06 PM
    Author     : cestdrama
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Searching Movies</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Searching Movies</h1>
        <div>
            <form action="browsemovie.htm" method="post">
                <label>Keyword: </label>
                <input type="text" name="keyword"><br/>
                <input type="radio" name="search" value="title">Search By Title<br/>
                <input type="radio" name="search" value="actor">Search By Actor<br/>
                <input type="radio" name="search" value="actress">Search By Actress<br/>
                <input type="submit" name="submit" value="Search Movies">
            </form>
        </div>
    </body>
</html>
