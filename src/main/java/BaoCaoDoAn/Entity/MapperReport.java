package BaoCaoDoAn.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperReport implements RowMapper<Report> {

	public Report mapRow(ResultSet rs, int rowNum) throws SQLException {
			Report rp = new Report();
			rp.setId(rs.getInt("id"));
			rp.setName(rs.getString("name"));
			rp.setPoint(rs.getDouble("point"));
			rp.setComment(rs.getString("comment"));	
			rp.setTimeCreate(rs.getDate("timeCreate"));
			rp.setTimeSubmit(rs.getDate("timeSubmit"));
			rp.setUrlReport(rs.getString("urlReport"));	
			rp.setProject_id(rs.getInt("project_id"));
			rp.setStatus(rs.getInt("status"));
		return rp;
	}

}
