package BaoCaoDoAn.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperMeetingRecord  implements RowMapper<MeetingRecord> {

	public MeetingRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
		MeetingRecord meetingRecord = new MeetingRecord();
		meetingRecord.setId(rs.getInt("id"));
		meetingRecord.setMeetingId(rs.getInt("meeting_id"));
		meetingRecord.setContent(rs.getString("content"));
		return meetingRecord;
	}
}

