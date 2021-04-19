/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jdbc;

/**
 *
 * @author kcook
 */
import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class GlobalConnectionPool implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized:enter");
        ServletContext servletContext = sce.getServletContext();
        ConnectionPool connectionPool = new ConnectionPool();

        String dbserver = servletContext.getInitParameter("db_server");
        String userid = servletContext.getInitParameter("db_userid");
        String password = servletContext.getInitParameter("db_password");

        // The following code be configurables in web.xml, but for simplicity I have them hard-coded
        int initialConnections = 3;
        int maxConnections = 20;
        boolean waitIfBusy = true;

        // Initialize the Connection Pool
        try {
            connectionPool.CreateConnectionPool(dbserver, userid, password,
                    initialConnections, maxConnections, waitIfBusy);
            servletContext.setAttribute("connectionPool", connectionPool);
            System.out.println("GlobalConnectionPool has setup the connection pool");
        } catch (SQLException e) {
            System.out.println("init SQLException caught: " + e);
        }
        
        System.out.println("contextInitialized:exit");
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        System.out.println("contextDestroyed:enter");
        
        ServletContext servletContext = sce.getServletContext();
        ConnectionPool connectionPool = (ConnectionPool) servletContext.getAttribute("connectionPool");
        if (connectionPool != null) {
            connectionPool.closeAllConnections();
            System.out.println("GlobalConnectionPool closed out the connection pool");
        }
    }
}
