package beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketBean implements Serializable {
	private int ticketId;
	private int customer_id;
	private int showing_id;
	public int getId() {
		return this.ticketId;
	}
	public void setId(int id) {
		this.ticketId=id;
	}
	public int getCustomerId() {
		return this.customer_id;
	}
	public void setCustomerId(int customerId) {
		this.customer_id= customerId;
	}
}
