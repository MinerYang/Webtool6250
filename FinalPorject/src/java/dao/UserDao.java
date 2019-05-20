/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
/**
 *
 * @author cestdrama
 */

import java.util.*;
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
import org.hibernate.criterion.Restrictions;
import pojo.MedRecord;
import pojo.User;

/**
 *
 * @author rahulzore
 */
public class UserDao {
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

    public int Register(User user) {
       int result = 0;
        try {
            beginTransaction();
            Session sf = getSession();
            sf.save(user);
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
    
    public User login(String username,String password ){
        if(username==null)
            username="";
        if(password==null)
            password="";
        List<Object[]> list = null;
        List<User> al=new ArrayList();
        //user.username ,user.password
        String hql="select user.id,user.username ,user.password,user.email from User as user where user.username='"+username+"' and user.password = '"+password+"'";
        try {
            //Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
            beginTransaction();
            Session sf=getSession();
            Query query =sf.createQuery(hql);
            list = query.list();
            commit();
            for(Object[] u:list){
                int id=(Integer) u[0];
                String name = (String) u[1];
                String pwd = (String) u[2];
                String email=(String) u[3];
                User uu=new User();
                uu.setId(id);
                uu.setUsername(name);
                uu.setPassword(password);
                uu.setEmail(email);
                al.add(uu);
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
    
   
    public User update(Integer id,String username,String password,String email){
        beginTransaction();
        Session sf=getSession();
        User user=(User) sf.get(User.class,id);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        sf.update(user);
        sf.getTransaction().commit();
       // session.close();
        System.out.println("*********\n"+"username:"+user.getUsername());
        return user;
    }
    
    public void Delete(Integer id){
        beginTransaction();
        Session sf=getSession();
        User user=(User) sf.get(User.class,id);
        sf.delete(user);
        sf.getTransaction().commit();
        sf.close();
    }
    public int insert(User user){
        int result =0;
        beginTransaction();
        Session sf=getSession();
        sf.save(user);
        sf.getTransaction().commit();
        sf.close();
        return 1;
    }
    
    public User inputMed(int userid,String des,String treatment){
        beginTransaction();
        Session sf=getSession();
        User user=(User)sf.get(User.class,userid);
        //session.save(user);
        
        MedRecord md=new MedRecord();
        md.setDescription(des);
        md.setTreatment(treatment);
        md.setUser(user);
//        user.getRecord().add(md);
        user.getRecset().add(md);
        session.save(md);
        commit();
        
        return user;
    }
    
     
   public User searchpwd(String username,String email){
        beginTransaction();
        Session session=getSession();
        Criteria crit=session.createCriteria(User.class);
        crit.add(Restrictions.eq("username",username));
        crit.add(Restrictions.eq("email",email));
        List<User> res=crit.list();
        commit();
        if(res.size()==0)
            return null;
        return res.get(0);
    }
   
   public User finduser(int userid){
        beginTransaction();
        Session session=getSession();
        Criteria crit=session.createCriteria(User.class);
        crit.add(Restrictions.eq("id",userid));
        List<User> res=crit.list();
        commit();
        if(res.size()==0)
            return null;
        return res.get(0);
    }
     
    public List<MedRecord> searchRecord(int userid){
        beginTransaction();
        Session sf=getSession(); 
        User user=(User)sf.load(User.class,userid);
        commit();
        List <MedRecord> res=new ArrayList();
        for(MedRecord md: user.getRecset())
            res.add(md);
        return res;
//        String hql="from MedRecord as md where md.user.id ="+userid;      
//        beginTransaction();
//        Session session=getSession();
//        Query query =session.createQuery(hql);
//        List<MedRecord> res = query.list();
//        commit();
//        return res;
    }
    
    
    
//    public List<MedRecord> searchRecord(int userid,String des){
//        beginTransaction();
//        Session session=getSession();
//        User user=(User)session.load(User.class,userid);
//        Set<MedRecord>lset=user.getRecset();
//        
//        Criteria crit=session.createCriteria(MedRecord.class);
//        crit.add(Restrictions.like("description",des+"%"));
//        List<MedRecord> clist=crit.list();
//        
//        return res ;
//    }
    

    
    public static void main(String args[]){
          UserDao ud=new UserDao();
//          for(MedRecord md:ud.searchRecord(16))
//              System.out.println("mdid:"+md.getMedid()+" "+"description:"+md.getDescription()+" ");
             
//          Set<MedRecord> set=new HashSet<MedRecord>();
//          set=ud.searchMed(16);
//          System.out.println("size:"+set.size());
//          for(MedRecord md:set){
//              System.out.println("mdid:"+md.getMedid()+" "+"description:"+md.getDescription()+" ");
//          }
          
//         ud.beginTransaction();
//          Session session=ud.getSession();
//          User user=(User) session.get(User.class,16);
            List<MedRecord> prelist=ud.searchRecord(4);
            System.out.println("presize:"+prelist.size());
//            User u=ud.inputMed(4, "cold", " hot water",7);
//          System.out.println("mail:"+u.getEmail());
//          ud.insert(user);
          // ud.Register(new User("lin","123","qq"));
     //       User user=ud.login("uuu","123");
//           List<MedRecord> list=ud.searchRecord(4);
           //System.out.println("size:"+list.size());
          // User user=ud.searchpwd("lily", "liy@outlook.com");
           //User user=ud.finduser(16);
           System.out.println("finish");
          //ud.Delete(6);
          //User u=ud.update(4,"lee", "123", "e@h.com");
         
//          if(user!=null)
//              System.out.println("my email:"+user.getEmail());
//          else System.out.println("failed");
    }

}
