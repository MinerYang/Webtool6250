/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import com.my.dao.*;
import com.my.pojo.*;

/**
 *
 * @author cestdrama
 */
public class BrowseMovieController extends AbstractController {

    public BrowseMovieController() {
    }
    
     @Override
   protected ModelAndView handleRequestInternal(HttpServletRequest request,
      HttpServletResponse response) throws Exception {
       ModelAndView mv =null;
       
       String keyword = request.getParameter("keyword");
        String search = request.getParameter("search");
        MovieDAO movieDAO = new MovieDAO();
        List<Movie> result = movieDAO.getMovies(search, keyword);
//        request.setAttribute("keyword", keyword);
//        request.setAttribute("result", result);
//        request.getRequestDispatcher("part7/SearchView.jsp").forward(request, response);
      mv=new ModelAndView("SearchView");
      mv.addObject("keyword", keyword);
      mv.addObject("result", result);
      
      return mv;
       
   }
      
    
}
