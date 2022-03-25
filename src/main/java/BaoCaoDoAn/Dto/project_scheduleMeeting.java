package BaoCaoDoAn.Dto;

import java.sql.Date;

public class project_scheduleMeeting {
	
	private String  name_project ; 
	private int id_scheduleMeeting ; 
	private Date timeMeeting ; 
	private int project_id ; 
	private int account_id ;
	private String name_scheduleMeeting ; 
	private String link_meeting ; 
	private String  content_scheduleMeeting ;
	
	
	public project_scheduleMeeting() {
		super();
	}
	public project_scheduleMeeting(String name_project, int id_scheduleMeeting, Date timeMeeting, int project_id,
			int account_id, String name_scheduleMeeting, String link_meeting, String content_scheduleMeeting) {
		super();
		this.name_project = name_project;
		this.id_scheduleMeeting = id_scheduleMeeting;
		this.timeMeeting = timeMeeting;
		this.project_id = project_id;
		this.account_id = account_id;
		this.name_scheduleMeeting = name_scheduleMeeting;
		this.link_meeting = link_meeting;
		this.content_scheduleMeeting = content_scheduleMeeting;
	}
	public String getName_project() {
		return name_project;
	}
	public void setName_project(String name_project) {
		this.name_project = name_project;
	}
	public int getId_scheduleMeeting() {
		return id_scheduleMeeting;
	}
	public void setId_scheduleMeeting(int id_scheduleMeeting) {
		this.id_scheduleMeeting = id_scheduleMeeting;
	}
	public Date getTimeMeeting() {
		return timeMeeting;
	}
	public void setTimeMeeting(Date timeMeeting) {
		this.timeMeeting = timeMeeting;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public String getName_scheduleMeeting() {
		return name_scheduleMeeting;
	}
	public void setName_scheduleMeeting(String name_scheduleMeeting) {
		this.name_scheduleMeeting = name_scheduleMeeting;
	}
	public String getLink_meeting() {
		return link_meeting;
	}
	public void setLink_meeting(String link_meeting) {
		this.link_meeting = link_meeting;
	}
	public String getContent_scheduleMeeting() {
		return content_scheduleMeeting;
	}
	public void setContent_scheduleMeeting(String content_scheduleMeeting) {
		this.content_scheduleMeeting = content_scheduleMeeting;
	}
	
	
	
}
