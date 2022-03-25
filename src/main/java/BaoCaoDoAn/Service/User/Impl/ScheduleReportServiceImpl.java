package BaoCaoDoAn.Service.User.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import BaoCaoDoAn.Dao.ScheduleReportDAO;
import BaoCaoDoAn.Entity.ScheduleMeeting;
import BaoCaoDoAn.Entity.ScheduleReport;
import BaoCaoDoAn.Service.User.IScheduleReport;

@Service
public class ScheduleReportServiceImpl implements IScheduleReport {
	@Autowired
	private ScheduleReportDAO scheduleReportDAO;

	public List<ScheduleReport> getAllScheduleReport() {
		return scheduleReportDAO.getAllScheduleReport();
	}

	public int addScheduleReport(ScheduleReport scheduleReport) {
		return scheduleReportDAO.addScheduleReport(scheduleReport);
	}

	public List<ScheduleReport> getAllScheduleReportByReportId(int reportId) {
		// TODO Auto-generated method stub

		return null;
	}

	public List<ScheduleReport> getAllScheduleReportByReportId() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ScheduleReport> getAllScheduleReportByTeacherId(int teacherId) {
		// TODO Auto-generated method stub
		return scheduleReportDAO.getScheduleReportByTeacherId(teacherId);
	}

	public List<ScheduleReport> getScheduleReportBygroupId(int groupId) {
		// TODO Auto-generated method stub
		return scheduleReportDAO.getScheduleReportBygroupId(groupId);
	}

	public int InsertScheduleRepot(ScheduleReport scheduleReport) {
		// TODO Auto-generated method stub
		return scheduleReportDAO.InsertScheduleRepot(scheduleReport);
	}

	public int updateScheduleRepot(ScheduleReport scheduleReport) {
		return scheduleReportDAO.updateScheduleRepot(scheduleReport);

	}

	public ScheduleReport getScheduleReport(int id) {
		// TODO Auto-generated method stub
		return scheduleReportDAO.getScheduleReport(id);
	}

	public void updateAndSave(ScheduleReport scheduleReport) {
		// TODO Auto-generated method stub
		scheduleReportDAO.updateAndSave(scheduleReport);
	}

	public ScheduleReport getScheduleReportByID(int id) {
		return scheduleReportDAO.GetScheduleReportByID(id);
	}
}
