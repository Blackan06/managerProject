package BaoCaoDoAn.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PointDetailMapper implements RowMapper<PointDetail> {

	public PointDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
		PointDetail pointDetail = new PointDetail();	
			pointDetail.setId(rs.getInt("id"));
			pointDetail.setReportId(rs.getInt("report_id"));
			pointDetail.setStudentId(rs.getInt("student_id"));
			pointDetail.setTeacherId(rs.getInt("teacher_id"));
			pointDetail.setPoint(rs.getDouble("point"));
			pointDetail.setDateGrade(rs.getDate("pointing_date"));	
		return pointDetail;
	}
}
