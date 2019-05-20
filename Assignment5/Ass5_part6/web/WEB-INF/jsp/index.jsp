<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Movie Store</title>
    </head>
    <script language="javascript" type="text/javascript">
        function redirect() {
            var selected = document.getElementById("choice");
            if (selected.value === "browse") {
                window.location.href = "browse.htm";
            } else if (selected.value === "add") {
                window.location.href = "add.htm";
            }
        }
    </script>
    <body>
        <h1>Welcome to our Movie Store</h1>
        <p>Please make your selection below</p>
        <select id="choice">
            <option value="browse">Browse Movies</option>
            <option value="add">Add New Movie to Database</option>
        </select>
        <button type="button" onclick="redirect()">Send</button>
</body>
</html>
