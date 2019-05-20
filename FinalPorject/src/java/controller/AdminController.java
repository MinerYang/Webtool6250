/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.*;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import pojo.*;

/**
 *
 * @author cestdrama
 */
public class AdminController extends MultiActionController {
    
    public ModelAndView aEnter(HttpServletRequest request, HttpServletResponse response )   
    throws Exception {
        ModelAndView mv=new ModelAndView("login");
        mv.addObject("type",3);
        return mv;
    }
    public ModelAndView aLogin (HttpServletRequest request, HttpServletResponse response )   
  throws Exception {
        String name=request.getParameter("adminname");
        String pwd=request.getParameter("apwd");
        AdminDao adao = new AdminDao();
        Admin admin = adao.login(name,pwd);
        ModelAndView mv=new ModelAndView("admin");
        if(admin!=null){
            mv.addObject("admin", admin);
            mv.addObject("result", 1);
//            return mv;
        }
        else 
            mv.addObject("result", 0);
        return mv;        
    }
    
    public ModelAndView mngdoc (HttpServletRequest request, HttpServletResponse response )   
  throws Exception {
//        String name=request.getParameter("adminname");
//        String pwd=request.getParameter("apwd");
        AdminDao adao = new AdminDao();
//        Admin admin = adao.login(name,pwd);
        ModelAndView mv=new ModelAndView("docmanage");
        List<Doctor> list=adao.Searchdoc();
        mv.addObject("list", list);
        return mv;        
    }
    
   public ModelAndView deleteDoc (HttpServletRequest request, HttpServletResponse response )   
  throws Exception {
        Integer docid=Integer.valueOf(request.getParameter("docid"));
        AdminDao adao = new AdminDao();
        adao.deletedoc(docid);
        ModelAndView mv=new ModelAndView("docmanage");
        List<Doctor> list=adao.Searchdoc();
        mv.addObject("list", list);
        return mv;        
    }
   
   public ModelAndView mngpatient (HttpServletRequest request, HttpServletResponse response )   
  throws Exception {
//        String name=request.getParameter("adminname");
//        String pwd=request.getParameter("apwd");
        AdminDao adao = new AdminDao();
//        Admin admin = adao.login(name,pwd);
        ModelAndView mv=new ModelAndView("patmanage");
        List<User> list=adao.Searchpat();
        mv.addObject("list", list);
        return mv;        
    }
   public ModelAndView deletepat (HttpServletRequest request, HttpServletResponse response )   
  throws Exception {
        Integer id=Integer.valueOf(request.getParameter("id"));
        AdminDao adao = new AdminDao();
        adao.deletepat(id);
        ModelAndView mv=new ModelAndView("patmanage");
        List<User> list=adao.Searchpat();
        mv.addObject("list", list);
        return mv;        
    }
   
   public ModelAndView mngmed (HttpServletRequest request, HttpServletResponse response )   
  throws Exception {
//        String name=request.getParameter("adminname");
//        String pwd=request.getParameter("apwd");
        AdminDao adao = new AdminDao();
//        Admin admin = adao.login(name,pwd);
        ModelAndView mv=new ModelAndView("medmanage");
        List<MedRecord> list=adao.Searchmed();
        mv.addObject("list", list);
        return mv;        
    }
   public ModelAndView deletemed (HttpServletRequest request, HttpServletResponse response )   
  throws Exception {
        Integer medid=Integer.valueOf(request.getParameter("medid"));
        AdminDao adao = new AdminDao();
        adao.deletemed(medid);
        ModelAndView mv=new ModelAndView("medmanage");
        List<MedRecord> list=adao.Searchmed();
        mv.addObject("list", list);
        return mv;        
    }
    
}
