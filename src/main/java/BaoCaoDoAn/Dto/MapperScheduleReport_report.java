package BaoCaoDoAn.Dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperScheduleReport_report implements RowMapper<scheduleReport_report>{

	public scheduleReport_report mapRow(ResultSet rs, int rowNum) throws SQLException {
		scheduleReport_report sr = new scheduleReport_report();
			sr.setId(rs.getInt("id"));
			sr.setTimeReport(rs.getDate("timeReport"));
			sr.setName(rs.getString("name"));
			sr.setProject_name(rs.getString("project_name"));

			sr.setAccount_id(rs.getInt("account_id"));
			sr.setReport_id(rs.getInt("report_id"));
			sr.setDateSubmit(rs.getDate("date_submit"));
		return sr;
	}

}
