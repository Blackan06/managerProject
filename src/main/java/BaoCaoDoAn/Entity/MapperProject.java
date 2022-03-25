package BaoCaoDoAn.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperProject  implements RowMapper<Project> {

	public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
		Project project = new Project();
		project.setId(rs.getInt("id"));
		project.setName(rs.getString("project_name"));
		project.setUrlProject(rs.getString("urlProject"));
		project.setCreateTime(rs.getDate("createTime"));
		project.setGroup_id(rs.getInt("group_id"));
		project.setTeacherId(rs.getInt("teacher_id"));
		return project;
	}

}
