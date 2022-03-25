package BaoCaoDoAn.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BaoCaoDoAn.Dao.MeetingRecordDAO;
import BaoCaoDoAn.Entity.MeetingRecord;

@Service
public class MeetingRecordServiceImpl implements IMeetingRecordService {
	@Autowired
	private MeetingRecordDAO meetingRecordDAO;
	public List<MeetingRecord> getMeetingRecordByMeetingID(int id) {
		return meetingRecordDAO.GetMeetingRecordByMeetingID(id);
	}

}
