/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author kcook
 */
public class TB_DBAdmin {

    static String errMsg = "";
    String dbgMsg = "";
    static String stsMsg = "";

    public String getErrMsg() {
        return errMsg;
    }

    public String getDbgMsg() {
        return dbgMsg;
    }

    public String getStsMsg() {
        return stsMsg;
    }

    private static String doDescribeConsole(Statement stmt, HttpServletRequest req) {
        String func = "TB_DBAdmin:doDescribe";

        try {
            String sql = "DESCRIBE people;";

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

        return ("");
    }

    private static String doDescribe(Statement stmt, HttpServletRequest req, String sqltbl ) {
        String func = "TB_DBAdmin:doDescribe";

        final ArrayList<SqlField> fldLst = new ArrayList<>();

        ResultSet rs;
        ResultSetMetaData rsmd;
        int ncol;

        // validate sqltable
        if( ! ( sqltbl.equals("customer")
                || sqltbl.equals("movie")
                || sqltbl.equals("screen")
                || sqltbl.equals("seat")
                || sqltbl.equals("showing")
                || sqltbl.equals("ticket")
                || sqltbl.equals("ticket_seat")
                        )
                )
            sqltbl = "customer";
        
        // String sql = "DESCRIBE customer;";
        String sql = "DESCRIBE " + sqltbl + ";";

        try {

            System.out.println(sql);

            rs = stmt.executeQuery(sql);
            rsmd = rs.getMetaData();
            
            System.out.println("DESCRIBE executed");

            ncol = rsmd.getColumnCount();

            while (rs.next()) {
                String nm = rs.getString(1);
                String ty = rs.getString(2);
                String nu = rs.getString(3);
                String ky = rs.getString(4);
                String df = rs.getString(5);
                if( df == null ) {
                    df = "null";
                }
                String ex = rs.getString(6);

                SqlField sf = new SqlField( nm, ty, nu, ky, df, ex );
                fldLst.add(sf);

            }
            System.out.println("DESCRIBE had "+ fldLst.size()+" flds");
            
            
            req.setAttribute("FldLst", fldLst );

        } catch (SQLException ex) {
            System.err.println(func + ":SQLException: " + ex);
            return (sql + ":" + ex.toString());
        }

        // show count for current table
        doCount( stmt, req, sqltbl );
        
        // stmt.close();
        // return ("DESCRIBE TABLE customer ;");
        return ("DESCRIBE TABLE " + sqltbl +" ;");
    }

    private static String doCreate(Statement stmt, HttpServletRequest req) {
        String func = "TB_DBAdmin:doCreate";

        int ncol;
        int rows;

        String sql = "CREATE TABLE people ( "
                + "id int Primary Key Auto_Increment,"
                + "name text," 
                + "eye_color text," 
                + "hair_color text," 
                + "height text," 
                + "weight text," 
                + "email  text," 
                + "dob text )";

        try {

            System.out.println(sql);

            rows = stmt.executeUpdate(sql);
            
            System.out.println("CREATE executed");

        } catch (SQLException ex) {
            System.err.println(func + ":SQLException: " + ex);
            return (sql + ":" + ex.toString());
        }

        // stmt.close();
        return ("TABLE people CREATED");
    }

    private static String doDrop(Statement stmt, HttpServletRequest req) {
        String func = "TB_DBAdmin:doDrop";

        int ncol;
        int rows;

        String sql = "DROP TABLE people;";
                
        try {

            System.out.println(sql);

            rows = stmt.executeUpdate(sql);
            
            System.out.println("DROP executed");

        } catch (SQLException ex) {
            System.err.println(func + ":SQLException: " + ex);
            return (sql + ":" + ex.toString());
        }

        // stmt.close();
        return ("TABLE people DROPPED");
    }

    private static String doStatus(Statement stmt, HttpServletRequest req) {
        String func = "TB_DBAdmin:doStatus";

        ResultSet rs;
        ResultSetMetaData rsmd;
        int ncol;
        String strRows = "0" ;

        req.setAttribute("stsMsg", "" );
        
        String sql = "SELECT COUNT(*) AS COUNT FROM customer;";
                
        try {

            System.out.println(sql);

            rs = stmt.executeQuery(sql);
            rsmd = rs.getMetaData();
            
            System.out.println("SELECT COUNT executed");

            // column 1 should have number of rows in the table
            if( rs.next() )
                strRows = rs.getString(1);
            
        } catch (SQLException ex) {
            System.err.println(func + ":SQLException: " + ex);
            // return (sql + ":" + ex.toString());
            return ("TABLE customer does not exist");
        }

        // stmt.close();
        req.setAttribute("stsMsg", "TABLE customer has " + strRows + " records" );
        
        return ("");
    }

    private static String doCount(Statement stmt, HttpServletRequest req, String sqltbl) {
        String func = "TB_DBAdmin:doCount";

        ResultSet rs;
        ResultSetMetaData rsmd;
        int ncol;
        String strRows = "0" ;

        req.setAttribute("stsMsg", "" );
        
        String sql = "SELECT COUNT(*) AS COUNT FROM " + sqltbl + ";";
                
        try {

            System.out.println(sql);

            rs = stmt.executeQuery(sql);
            rsmd = rs.getMetaData();
            
            System.out.println("SELECT COUNT executed");

            // column 1 should have number of rows in the table
            if( rs.next() )
                strRows = rs.getString(1);
            
        } catch (SQLException ex) {
            System.err.println(func + ":SQLException: " + ex);
            // return (sql + ":" + ex.toString());
            return ("TABLE "+sqltbl+" does not exist");
        }

        // stmt.close();
        req.setAttribute("stsMsg", "TABLE "+sqltbl+" has " + strRows + " records" );
        
        return ("");
    }

    public static String update(Statement stmt, HttpServletRequest req) {
        //HttpSession session = pgCtx.getSession();
        // String errMesg = "";
        int idx;
        String strIdx;
        String sqltbl;

        errMsg = "No errors";

        /*
         * connection status, server status, table status, table count, structure
         * actions: 
         * see structure
         * see count
         * drop and recreate table
         *
         */
        // see why this was called
        String act = req.getParameter("action");

        System.out.println("TB_DBAdmin:action:" + act);

        req.setAttribute("PersonTableStatus", "present action:" + act);

        // anything clicked?
        if (act != null) {

            // something was clicked
            // get parameters
            String confirm = req.getParameter("confirm");

            
            switch (act) {
                case "DROP TABLE":
                    if (confirm.equals("YES")) {
                        errMsg = doDrop(stmt, req);
                    } else {
                        errMsg = "DROP TABLE people; confirm:" + confirm + ", No action taken";
                    }
                    break;

                case "CREATE TABLE":
                    if (confirm.equals("YES")) {
                        errMsg = doCreate(stmt, req);
                    } else {
                    errMsg = "CREATE TABLE people(); confirm:" + confirm + ", No action taken";
                   
                    }
                    break;

                case "DESCRIBE TABLE":
                    sqltbl = req.getParameter("sqltable");
                    errMsg = doDescribe(stmt, req, sqltbl );
                    break;

            case "SHOW TABLE":
                    sqltbl = req.getParameter("sqltable");
                    // errMsg = doShowTbl(stmt, req, sqltbl );
                    errMsg = "";
                    break;

            
                default:
                    System.out.println("No action taken");
                    break;
            }

        }

        String terrMsg = ""; // doStatus( stmt, req );
        if( ! terrMsg.isEmpty() )
            errMsg = terrMsg ;
        
        return (errMsg);
    }
}
