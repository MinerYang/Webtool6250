/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MovieDao;
import java.util.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import pojo.Movie;

/**
 *
 * @author Administrator
 */
public class SaveController extends SimpleFormController {

    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {
        Movie movie = (Movie)command;
        MovieDao movieDAO = new MovieDao();
        int result = movieDAO.addMovie(movie);  
        return new ModelAndView("addResult", "result", result);
    }
}
