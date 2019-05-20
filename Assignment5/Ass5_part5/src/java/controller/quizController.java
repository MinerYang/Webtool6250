/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;
import pojo.Result;

/**
 *
 * @author Administrator
 */
public class quizController extends AbstractWizardFormController{

    private String successView;
    private String cancelView;
    public String getCancelView() {
        return cancelView;
    }

    public void setCancelView(String cancelView) {
        this.cancelView = cancelView;
    }

    public String getSuccessView() {
        return successView;
    }

    public void setSuccessView(String successView) {
        this.successView = successView;
    }
    
    protected Map referenceData(HttpServletRequest request, int page) throws Exception { 
        Map map = new HashMap(); 
//        for(int i=0;i<3;i++){
//            if(page==i) {
//                map.put("title", "Question "+(i+1)+": Which method doesn't exist in HttpServlet class:");
//                map.put("question", Arrays.asList("Post", "Init", "Get", "Opiton")); 
//                map.put("pageNumber",i);
//            } 
//        }
        if(page==0){
             map.put("title", "Question 1: Which method doesn't exist in HttpServlet class?");
             map.put("question", Arrays.asList("Post", "Init", "Get", "Opiton")); 
             map.put("pageNumber",0);
        }
         if(page==1){
             map.put("title", "Question 2: Which of these life-circle method you can over-ride in your class?");
             map.put("question", Arrays.asList("Service", "Init", "DoGet", "AllofAbovles")); 
             map.put("pageNumber",1);
         }
        if(page==2){
             map.put("title", "Question 3: Which interface contain servlet life-cycle methods?");
             map.put("question", Arrays.asList("HttpServlet", "GenerticServlet", "Service", "Servlet")); 
             map.put("pageNumber",2);
        
        }
        return map; 
    } 
    
    
    @Override
    protected ModelAndView processFinish(HttpServletRequest request, HttpServletResponse response, Object object, BindException be) throws Exception {
        Result result=(Result)object;
        return new ModelAndView(this.getSuccessView(),"result", result); 
    }

    @Override
    protected ModelAndView processCancel(HttpServletRequest request, HttpServletResponse response, Object object, BindException be) throws Exception {
         return new ModelAndView(this.getCancelView());
    }
 
    
    
}
