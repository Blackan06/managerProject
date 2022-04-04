package BaoCaoDoAn.Dto;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.jdbc.core.RowMapper;

public class MapperProjectScheduleMeeting  implements RowMapper<project_scheduleMeeting> {

	public project_scheduleMeeting mapRow(ResultSet rs, int rowNum) throws SQLException {
		project_scheduleMeeting admin = new project_scheduleMeeting();
		admin.setId(rs.getInt("id"));
		admin.setName(rs.getString("name_scheduleMeeting"));

		Date date = rs.getDate("timeMeeting");
		admin.setTimeMeeting(date);
		Calendar calendar = Calendar.getInstance();
	//	calendar.setTimeInMillis(rs.getTime("timeMeeting").getTime());
		admin.setTime(new SimpleDateFormat("HH:mm").format(calendar.getTime()));

		Date dateSubmit = rs.getDate("date_submit");
		admin.setSubmitDate(dateSubmit);
		if (dateSubmit != null) {
			Calendar calendarSubmit = Calendar.getInstance();
			calendarSubmit.setTimeInMillis(rs.getTime("date_submit").getTime());
			admin.setSubmitTime(new SimpleDateFormat("HH:mm").format(calendarSubmit.getTime()));
		}
		admin.setProjectName(rs.getString("project_name"));
		admin.setProject_id(rs.getInt("project_id"));
		admin.setAccount_id(rs.getInt("account_id"));
		admin.setLink_meeting(rs.getString("link_meeting"));
		admin.setContent(rs.getString("content"));
		return admin;

	}

}
