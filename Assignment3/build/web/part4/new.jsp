<%-- 
    Document   : new
    Created on : Feb 12, 2019, 7:23:23 PM
    Author     : cestdrama
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>  
 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Page</title>
    </head>
    <body>
        <c:out value="Hello JSTL." />  //
        <c:forEach var="i" begin="1" end="10" step="2">  //
            i = ${i}<br>
        </c:forEach> 
        
        <%
        java.util.ArrayList list = new java.util.ArrayList();
        list.add("One");
        list.add("Two");
        list.add("Three");
        session.setAttribute("list", list);
        %>
        
        
        <c:forEach var="item" items="${list}">
        ${item}<br>
        </c:forEach>
        
       <c:forEach var="i" begin="1" end="5" step="1"> 
           i=${i}<c:if test="${i%2!=0}">odd</c:if><br>
       </c:forEach>
       <br>
        
       <c:set var="String" value="Welcome to my functionTag"/>   //
       <c:if test="${fn:contains(String, 'functionTag')}">    //
       <p>Found functionTag string<p>  
       </c:if>
      
       <c:set var="string1" value="It is first String."/>  
       <c:set var="string2" value="It is one of my test String.</xyz>"/>  
       <p>Index-1 : ${fn:indexOf(string1, "is")}</p>   //
       <p>Index-2 : ${fn:indexOf(string2, "of")}</p> 
       
       <c:set var="str1" value="Welcome-to-JSP-Programming."/> 
       <p>String-1 : ${str1}</p>  
       <c:set var="str2" value="${fn:split(str1, '-')}" />  //
<!--       <p>String-2 : ${str2}</p>-->
       <c:set var="str3" value="${fn:join(str2, ' ')}" />    
       <p>String-3 : ${str3}</p>  
       <c:set var="str4" value="${fn:split(str3, ' ')}" /> 
<!--       <p>String-4 : ${str4}</p>-->
       <c:set var="str5" value="${fn:join(str4, '>')}" />  
       <p>String-5 : ${str5}</p>  
       <br>
       
       
       <c:set var="Amount" value="786.970" />  
       <fmt:parseNumber var="j" integerOnly='true' type="number" value="${Amount}" />  //
       <p><i>Amount is:</i>  <c:out value="${j}" /></p> 
       
       <c:set var="date" value="12/02/2019" />  
       <fmt:parseDate value="${date}" var="parsedDate"  pattern="dd/MM/yyyy" />  //
       <p><c:out value="${parsedDate}" /></p> 
       
       <c:set var="Date" value="<%=new java.util.Date()%>" />  
       <p>Formatted Time :  
       <fmt:formatDate type="time" value="${Date}" />  //
       </p>
       <br>
       
      <c:set var="vegetable"> 
      <vegetables>  
      <vegetable>  
      <name>onion</name>  
      <price>40/kg</price>  
      </vegetable>  
      <vegetable>  
      <name>Potato</name>  
      <price>30/kg</price>  
      </vegetable>  
      <vegetable>  
      <name>Tomato</name>  
      <price>90/kg</price>  
      </vegetable>  
      </vegetables>  
      </c:set>  
      <x:parse xml="${vegetable}" var="output"/>   //
      <b>Name of the vegetable is</b>:  
      <x:out select="$output/vegetables/vegetable[1]/name" /><br> 
      <b>Price of the Potato is</b>:  
      <x:out select="$output/vegetables/vegetable[2]/price" />
      
      <x:parse xml="${vegetable}" var="output"/>  
      <x:choose>  
      <x:when select="$output//vegetable/price = '30/kg'">  
      <p>The price is 30/kg</p>  
      </x:when> 
      </x:choose> 
      <br>
      
      <sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"  
      url="jdbc:mysql://localhost:3306/moviedb?serverTimezone=UTC"  
      user="root"  password="12345678"/>  
      
      <sql:query dataSource="${db}" var="rs">  
      SELECT * from books;  
      </sql:query>
      
      <sql:update dataSource="${db}" var="count">  
      INSERT INTO books VALUES ('001','jstl sql tag', 'me', 10.00);  
      </sql:update>  
   
      <table border="2" width="100%">  
      <tr>  
      <th>ISBN</th>  
      <th>Title</th>  
      <th>Authors</th>  
      <th>Price</th>  
      </tr>  
      <c:forEach var="table" items="${rs.rows}">  
      <tr>  
      <td><c:out value="${table.isbn}"/></td>  
      <td><c:out value="${table.title}"/></td>  
      <td><c:out value="${table.authors}"/></td>  
      <td><c:out value="${table.price}"/></td>  
      </tr>  
      </c:forEach>  
      </table>  
       

    </body>

</html>
