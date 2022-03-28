package BaoCaoDoAn.Dto;

import java.sql.Date;

public class Report_Project_Group {
	private int report_id ;
	private String report_name ;
	private Double report_point ;
	private String report_comment ;
	private Date report_timeCreate ; 
	private String project_name ;
	private String group_name ;
	
	
	
	public Report_Project_Group() {
		super();
	}
	public Report_Project_Group(int report_id, String report_name, Double report_point, String report_comment,
			Date report_timeCreate, String project_name, String group_name) {
		super();
		this.report_id = report_id;
		this.report_name = report_name;
		this.report_point = report_point;
		this.report_comment = report_comment;
		this.report_timeCreate = report_timeCreate;
		this.project_name = project_name;
		this.group_name = group_name;
	}
	public int getReport_id() {
		return report_id;
	}
	public void setReport_id(int report_id) {
		this.report_id = report_id;
	}
	public String getReport_name() {
		return report_name;
	}
	public void setReport_name(String report_name) {
		this.report_name = report_name;
	}
	public Double getReport_point() {
		return report_point;
	}
	public void setReport_point(Double report_point) {
		this.report_point = report_point;
	}
	public String getReport_comment() {
		return report_comment;
	}
	public void setReport_comment(String report_comment) {
		this.report_comment = report_comment;
	}
	public Date getReport_timeCreate() {
		return report_timeCreate;
	}
	public void setReport_timeCreate(Date report_timeCreate) {
		this.report_timeCreate = report_timeCreate;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	} 
	
	
}
