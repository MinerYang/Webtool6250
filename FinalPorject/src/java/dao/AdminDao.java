/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import pojo.*;

/**
 *
 * @author cestdrama
 */
public class AdminDao {
    private SessionFactory sessionFactory;
    private static Session session;

    protected SessionFactory setUp() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        //configuration.addResource("hibernate.cfg.xml").configure();
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();
        try {
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }

    public Session getSession() {
        if (session == null) {
            session = setUp().openSession();
        }
        return session;
    }

    private void beginTransaction() {
        getSession().beginTransaction();
    }

    private void commit() {
        getSession().getTransaction().commit();
    }

    private void close() {
        getSession().close();
    }

    private void rollbackTransaction() {
        getSession().getTransaction().rollback();
    }
    
    
    public void insert(Admin admin){
        beginTransaction();
        Session session=getSession();
        session.save(admin);
        session.getTransaction().commit();
        //session.close();
        
    }
    
    public Admin login(String adminname,String password ){
        if(adminname==null)
            adminname="";
        if(password==null)
            password="";
        beginTransaction();
        Session session=getSession();
        Criteria crit=session.createCriteria(Admin.class);
        crit.add(Restrictions.eq("adminname", adminname));
        crit.add(Restrictions.eq("apwd", password));
        List<Admin> res=crit.list();
        commit();
       
        if(res.isEmpty()){
            return null;
        }
        
        return res.get(0);
    }
     
    public List<Doctor> Searchdoc(){
        beginTransaction();
        Session session=getSession();
        Criteria crit=session.createCriteria(Doctor.class);
        List<Doctor> res=crit.list();
        commit();
        return res;
    }
    
    public void deletedoc(Integer docid){
        beginTransaction();
        Session session=getSession();
        Doctor doc=(Doctor) session.get(Doctor.class,docid);
        if(doc !=null)
            session.delete(doc);
        session.getTransaction().commit();
        //session.close();
    
    }
    
    public List<User> Searchpat(){
        beginTransaction();
        Session session=getSession();
        Criteria crit=session.createCriteria(User.class);
        List<User> res=crit.list();
        commit();
        return res;
    }
    
    public void deletepat(Integer userid){
        beginTransaction();
        Session session=getSession();
        User user=(User) session.get(User.class,userid);
        if(user!=null)
            session.delete(user);
        session.getTransaction().commit();
        //session.close();
    
    }
    
    public List<MedRecord> Searchmed(){
        beginTransaction();
        Session session=getSession();
        Criteria crit=session.createCriteria(MedRecord.class);
        List<MedRecord> res=crit.list();
        commit();
        return res;
    }
    
    public void deletemed(Integer medid){
        beginTransaction();
        Session session=getSession();
        MedRecord med=(MedRecord) session.get(MedRecord.class,medid);
        if(med!=null)
           session.delete(med);
        session.getTransaction().commit();
        //session.close();
    
    }
    
    public static void main(String args[]){
          AdminDao ad=new AdminDao();
          Admin admin=new Admin();
          //admin=ad.login("root", "12345678");
          ad.deletedoc(3);
          //System.out.println("admin:"+admin.getAdminname());
          
//          List<Doctor> list=ad.Searchdoc();
//          System.out.println(list.size());
         
//          admin.setAdminname("root");
//          admin.setApwd("12345678");
//          
//          ad.insert(admin);
          System.out.println("finish");
          

         
          

    }
}
