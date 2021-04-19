/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 * EDIT HISTORY
 * ORIGINAL FROM CPS278 class notes
 *
 * KPCOOK added closeConnection method
 */
package jdbc;

import java.net.URL;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyConnection {

    /*
     * connect to specified server, as user, with password
     */
    public static Connection getConnection(String srvr, String user, String pass) {

        Connection con = null;
        String urlStr = null;
        String func = "getConnection";

        /*
         if (args.length < 2 )   
         {   
         System.out.println("You need to enter:");   
         System.out.println("         arg[0] = Userid, arg[1] = password");   
         return con;   
         } 
         */
        try {
            //Load the Driver Class Now       
            Class.forName("com.mysql.jdbc.Driver").newInstance();

// https://stackoverflow.com/questions/34189756/warning-about-ssl-connection-when-connecting-to-mysql-database
            //urlStr =   "jdbc:mysql://localhost/" + args[0] +
            //      "?user="+args[0]+ "&password="+args[1];
            urlStr = "jdbc:mysql://" + srvr + "/" + user
                    + "?" + "verifyServerCertificate=false&useSSL=true"
                    + "&user=" + user + "&password=";

            System.out.println(func + ":Connecting to:" + urlStr + "xxx");
            con = DriverManager.getConnection(urlStr + pass);

        } catch (SQLException ex) {
            System.err.println(func + ":getConnection:SQLException(" + urlStr + "): " + ex);
        } catch (Exception ex) {
            System.err.println(func + ":getConnection:Exception(" + urlStr + "): " + ex);
        }

        return con;
    }

    /*
     * use a specific database 
     * create it if it does not exist
     */
    public static int useSQLdb(Connection con, String db) {
        Statement stmt = null;
        String func = "useSQLdb";
        int retv = 0;
        try {
            stmt = con.createStatement();
        } catch (SQLException ex) {
            System.err.println(func + ":createStatement:SQLException(" + db + "): " + ex);
            retv = -1;
        } catch (Exception ex) {
            System.err.println(func + ":createStatement:Exception(" + db + "): " + ex);
            retv = -2;
        }
        if (stmt == null) {
            return -3;
        }

        String sql = "CREATE DATABASE IF NOT EXISTS " + db;

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.err.println(func + ":executeUpdate:SQLException(" + db + "):(" + sql + "): " + ex);
            retv = -4;
        }
        /*catch (Exception ex) {
         System.err.println(func+":Exception(" + db + "): " + ex);
         retv = -2;
         }*/

        try {
        con.setCatalog(db);
        } catch (SQLException ex) {
            System.err.println(func + ":setCatalog:SQLException(" + db + "): " + ex);
            retv = -5;
        }

        return retv;
    }

    /*
     * close the specified connection
     */
    public static int closeConnection(Connection con) {
        int retv = 0;
        try {
            con.close();
        } catch (SQLException ex) {
            // Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("closeConnection:SQLException: " + ex);
            retv = -1;
        } catch (Exception ex) {
            System.err.println("closeConnection:Exception: " + ex);
            retv = -2;
        }

        return retv;
    }
}
