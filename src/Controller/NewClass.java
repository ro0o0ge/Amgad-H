/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.persistence.internal.libraries.antlr.runtime.tree.Tree;

/**
 *
 * @author Abdo
 */
public class NewClass {

    private static Statement stmt;
    private static ResultSet rs;
    private static Connection con;
    private static List listS_ID;
    private static List<String> listAOO;
    private static List listNewAOO;

    public static void x(String args[]) {
        try {
            //conv();
            conv();
//        System.out.println("0".replaceAll("0", "\\\u0660"));
//        System.out.println("1".replaceAll("1", "\\\u0661"));
//        System.out.println("2".replaceAll("2", "\\\u0662"));
//        System.out.println("3".replaceAll("3", "\\\u0663"));
//        System.out.println("4" .replaceAll("4", "\\\u0664"));
//        System.out.println("5".replaceAll("5", "\\\u0665"));
//        System.out.println("6".replaceAll("6", "\\\u0666"));
//        System.out.println("7".replaceAll("7", "\\\u0667"));
//        System.out.println("8".replaceAll("8", "\\\u0668"));
//        System.out.println("9".replaceAll("9", "\\\u0669"));
        } catch (SQLException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void conv() throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://192.168.1.107:3306/amgad_sc", "amgad_root", "Amgad@123@Root");
            stmt = con.createStatement();
            add();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            con.close();
        }
    }

    static void add() {
        listS_ID = new ArrayList<String>();
        listAOO = new ArrayList<String>();
        listNewAOO = new ArrayList<String>();
        
        
        
                
                    
///* 208 */         t = t.replace("Y", "");
///* 209 */         t = t.replace("M", "");
///* 210 */         t = t.replace("D", "");
/* 211 */         
        
        try {
            rs = stmt.executeQuery("select s.S_ID,p.dob from persons p inner join student s on p.P_ID = s.P_ID");
//            rs = stmt.executeQuery("SELECT S_ID,AGE_ON_OCT FROM student ");
            while (rs.next()) {
                listS_ID.add(rs.getString(1));
                listAOO.add(rs.getString(2));
            }
            String t = "";
            for (int i = 0; i < listAOO.size(); i++) {
                t = listAOO.get(i);
                
                LocalDate currentDate = LocalDate.parse(t);
                t = currentDate.until(LocalDate.of(Calendar.getInstance().get(1), 10, 1)).toString().replace("P", "");
//                t = ((t.indexOf("D") == -1 && t.indexOf("M") == -1) ? t.replaceAll("Y", "/0/0")
//                        : (t.indexOf("D") > -1 && t.indexOf("M") == -1) ? t.replaceAll("Y", "/0/").replace('D', ' ')
//                        : (t.indexOf("D") == -1 && t.indexOf("M") > -1) ? t.replace('Y', '/').replace('M', '/').concat("0")
//                        : t.replace('Y', '/').replace('M', '/').replace('D', ' ')).trim();
//                t = t.replaceAll("/", "-");
//                System.out.println(t);
                   t = t.replaceAll("-", "");
                   t = ((t.indexOf("D") == -1 && t.indexOf("M") == -1) ? t.replaceAll("Y", "-0-0")
                        : (t.indexOf("D") > -1 && t.indexOf("M") == -1) ? t.replaceAll("Y", "-0-").replace('D', ' ')
                        : (t.indexOf("D") == -1 && t.indexOf("M") > -1) ? t.replace('Y', '-').replace('M', '-').concat("0")
                        : t.replace('Y', '-').replace('M', '-').replace('D', ' ')).trim();
                    t = t.replaceAll("-", " ");
                    
/* 212 */         String[] ar = t.split(" ");
/* 213 */         List a = Arrays.asList(ar);
/* 214 */         Collections.reverse(a);
/* 215 */         t = "";
/* 216 */         for (int j = 0; j < a.size(); j++) {
/* 217 */           if (j == a.size() - 1) {
/* 218 */             t = t + a.get(j);
/*     */           } else {
/* 220 */             t = t + a.get(j) + " ";
/*     */           } 
/*     */         } 
///* 223 */         System.out.println(t);

//                String[] ar = t.split("-");
//                List ab = Arrays.asList(ar);
//                Collections.reverse(ab);
//                t = "";
//                for (int j = 0; j < ab.size(); j++) {
//                    if (j == ab.size() - 1) {
//                        t += ab.get(j);
//                    } else {
//                        t += ab.get(j) + " ";
//                    }
//                }
                stmt.executeUpdate("update student set AGE_ON_OCT='" + t + "' where S_ID = " + listS_ID.get(i));
                System.out.println("record no "+i+ " finished");
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private static void conv2() throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/amgad_sc", "root", "1234");
            stmt = con.createStatement();
            listS_ID = new ArrayList<String>();
            listAOO = new ArrayList<String>();
            listNewAOO = new ArrayList<String>();
            try {
                rs = stmt.executeQuery("SELECT C_ID,ClASS_DESC FROM classes ");
                while (rs.next()) {
                    listS_ID.add(rs.getString(1));
                    listAOO.add(rs.getString(2));
                }
                String t = "";
                for (int i = 0; i < listAOO.size(); i++) {
                    t = t = listAOO.get(i);
                    t = t.replaceAll("0", "٠").replaceAll("1", "١").replaceAll("2", "٢")
                            .replaceAll("3", "٣").replaceAll("4", "٤").replaceAll("5", "٥")
                            .replaceAll("6", "٦").replaceAll("7", "٧").replaceAll("8", "٨").replaceAll("9", "٩").trim();
                    
                    
                   System.out.println(listS_ID.get(i)+"   "+t);
                   stmt.executeUpdate("update classes set ClASS_DESC='" + t + "' where C_ID = " + listS_ID.get(i));
                }

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            con.close();
        }
    }
}
