/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Entity.Users;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Abdo
 */
public class LoginSec {

    public LoginSec() {
    }
    
    
    HibernateUtil HU;
    
    public String HandleLogin(String uName, String Pass){
        String status="";
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        
        Transaction t = s.beginTransaction();
        Query query = s.createQuery("from Users where U_NAME= :s and PASS= :p");
                query.setParameter("s", uName).setParameter("p", Pass);
        
        
        List<Users> users = query.list();
        
        for (Iterator<Users> iterator = users.iterator(); iterator.hasNext();) {
            Users next = iterator.next();
            System.out.println("uname "+next.getUName());
           status=next.getStatus();
            System.out.println("status "+status);
                          
        }
        s.close();
        return status;
    }
}
