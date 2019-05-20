<%-- 
    Document   : Insert
    Created on : Feb 21, 2019, 7:29:30 PM
    Author     : cestdrama
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Add Movie to Database</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Please enter the information below:</h1>
        <div>
            <form action="addmovie.htm" method="get">
                <label>Movie Title: </label>
                <input type="text" name="Movie Title"><br/>
                <label>Lead Actor: </label>
                <input type="text" name="Lead Actor"><br/>
                <label>Lead Actress: </label>
                <input type="text" name="Lead Actress"><br/>
                <label>Genre: </label>
                <input type="text" name="Genre"><br/>
                <label>Year: </label>
                <input type="text" name="Year"><br/>
                <input type="submit" name="submit" value="Add Movie">
            </form> 
        </div>
    </body>
</html>