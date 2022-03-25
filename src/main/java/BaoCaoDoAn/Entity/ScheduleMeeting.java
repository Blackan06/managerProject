package BaoCaoDoAn.Entity;

import java.sql.Date;
import java.time.LocalTime;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import BaoCaoDoAn.validator.FutureBasedDateSchedule;

@FutureBasedDateSchedule(message = "Deadline must be greater than create time!")
public class ScheduleMeeting {
	private int id;

	@Pattern(regexp = "[a-zA-Z0-9 ]{1,100}", message = "Name is empty")
	private String name;
	private Date timeMeeting;
	private int project_id;
	private int account_id;

	/* @Pattern(regexp = "[a-zA-Z ]{1,1000}" , message = "Link is empty") */
	@NotEmpty(message = "link is empty")
	private String link_meeting;

	private String content;
	private String time;
	private Date submitDate;
	private String submitTime;
	private String messageForSubmitting;
	private int up;

	public String getMessageForSubmitting() {
		java.util.Date date = new java.util.Date();
		Date dateSQL = new Date(date.getTime());
		if (getSubmitDate() != null) {
			messageForSubmitting = "You submitted a file";
			int compareResult = dateSQL.compareTo(getSubmitDate());
			if (compareResult > 0) {
				messageForSubmitting = "Out of date, cannot upload";
			}
		}
		return messageForSubmitting;
	}

	public void setMessageForSubmitting(String messageForSubmitting) {
		this.messageForSubmitting = messageForSubmitting;
	}

	public String getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}

	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
		System.out.println(time);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getLink_meeting() {
		return link_meeting;
	}

	public void setLink_meeting(String link_meeting) {
		this.link_meeting = link_meeting;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ScheduleMeeting() {
		super();
	}

	public int getUp() {
		if (Optional.ofNullable(getContent()).orElse("").isEmpty()) {
			return 0;
		} else {
			return 1;
		}
	}

	public void setUp(int up) {
		up = up;
	}

}