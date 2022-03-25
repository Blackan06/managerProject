package BaoCaoDoAn.validator.Imp;

import java.sql.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import BaoCaoDoAn.Entity.Report;
import BaoCaoDoAn.Service.User.Impl.ReportServiceImpl;
import BaoCaoDoAn.validator.FutureBasedDate;

public class FutureBasedDateValidator implements ConstraintValidator<FutureBasedDate, Report> {
	@Autowired
	private ReportServiceImpl reportService;
//	public boolean isValid(Date value, ConstraintValidatorContext context) {
//		// TODO Auto-generated method stub
//		boolean result = true;

//		return result;
//	}
	public boolean isValid(Report value, ConstraintValidatorContext context) {
		boolean result = false;
		// Creating
		if(value.getId()==0) {
			Date now = new Date(new java.util.Date().getTime());
			if(value.getTimeSubmit()!=null) {
				if(!now.after(value.getTimeSubmit())) {
					result = true;
				}
			}			
		}else {
			// Updating
			Report fullReport = reportService.getReport(value.getId());
			Date createTime = fullReport.getTimeCreate();
			System.out.println("DATE CRE:"+createTime);
			Date deadline = value.getTimeSubmit();
			if(deadline!=null) {
				if (!createTime.after(deadline)) {
					result = true;
				}	
			}			
		}
		
		return result;
	}

}
