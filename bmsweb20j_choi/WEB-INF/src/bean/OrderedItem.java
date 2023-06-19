package bean;

import java.util.Date;

public class OrderedItem {

	private String userid;
	private String title;
	private String date;

	public OrderedItem() {

		this.userid = null;
		this.date = null;
		this.title = null;

	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public OrderedItem(String userid, String title, String date) {
		super();
		this.userid = userid;
		this.title = title;
		this.date = date;
	}

}
