package beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShowingBean implements Serializable {
	private static final DateFormat TIME_FORMAT = DateFormat.getTimeInstance(DateFormat.SHORT);
	private static final DateFormat DATE_FORMAT = DateFormat.getDateInstance();
	
	private Date time;
	private Date date;
	private List<SeatBean> seats = new ArrayList<>();
	private MovieBean movie;
	private int movieId;
	private String screenName;
	private int screenRows, screenCols;
	private int showingId;
	
	
	
	public void setTime(Date time) {
		this.time = time;
	}
	public Date getTime() {
		return time;
	}
	public String getTimeString() {
		return TIME_FORMAT.format(time);
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDateString() {
		return DATE_FORMAT.format(date);
	}
	
	public List<SeatBean> getSeats() {
		return seats;
	}
	public void setSeats(List<SeatBean> seats) {
		this.seats = seats;
	}
	
	public MovieBean getMovie() {
		return movie;
	}
	public void setMovie(MovieBean movie) {
		this.movie = movie;
	}
	
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	
	public int getScreenRows() {
		return screenRows;
	}
	public void setScreenRows(int screenRows) {
		this.screenRows = screenRows;
	}
	
	public int getScreenCols() {
		return screenCols;
	}
	public void setScreenCols(int screenCols) {
		this.screenCols = screenCols;
	}
	public int getShowingId() {
		return showingId;
	}
	public void setShowingId(int showingId) {
		this.showingId = showingId;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String toString() {
		return "showingId: "+showingId + " time: "+ time +" movieId: "+movieId;
	}
	
	public boolean loadOneFromDatabase(Connection conn, int id) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT showing.id, showing.date, showing.time, movie.title, movie.rated, movie.release_date, movie.image_link, screen.name, screen.max_rows, screen.max_cols FROM showing JOIN movie ON showing.movie_id = movie.id JOIN screen ON showing.screen_id = screen.id WHERE showing.id = ?");
		stmt.setInt(1, id);
		ResultSet results = stmt.executeQuery();
		
		if(results.next()) {
			date = results.getDate("showing.date");
			if(date == null) {
				date = getCurrentDay();
			}
			time = results.getTime("showing.time");
			showingId=results.getInt("showing.id");
			
			screenRows=results.getInt("screen.max_rows");
			screenCols=results.getInt("screen.max_cols");
			
			MovieBean movieBean = new MovieBean();
			movieBean.setTitle(results.getString("movie.title"));
			movieBean.setRating(MovieBean.Rating.fromIndex(results.getInt("movie.rated") - 1));
			movieBean.setReleaseDate(results.getDate("movie.release_date"));
			movieBean.setImageLink(results.getString("movie.image_link"));
			movie = movieBean;
			screenName = results.getString("screen.name");
			screenRows = results.getInt("screen.max_rows");
			screenCols = results.getInt("screen.max_cols");
			return true;
		} else {
			return false;
		}
	}
	public boolean loadAllFromDatabase(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT showing.id, showing.date, showing.time, movie.title, movie.rated, movie.release_date, movie.image_link, screen.name, screen.max_rows, screen.max_cols FROM showing JOIN movie ON showing.movie_id = movie.id JOIN screen ON showing.screen_id = screen.id");
		ResultSet results = stmt.executeQuery();
		
		if(results.next()) {
			date = results.getDate("showing.date");
			if(date == null) {
				date = getCurrentDay();
			}
			time = results.getTime("showing.time");
			MovieBean movieBean = new MovieBean();
			movieBean.setTitle(results.getString("movie.title"));
			movieBean.setRating(MovieBean.Rating.fromIndex(results.getInt("movie.rated") - 1));
			movieBean.setReleaseDate(results.getDate("movie.release_date"));
			movieBean.setImageLink(results.getString("movie.image_link"));
			movie = movieBean;
			screenName = results.getString("screen.name");
			screenRows = results.getInt("screen.max_rows");
			screenCols = results.getInt("screen.max_cols");
			return true;
		} else {
			return false;
		}
	}
	
	private static Date getCurrentDay() {
		return Date.from(LocalDate.now().atTime(0, 0, 0, 0).atZone(ZoneId.systemDefault()).toInstant());
	}
}
