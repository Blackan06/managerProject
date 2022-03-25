package BaoCaoDoAn.Dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;



public class MapperProjectScheduleMeeting  implements RowMapper<project_scheduleMeeting>{



	public project_scheduleMeeting mapRow(ResultSet rs, int rowNum) throws SQLException {
		project_scheduleMeeting admin = new project_scheduleMeeting();
		admin.setName_project(rs.getString("name"));
		admin.setId_scheduleMeeting(rs.getInt("id"));
		admin.setTimeMeeting(rs.getDate("timeMeeting"));
		admin.setProject_id(rs.getInt("project_id"));
		admin.setAccount_id(rs.getInt("account_id"));
		admin.setName_scheduleMeeting(rs.getString("name_scheduleMeeting"));
		admin.setLink_meeting(rs.getString("link_meeting"));
		admin.setContent_scheduleMeeting(rs.getString("content"));
		
		return admin;
	}
	}