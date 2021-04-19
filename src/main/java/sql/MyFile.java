/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * MyFile -- work with files related to the project
 *
 * @author kcook
 */
public class MyFile {

    String fpath;
    File ifp;
    Scanner ifscan;

    public MyFile(String fn) {
        this.fpath = fn;
    }

    // create a file 'rabbit' 
    // see where our current directory is
    public void makefile() {
        File fp = new File(fpath);
        // String eol = System.getProperty("line.separator");

        FileWriter fw;
        try {
            fw = new FileWriter(fp, true);
        } catch (IOException ex) {
            System.out.println("makefile(" + fpath + "):IOException:" + ex);
            return;
        }

        PrintWriter out = new PrintWriter(fw);
        out.println("Hello World!");
        out.close();
    }

    /*
    * setup scanner to read lines from a file
    */
    public int open() {
        int retv = 0 ;

        this.ifp = new File(fpath);

        try {
            this.ifscan = new Scanner(ifp);
        } catch (FileNotFoundException ex) {
            System.out.println("makefile(" + fpath + "):FileNotFoundException:" + ex);
            return -1;
        }

        return retv;
    }
    
    Boolean hasNextLline() {
        return this.ifscan.hasNextLine() ;
    }

    String nextLine() {
        return this.ifscan.nextLine() ;
    }
    
    public void close() {
        this.ifscan.close();
    }

}
