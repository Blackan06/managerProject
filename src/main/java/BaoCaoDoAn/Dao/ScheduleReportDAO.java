package BaoCaoDoAn.Dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import BaoCaoDoAn.Entity.Group;
import BaoCaoDoAn.Entity.MapperScheduleMeeting;
import BaoCaoDoAn.Entity.MapperScheduleReport;
import BaoCaoDoAn.Entity.Report;
import BaoCaoDoAn.Entity.ScheduleMeeting;
import BaoCaoDoAn.Entity.ScheduleReport;

@Repository
public class ScheduleReportDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

//	public List<ScheduleReport> getScheduleReport(int id) {
//		List<ScheduleReport> list = new ArrayList<ScheduleReport>();
//		String sql = "Select * from schedulereport where account_id = " + id ;
//		 list =  jdbcTemplate.query(sql, new MapperScheduleReport()) ;
//		return list ;
//	}
//	

	public List<ScheduleReport> getAllScheduleReport() {
		List<ScheduleReport> list = new ArrayList<ScheduleReport>();
		String sql = "Select * from schedulereport";
		list = jdbcTemplate.query(sql, new MapperScheduleReport());

		return list;
	}

	public List<ScheduleReport> getScheduleReportByReportId(int i) {
		List<ScheduleReport> list = new ArrayList<ScheduleReport>();
		String sql = "Select * from schedulereport WHERE report_id=" + i;
		list = jdbcTemplate.query(sql, new MapperScheduleReport());
		return list;
	}

	public int addScheduleReport(ScheduleReport scheduleReport) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO schedulereport (timeReport, report_id) " + " VALUES ('" + scheduleReport.getTimeReport()
				+ "', " + scheduleReport.getReport_id() + ");");
		int insert = jdbcTemplate.update(sql.toString());

		return insert;
	}

	public int DeleteScheduleReport(String id) {

		String sql = "DELETE FROM schedulereport WHERE id = " + id + " ";
		int result = jdbcTemplate.update(sql);
		return result;

	}

	public List<ScheduleReport> getScheduleReportByAccountId(int accountId) {
		List<ScheduleReport> list = new ArrayList<ScheduleReport>();
		String sql = "Select * from schedulereport WHERE account_id=" + accountId;
		list = jdbcTemplate.query(sql, new MapperScheduleReport());
		return list;
	}

	public List<ScheduleReport> getScheduleReportByTeacherId(int teacherId) {
		List<ScheduleReport> list = new ArrayList<ScheduleReport>();
		String sql = "SELECT * \r\n"
				+ "FROM baocaodoan.schedulereport\r\n"
				+ "WHERE report_id IN (SELECT r.id\r\n"
				+ "FROM baocaodoan.project as p,baocaodoan.report as r \r\n"
				+ "where p.teacher_id ="+teacherId+"  and p.id = r.project_id)\r\n"
				+ "order by timeReport;";
		list = jdbcTemplate.query(sql, new MapperScheduleReport());
		return list;
	}
	
	public List<ScheduleReport> getScheduleReportBygroupId(int groupId) {
		List<ScheduleReport> list = new ArrayList<ScheduleReport>();
		String sql = "SELECT * \r\n"
				+ "FROM baocaodoan.schedulereport\r\n"
				+ "WHERE report_id IN (SELECT r.id\r\n"
				+ "FROM baocaodoan.project as p,baocaodoan.report as r \r\n"
				+ "where p.group_id =" + groupId + "  and p.id = r.project_id)\r\n"
				+ "order by timeReport;";
		list = jdbcTemplate.query(sql, new MapperScheduleReport());
		return list;
	}

	public int InsertScheduleRepot(ScheduleReport scheduleReport) {
		String sql = "INSERT INTO schedulereport (id, `timeReport`,account_id,report_id,date_submit) VALUES (?,?,?,?,?)";
		int count = jdbcTemplate.update(sql, new Object[] { scheduleReport.getId(), scheduleReport.getTimeReport(),1,scheduleReport.getReport_id(),scheduleReport.getDateSubmit() });
		return count;
	}

	public int updateScheduleRepot(ScheduleReport scheduleReport) {
		String sql = "UPDATE schedulereport SET timeReport=? , account_id=? , report_id=? , date_submit=? WHERE id=?";
		int count = jdbcTemplate.update(sql, scheduleReport.getTimeReport(),1,scheduleReport.getReport_id(),scheduleReport.getDateSubmit(),scheduleReport.getId());
		return count;
	}
	public ScheduleReport getScheduleReport(int id) {
		String sql = "SELECT * FROM schedulereport WHERE id=" + id;
		ScheduleReport result = jdbcTemplate.queryForObject(sql, new MapperScheduleReport());
		return result;
	}
	public void updateAndSave(ScheduleReport scheduleReport) {
		if (scheduleReport.getId() > 0) {
			String sql = "UPDATE schedulereport SET timeReport= '?' , account_id=? , report_id=? , date_submit= '?' WHERE id=?";
			jdbcTemplate.update(sql, scheduleReport.getTimeReport(),scheduleReport.getAccount_id(),scheduleReport.getReport_id(),scheduleReport.getDateSubmit(),scheduleReport.getId());

		} else {
			String sql = "INSERT INTO schedulereport (id, timeReport,account_id,report_id,date_submit) VALUES (?,?,?,?,?)";
			jdbcTemplate.update(sql, scheduleReport.getTimeReport(),scheduleReport.getAccount_id(),scheduleReport.getReport_id(),scheduleReport.getDateSubmit(),scheduleReport.getId());
			}
		}

	public int DeleteScheduleReportByReportId(int reportId) {
		String sql = "DELETE FROM schedulereport WHERE report_id = " + reportId + " ";
		int result = jdbcTemplate.update(sql);
		return result;

	}
	
	public ScheduleReport GetScheduleReportByID(int reportId) {
		String sql = "SELECT * FROM schedulereport where id = " + reportId;
		ScheduleReport result = jdbcTemplate.queryForObject(sql, new MapperScheduleReport());
		return result;
	}
}
