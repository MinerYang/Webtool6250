/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DoctorDao;
import dao.UserDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import pojo.Doctor;
import pojo.MedRecord;
import pojo.User;

/**
 *
 * @author cestdrama
 */
public class DoctorController extends MultiActionController{
    
    public ModelAndView dEnter(HttpServletRequest request, HttpServletResponse response )   
    throws Exception {
        ModelAndView mv=new ModelAndView("login");
        mv.addObject("type",2);
        return mv;
    }
    
    public  ModelAndView dLogin (HttpServletRequest request, HttpServletResponse response )   
  throws Exception {
        String name=request.getParameter("docname");
        String pwd=request.getParameter("password");
        DoctorDao docDao = new DoctorDao();
        Doctor doc = docDao.login(name,pwd);
        ModelAndView mv=new ModelAndView("doctor");
        if(doc!=null){
            mv.addObject("doc", doc);
            mv.addObject("result", 1);
//            return mv;
        }
        else 
            mv.addObject("result", 0);
        return mv;        
    }
    
    public ModelAndView dRegister(HttpServletRequest request, HttpServletResponse response )   
  throws Exception {
        ModelAndView mv=new ModelAndView("register");
        mv.addObject("type", 2);
        return mv;
    }
    
    public ModelAndView DoRegister(HttpServletRequest request, HttpServletResponse response )   
  throws Exception {
        String name=request.getParameter("docname");
        String pwd=request.getParameter("pwd");
        Doctor doc=new Doctor();
        doc.setDocname(name);
        doc.setPwd(pwd);
        DoctorDao dd=new DoctorDao();
        int result=dd.Register(doc);
        ModelAndView mv=new ModelAndView("addResult","result",result);
        return mv;
    }
    
     public ModelAndView dUpdate(HttpServletRequest request, HttpServletResponse response){
        int id=Integer.valueOf(request.getParameter("docid"));
        String name=request.getParameter("docname");
        String pwd=request.getParameter("pwd");
        DoctorDao dd = new DoctorDao();
        Doctor doc=dd.update(id,name,pwd);
        ModelAndView mv=new ModelAndView("doctor");
        mv.addObject("doc", doc);
        mv.addObject("result", 1);
        return mv;
    }
    
   public ModelAndView transToInsert(HttpServletRequest request, HttpServletResponse response ){
         ModelAndView mv=new ModelAndView("diagnose");
         mv.addObject("docid",request.getParameter("docid"));
         return mv;
   }
   
   public ModelAndView diagnosis(HttpServletRequest request, HttpServletResponse response ){
        int docid=Integer.valueOf(request.getParameter("docid"));
        int userid=Integer.valueOf(request.getParameter("userid"));
        String des=request.getParameter("des");
        String treatment=request.getParameter("treatment");
        DoctorDao dd = new DoctorDao();
        int res=dd.inputMed(docid, userid, des, treatment);
        ModelAndView mv= new ModelAndView("addResult");
        mv.addObject("result", res);
        return mv;
   }
   
//   public ModelAndView transToView(HttpServletRequest request, HttpServletResponse response ){
//         ModelAndView mv=new ModelAndView("doctorView");
//         return mv;
//   }
   
   public ModelAndView ViewRecord(HttpServletRequest request, HttpServletResponse response ){
          DoctorDao dd = new DoctorDao();
          List<MedRecord> list=dd.searchRecord();
          ModelAndView mv=new ModelAndView("doctorView");
          mv.addObject("list", list);
          return mv;      
   }
   public ModelAndView SearchUserRecord(HttpServletRequest request, HttpServletResponse response ){
          int userid=Integer.valueOf(request.getParameter("userid"));
          DoctorDao dd = new DoctorDao();
          List<MedRecord> list=dd.searchRecord(userid);
          
          UserDao ud=new UserDao();
          User user=ud.finduser(userid);
          ModelAndView mv=new ModelAndView("doctorView");
          if(user!=null)
              mv.addObject("user", user);
          else mv.addObject("user", new User());
          mv.addObject("list", list);
          mv.addObject("type", 1);
          return mv;      
   }
   
   
   
}
