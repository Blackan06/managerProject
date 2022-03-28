package BaoCaoDoAn.Export;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import BaoCaoDoAn.Dto.Report_Project_Group;
import BaoCaoDoAn.Entity.Report;

public class ExcelListReportView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "attachment: filename=\"user_list.xls\"");
		 @SuppressWarnings("unchecked")
		List<Report_Project_Group> list = (List<Report_Project_Group>) model.get("userList");
		 Sheet sheet = workbook.createSheet("User List") ;
		 
		 Row header = sheet.createRow(0) ;
		 header.createCell(0).setCellValue("ID");
		 header.createCell(1).setCellValue("NAME");
		 header.createCell(2).setCellValue("POINT");
		 header.createCell(3).setCellValue("COMMENT");
		 header.createCell(4).setCellValue("TIME CREATE");
//		 header.createCell(5).setCellValue("timeSubmit");
//		 header.createCell(6).setCellValue("urlReport");
		 header.createCell(7).setCellValue("PROJECT NAME");
		 header.createCell(8).setCellValue("GROUP NAME");
		
		
		 int rowNum = 1 ; 
		 for(Report_Project_Group report : list) {
			 Row row = sheet.createRow(rowNum ++) ;
			 row.createCell(0).setCellValue(report.getReport_id());
			 row.createCell(1).setCellValue(report.getReport_name());
			 row.createCell(2).setCellValue(report.getReport_point());
			 row.createCell(3).setCellValue(report.getReport_comment());
			 row.createCell(4).setCellValue(String.valueOf(report.getReport_timeCreate()));
//			 row.createCell(5).setCellValue(String.valueOf(report.getTimeSubmit()));
//			 row.createCell(6).setCellValue(report.getUrlReport());
			 row.createCell(7).setCellValue(report.getProject_name());
			 row.createCell(8).setCellValue(report.getGroup_name());
		
		 }
	}

}
