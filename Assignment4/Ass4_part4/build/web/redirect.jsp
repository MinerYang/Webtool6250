<%-- 
    Document   : redirect
    Created on : Feb 22, 2019, 1:57:32 PM
    Author     : cestdrama
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
    <c:choose>
    <c:when test="${pageContext.request.isUserInRole('manager-gui')}">  
    <form action="display.jsp" method="post">
            <label>Input the file name</label>
            <input type="text" name="filename"/>
            <input type="submit" name="submit" value="Submit"/>
     </form>
    </c:when>
        
    <c:otherwise>
      <p>You have no authority to check this part!</p>
    </c:otherwise>
    </c:choose>
</body>
