package BaoCaoDoAn.Dto;

import java.sql.Date;

public class group_Account_Project {
	private int id;
	private String project_name;
	private String urlProject;
	private Date createTime;
	private int group_id;
	private int teacherId;
	private String group_name;
	private String account_name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
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
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	
	public group_Account_Project(int id, String project_name, String urlProject, Date createTime, int group_id,
			int teacherId, String group_name, String account_name) {
		super();
		this.id = id;
		this.project_name = project_name;
		this.urlProject = urlProject;
		this.createTime = createTime;
		this.group_id = group_id;
		this.teacherId = teacherId;
		this.group_name = group_name;
		this.account_name = account_name;
	}
	public group_Account_Project() {
		super();
	}
	
	
}