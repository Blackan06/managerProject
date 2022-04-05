package BaoCaoDoAn.Controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import BaoCaoDoAn.Dao.ReportDAO;
import BaoCaoDoAn.Dao.StudentDAO;
import BaoCaoDoAn.Dto.Report_Project_Group;
import BaoCaoDoAn.Dto.group_Account_Project;
import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Entity.Group;
import BaoCaoDoAn.Entity.PointDetail;
import BaoCaoDoAn.Entity.Project;
import BaoCaoDoAn.Entity.Report;
import BaoCaoDoAn.Export.ExcelListReportView;
import BaoCaoDoAn.Export.PdfListReportView;
import BaoCaoDoAn.Service.User.Impl.AccountServiceImpl;
import BaoCaoDoAn.Service.User.Impl.GroupServiceImpl;
import BaoCaoDoAn.Service.User.Impl.ProjectServiceImpl;
import BaoCaoDoAn.Service.User.Impl.ReportServiceImpl;
import BaoCaoDoAn.Service.User.Impl.ScheduleReportServiceImpl;

@Controller
public class ReportController {
	@Autowired
	GroupServiceImpl groupServiceImpl;
	@Autowired
	private ReportServiceImpl reportService;
	@Autowired
	private ProjectServiceImpl projectSerivce;
	@Autowired
	private ReportDAO reportDAO;

	@Autowired

	private AccountServiceImpl accountService;
	private ModelAndView mv = new ModelAndView();

	@RequestMapping(value = { "/editReport/{id}" })
	public ModelAndView report(@PathVariable String id) {
		mv.setViewName("user/editReport");
		mv.addObject("getReport", reportService.getReport(Integer.parseInt(id)));
		return mv;

	}

	@RequestMapping(value = "/addreport", method = RequestMethod.POST)
	public String addReport(@Valid @ModelAttribute("report") Report report) {
		mv.addObject("addReport", reportService.addReport(report));
		return "redirect:/ScheduleReport";

	}

	@RequestMapping(value = { "/deleteReport/{id}" })
	public String DeleteReport(@PathVariable String id) {
		Report report = reportService.getReport(Integer.parseInt(id));
		if (report != null) {
			reportService.deleteReport(report);
		}
		return "redirect:/getReport";

	}

	@GetMapping(value = "teacher_viewReport")
	public ModelAndView viewReport(HttpSession session) {
		Account teacher = (Account) session.getAttribute("InforAccount");
		ModelAndView mv = new ModelAndView();
		List<Project> managedProject = projectSerivce.getProjectByTeacherId(teacher.getId());

		List<Report> reports = new ArrayList<Report>();
		for (Project project : managedProject) {
			List<Report> reportsTemp = reportService.getAllReportByProjecId(project.getId());
			for (Report reportInner : reportsTemp) {
				reportInner.setGroup(groupServiceImpl.getGroupByProjectId(reportInner.getProject_id()));
				reports.add(reportInner);

			}
		}

		mv.addObject("reportList", reports);
		mv.setViewName("user/teacher/teacherReport");
		return mv;
	}

	@GetMapping(value = "/student_ViewReport")
	public ModelAndView studentViewReport(HttpSession session) {
		Account account = (Account) session.getAttribute("InforAccount");

		System.out.println(account.getId());
//		PointDetail pointDetails = reportDAO.StudentGetPoint(account.getId());
//			System.out.println(pointDetails);
		List<Project> project = projectSerivce.getProject(account.getGroup_id());

		for (Project project2 : project) {
			List<Report> reports = reportService.getAllReportByProjecId(project2.getId());

			project2.setReport(reports);
		}

		mv.addObject("listReport", project);
//		mv.addObject("pointDetails", pointDetails);
		mv.setViewName("user/student/studentreport");

		return mv;
	}

	@RequestMapping("/viewPointDetails/{id}")
	public ModelAndView getViewPoint(@PathVariable int id, HttpSession session, HttpServletRequest request,
			RedirectAttributes redirAttr) {
		Account student = (Account) session.getAttribute("InforAccount");
		PointDetail pointDetails = reportDAO.StudentGetPoint(id, student.getId());

		if (pointDetails == null) {
			System.out.println(pointDetails);
			mv.addObject("mess", "No score yet");
//			redirAttr.addFlashAttribute("message","You successfully uploaded ");
			mv.setViewName("/user/student/studentreport");

		} else if (pointDetails != null) {
			System.out.println(pointDetails);
			mv.addObject("mess", "");
			mv.setViewName("/user/student/viewPointDetails");

			mv.addObject("pointDetails", pointDetails);// Chorm dau mat tieu roi :DD
		}

		return mv;
	}

	@RequestMapping("/grading_table/{reportId}")
	public ModelAndView getTableMemberForGrading(@PathVariable int reportId, HttpSession session) {
		Report report = reportService.getReport(reportId);
		mv.addObject("report", report);
		Group group = groupServiceImpl.getGroupByProjectId(report.getProject_id());
		mv.addObject("group", group);
		List<Account> members = accountService.getAccountByGroupId(group.getId());
		// get point detail for each member by using report id
		for (Account a : members) {
			PointDetail p = reportService.getPointDetaiByReportIdStudentId(reportId, a.getId());
			if (p != null) {
				if (p.getId() != 0) {
					a.setStatusPoint(1);
					a.setPointDetailForReport(p);
				}

			}
		}

		mv.addObject("members", members);
		mv.setViewName("user/teacher/memberGradingPage");
		return mv;
	}

	@RequestMapping(value = "/teacher_grade/{reportId}/{studentId}")
	public ModelAndView getReportToGrade(@PathVariable int reportId, @PathVariable int studentId, HttpSession session) {
		Account teacher = (Account) session.getAttribute("InforAccount");
		PointDetail pointDetail;
		ModelAndView mv = new ModelAndView();
		if (teacher != null) {
			Account student = accountService.getAccountById(studentId);
			Report report = reportService.getReport(reportId);
			pointDetail = new PointDetail();
			pointDetail.setReportId(reportId);
			pointDetail.setStudentId(studentId);
			pointDetail.setTeacherId(teacher.getId());
			mv.addObject("student", student);
			mv.addObject("pointDetail", pointDetail);
			mv.addObject("report", report);
			mv.setViewName("user/teacher/grade");
		} else {
			// return error page, for later
		}
		return mv;
	}

	@RequestMapping(value = "/teacher_editPoint/{reportId}/{studentId}")
	public ModelAndView getReportToEdit(@PathVariable int reportId, @PathVariable int studentId, HttpSession session) {
		Account teacher = (Account) session.getAttribute("InforAccount");
		PointDetail pointDetail;
		ModelAndView mv = new ModelAndView();
		if (teacher != null) {
			Account student = accountService.getAccountById(studentId);
			Report report = reportService.getReport(reportId);
			pointDetail = reportService.getPointDetaiByReportIdStudentId(reportId, studentId);
			mv.addObject("student", student);
			mv.addObject("pointDetail", pointDetail);
			mv.addObject("report", report);
			mv.addObject("editAction", true);
			mv.setViewName("user/teacher/grade");
		} else {
			// return error page, for later
		}
		return mv;
	}

	@PostMapping(value = "/processGrade")
	public ModelAndView processGrade(@Valid @ModelAttribute("pointDetail") PointDetail pointDetail,
			BindingResult theBindingResult) {
		mv = new ModelAndView("redirect:/grading_table/" + pointDetail.getReportId());
		if (theBindingResult.hasErrors()) {
			System.out.println(theBindingResult);
			mv.addObject("student", accountService.getAccountById(pointDetail.getStudentId()));
			mv.addObject("report", reportService.getReport(pointDetail.getReportId()));
			mv.setViewName("user/teacher/grade");
		} else {
			// do some work here
//			reportService.gradeReport(report.getPoint(), report.getId());
			reportService.addPointDetail(pointDetail);
		}
		return mv;
	}

	@PostMapping(value = "/processEditGrade")
	public ModelAndView processEditGrade(@Valid @ModelAttribute("pointDetail") PointDetail pointDetail,
			BindingResult theBindingResult) {
		mv = new ModelAndView("redirect:/grading_table/" + pointDetail.getReportId());
		if (theBindingResult.hasErrors()) {
			System.out.println(theBindingResult);
			mv.addObject("student", accountService.getAccountById(pointDetail.getStudentId()));
			mv.addObject("report", reportService.getReport(pointDetail.getReportId()));
			mv.setViewName("user/teacher/grade");
		} else {
			// do some work here
//			reportService.gradeReport(report.getPoint(), report.getId());
			reportService.editPointDetail(pointDetail);
			mv.addObject("editAction", true);
		}
		return mv;
	}

	@RequestMapping("/upload_report/{report_id}")
	public ModelAndView showUploadPage(@PathVariable int report_id, @ModelAttribute("message") String message,
			HttpSession session, RedirectAttributes redirAttr) {

		mv.setViewName("/user/student/StudentUploadFile");
		Report report = reportDAO.getReport(report_id);

		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

		mv.addObject("InforReport", report.getTimeSubmit());
		mv.addObject("TIMENOW", date);

		int compareTime = report.getTimeSubmit().compareTo(date);

		mv.addObject("compareTime", compareTime);

		if (compareTime == -1) {
			if (report.getTimeSubmit().toString().equalsIgnoreCase(date.toString())) {
				mv.setViewName("/user/student/StudentUploadFile");
			} else {

				mv.setViewName("/user/student/studentreport");

			}

		} else if (compareTime == 1) {

			mv.setViewName("/user/student/StudentUploadFile");
		}

		mv.addObject("ReportId", report_id);
		return mv;
	}

	@RequestMapping(value = "/saveReportFile", method = RequestMethod.POST)
	public String upload(@RequestParam CommonsMultipartFile file, HttpServletRequest request,
			RedirectAttributes redirAttr, HttpSession session) {
		String reportId = request.getParameter("ReportId");
		Account student = (Account) session.getAttribute("InforAccount");
		boolean studentAuthority = student.getIsLeader();
		String path = session.getServletContext().getRealPath("/ReportFile");
		String filename = file.getOriginalFilename();
		String extendtionOfFile = FilenameUtils.getExtension(filename);
		System.out.println(path);
		if (studentAuthority == true) {
			if (extendtionOfFile.equals("doc") || extendtionOfFile.equals("docx") || extendtionOfFile.equals("txt")
					|| extendtionOfFile.equals("wpd") || extendtionOfFile.equals("odt")
					|| extendtionOfFile.equals("pdf")) {
				System.out.println("VALID TYPE");
				try {
					byte barr[] = file.getBytes();
					System.out.println("VALID TYPE");
					BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(path + "/" + filename));
					bout.write(barr);
					bout.flush();
					bout.close();
					redirAttr.addFlashAttribute("message",
							"You successfully uploaded '" + file.getOriginalFilename() + "'");
					System.out.println("report ID:" + reportId);
					// Save file in to DB
					Report reportToSave = new Report();
					reportToSave.setId(Integer.parseInt(reportId));
					reportToSave.setUrlReport(filename);

					reportService.WriteReportFile(reportToSave);
					return "redirect:/student_ViewReport";
				} catch (Exception e) {
					System.out.println(e);
				}

			} else {
				redirAttr.addFlashAttribute("message", "File Type Not Valid");
				System.out.println("Not valid");
			}
		} else {
			redirAttr.addFlashAttribute("message", "You dont have authority to upload, just leader!");
			System.out.println("Not author");
		}

		return "redirect:/upload_report/" + reportId;

	}

	@RequestMapping("/getReport")
	public ModelAndView getAllReport(HttpServletRequest req, HttpServletResponse res) {
		mv.setViewName("/admin/adminReport");
		String typeReport = req.getParameter("type");

		List<Report> reportList = reportService.getAllReport();
		List<Report_Project_Group> exportList = reportDAO.getAllReportWithProject_Group();

		// load project object for each report
		for (Report rp : reportList) {
			Project projet = projectSerivce.getProjectById(rp.getProject_id());
			rp.setProject(projet);

		}

		mv.addObject("getAllReport", reportList);
		if (typeReport != null && typeReport.equals("xls")) {
			return new ModelAndView(new ExcelListReportView(), "userList", exportList);
		} else if (typeReport != null && typeReport.equals("pdf")) {
			return new ModelAndView(new PdfListReportView(), "userList", exportList);
		}
		return mv;
	}

	@GetMapping("/addReport")
	public ModelAndView showAddReportForm() {
		ModelAndView modelView = new ModelAndView("/admin/reportAddForm");
		List<Project> projectList = projectSerivce.getAllProjectSimple();
		modelView.addObject("projectList", projectList);
		modelView.addObject("report", new Report());
		return modelView;
	}

	@PostMapping("/addReport")
	public ModelAndView processAddReportForm(@Valid @ModelAttribute("report") Report report,
			BindingResult theBindingResult) {
		if (theBindingResult.hasFieldErrors("name") || theBindingResult.hasGlobalErrors()) {
			if (theBindingResult.hasGlobalErrors()) {
				mv.addObject("dateError", "Deadline have to greater than now!");
			} else {
				mv.addObject("dateError", "");
			}
			mv.setViewName("admin/reportAddForm");
			List<Project> projectList = projectSerivce.getAllProjectSimple();
			mv.addObject("projectList", projectList);
		} else {
			Report addedReport = new Report();
			Group group = groupServiceImpl.getGroupByProjectId(report.getProject_id());
			addedReport.setName(report.getName());
			addedReport.setProject_id(report.getProject_id());
			addedReport.setTimeCreate(new Date(new java.util.Date().getTime()));
			addedReport.setTimeSubmit(report.getTimeSubmit());
			addedReport.setGroup(group);
			reportService.addReport(addedReport);
			mv = new ModelAndView("redirect:/getReport");
		}
		return mv;
	}

	@GetMapping("/updateReport/{id}")
	public ModelAndView showUpdateReportForm(@PathVariable("id") int id) {
		ModelAndView modelView = new ModelAndView("/admin/reportEditForm");
		List<Project> projectList = projectSerivce.getAllProjectSimple();
		modelView.addObject("projectList", projectList);
		modelView.addObject("report", reportService.getReport(id));
		return modelView;
	}

	@PostMapping("/updateReport")
	public ModelAndView processUpdateReportForm(@Valid @ModelAttribute("report") Report report,
			BindingResult theBindingResult) {
		if (theBindingResult.hasFieldErrors("name") || theBindingResult.hasGlobalErrors()) {
			if (theBindingResult.hasGlobalErrors()) {
				mv.addObject("dateError", "Deadline have to greater than create time!");
			} else {
				mv.addObject("dateError", "");
			}
			mv.setViewName("admin/reportEditForm");
			List<Project> projectList = projectSerivce.getAllProjectSimple();
			mv.addObject("projectList", projectList);
		} else {
			reportService.editReport(report.getId(), report);
			mv = new ModelAndView("redirect:/getReport");
		}
		return mv;
	}

	@PostMapping("/saveReportComment")
	public ModelAndView saveReportComment(@Valid @ModelAttribute("report") Report report,
			BindingResult theBindingResult, RedirectAttributes redirectAttributes) {
		if (theBindingResult.hasFieldErrors("comment")) {
			redirectAttributes.addFlashAttribute("error",
					"Error must be 1-200 characters and not special characters.");

		} else if (theBindingResult.hasFieldErrors("point")) {
			redirectAttributes.addFlashAttribute("error",
					"Must be number, 0-10");
		} else {
			if (report.getComment() == null) {
				report.setComment("");
			}
			reportService.saveComment(report);
		}
		mv = new ModelAndView("redirect:/grading_table/" + report.getId());
		return mv;
	}

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
}