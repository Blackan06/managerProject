package BaoCaoDoAn.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import BaoCaoDoAn.Entity.MapperMeeting;
import BaoCaoDoAn.Entity.Meeting;
@Repository
public class MeetingDAO {
	@Autowired
	JdbcTemplate jdbcTemplate ;
	public List<Meeting> GetMeetingByScheduleMeetingID(int id) {
		List<Meeting> list = new ArrayList<Meeting>();
		String sql = "SELECT * FROM meeting where scheduleMeeting_id = " + id;
		list = jdbcTemplate.query(sql, new MapperMeeting());
		return list;
	}
	public void updateAndSave(Meeting meeting) {
        if(meeting.getId()>0){
        String sql = "UPDATE meeting SET scheduleMeeting_id=?, linkMeeting=? "
                    + "WHERE id=?";
        jdbcTemplate.update(sql, meeting.getSchedulemeetingId(),meeting.getLinkMeeting(),meeting.getId());
        }else {
        	String sql = "INSERT INTO meeting (scheduleMeeting_id,linkMeeting) VALUES (?,?)";
    		jdbcTemplate.update(sql,new Object[] {meeting.getSchedulemeetingId(),meeting.getLinkMeeting()});
    		
        }
        
	}
}
