package BaoCaoDoAn.Dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperReport_Project_Group  implements RowMapper<Report_Project_Group> {

	public Report_Project_Group mapRow(ResultSet rs, int rowNum) throws SQLException {
		Report_Project_Group rpg = new Report_Project_Group();
		rpg.setReport_id(rs.getInt("id"));
		rpg.setReport_name(rs.getString("name"));
		rpg.setReport_point(rs.getDouble("point"));
		rpg.setReport_comment(rs.getString("comment"));
		rpg.setReport_timeCreate(rs.getDate("timeCreate"));
		rpg.setProject_name(rs.getString("project_name"));
		rpg.setGroup_name(rs.getString("group_name"));
		return rpg;
	}

}
