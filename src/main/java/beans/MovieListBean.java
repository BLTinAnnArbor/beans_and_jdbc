package beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class MovieListBean implements Serializable {
	private List<MovieBean> movies;
	
	public List<MovieBean> getMovies() {
		return movies;
	}
	public void setMovies(List<MovieBean> movies) {
		this.movies = movies;
	}
	public MovieBean getMovieAt(Integer i){
		return movies.get(i);
	}
	
	public List<ShowingBean> loadFromDBAfterTime(Connection conn, Date date) throws SQLException {
//		PreparedStatement moviesStmt = conn.prepareStatement("SELECT movie.title, movie.id, movie.image_link, movie.rated FROM movie JOIN showing ON movie.id = showing.movie_id;");
		PreparedStatement moviesStmt = conn.prepareStatement("SELECT movie.title, movie.id, movie.image_link, movie.rated FROM movie;");
		PreparedStatement showingsStmt = conn.prepareStatement("SELECT time, showing.id, showing.movie_id FROM showing WHERE movie_id = ? ORDER BY time");
				
//		moviesStmt.setDate(1, date);
//		moviesStmt.setTime(2, time);
		ResultSet results = moviesStmt.executeQuery();
		List<MovieBean> list = new ArrayList<>();
		List<ShowingBean> sblist = new ArrayList<>();
		
		while(results.next()) {
			MovieBean bean = new MovieBean();
			bean.setTitle(results.getString("movie.title"));
			bean.setImageLink(results.getString("movie.image_link"));
			bean.setId(results.getInt("movie.id"));
//			bean.setRating(MovieBean.Rating.fromIndex(results.getInt("")));

			List<Time> showingTimes = new ArrayList<>();
//			List<ShowingBean> showings = new ArrayList<>();
			list.add(bean);
		}
		for(int i=0; i < list.size(); i++) {
			showingsStmt.setInt(1, list.get(i).getId());
			ResultSet showingResults = showingsStmt.executeQuery();
			while(showingResults.next()) {
				ShowingBean sb = new ShowingBean();
				sb.setTime(showingResults.getTime("time"));
				sb.setShowingId(showingResults.getInt("showing.id"));
				sb.setMovieId(showingResults.getInt("showing.movie_id"));
				sblist.add(sb);
//				showingTimes.add(showingResults.getTime("time"));
//				showings.add(showingResults.getInt("showing.id"));
				System.out.println(sb.toString());
			}
		}
		
		System.out.println("list size: "+list.size());
		System.out.println("sblist.toString(): "+ sblist.toString());
		return sblist;
	}
	public List<MovieBean> loadMovies(Connection conn) throws SQLException{
		PreparedStatement selectStmt = conn.prepareStatement("Select movie.title, movie.image_link, movie.id, movie.rated from movie");
		PreparedStatement showingsStmt = conn.prepareStatement("SELECT time FROM showing WHERE movie_id = ? ORDER BY time");
		ResultSet results = selectStmt.executeQuery();
		
		List<MovieBean> list = new ArrayList<>();
		while(results.next()) {
			MovieBean bean = new MovieBean();
			bean.setTitle(results.getString("movie.title"));
			bean.setImageLink(results.getString("movie.image_link"));
			bean.setId(results.getInt("movie.id"));
//			bean.setRating(MovieBean.Rating.fromIndex(results.getInt("")));
//			showingsStmt.setInt(1, results.getInt("movie.id"));
//			ResultSet showingResults = showingsStmt.executeQuery();
//			List<Time> showingTimes = new ArrayList<>();
//			while(showingResults.next()) {
//				showingTimes.add(showingResults.getTime("time"));
//			}
			list.add(bean);
			System.out.println(bean.toString());
		}
		
		setMovies(list);
		return getMovies();
	}
}
