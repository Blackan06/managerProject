package BaoCaoDoAn.validator.Imp;

import java.sql.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import BaoCaoDoAn.Entity.Report;
import BaoCaoDoAn.Entity.ScheduleMeeting;
import BaoCaoDoAn.Service.User.Impl.ScheduleMeetingServiceImpl;
import BaoCaoDoAn.validator.FutureBasedDateSchedule;

public class FutureBasedDateScheduleValidator implements ConstraintValidator<FutureBasedDateSchedule, ScheduleMeeting> {
	@Autowired
	private ScheduleMeetingServiceImpl scheduleService;

	public boolean isValid(ScheduleMeeting value, ConstraintValidatorContext context) {
		boolean result = false;
		try {
			// Creating
			if (value.getId() == 0) {
				Date now = new Date(new java.util.Date().getTime());
				if (!now.after(value.getTimeMeeting())) {
					result = true;
				}
			} else {
				// Updating
				ScheduleMeeting fullReport = scheduleService.getScheduleMeetingByID(value.getId());
				Date createTime = fullReport.getSubmitDate();
				Date deadline = value.getTimeMeeting();
				if (!createTime.after(deadline)) {
					result = true;
				}
			}
		} catch (Exception e) {
		
		}

		return result;
	}

	public boolean isValid(Scheduled value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return false;
	}

}
