/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MovieDao;
import java.util.List;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import pojo.Movie;
import pojo.Search;

/**
 *
 * @author Administrator
 */
public class SearchController extends SimpleFormController {

    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {
        Search search = (Search)command;
        MovieDao movieDAO = new MovieDao();
        List<Movie> results = movieDAO.getMovies(search.getType(), search.getKeyword());
        ModelAndView mv = new ModelAndView("browseResult");
        mv.addObject("keyword", search.getKeyword());
        mv.addObject("result", results);
        return mv;
    }
    
    
    
}
