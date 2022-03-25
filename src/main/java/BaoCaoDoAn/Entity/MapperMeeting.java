package BaoCaoDoAn.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperMeeting implements RowMapper<Meeting> {

	public Meeting mapRow(ResultSet rs, int rowNum) throws SQLException {
		Meeting meeting = new Meeting();
		meeting.setId(rs.getInt("id"));
		meeting.setSchedulemeetingId(rs.getInt("scheduleMeeting_id"));
		meeting.setLinkMeeting(rs.getString("linkMeeting"));
		
		return meeting;
	}
}
