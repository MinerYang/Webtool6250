/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDao;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import pojo.User;

/**
 *
 * @author cestdrama
 */
 public class LoginController extends SimpleFormController {

    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {
        User user = (User)command;
        String name=user.getUsername();
        String pwd=user.getPassword();
//        String email=user.getEmail();
        UserDao userDao = new UserDao();
        ModelAndView mv=new ModelAndView("patient");
        User patient = userDao.login(name,pwd); 
        if(patient!=null){
            mv.addObject("result", 1);
            mv.addObject("id", patient.getId());
            mv.addObject("username",patient.getUsername());
            mv.addObject("email",patient.getEmail());
            return mv;
        }
        else 
            mv.addObject("result", 0);
           
        return mv;
    }
    
    
}
