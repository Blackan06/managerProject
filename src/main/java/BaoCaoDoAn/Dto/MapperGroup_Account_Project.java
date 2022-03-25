package BaoCaoDoAn.Dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;



public class MapperGroup_Account_Project implements RowMapper<group_Account_Project> {
public group_Account_Project mapRow(ResultSet rs, int rowNum) throws SQLException {
	group_Account_Project gap = new group_Account_Project();
	gap.setId( rs.getInt("id"));

	gap.setProject_name(rs.getString("project_name"));
	gap.setUrlProject(rs.getString("urlProject"));
	gap.setCreateTime(rs.getDate("createTime"));
	gap.setGroup_id(rs.getInt("group_id"));
	gap.setTeacherId(rs.getInt("teacher_id"));
	gap.setGroup_name(rs.getString("group_name"));
	gap.setAccount_name(rs.getString("account_name"));

	return gap;
}
}




