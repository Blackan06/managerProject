package BaoCaoDoAn.Dto;


import java.sql.Date;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import BaoCaoDoAn.validator.FutureBasedDateScheduleReport;


@FutureBasedDateScheduleReport(message = "Deadline must be greater than create time!")
public class scheduleReport_report {
	private int id;
	private Date timeReport;
	private Date dateSubmit;
	@NotNull(message = "Account id can't be empty!")
	private int account_id;
	@NotNull(message = "Report id can't be empty!")
	private int report_id;

	@NotNull
	@Length(min = 5, max = 20, message = "Length of report name must be between 5 and 20")


	@Pattern(regexp = "[a-zA-Z0-9 ]{1,100}" , message = " Report name is empty")

	private String name;

	@Pattern(regexp = "[a-zA-Z0-9 ]{1,100}", message = " Project name is empty")
	private String project_name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateSubmit() {
		return dateSubmit;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public void setDateSubmit(Date dateSubmit) {
		this.dateSubmit = dateSubmit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getTimeReport() {
		return timeReport;
	}

	public void setTimeReport(Date timeReport) {
		this.timeReport = timeReport;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public int getReport_id() {
		return report_id;
	}

	public void setReport_id(int report_id) {
		this.report_id = report_id;
	}



}
