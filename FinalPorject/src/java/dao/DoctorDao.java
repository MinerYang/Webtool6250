/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import pojo.Doctor;
import pojo.MedRecord;
import pojo.User;

/**
 *
 * @author cestdrama
 */
public class DoctorDao {
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
    
    public void insert(Doctor doc){
        beginTransaction();
        Session session=getSession();
        session.save(doc);
        session.getTransaction().commit();
        //session.close();
        
    }
    
    public int Register(Doctor doc) {
       int result = 0;
        try {
            beginTransaction();
            Session session = getSession();
            session.save(doc);
            commit();
            result = 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            try {
                rollbackTransaction();
            } catch (Exception ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                 //close();
            } catch (Exception ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    
    public Doctor login(String docname,String password ){
        if(docname==null)
            docname="";
        if(password==null)
            password="";
        List<Object[]> list = null;
        List<Doctor> al=new ArrayList();
        //user.username ,user.password
        //String hql="select doctor.docid,doctor.docname ,doctor.pwd from Doctor as doc where doc.docname='"+docname+"' and doc.pwd = '"+password+"'";
        String hql="select d.docid,d.docname ,d.pwd from Doctor as d where d.docname='"+docname+"' and d.pwd = '"+password+"'";
        try {
            //Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
            beginTransaction();
            Session session=getSession();
            Query query =session.createQuery(hql);
            list = query.list();
            commit();
            for(Object[] u:list){
                int id=(Integer) u[0];
                String name = (String) u[1];
                String pwd = (String) u[2];
                Doctor dd=new Doctor();
                dd.setDocid(id);
                dd.setDocname(name);
                dd.setPwd(pwd);
                al.add(dd);
                //System.out.println(name + " : "+email); 
            }            
        } catch (HibernateException e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        } 
       
        if(list.isEmpty()){
            return null;
        }
        
            return al.get(0);
    }
    
     public Doctor update(int docid,String docname,String pwd){
        beginTransaction();
        Session session=getSession();
        Doctor doc=(Doctor) session.get(Doctor.class,docid);
        doc.setDocname(docname);
        doc.setPwd(pwd);
        session.update(doc);
        session.getTransaction().commit();
       // session.close();
        return doc;
    }
    
    
    
   public int inputMed(Integer docid,int userid,String des,String treatment){
       int res=0;
       beginTransaction();
       Session session=getSession();
       User user=(User)session.get(User.class,userid);
       MedRecord md=new MedRecord();
        md.setDocid(docid);
        md.setDescription(des);
        md.setTreatment(treatment);
//        md.setUser(user);
        if(user!=null){
           res=1;
           user.getRecset().add(md);
           md.setUser(user);
           session.save(md);
           session.update(user);
         }
        commit();
        return res;
       
       
    }
   
   public List<MedRecord> searchRecord(){
        beginTransaction();
        Session session=getSession(); 
        Criteria criteria=session.createCriteria(MedRecord.class);
        List<MedRecord> res=criteria.list();
        commit();
//        List <MedRecord> res=new ArrayList();
//        for(MedRecord md: user.getRecset())
//            res.add(md);
        return res;
    }
   
   public List<MedRecord> searchRecord(int userid){ 
        String hql="from MedRecord as md where md.user.id ="+userid;      
        beginTransaction();
        Session session=getSession();
        Query query =session.createQuery(hql);
        List<MedRecord> res = query.list();
        commit();
        return res;
    }
    
    
    public static void main(String args[]){
          DoctorDao dd=new DoctorDao();
          
          List<MedRecord> list=dd.searchRecord(1);
          System.out.println(list.size());
 //         for(MedRecord md:list){
//               System.out.println("des:"+md.getDescription()+"docid:"+md.getDocid());
//          }
          //Doctor d=dd.login("yang", "123");
         // Doctor doc=new Doctor();
//          doc.setDocname("yang");
//           doc.setPwd("123");
//// //         
//          dd.insert(doc);
//          Doctor d=dd.update(5,"yang","123");
 //          User user=dd.inputMed(1, 16, "headache", "sleep");
//          System.out.println("docname:"+d.getDocname()+"id:"+d.getDocid());
         
          

    }
}
