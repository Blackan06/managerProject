package BaoCaoDoAn.Entity;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import BaoCaoDoAn.Service.User.Impl.GroupServiceImpl;

public class Project {
	private int id;
	
	
	@NotNull(message = "Name is empty")
	private String name;
	
//	@Pattern(regexp = "[a-zA-Z ]{1,100}", message = " Url name is empty")


	private Date createTime;
	private int group_id;
	private int teacherId;
	private List<ScheduleMeeting> scheduleMeeting;
	private List<Report> report;

	public List<Report> getReport() {
		return report;
	}

	public void setReport(List<Report> report) {
		this.report = report;
	}

	public List<ScheduleMeeting> getScheduleMeeting() {
		return scheduleMeeting;
	}

	public void setScheduleMeeting(List<ScheduleMeeting> scheduleMeeting) {
		this.scheduleMeeting = scheduleMeeting;
	}

	public Project() {
		super();
	}

	public Project(int id, String name, Date createTime, int group_id, int teacherId,
			List<ScheduleMeeting> scheduleMeeting) {
		super();
		this.id = id;
		this.name = name;
	
		this.createTime = createTime;
		this.group_id = group_id;
		this.teacherId = teacherId;
		this.scheduleMeeting = scheduleMeeting;
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


	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public Group getGroup() {
		GroupServiceImpl group = new GroupServiceImpl();
		return group.findGroupById(group_id);
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

}
