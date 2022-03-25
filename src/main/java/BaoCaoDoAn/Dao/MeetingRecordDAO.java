package BaoCaoDoAn.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import BaoCaoDoAn.Entity.MapperMeetingRecord;
import BaoCaoDoAn.Entity.MeetingRecord;
@Repository
public class MeetingRecordDAO {
	@Autowired
	JdbcTemplate jdbcTemplate ;
	public List<MeetingRecord> GetMeetingRecordByMeetingID(int id) {
		List<MeetingRecord> list = new ArrayList<MeetingRecord>();
		String sql = "SELECT * FROM meetingrecord where meeting_id = " + id;
		list = jdbcTemplate.query(sql, new MapperMeetingRecord());
		return list;
	}
}
