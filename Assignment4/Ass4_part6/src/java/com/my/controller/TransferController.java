/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author cestdrama
 */
public class TransferController extends AbstractController {
    public TransferController() {
    }
   @Override
   protected ModelAndView handleRequestInternal(HttpServletRequest request,
      HttpServletResponse response) throws Exception {
       
    ModelAndView mv = null;
    String option =request.getParameter("selection")==null?"":request.getParameter("selection");
  
            switch (option) {
                case "browse":
                    //String recipient = request.getParameter("recipient");
                    mv = new ModelAndView("browse"); //Srting viewname, String modelname,Object objectname
                    break;
                
                case "add":
                    mv=new ModelAndView("Insert");
                    break;
            }
     //mv=new ModelAndView("insert");
    
    return mv;
   }        
            
    
}