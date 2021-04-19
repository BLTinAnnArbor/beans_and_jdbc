package beans;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class MovieBean implements Serializable {
	private String title;
	private Rating rating;
	private String imageLink;
	private Date release;
	private List<Time> showingTimes;
	private List<Integer> showingIds;
	private int id;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public Date getReleaseDate() {
		return release;
	}
	public void setReleaseDate(Date release) {
		this.release = release;
	}

	public List<Time> getShowingTimes() {
		return showingTimes;
	}
	public void setShowingTimes(List<Time> showingTimes) {
		this.showingTimes = showingTimes;
	}
	public List<Integer> getShowingIds() {
		return showingIds;
	}
	public void setShowinIds(List<Integer> showingIds) {
		this.showingIds = showingIds;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

	public enum Rating implements Serializable {
		G("G"),
		PG("PG"),
		PG13("PG-13"),
		R("R"),
		NC17("NC-17"),
		X("X");
		
		private static final Rating[] VALUES = values(); 
		
		private final String displayName;
		
		private Rating(String displayName) {
			this.displayName = displayName;
		}

		public String getDisplayName() {
			return displayName;
		}
		
		public static Rating fromIndex(int idx) {
			return values()[idx];
		}
	}
	public String toString() {
		String str = getTitle()+" "+ getImageLink();
		return str;
	}
}
