package BaoCaoDoAn.Entity;

import java.sql.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class PointDetail {
	private int id;
	private int reportId;
	private int studentId;
	private int teacherId;
	private Date dateGrade;
	@NotNull(message = "Not character, just number")
	@Max(value = 10, message = "must be less than or equal 10")
	@Min(value = 0, message = "must be equal or greater than 0")
	private Double point;

	public PointDetail(int id, int reportId, int studentId, int teacherId, Date dateGrade, Double point) {
		super();
		this.id = id;
		this.reportId = reportId;
		this.studentId = studentId;
		this.teacherId = teacherId;
		this.dateGrade = dateGrade;
		this.point = point;
	}

	public PointDetail() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public Date getDateGrade() {
		return dateGrade;
	}

	public void setDateGrade(Date dateGrade) {
		this.dateGrade = dateGrade;
	}

	public Double getPoint() {
		return point;
	}

	public void setPoint(Double point) {
		this.point = point;
	}

}
