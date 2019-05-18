/*    */ package Util;
/*    */ 
/*    */ import Entity.UserLog;
/*    */ import Entity.Users;
/*    */ import java.sql.Timestamp;
/*    */ import java.util.Date;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import org.hibernate.HibernateException;
/*    */ import org.hibernate.Query;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.SessionFactory;
/*    */ import org.hibernate.Transaction;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LoginSec
/*    */ {
/*    */   private static Users LoggedUser;
/*    */   SessionFactory sf;
/*    */   Session s;
/*    */   
/* 34 */   public static Users getLoggedUser() { return LoggedUser; }
/*    */ 
/*    */   
/*    */   public String HandleLogin(String uName, String Pass) throws HibernateException {
/* 38 */     String status = "";
/* 39 */     this.sf = HibernateUtil.getSessionFactory();
/* 40 */     this.s = this.sf.openSession();
/* 41 */     Transaction t = this.s.beginTransaction();
/* 42 */     Query query = this.s.createQuery("from Users where U_NAME= :s and PASS= :p");
/* 43 */     query.setParameter("s", uName).setParameter("p", Pass);
/* 44 */     List<Users> users = query.list();
/* 45 */     UserLog ul = new UserLog();
/* 46 */     for (Iterator<Users> iterator = users.iterator(); iterator.hasNext(); ) {
/* 47 */       Users next = (Users)iterator.next();
/* 48 */       LoggedUser = next;
/* 49 */       status = LoggedUser.getStatus();
/* 50 */       ul.setUId(LoggedUser);
/* 51 */       ul.setLogDate(new Timestamp((new Date()).getTime()));
/* 52 */       ul.setLogDESC("User : " + LoggedUser.getUName() + " -- Login");
/* 53 */       this.s.persist(ul);
/* 54 */       t.commit();
/*    */     } 
/* 56 */     this.s.close();
/*    */     
/* 58 */     return status;
/*    */   }
/*    */   
/*    */   public void HandleLogout() {
/* 62 */     UserLog ul = new UserLog();
/* 63 */     this.sf = HibernateUtil.getSessionFactory();
/* 64 */     this.s = this.sf.openSession();
/* 65 */     Transaction t = this.s.beginTransaction();
/* 66 */     ul.setUId(LoggedUser);
/* 67 */     ul.setLogDate(new Timestamp((new Date()).getTime()));
/* 68 */     ul.setLogDESC("User : " + LoggedUser.getUName() + " -- logout");
/* 69 */     this.s.persist(ul);
/* 70 */     t.commit();
/* 71 */     this.s.close();
/*    */   }
/*    */ }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Util\LoginSec.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */