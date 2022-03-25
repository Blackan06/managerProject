package BaoCaoDoAn.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BaoCaoDoAn.Entity.Meeting;

@Service
public interface IMeetingService {

	@Autowired
	public List<Meeting> getMeetingByScheduleMeetingID(int id);
	@Autowired
	public void SaveOrUpdate(Meeting meeting);
}
