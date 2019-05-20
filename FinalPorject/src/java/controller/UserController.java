/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import pojo.User;
import dao.UserDao;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import pojo.MedRecord;

/**
 *
 * @author cestdrama
 */
    public class UserController extends MultiActionController {

   public ModelAndView pEnter(HttpServletRequest request, HttpServletResponse response )   
  throws Exception {
        ModelAndView mv=new ModelAndView("login");
        mv.addObject("type", 1);
        return mv;
    }
   
   public ModelAndView pRegister(HttpServletRequest request, HttpServletResponse response )   
  throws Exception {
        ModelAndView mv=new ModelAndView("register");
        mv.addObject("type", 2);
        return mv;
    }
   
   public ModelAndView HandelRegister(HttpServletRequest request, HttpServletResponse response )   
  throws Exception {
        String name=request.getParameter("username");
        String pwd=request.getParameter("password");
        String email=request.getParameter("email");
        User user=new User();
        user.setUsername(name);
        user.setPassword(pwd);
        user.setEmail(email);
        
        UserDao ud=new UserDao();
        int result=ud.Register(user);
        ModelAndView mv=new ModelAndView("addResult","result",result);
        return mv;
    }
   
   
    
    public  ModelAndView pLogin (HttpServletRequest request, HttpServletResponse response )   
  throws Exception {
        String name=request.getParameter("username");
        String pwd=request.getParameter("password");
        UserDao userDao = new UserDao();
        User user = userDao.login(name,pwd);
        ModelAndView mv=new ModelAndView("patient");
        if(user!=null){
            mv.addObject("user", user);
            mv.addObject("result", 1);
//            return mv;
        }
        else 
            mv.addObject("result", 0);
        return mv;        
    }
    
    public ModelAndView pUpdate(HttpServletRequest request, HttpServletResponse response){
        Integer id=Integer.valueOf(request.getParameter("id"));
        String name=request.getParameter("username");
        String pwd=request.getParameter("password");
        String email=request.getParameter("email");
        UserDao userDao = new UserDao();
        User user=userDao.update(id,name,pwd,email);
        ModelAndView mv=new ModelAndView("patient");
        mv.addObject("user", user);
        mv.addObject("result", 1);
        return mv;
    }
    
     public ModelAndView pView(HttpServletRequest request, HttpServletResponse response){
        int userid=Integer.valueOf(request.getParameter("id"));
        //String des=request.getParameter("userid");
        
        UserDao userDao = new UserDao();
        ModelAndView mv=new ModelAndView("patientView");
        List<MedRecord> res=new ArrayList();
        //User user=new User();
        res=userDao.searchRecord(userid);
        //mv.addObject("size",res.size());
        mv.addObject("result", res);       
        return mv;
    }
   
     public ModelAndView findpwd(HttpServletRequest request, HttpServletResponse response){
        //int userid=Integer.valueOf(request.getParameter("id"));
        String username=request.getParameter("username");
        String email=request.getParameter("email");
        
        UserDao userDao = new UserDao();
        ModelAndView mv=new ModelAndView("backpwd");
        
        User user=userDao.searchpwd(username,email);
        if(user!=null){
           mv.addObject("result",1 );
        }
        else 
           mv.addObject("result",0 );
        mv.addObject("user",user );       
        return mv;
    }
    
}
