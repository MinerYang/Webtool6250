/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pojo.Movie;
/**
 *
 * @author Administrator
 */
public class MovieValidator implements Validator{

    @Override
    public boolean supports(Class aClass) {
        return Movie.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "error.title.required","Title Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "actor", "error.actor.required","actor Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "actress", "error.actress.required","actress Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "genre", "error.genre.required","genre Required");
        if(errors.hasErrors())
            return;
        Movie movie = (Movie) o;
        if(movie.getYear()==0){
            errors.rejectValue("year", "error.year.format","not validate");
                    
        }
    }
    
}
