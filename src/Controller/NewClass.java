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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public static void main(String args[]) {
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
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/amgad_sc", "root", "123456");
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
        try {
            rs = stmt.executeQuery("SELECT S_ID,AGE_ON_OCT FROM student ");
            while (rs.next()) {
                listS_ID.add(rs.getString(1));
                listAOO.add(rs.getString(2));
            }
            String t = "";
            for (int i = 0; i < listAOO.size(); i++) {
                t = t = listAOO.get(i);
                t = ((t.indexOf("D") == -1 && t.indexOf("M") == -1) ? t.replaceAll("Y", "/0/0")
                        : (t.indexOf("D") > -1 && t.indexOf("M") == -1) ? t.replaceAll("Y", "/0/").replace('D', ' ')
                        : (t.indexOf("D") == -1 && t.indexOf("M") > -1) ? t.replace('Y', '/').replace('M', '/').concat("0")
                        : t.replace('Y', '/').replace('M', '/').replace('D', ' ')).trim();
                t = t.replaceAll("/", "-");
                System.out.println(t);
                String[] ar = t.split("-");
                List a = Arrays.asList(ar);
                Collections.reverse(a);
                t = "";
                for (int j = 0; j < a.size(); j++) {
                    if (j == a.size() - 1) {
                        t += a.get(j);
                    } else {
                        t += a.get(j) + " ";
                    }
                }
                stmt.executeUpdate("update student set AGE_ON_OCT='" + t + "' where S_ID = " + listS_ID.get(i));
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
