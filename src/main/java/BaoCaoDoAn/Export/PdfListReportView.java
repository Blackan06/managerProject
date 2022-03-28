package BaoCaoDoAn.Export;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;import org.springframework.jdbc.datasource.UserCredentialsDataSourceAdapter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

import BaoCaoDoAn.Entity.Report;

public class PdfListReportView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		response.setHeader("Content-Disposition", "attachment; filename=\"user_list.pdf\"");
		@SuppressWarnings("unchecked")
		List<Report> list = (List<Report>) model.get("userList");
		Table table = new Table(5) ;
		table.addCell("id");
		table.addCell("name");
		table.addCell("point");
		table.addCell("comment");
//		table.addCell("timeCreate");
//		table.addCell("timeSubmit");
//		table.addCell("urlReport");
		table.addCell("project_id");
//		table.addCell("status");
		
		for(Report report : list ) {
			table.addCell(String.valueOf(report.getId()));
			table.addCell(report.getName()) ;
			table.addCell(String.valueOf(report.getPoint())) ;
			table.addCell(report.getComment()) ;
//			table.addCell(String.valueOf(report.getTimeCreate())) ;
//			table.addCell(String.valueOf(report.getTimeSubmit())) ;
//			table.addCell(report.getUrlReport()) ;
			table.addCell(String.valueOf(report.getProject_id())) ;
//			table.addCell(String.valueOf(report.getStatus())) ;
		}
		document.add(table) ;
	} 

}
