package BaoCaoDoAn.Entity;

public class Meeting {
	public int id;
	public int schedulemeetingId;
	public String linkMeeting;
	public Meeting() {
		super();
	}
	public Meeting(int id, int schedulemeetingId, String linkMeeting) {
		super();
		this.id = id;
		this.schedulemeetingId = schedulemeetingId;
		this.linkMeeting = linkMeeting;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSchedulemeetingId() {
		return schedulemeetingId;
	}
	public void setSchedulemeetingId(int schedulemeetingId) {
		this.schedulemeetingId = schedulemeetingId;
	}
	public String getLinkMeeting() {
		return linkMeeting;
	}
	public void setLinkMeeting(String linkMeeting) {
		this.linkMeeting = linkMeeting;
	}
	
	
	 
}
