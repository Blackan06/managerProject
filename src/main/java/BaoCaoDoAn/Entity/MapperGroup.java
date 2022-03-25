package BaoCaoDoAn.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperGroup implements RowMapper<Group> {

	public Group mapRow(ResultSet rs, int rowNum) throws SQLException {
		Group group = new Group();
		group.setId(rs.getInt("id"));
		group.setName(rs.getString("group_name"));
		
		return group;
	}
}
