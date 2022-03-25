package BaoCaoDoAn.validator.Imp;

import java.sql.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import BaoCaoDoAn.Entity.ScheduleReport;
import BaoCaoDoAn.Service.User.Impl.ScheduleReportServiceImpl;
import BaoCaoDoAn.validator.FutureBasedDateScheduleReport;

public class FutureBasedDateScheduleReportValidator implements ConstraintValidator<FutureBasedDateScheduleReport, ScheduleReport> {
	@Autowired
	private ScheduleReportServiceImpl scheduleService;

	public boolean isValid(ScheduleReport value, ConstraintValidatorContext context) {
		boolean result = false;
		// Creating
		if(value.getId()==0) {
			Date now = new Date(new java.util.Date().getTime());
			if(!now.after(value.getTimeReport())) {
				result = true;
			}
		}else {
			// Updating
			ScheduleReport fullReport = scheduleService.getScheduleReportByID(value.getId());
			Date createTime = fullReport.getTimeReport();
			Date deadline = value.getDateSubmit();
			if (!createTime.after(deadline)) {
				result = true;
			}
		}

		return result;
	}

	public boolean isValid(Scheduled value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return false;
	}

}