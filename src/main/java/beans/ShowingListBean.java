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

public class ShowingListBean implements Serializable {
	
	private List<ShowingBean> showings = new ArrayList<>();
	
	public List<ShowingBean> getShowings(){
		return showings;
	}
	public void setShowings(List<ShowingBean> showingList) {
		this.showings = showingList;
	}
	public void addShowing(ShowingBean showing) {
		showings.add(showing);
	}
	public String toString() {
		String str="";
		if(showings.size()> 0 ) {
			for(int i=0; i<showings.size(); i++) {
				str += (" showingId: " + showings.get(i).getShowingId() + " ");  
			}
		}
		else {str = "no results found";}
		
		return str;
	}
}
