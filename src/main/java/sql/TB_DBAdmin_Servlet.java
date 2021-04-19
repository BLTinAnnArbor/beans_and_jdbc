/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdbc.ConnectionPool;


/**
 *
 * @author kcook
 */
public class TB_DBAdmin_Servlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        System.out.println("TB_DBAdmin_Servlet");
        
        ServletContext servletContext = getServletContext();
        ConnectionPool connectionPool = (ConnectionPool) servletContext.getAttribute("connectionPool");

        Connection connection ;
        Statement statement ;
        String errMsg = "";
        try {
            connection = connectionPool.getConnection();
            statement = connection.createStatement();

            String db = "cps298at";
            if (statement != null ) {
                try {
                    connection.setCatalog(db);
                } catch (SQLException ex) {
                    System.err.println(":setCatalog:SQLException(" + db + "): " + ex);
                    // retv = -5;
                }

                errMsg = TB_DBAdmin.update(statement, request);
                statement.close();      
            }
            
            if (connection != null) {
                connectionPool.free(connection);
            }
        } catch (SQLException ex) {
            errMsg = ex.toString();
        }

        System.out.println("TB_DBAdmin_Servlet:errMsg:("+errMsg+")");
        request.setAttribute("errMsg", errMsg);

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher("/TB_DBAdmin.jsp");

        dispatcher.forward(request, response);
        
        /*
        =========================
                
        ArrayList<Person> pCollection ;
        HttpSession session = request.getSession();
        pCollection = (ArrayList<Person>) session.getAttribute("PCollection");
        if (pCollection == null) 
        {
            System.out.println("pCollection is null");
            pCollection = new ArrayList<>();
            session.setAttribute("PCollection", pCollection);
        } else {
            System.out.println("pCollection is not null");
        }
        String errorMessage = PersonCollection.update(pCollection, request);
        request.setAttribute("errMsg",errorMessage);
             
        RequestDispatcher dispatcher =
             getServletContext().getRequestDispatcher("/PersonCollection.jsp");
        dispatcher.forward(request, response);  
                
        */        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}

