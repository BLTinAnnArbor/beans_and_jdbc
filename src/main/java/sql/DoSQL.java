/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author kcook
 */
public class DoSQL {
    public static void doSQLupd(Connection sqlCon, String sql) {
        
        String func = "doSQLupd";
        Statement stmt = null;
        
        try {
            stmt = sqlCon.createStatement();
            
            System.out.println(sql);
            
            int rows = stmt.executeUpdate(sql);
            
        } catch (SQLException ex) {
            System.err.println(func + ":SQLException: " + ex);
            
        }
    }
    
    public static void doSQLquery(Connection sqlCon, String sql) {
        
        String func = "doSQLquery";
        Statement stmt = null;
        
        try {
            stmt = sqlCon.createStatement();
            
            System.out.println(sql);
            
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();

            // build array of column widths
            // to help pretty print the results
            int ncol = rsmd.getColumnCount();
            int[] colwid = new int[ncol + 1];
            
            for (int i = 1; i <= ncol; i++) {
                colwid[i] = rsmd.getColumnName(i).length();
            }

            // build a separator line
            String sep = "+-";
            String line = "--------------------------------------------------------";
            for (int i = 1; i <= ncol; i++) {
                sep += line.substring(0, colwid[i]);
                sep += "-+-";
            }
            
            System.out.println(sep);
            System.out.print("| ");
            for (int i = 1; i <= ncol; i++) {
                String s = rsmd.getColumnName(i);
                // colwid[i] = s.length();
                System.out.printf("%-" + colwid[i] + "s", s);
                System.out.print(" | ");
            }
            System.out.println();
            
            System.out.println(sep);
            
            while (rs.next()) {
                System.out.print("| ");
                for (int i = 1; i <= ncol; i++) {
                    System.out.printf("%-" + colwid[i] + "s", rs.getString(i));
                    System.out.print(" | ");
                }
                System.out.println();
                
            }
            System.out.println(sep);
            
            stmt.close();
            
        } catch (SQLException ex) {
            System.err.println(func + ":SQLException: " + ex);
            
        }
    }
    
    public static void wt4key() {
        System.out.print("Press Enter to continue");
        Scanner wt = new Scanner(System.in);
        wt.nextLine();
    }
    
    
}
