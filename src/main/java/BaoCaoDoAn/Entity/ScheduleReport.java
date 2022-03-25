package BaoCaoDoAn.Entity;

import java.sql.Date;


import javax.validation.constraints.NotNull;

import BaoCaoDoAn.validator.FutureBasedDateScheduleReport;


@FutureBasedDateScheduleReport(message = "Deadline must be greater than create time!")
public class ScheduleReport {
	private int id;
	private Date timeReport;
	private Date dateSubmit;
	@NotNull(message = "Account id can't be empty!")
	private int account_id;
	@NotNull(message = "Report id can't be empty!")
	private int report_id;
	private Group group;
	private Report report;
	
	
	public Date getDateSubmit() {
		return dateSubmit;
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

	public ScheduleReport(int id, Date timeReport, int account_id, int report_id) {
		super();
		this.id = id;
		this.timeReport = timeReport;
		this.account_id = account_id;
		this.report_id = report_id;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public ScheduleReport() {
		super();
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}
	

}
