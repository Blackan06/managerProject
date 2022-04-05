package BaoCaoDoAn.Controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import BaoCaoDoAn.Dao.AccountDAO;
import BaoCaoDoAn.Dao.ProjectDAO;
import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Entity.Project;
import BaoCaoDoAn.Entity.Report;
import BaoCaoDoAn.Service.User.Impl.AccountServiceImpl;
import BaoCaoDoAn.Service.User.Impl.GroupServiceImpl;
import BaoCaoDoAn.Service.User.Impl.ProjectServiceImpl;
import BaoCaoDoAn.validator.AuthorityValid;

@Controller
public class ProjectController {
	@Autowired
	private AuthorityValid authorityValid;
	@Autowired
	AccountDAO accountDao;
	@Autowired
	GroupServiceImpl groupServiceImpl;
	@Autowired
	private ProjectServiceImpl projectService;
	@Autowired
	private ProjectDAO projectDao;
	@Autowired
	private AccountServiceImpl accountService;
	private ModelAndView mv = new ModelAndView();

	@RequestMapping(value = { "/teacher_getProject/{id}" })
	public ModelAndView teacherGetProjectById(@PathVariable int id, HttpSession session) {
		if(authorityValid.authorityWithLogin(session, "student","teacher_getProject/{id}") == false) {
			mv.setViewName("errorPage");
			return mv;
		}
		List<Project> result = projectService.getProjectByTeacherId(id);
		if (!result.isEmpty()) {
			mv.addObject("projectById", result);
			mv.setViewName("user/teacher/teacherProject");
		}
		return mv;
	}

	@RequestMapping(value = { "/AdminProject" })
	public ModelAndView getAllProject(Project project, HttpSession session	) {
		if(authorityValid.authorityWithLogin(session, "admin","AdminProject") == false) {
			mv.setViewName("errorPage");
			return mv;
		}
		mv.setViewName("admin/adminproject");
		mv.addObject("getAllProject", projectService.getAllProject());
		mv.addObject("group4", groupServiceImpl.getGroupAdmin());
		mv.addObject("project", new Project());
		return mv;
	}

	@RequestMapping(value = "/addProject", method = RequestMethod.GET)
	public ModelAndView doGetAddProject(Model model, HttpSession session) {
		if (!model.containsAttribute("project")) {
			model.addAttribute("project", new Project());
		}
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		mv.addObject("TIMENOW", date);

		mv.addObject("teacher", accountDao.getTeacherByAdmin());
		mv.addObject("groups", groupServiceImpl.getGroupAdmin());
		mv.addObject("getAllProject", projectService.getAllProject());
		mv.setViewName("/admin/addProject");
		return mv;

	}

	@RequestMapping(value = "/addProject", method = RequestMethod.POST)
	public ModelAndView add(@Valid @ModelAttribute("project") Project project, BindingResult bindingResult) {

		int groupId = project.getGroup_id();
		int countGroupId = projectService.getCountGroupId(groupId);
		System.out.println("check group  count project " + countGroupId);

		int teacherId = project.getTeacherId();
		int countTeacherId = projectService.getCountTeacherId(teacherId);
		System.out.println("check techer count project " + countTeacherId);
		if (bindingResult.hasErrors()) {
			if(bindingResult.hasFieldErrors("name")) {
				System.out.println("Name Error");
			}
			mv.addObject("project", project);
			mv.setViewName("/admin/addProject");
				
		} else {
			if (countGroupId >= 1) {

				mv.addObject("ValidationProject_Group", "The group currently has a project");

				mv.setViewName("/admin/addProject");
			} else if (countTeacherId >= 2) {

				mv.addObject("ValidationProject_Teacher", "Teachers have enough guidance groups. (biggest 4)");
				mv.setViewName("/admin/addProject");

			} else {
				projectService.addProject(project);
				mv.addObject("ValidationProject_Group", "");
				mv.addObject("ValidationProject_Teacher", "");
				return new ModelAndView("redirect:/AdminProject");
			}
		}

		return mv;

	}

	@GetMapping(value = "/editProject/{id}")
	public ModelAndView getEditProject(@PathVariable("id") int id, HttpSession session) {
		Project project = projectService.getProjectById(id);

		System.out.println("get Group Id current :" + project.getGroup_id());
		session.setAttribute("GroupIdcurrent", project.getGroup_id());

		System.out.println("Teacher id :" + project.getTeacherId());
		session.setAttribute("TeacheridCurent", project.getTeacherId());

		mv.addObject("project", projectService.getProjectById(id));
		mv.setViewName("/admin/editProject");

		mv.addObject("groups", groupServiceImpl.getGroupAdmin());
		mv.addObject("teacher", accountDao.getTeacherByAdmin());
		return mv;

	}

	@PostMapping(value = "/editProject")
	public ModelAndView edit(@Valid @ModelAttribute("project") Project project, BindingResult bindingResult,
			HttpSession session,	RedirectAttributes redirectAttributes , Model model  ) {
		int groupId = project.getGroup_id();
		int countGroupId = projectService.getCountGroupId(groupId);

		int teacherId = project.getTeacherId();
		int countTeacherId = projectService.getCountTeacherId(teacherId);

		System.out.println("count Teacher havce project " + countTeacherId);

		int countTeacherHaveProject = projectDao.getCountTeacherId(project.getTeacherId());
		System.out.println("countTeacherHaveProject " + countTeacherHaveProject);

		System.out.println("teacher id new edit " + project.getTeacherId());

		Object GroupIdcurrent = session.getAttribute("GroupIdcurrent");
		String GroupidCompare = GroupIdcurrent.toString();
		String groupIdEdit = String.valueOf(project.getGroup_id());

		Object TeacherIdcurrent = session.getAttribute("TeacheridCurent");
		String TeacherIdCompare = TeacherIdcurrent.toString();
		String TeacherIdEdit = String.valueOf(project.getTeacherId());

		System.out.println(TeacherIdCompare.equals(TeacherIdEdit));
		
		if (bindingResult.hasErrors()) {

			mv.setViewName("/admin/editProject");
		} else {
			if (countGroupId >= 1 && !GroupidCompare.equals(groupIdEdit)) {
				redirectAttributes.addFlashAttribute("errorGroup", "Group has been project!");
				return new ModelAndView("redirect:/editProject/" + project.getId());
			}

			else if (countTeacherId >= 1 && !TeacherIdCompare.equals(TeacherIdEdit)) {
				/* redirAttr.addFlashAttribute("message", "File Type Not Valid"); */
				redirectAttributes.addFlashAttribute("errorTeacher", "Teacher has been group!");
				return new ModelAndView("redirect:/editProject/" + project.getId());

			} else if (countTeacherHaveProject >= 1 && TeacherIdCompare.equals(TeacherIdEdit)) {
				projectService.editProject(project.getId(), project);
				return new ModelAndView("redirect:/AdminProject");
			}

			else if (countGroupId >= 1 && GroupidCompare.equals(groupIdEdit)) {

				mv.addObject("ValidationProject_Group", "");
				projectService.editProject(project.getId(), project);
				return new ModelAndView("redirect:/AdminProject");
			} else {
				projectService.editProject(project.getId(), project);
				mv.addObject("ValidationProject_Group", "");
				return new ModelAndView("redirect:/AdminProject");
			}
		}

		return mv;

	}

	@RequestMapping(value = { "/deleteProject/{id}" })
	public ModelAndView DeleteReport(@PathVariable int id) {
		int result = projectService.deleteProject(id);

		if (result > 0) {
			System.out.println("thanh cong");
			projectService.deleteProject(id);
		}
		return new ModelAndView("redirect:/AdminProject");
	}

	@RequestMapping(value = "/studentProject")
	public ModelAndView getProject(HttpSession session) {
		if(authorityValid.authorityWithLogin(session, "student","studentProject") == false) {
			mv.setViewName("errorPage");
			return mv;
		}
		Account student = (Account) session.getAttribute("InforAccount");
		Project project = projectService.getProjectByGroupId(student.getGroup_id());
		Account teacher = accountService.getAccountById(project.getTeacherId());
		mv.addObject("project", project);
		mv.addObject("teacher", teacher);
		mv.setViewName("user/student/studentProject");
		return mv;
	}
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
}
