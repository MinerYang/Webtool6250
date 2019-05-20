/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import com.my.dao.*;

/**
 *
 * @author cestdrama
 */
public class AddMovieController extends AbstractController{

    public AddMovieController() {
    }

    @Override
   protected ModelAndView handleRequestInternal(HttpServletRequest request,
      HttpServletResponse response) throws Exception {
       
    ModelAndView mv = null;
    MovieDAO movieDAO = new MovieDAO();
    //
        String movieTitle = request.getParameter("Movie Title");
        String leadActor = request.getParameter("Lead Actor");
        String leadActress = request.getParameter("Lead Actress");
        String genre = request.getParameter("Genre");
        String year = request.getParameter("Year");
        int result = movieDAO.addMovie(movieTitle, leadActor, leadActress, genre, Integer.parseInt(year));
       // request.setAttribute("result", String.valueOf(result));
        //request.getRequestDispatcher("part7/AddView.jsp").forward(request, response);
        mv=new ModelAndView("AddView");
        mv.addObject("year", year);
        mv.addObject("result", result);//String attributeName, Object attributeValue
   
    return mv;
   }  
    
    
}
