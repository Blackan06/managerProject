package BaoCaoDoAn.Dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import BaoCaoDoAn.Entity.ScheduleMeeting;
import BaoCaoDoAn.Dto.MapperProjectScheduleMeeting;
import BaoCaoDoAn.Dto.project_scheduleMeeting;
import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Entity.MapperAccount;
import BaoCaoDoAn.Entity.MapperMeeting;
import BaoCaoDoAn.Entity.MapperScheduleMeeting;
import BaoCaoDoAn.Entity.Meeting;

@Repository
public class ScheduleMeetingDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;

//	public List<project_scheduleMeeting> GetScheduleMeetingByProjectId(int id){
//		List<project_scheduleMeeting> list = new ArrayList<project_scheduleMeeting>();
//		String sql = "SELECT project.name , schedulemeeting.id , schedulemeeting.timeMeeting , schedulemeeting.project_id \r\n" + 
//				", schedulemeeting.account_id , schedulemeeting.name_scheduleMeeting , schedulemeeting.link_meeting ,\r\n" + 
//				"schedulemeeting.content \r\n" + 
//				" FROM schedulemeeting \r\n" + 
//				"\r\n" + 
//				"INNER JOIN \r\n" + 
//				"project \r\n" + 
//				"ON\r\n" + 
//				"project .id = schedulemeeting.project_id  and project.teacher_id = "+id+" " ; 
//		list = jdbcTemplate.query(sql, new MapperProjectScheduleMeeting());
//		return list;
//	}
//	
	public List<ScheduleMeeting> GetScheduleMeetingByProjectId(int project_id) {
		List<ScheduleMeeting> list = new ArrayList<ScheduleMeeting>();
		String sql = "SELECT * FROM schedulemeeting where project_id = " + project_id;
		list = jdbcTemplate.query(sql, new MapperScheduleMeeting());
		return list;
	}

	public List<ScheduleMeeting> GetDataAmin() {
		List<ScheduleMeeting> list = new ArrayList<ScheduleMeeting>();
		String sql = "SELECT * FROM schedulemeeting";
		list = jdbcTemplate.query(sql, new MapperScheduleMeeting());
		return list;
	}

	// add
//	public int save(ScheduleMeeting admin) {
//		String sql = "INSERT INTO schedulemeeting (timeMeeting,project_id,account_id) VALUES (?,?,?)";
//		int count = jdbcTemplate.update(sql,new Object[] {admin.getTimeMeeting(),admin.getProject_id(),admin.getAccount_id()});
//		return count;
//	}
	// delete
	public void delete(int id) {
		String sql = "DELETE FROM schedulemeeting WHERE id=?";
		jdbcTemplate.update(sql, id);
	}

	// Update
	public void updateAndSave(ScheduleMeeting admin) {
		if (admin.getId() > 0) {
			String sql = "UPDATE schedulemeeting SET timeMeeting=?, project_id=?, account_id=? ,name_scheduleMeeting=?,link_meeting=?,content=?,date_submit=?" + "WHERE id=?";
			jdbcTemplate.update(sql, admin.getTimeMeeting(), admin.getProject_id(),1,admin.getName(),admin.getLink_meeting(),admin.getContent(),admin.getSubmitDate(),
					admin.getId());
		} else {
			String sql = "INSERT INTO schedulemeeting (timeMeeting,project_id,account_id,name_scheduleMeeting,link_meeting,content,date_submit) VALUES (?,?,?,?,?,?,?)";
			jdbcTemplate.update(sql,
					new Object[] { admin.getTimeMeeting(), admin.getProject_id(),1,admin.getName(),admin.getLink_meeting(),admin.getContent(),admin.getSubmitDate() });

		}

	}

	public ScheduleMeeting get(int adminId) {
		String sql = "SELECT * FROM schedulemeeting WHERE id=" + adminId;
		ScheduleMeeting result = jdbcTemplate.queryForObject(sql, new MapperScheduleMeeting());
		return result;
	}

	public List<Meeting> GetMeetingByScheduleMeetingID(int id) {
		List<Meeting> list = new ArrayList<Meeting>();
		String sql = "SELECT * FROM meeting where scheduleMeeting_id = " + id;
		list = jdbcTemplate.query(sql, new MapperMeeting());
		return list;
	}

	public void saveFileMeetingContentFileName(String fileName, Integer schMeetingId) {
		Date dateSubmit = new Date();
		String formatSubmitDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(dateSubmit);
		String sql = "UPDATE `baocaodoan`.`schedulemeeting` SET `content` = ?,`date_submit`= ?  WHERE (`id` = ?);";
		jdbcTemplate.update(sql, new Object[] { fileName, formatSubmitDate, schMeetingId });
	}

	public ScheduleMeeting GetScheduleMeetingByID(int id) {

		String sql = "SELECT * FROM schedulemeeting where id = " + id;
		ScheduleMeeting result = jdbcTemplate.queryForObject(sql, new MapperScheduleMeeting());
		return result;
	}
}
