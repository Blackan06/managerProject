package BaoCaoDoAn.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperScheduleReport implements RowMapper<ScheduleReport>{

	public ScheduleReport mapRow(ResultSet rs, int rowNum) throws SQLException {
			ScheduleReport sr = new ScheduleReport();
			sr.setId(rs.getInt("id"));
			sr.setTimeReport(rs.getDate("timeReport"));
		
			sr.setAccount_id(rs.getInt("account_id"));
			sr.setReport_id(rs.getInt("report_id"));
			sr.setDateSubmit(rs.getDate("date_submit"));
		return sr;
	}

}
