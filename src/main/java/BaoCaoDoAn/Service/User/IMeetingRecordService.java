package BaoCaoDoAn.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BaoCaoDoAn.Entity.MeetingRecord;

@Service
public interface IMeetingRecordService {
	@Autowired
	public List<MeetingRecord> getMeetingRecordByMeetingID(int id);
}
