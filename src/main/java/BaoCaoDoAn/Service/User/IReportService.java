package BaoCaoDoAn.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BaoCaoDoAn.Entity.PointDetail;
import BaoCaoDoAn.Entity.Report;

@Service
public interface IReportService {
	
	@Autowired
	public Report getReport(int id) ;
	
	@Autowired
	public List<Report> getAllReport() ;
	
	@Autowired
	public int addReport(Report report);
	
	@Autowired
	public int editReport(int id,Report report);
	
	public List<Report> getAllReportByProjecId(int reportId) ;
	public int gradeReport(PointDetail studentGradeReportModel);
	public boolean addPointDetail(PointDetail studentGradeReportModel);
	public boolean editPointDetail(PointDetail studentGradeReportModel);
}
