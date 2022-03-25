package BaoCaoDoAn.Dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Entity.MapperReport;
import BaoCaoDoAn.Entity.PointDetail;
import BaoCaoDoAn.Entity.PointDetailMapper;
import BaoCaoDoAn.Entity.Report;

@Repository
public class ReportDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public Report getReport(int id) {
		Report result = null;
		List<Report> list = new ArrayList<Report>();
		String sql = "Select * from report where id =" + id;
		list = jdbcTemplate.query(sql, new MapperReport());
		if (!list.isEmpty()) {
			result = list.get(0);
		}
		return result;

	}

	public List<Report> getReportId() {
		List<Report> list = new ArrayList<Report>();
		String sql = "Select * from report ";
		list = jdbcTemplate.query(sql, new MapperReport());
		return list;

	}

	
	public List<Report> getAllReport() {
		List<Report> list = new ArrayList<Report>();
		String sql = "Select * from report  ORDER BY project_id;";
		list = jdbcTemplate.query(sql, new MapperReport());
		return list;

	}

	public int addReport(Report report) {
		StringBuffer sql = new StringBuffer();
		System.out.println("REPORT DATE:" + report.getTimeCreate());
		sql.append("INSERT INTO report (name, timeCreate,timeSubmit,urlReport,project_id,status) "
				+ "VALUES (?,?,?,?,?,?);");

		int insert = jdbcTemplate.update(sql.toString(), new Object[] { report.getName(), report.getTimeCreate(),
				report.getTimeSubmit(), "", report.getProject_id(), 0 });
		return insert;
	}

	public int DeleteReport(int id) {
		String sql = "DELETE FROM report WHERE id = " + id + " ";
		int result = jdbcTemplate.update(sql);
		return result;

	}

	public int editReport(int id, Report report) {
		String sql = "UPDATE report SET name=?, timeSubmit=?, project_id=?" + " WHERE id= ?";
		int result = jdbcTemplate.update(sql,
				new Object[] { report.getName(), report.getTimeSubmit(), report.getProject_id(), id });
		return result;
	}

	public List<Report> getReportByProjectId(int projectId) {
		List<Report> list = new ArrayList<Report>();
		String sql = "SELECT * FROM report where project_id  =" + projectId;
		list = jdbcTemplate.query(sql, new MapperReport());
		return list;

	}

	public int gradeReport(PointDetail gradeReportModel) {
		String sql = "INSERT INTO `pointdetail` "
				+ "(`report_id`, `student_id`, `teacher_id`, `pointing_date`, `point`) " + "VALUES (?, ?, ?, ?,?);";
		int result = jdbcTemplate.update(sql,
				new Object[] { gradeReportModel.getReportId(), gradeReportModel.getStudentId(),
						gradeReportModel.getTeacherId(), new Date(), gradeReportModel.getPoint() });
		return result;
	}

	public void saveFileReportFile(String fileName, Integer reportId) {
		String sql = "UPDATE `baocaodoan`.`report` SET `urlReport` = ? WHERE (`id` = ?);";
		jdbcTemplate.update(sql, new Object[] { fileName, reportId });
	}

	public List<Report> getTimeSubmitReport(int group_id, int porject_id) {
		List<Report> list = new ArrayList<Report>();
		String sql = "UPDATE `pointdetail` SET `student_id` = ?, `teacher_id` = ?, `pointing_date` = ?, `point` = ? WHERE (`id` = ?);"
				+ " and p.id = " + porject_id + " ";
		list = jdbcTemplate.query(sql, new MapperReport());
		return list;
	}

	public PointDetail getPointDetailByReporIdStudentId(int reportId, int studentId) {
		String sql = "SELECT * FROM pointdetail where report_id = ? and student_id=?;";
		List<PointDetail> result = jdbcTemplate.query(sql, new Object[] { reportId, studentId },
				new PointDetailMapper());
		if(result.size()!=0) {
			return result.get(0);
		}
		return null;
	}

	public boolean addPointDetail(PointDetail poinDetail) {
		String sql = "INSERT INTO `pointdetail` "
				+ "(`report_id`, `student_id`, `teacher_id`, `pointing_date`, `point`) " + "VALUES (?, ?,?,?,?);";
		jdbcTemplate.update(sql, new Object[] { poinDetail.getReportId(), poinDetail.getStudentId(),
				poinDetail.getTeacherId(), new Date(), poinDetail.getPoint() });
		return true;
	}

	public boolean editPoint(PointDetail pointDetail) {
		String sql = "UPDATE `baocaodoan`.`pointdetail` SET `point` = ? WHERE (`id` = ?);";
		jdbcTemplate.update(sql, new Object[] { pointDetail.getPoint(), pointDetail.getId() });
		return true;
	}
	public PointDetail StudentGetPoint(int idreport , int idStudent){
		try {
		PointDetail pointDetails = new PointDetail() ;
		String query = "SELECT * FROM `pointdetail` WHERE report_id = "+idreport+" and student_id = "+idStudent+ " " ;
		pointDetails = jdbcTemplate.queryForObject(query, new PointDetailMapper());
		
		if (pointDetails != null) {
			return pointDetails;
		}
	} catch (EmptyResultDataAccessException e) {

		return null;
	}
	return null;
		
	}
}
