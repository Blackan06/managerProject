package BaoCaoDoAn.Entity;

public class MeetingRecord {
	public int id;
	public int meetingId;
	public String content;
	public MeetingRecord(int id, int meetingId, String content) {
		super();
		this.id = id;
		this.meetingId = meetingId;
		this.content = content;
	}
	public MeetingRecord() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMeetingId() {
		return meetingId;
	}
	public void setMeetingId(int meetingId) {
		this.meetingId = meetingId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
