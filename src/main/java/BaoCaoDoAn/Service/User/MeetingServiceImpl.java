package BaoCaoDoAn.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BaoCaoDoAn.Dao.MeetingDAO;
import BaoCaoDoAn.Entity.Meeting;

@Service
public class MeetingServiceImpl implements IMeetingService{
	@Autowired
	private MeetingDAO meetingDAO;
	public List<Meeting> getMeetingByScheduleMeetingID(int id) {
		return meetingDAO.GetMeetingByScheduleMeetingID(id);
	}
	public void SaveOrUpdate(Meeting meeting) {
		meetingDAO.updateAndSave(meeting);
	}

}
