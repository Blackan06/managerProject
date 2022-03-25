package BaoCaoDoAn.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import BaoCaoDoAn.Dao.ScheduleReportDAO;
import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Entity.Group;
import BaoCaoDoAn.Entity.Report;
import BaoCaoDoAn.Entity.ScheduleReport;
import BaoCaoDoAn.Service.User.Impl.GroupServiceImpl;
import BaoCaoDoAn.Service.User.Impl.ProjectServiceImpl;
import BaoCaoDoAn.Service.User.Impl.ReportServiceImpl;
import BaoCaoDoAn.Service.User.Impl.ScheduleReportServiceImpl;

@Controller
public class ScheduleReportController {
	@Autowired
	private ScheduleReportServiceImpl scheduleReportService;
	@Autowired
	private ReportServiceImpl reportService;
	@Autowired
	private ProjectServiceImpl projectService;
	@Autowired
	private GroupServiceImpl groupService;
	private ModelAndView mv = new ModelAndView();

	@Autowired
	private ScheduleReportDAO scheduleReportDAO;

	@RequestMapping(value = { "/ScheduleReport" })
	public ModelAndView AllScheduleReport(Model model) {

		mv.setViewName("admin/adminschedulereport");
		mv.addObject("schedule", new ScheduleReport());
		mv.addObject("report", new Report());
		mv.addObject("getAllReport", reportService.getAllReport());
		mv.addObject("getAllScheduleReport", scheduleReportDAO.getAllScheduleReport());
		return mv;

	}

	@RequestMapping(value = "/new")

	public ModelAndView addScheduleReport(@ModelAttribute("schedule") ScheduleReport scheduleReport) {
		mv.setViewName("admin/adminAddScheduleReport");
//			mv.addObject("addSchedule" , scheduleReportDAO.addScheduleReport(scheduleReport) ) ;		
		return mv;

	}

	@RequestMapping(value = { "/deleteScheduleReport/{id}" })
	public String DeleteScheduleReport(@PathVariable String id) {
		int result = scheduleReportDAO.DeleteScheduleReport(id);
		System.out.println("deleteScheduleReprot " + result);
		if (result > 0) {
			System.out.println("thanh cong");
			scheduleReportDAO.DeleteScheduleReport(id);
		}
		return "redirect:/ScheduleReport";

	}

	@RequestMapping(value = "/teacher_viewReportSchedule")
	public ModelAndView viewReportSchedule(HttpSession session) {
		System.out.println("In View Report");
		Account teacher = (Account) session.getAttribute("InforAccount");
	
		List<ScheduleReport> scheduleReportList = scheduleReportService
				.getAllScheduleReportByTeacherId(teacher.getId());
		for (ScheduleReport sch : scheduleReportList) {

			
			Group groupOfReport = groupService.getGroupByAccountId(sch.getAccount_id());
			sch.setGroup(groupOfReport);
			
			Report reportOfSchedule = reportService.getReport(sch.getReport_id());
			sch.setReport(reportOfSchedule);
		}
		mv.addObject("scheduleReports", scheduleReportList);
		mv.setViewName("user/teacher/teacherScheduleReport");
		return mv;
	}

	@RequestMapping(value = "/student_ViewScheduleReport")
	public ModelAndView StudentviewReportSchedule(HttpSession session) {

		Account student = (Account) session.getAttribute("InforAccount");
		ModelAndView mv = new ModelAndView();
		List<ScheduleReport> scheduleReportList = scheduleReportService
				.getScheduleReportBygroupId(student.getGroup_id());
		for (ScheduleReport sch : scheduleReportList) {
			Report reportOfSchedule = reportService.getReport(sch.getReport_id());

			sch.setReport(reportOfSchedule);
		}
		mv.addObject("StudentScheduleReports", scheduleReportList);
		mv.setViewName("user/student/studentScheduleReport");
		return mv;
	}

	@RequestMapping(value = "/editScheduleReport", method = RequestMethod.GET)
	public ModelAndView editAdmin(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		ScheduleReport scheduleReport = scheduleReportService.getScheduleReport(id);

		ModelAndView mv = new ModelAndView("/user/ScheduleReportFrom");

		mv.addObject("ScheduleReportUpdateAndInsert", scheduleReport);
		mv.addObject("getAllReport", reportService.getAllReport());
		mv.addObject("dateError", "");
		mv.addObject("isDateSubmit", "");
		return mv;
	}

	@RequestMapping(value = "/addScheduleReport", method = RequestMethod.GET)
	public ModelAndView doGetAddUser(Model model, HttpSession session) {
		if (!model.containsAttribute("ScheduleReportUpdateAndInsert")) {
			model.addAttribute("ScheduleReportUpdateAndInsert", new ScheduleReport());
		}

		mv.addObject("getAllReport", reportService.getAllReport());
		mv.setViewName("/user/ScheduleReportFrom");
		mv.addObject("dateError", "");
		mv.addObject("isDateSubmit", "");
		return mv;
	}

	@RequestMapping(value = "/addScheduleReport", method = RequestMethod.POST)
	public ModelAndView doPostAddUser(
			@Valid @ModelAttribute("ScheduleReportUpdateAndInsert") ScheduleReport ScheduleReport,
			BindingResult result) {
		mv.addObject("dateError", "");
		mv.addObject("isDateSubmit", "");
		if (result.hasErrors()) {
			mv.setViewName("/user/ScheduleReportFrom");
			mv.addObject("dateError", "Date have to greater than now!");
		} else if (ScheduleReport.getTimeReport().after(ScheduleReport.getDateSubmit())) {
			mv.setViewName("/user/ScheduleReportFrom");
			mv.addObject("isDateSubmit", "Date submit have to greater than time create!");
		} else {
			if (ScheduleReport.getId() > 0) {
				scheduleReportService.updateScheduleRepot(ScheduleReport);
				return new ModelAndView("redirect:/ScheduleReport");
			} else {
				scheduleReportService.InsertScheduleRepot(ScheduleReport);
				return new ModelAndView("redirect:/ScheduleReport");
			}

		}
		return mv;
	}

}
