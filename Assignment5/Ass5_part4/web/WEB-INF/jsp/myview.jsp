

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>
    <style type="text/css">
        qfont{
           color:blue; 
        }
        cfont{
            color:#FFAD29;
        }
        sfont{
            color:green;
        }
        right{
            color:green;
        }
        wrong{
            color:red;
        }
        
    </style>
    <body>
        <h2>My Quiz</h2>
        <div>
            <c:if test="${requestScope.qz.getNum() eq '7'}" >
                <qfont><b>Question1:&nbsp;</b></qfont><span>${q1}<span><br/>
                <cfont><b>Your answer:&nbsp;</b></cfont>${chos1}
                &emsp;<c:if test="${std1 eq chos1}"> <right>^_^</right></c:if>
                &emsp;<c:if test="${std1 ne chos1}"> <wrong>u_u</wrong></c:if><br/>
                <sfont><b>Correct answer:&nbsp;</b></sfont>${std1}<br/>
                <hr/>
                
                <qfont><b>Question2:&nbsp;</b></qfont><span>${q2}<span><br/>
                <cfont><b>Your answer:&nbsp;</b></cfont>${chos2}
                &emsp;<c:if test="${std2 eq chos2}"> <right>^_^</right></c:if>
                &emsp;<c:if test="${std2 ne chos2}"> <wrong>u_u</wrong></c:if><br/>                            
                <sfont><b>Correct answer:&nbsp;</b></sfont>${std2}<br/>
                <hr/>
                
                <qfont><b>Question3:&nbsp;</b></qfont><span>${q3}<span><br/>
                <cfont><b>Your answer:&nbsp;</b></cfont>${chos3}
                &emsp;<c:if test="${std3 eq chos3}"> <right>^_^</right></c:if>
                &emsp;<c:if test="${std3 ne chos3}"> <wrong>u_u</wrong></c:if><br/>                            
                <sfont><b>Correct answer:&nbsp;</b></sfont>${std3}<br/>
                <hr/>
                
                <qfont><b>Question4:&nbsp;</b></qfont><span>${q4}<span><br/>
                <cfont><b>Your answer:&nbsp;</b></cfont>${chos4}
                &emsp;<c:if test="${std4 eq chos4}"> <right>^_^</right></c:if>
                &emsp;<c:if test="${std4 ne chos4}"> <wrong>u_u</wrong></c:if><br/>                            
                <sfont><b>Correct answer:&nbsp;</b></sfont>${std4}<br/>
                <hr/>
                
                <qfont><b>Question5:&nbsp;</b></qfont><span>${q5}<span><br/>
                <cfont><b>Your answer:&nbsp;</b></cfont>${chos5}
                &emsp;<c:if test="${std5 eq chos5}"> <right>^_^</right></c:if>
                &emsp;<c:if test="${std5 ne chos5}"> <wrong>u_u</wrong></c:if><br/>                            
                <sfont><b>Correct answer:&nbsp;</b></sfont>${std5}<br/>
                <hr/>
                
                <qfont><b>Question6:&nbsp;</b></qfont><span>${q6}<span><br/>
                <cfont><b>Your answer:&nbsp;</b></cfont>${chos6}
                &emsp;<c:if test="${std6 eq chos6}"> <right>^_^</right></c:if>
                &emsp;<c:if test="${std6 ne chos6}"> <wrong>u_u</wrong></c:if><br/>                            
                <sfont><b>Correct answer:&nbsp;</b></sfont>${std6}<br/>
                <hr/>
            </c:if>
        </div>

            
        <script type="text/javascript">
		onload=function(){
			setInterval(go, 1000);
		};
               
		var x=10; //
                var page=${requestScope.qz.getNum()};
		function go(){
                if(page<7){
		x--;
			if(x>0){
			document.getElementById("sp").innerHTML=x;  //?????x????????
			}else{
			location.href='${requestScope.qz.getNum()+1}.htm';
			}
                }
		}
        </script>
        <wrong><b id="sp"></b></wrong><br/>  
        <div> 
            <c:if test="${requestScope.qz.getNum() ne '7'}">
<!--               my map size:${fn:length(mymap)}<br/>-->
               <form action="${requestScope.qz.getNum()+1}.htm" method="post">
                   <label for="Question"><b>Question ${requestScope.qz.getNum()} </b>: ${requestScope.qz.getQuestion()}</label>
                   <br/>                     
                   <c:forEach items="${requestScope.qz.getOptionlist()}" var="m" varStatus="i">
                       ${i.count}. <input type="radio" name="Question" value="${m}">${m} <br/>
                   </c:forEach>      
                   <input type="hidden" name="stdans" value="${stdans}"><br/>
                   <input type="hidden" name="chosans" value="${chosans}" ><br/>
                   <input type="submit" name="submit" value="next">
               </form>
            </c:if> 
        </div>
    </body>
</html>
