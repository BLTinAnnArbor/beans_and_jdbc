package sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CartBean;
import beans.MovieBean;
import beans.MovieListBean;
import beans.ShowingBean;
import beans.ShowingListBean;
import jdbc.ConnectionPool;

/**
 * Servlet implementation class MovieServlet
 */
@WebServlet("/MovieServlet")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext servletContext = getServletContext();
		ConnectionPool connectionPool = (ConnectionPool) servletContext.getAttribute("connectionPool");
		
		
		MovieListBean movieListBean = new MovieListBean();
		ShowingBean showingBean = new ShowingBean();
		ShowingListBean sblist = new ShowingListBean();
		
		Connection conn = null;
		try {
			conn = connectionPool.getConnection();
			
			List<MovieBean> ml =movieListBean.loadMovies(conn);
			List<ShowingBean> sl;
			
			Date localDate = new Date(121,1,15);

			
			
			sl = movieListBean.loadFromDBAfterTime(conn, localDate);
			
//			for(int i=0; i<ml.size(); i++) {
//				System.out.println(ml.get(i).toString());
//			}
			for(int i=0; i<ml.size(); i++) {
				if (showingBean.getMovie() == ml.get(i)) {
					
				}
			}
//			request.setAttribute("movieList", movieListBean);
			request.setAttribute("showings", sl);
			request.setAttribute("ml",ml);
//			request.setAttribute("message", "this is my message. u have received it.");
			request.setAttribute("msg", "this is my message. u have received it.");
			
//			HttpSession session = request.getSession(false);
//			if (session == null) {
//				CartBean cartBean = new CartBean();
//				
//			    // Not created yet. Now do so yourself.
//			    session = request.getSession();
//			    session.setAttribute("cart", cartBean);
//			} else {
//			    // Already created.
//			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		} finally {
			if(conn != null) {
				connectionPool.free(conn);
			}
		}
		
		
		RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/moviePage.jsp");
		dispatcher.forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
