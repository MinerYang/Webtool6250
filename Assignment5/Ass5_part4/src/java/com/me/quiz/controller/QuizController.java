/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.quiz.controller;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import com.my.pojo.Quiz;
import javax.servlet.http.HttpSession;
//import javax.servlet.http.HttpSession;
/**
 *
 * @author ysf
 */
public class QuizController extends AbstractController {
    
    public QuizController() {
    }
    
 
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
            ModelAndView mv = null;
            String uri = request.getRequestURI();
            Quiz qz=new Quiz();
            String chosans="";
            String stdans="";
           // int result=0;
           // List<String> anslist1=new ArrayList(); //standard answer
           //List<String> anslist2=new ArrayList(); //chosen answer
           //Map<String,String> map;
            HttpSession session = request.getSession();
            
        if (uri.endsWith("1.htm"))
        {
            //question 1 displayed, no answer to read
            //map=new HashMap();
            //session.setAttribute("mymap", map);
            qz.setNum("1");
            qz.setQuestion("Which of these life-circle method you can over-ride in your class?");
            session.setAttribute("q1", qz.getQuestion());
            stdans="All of these";
            qz.setAns(stdans);
            session.setAttribute("std1", qz.getAns());
            //anslist1.add(qz.getAns());
            List<String> temp=new ArrayList();
            temp.add("seivice");
            temp.add("init");
            temp.add("doGet");
            temp.add("All of these");
            qz.setOptionlist(temp);
     
        }else if (uri.endsWith("2.htm"))
        {
            //question 1 submitted - read question 1
            //chosans=request.getParameter("Question");
            session.setAttribute("chos1",request.getParameter("Question"));
            //stdans=request.getParameter("stdans");
            //map=(HashMap)session.getAttribute("mymap");
            //map.put(stdans, chosans);
            //
            //session.setAttribute("mymap", map);
            
//            AnswerDAO answerDAO = new AnswerDAO();
//            result = answerDAO.addAnswer("1", stdans, chosans);
            qz.setNum("2");
            qz.setQuestion("Which interface contain servlet life-cycle methods?");
            session.setAttribute("q2", qz.getQuestion());
            stdans="Servlet";
            qz.setAns(stdans);
            session.setAttribute("std2", qz.getAns());
            List<String> temp=new ArrayList();
            temp.add("HttpServlet");
            temp.add("GenerticServlet");
            temp.add("Service");
            temp.add("Servlet");
            qz.setOptionlist(temp);

        }else if (uri.endsWith("3.htm"))
        {
            //question 2 submitted - read question 2
            //chosans=request.getParameter("Question");
             session.setAttribute("chos2",request.getParameter("Question"));
            //stdans=request.getParameter("stdans");
            //map=(HashMap)session.getAttribute("mymap");
           // map.put(stdans, chosans);
            //
           // session.setAttribute("mymap", map);
            qz.setNum("3");
            qz.setQuestion("Which life cycle method is called once in servlet life");
            session.setAttribute("q3", qz.getQuestion());
            stdans="init()";
            qz.setAns(stdans);
            session.setAttribute("std3", qz.getAns());
           // anslist1.add(qz.getAns());
            List<String> temp=new ArrayList();
            temp.add("class loading");
            temp.add("init()");
            temp.add("service()");
            temp.add("destroy()");
            qz.setOptionlist(temp);

        } else if (uri.endsWith("4.htm"))
        {
            //question 2 submitted - read question 2
           // chosans=request.getParameter("Question");
             session.setAttribute("chos3",request.getParameter("Question"));
           // stdans=request.getParameter("stdans");
           // map=(HashMap)session.getAttribute("mymap");
          //  map.put(stdans, chosans);
            //
          //  session.setAttribute("mymap", map);
            qz.setNum("4");
            qz.setQuestion("Which method does not exsits in HttpServlet Class");
            session.setAttribute("q4", qz.getQuestion());
            stdans="init";
            qz.setAns(stdans);
            session.setAttribute("std4", qz.getAns());
           // anslist1.add(qz.getAns());
            List<String> temp=new ArrayList();
            temp.add("service");
            temp.add("init");
            temp.add("doGet");
            temp.add("doPost");
            qz.setOptionlist(temp);

        }else if (uri.endsWith("5.htm"))
        {
            //question 2 submitted - read question 2
//            chosans=request.getParameter("Question");
            session.setAttribute("chos4",request.getParameter("Question"));
//            stdans=request.getParameter("stdans");
//            map=(HashMap)session.getAttribute("mymap");
//            map.put(stdans, chosans);
            //
            //session.setAttribute("mymap", map);
            qz.setNum("5");
            qz.setQuestion("Which http method is idempotent?");
            session.setAttribute("q5", qz.getQuestion());
            stdans="get";
            qz.setAns(stdans);
            session.setAttribute("std5", qz.getAns());
           // anslist1.add(qz.getAns());
            List<String> temp=new ArrayList();
            temp.add("get");
            temp.add("post");
            temp.add("trace");
            temp.add("option");
            qz.setOptionlist(temp);

        }else if (uri.endsWith("6.htm"))
        {
            //question 2 submitted - read question 2
//            chosans=request.getParameter("Question");
            session.setAttribute("chos5",request.getParameter("Question"));
//            stdans=request.getParameter("stdans");
//            map=(HashMap)session.getAttribute("mymap");
//            map.put(stdans, chosans);
            //
            //session.setAttribute("mymap", map);
            qz.setNum("6");
            qz.setQuestion("Which statement is not true about ServletContext?");
            session.setAttribute("q6", qz.getQuestion());
            stdans="There is one ServletContext per one servlet";
            qz.setAns(stdans);
            session.setAttribute("std6", qz.getAns());
           // anslist1.add(qz.getAns());
            List<String> temp=new ArrayList();
            temp.add("There is one ServletContext per one application");
            temp.add("Generally it is used to get web app parameters");
            temp.add("We can get Server Information through it");
            temp.add("There is one ServletContext per one servlet");
            qz.setOptionlist(temp);

        }
        else if (uri.endsWith("7.htm"))
        {
//            chosans=request.getParameter("Question");
//            stdans=request.getParameter("stdans");
//            map=(HashMap)session.getAttribute("mymap");
//            map.put(stdans, chosans);
             session.setAttribute("chos6",request.getParameter("Question"));
            //
            //session.setAttribute("mymap", map);
            //qz.setAnsmap(map);
            qz.setNum("7");
            
            
            
        }else {
            //first time user is visiting, so display the 1st question
            return new ModelAndView("redirect:question/1.htm");
        }
       mv=new ModelAndView("myview","qz",qz);
       mv.addObject("stdans",qz.getAns());
       mv.addObject("chosans",chosans);
       return mv;
    }
    
}
