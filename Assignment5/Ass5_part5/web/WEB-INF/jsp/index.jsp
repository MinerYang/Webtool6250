<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <c:if test="${pageNumber==null}">
            <c:if test="${result==null}">
                <form action="quiz/1.htm" method="post">
                    <h>Let's begin the quiz</h>
                    <br/><input type="submit" value="开始" name="_target0"/>
                </form>
            </c:if>
            <c:if test="${result!=null}">
                <div><center>
                    <h1>Quiz Result</h1><br/>
                    <table border="1">
                        <tr/><th/>Question Number<th/>Answer
                        <c:forEach var="number" begin="1" end="3" >
                            <tr/><td/>${number}<td/>${result.choice[number-1]}
                        </c:forEach>
                    </table>
                </center></div>
            </c:if>
        </c:if>
        <c:if test="${pageNumber==0}">
            <form action="2.htm" method="post">
                ${title}<br>
                <c:forEach var="option" items="${question}">
                    <input type='radio' name="choice[0]" value="${option}"/>${option}<br />
                </c:forEach>
                <input type="submit" value="Next" name="_target1"/>
                <input type="submit" value="Cancel" name="_cancel"/>
            </form>
        </c:if>
        <c:if test="${pageNumber==1}">
            <form action="3.htm" method="post">
                ${title}<br>
                <c:forEach var="option" items="${question}">
                    <input type='radio' name="choice[1]" value="${option}"/>${option}<br />
                </c:forEach>
                <input type="submit" value="Previous" name="_target0"/>
                <input type="submit" value="Next" name="_target2"/>
                <input type="submit" value="Cancel" name="_cancel"/>
            </form>
        </c:if>
        <c:if test="${pageNumber==2}">
            <form action="result.htm" method="post">
                ${title}<br>
                <c:forEach var="option" items="${question}">
                    <input type='radio' name="choice[2]" value="${option}"/>${option}<br />
                </c:forEach>
                <input type="submit" value="Previous" name="_target1"/>
                <input type="submit" value="Next" name="_finish"/>
                <input type="submit" value="Cancel" name="_cancel"/>
            </form>
        </c:if>


</FORM>
        

    </body>
</html>
