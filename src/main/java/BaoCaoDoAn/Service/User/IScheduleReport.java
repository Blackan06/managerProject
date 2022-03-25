package BaoCaoDoAn.Service.User;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BaoCaoDoAn.Entity.ScheduleReport;

@Service
public interface IScheduleReport {
//	@Autowired
//	public List<ScheduleReport> getScheduleReport(int id) ;
	@Autowired
	public List<ScheduleReport> getAllScheduleReport()  ;
		

	@Autowired
	public int addScheduleReport(ScheduleReport scheduleReport);
	
	public List<ScheduleReport> getAllScheduleReportByReportId();
	public List<ScheduleReport> getAllScheduleReportByTeacherId(int accountId);
	public List<ScheduleReport> getScheduleReportBygroupId(int groupId) ;
	public ScheduleReport getScheduleReport(int id);
	public int InsertScheduleRepot(ScheduleReport scheduleReport) ;
	public int updateScheduleRepot(ScheduleReport scheduleReport);
	public void updateAndSave(ScheduleReport scheduleReport) ;
}
