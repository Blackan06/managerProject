package BaoCaoDoAn.Entity;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import BaoCaoDoAn.Service.User.Impl.GroupServiceImpl;

public class Project {
	private int id;

	@Pattern(regexp = "[a-zA-Z0-9 ]{1,100}", message = " Project name is empty")
	private String name;
	
	@NotNull(message = " Url name is empty")
//	@Pattern(regexp = "[a-zA-Z ]{1,100}", message = " Url name is empty")
	private String urlProject;

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

	public Project(int id, String name, String urlProject, Date createTime, int group_id, int teacherId,
			List<ScheduleMeeting> scheduleMeeting) {
		super();
		this.id = id;
		this.name = name;
		this.urlProject = urlProject;
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

	public String getUrlProject() {
		return urlProject;
	}

	public void setUrlProject(String urlProject) {
		this.urlProject = urlProject;
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
