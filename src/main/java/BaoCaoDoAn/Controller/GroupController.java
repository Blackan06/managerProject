package BaoCaoDoAn.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import BaoCaoDoAn.Dao.GroupDAO;
import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Entity.Group;
import BaoCaoDoAn.Entity.Project;
import BaoCaoDoAn.Service.User.Impl.GroupServiceImpl;

@Controller
public class GroupController {
	@Autowired
	GroupServiceImpl groupServiceImpl;
	@Autowired
	GroupDAO groupDAO;

	private ModelAndView mv = new ModelAndView();
//	@RequestMapping(value = {"/", "/group"})
//	public ModelAndView Login() {
//		mv.setViewName("/group");
//		return mv ;
//	}

	@RequestMapping(value = "/studentGroup")
	public ModelAndView StudentGroup() {

		mv.setViewName("user/student/studentGroup");

		return mv;
	}

	@RequestMapping(value = "/teacherGroup/{id}")
	public ModelAndView TeacherGroup(@PathVariable int id) {

		mv.setViewName("user/teacherGroup");
		mv.addObject("TeacherGroup", groupDAO.FindGroupID(id));
		return mv;
	}

	@RequestMapping(value = "/group/{id}")
	public ModelAndView group(@PathVariable int id) {
		List<Account> list = new ArrayList<Account>();
		list = groupServiceImpl.GetDataGroup(id);

		if (!list.isEmpty()) {
			mv.setViewName("/admin/adminMemberGroup");
			mv.addObject("Group2", groupServiceImpl.GetDataGroup(id));
		} else if (list.isEmpty()) {

			mv.addObject("statusGroupOfStudent", "List group  is empty");

			return new ModelAndView("redirect:/ListGroup");

		}

		return mv;
	}

	@RequestMapping(value = { "/teacherGroupByteacher_id" })
	public ModelAndView TeacherGroupByTeacher_idInProject(HttpSession session) {
		Account teacher = (Account) session.getAttribute("InforAccount");
		List<Group> result = groupDAO.getGroupByProjectAndAccount(teacher.getId());
		for (Group group2 : result) {
			List<Account> list = groupDAO.getStudentInGroup(group2.getId());
			group2.setAccount(list);

		}
		mv.addObject("teacherGroup", result);

		mv.setViewName("user/teacher/teacherGroup");
		return mv;
	}

	@RequestMapping(value = { "/studentGroupByteacher_id" })
	public ModelAndView StudentGroupByTeacher_idInProject(HttpSession session) {
		Account student = (Account) session.getAttribute("InforAccount");
		List<Account> list = groupDAO.getStudentInGroupCach2(student.getGroup_id());
		List<Account> listaccount = groupDAO.GetGroup(student.getGroup_id());
		List<Group> listgroup = groupDAO.getStudentInGroupCach3(student.getGroup_id());

		mv.addObject("teacherNameInGroup", list);
		mv.addObject("studentGroup", listaccount);
		mv.addObject("getNameGroup", listgroup);
		mv.setViewName("user/student/studentGroup");
		return mv;
	}

	@RequestMapping(value = "/Project/{id}")
	public ModelAndView group(@PathVariable int id, Project project) {
		mv.setViewName("/admin/adminGroup_viewProject");
		List<Project> list = new ArrayList<Project>();
		Project projectTemp = groupServiceImpl.GetProjectByGroupID(id);

		System.out.println(projectTemp);
		if (projectTemp == null) {
			System.out.println("FAIL PRoject" + projectTemp);
			mv.addObject("statusGroupOfStudent", "Group has not project ");
			return new ModelAndView("redirect:/ListGroup");

		} else {
			System.out.println("FAIL PRoject" + projectTemp);
			list.add(projectTemp);

			mv.setViewName("/admin/adminGroup_viewProject");
			mv.addObject("getAllProject", groupServiceImpl.GetProjectByGroupID(id));

			mv.addObject("getAllProject", projectTemp);
		}

		return mv;
	}

	@RequestMapping(value = "/tags")
	public ModelAndView group() {
		List<Group> list1 = new ArrayList<Group>();
		list1 = groupServiceImpl.getGroupAdmin();

		if (list1 != null) {
			mv.setViewName("/admin/admin2");
			mv.addObject("groups", groupServiceImpl.getGroupAdmin());
		} else {
			mv.addObject("groups", "that bai");
		}

		return mv;

	}

	@RequestMapping(value = "/ListGroup")
	public ModelAndView listGroup() {
		List<Group> list1 = new ArrayList<Group>();
		list1 = groupServiceImpl.getGroupAdmin();

		if (list1 != null) {
			List<Account> list = new ArrayList<Account>();
			list = groupServiceImpl.getStudent();
			mv.setViewName("/admin/admingroup");
			mv.addObject("group4", groupServiceImpl.getGroupAdmin());
			mv.addObject("group3", groupServiceImpl.getStudent());
		} else {
			mv.addObject("group4", "that bai");
		}

		return mv;
	}

	@RequestMapping(value = "/editAccount", method = RequestMethod.GET)
	public ModelAndView editAdmin(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Account account = groupServiceImpl.getGroupID(id);

		ModelAndView model = new ModelAndView("/user/editGroup");

		model.addObject("group3", account);

		return model;
	}

	@RequestMapping(value = "/addAccountInGroup", method = RequestMethod.GET)
	public String doGetAddUser(Model model) {
		if (!model.containsAttribute("group3")) {
			model.addAttribute("group3", new Account());
		}
		return "/user/editGroup";
	}

	@RequestMapping(value = "/addAccountInGroup", method = RequestMethod.POST)
	public String doPostAddUser(@Valid @ModelAttribute("group3") Account account, BindingResult result) {

		if (result.hasErrors()) {
			return "/user/editGroup";
		}
		if (account.getGroup_id() > 0) {
			groupServiceImpl.updateAccountInGroup(account);
		} else {
			groupServiceImpl.updateAccountInGroup(account);
		}

		return "redirect:/ListGroup";

	}

	@RequestMapping(value = "/deleteGroup/{id}", method = RequestMethod.GET)
	public String deleteGroup(@PathVariable("id") int id) {
		groupServiceImpl.deleteGroup(id);
		return "redirect:/ListGroup";
	}

	@RequestMapping(value = "/addGroup", method = RequestMethod.GET)
	public ModelAndView doGetAddGroup(Model model, HttpSession session) {

		mv.addObject("group4", new Group());
		mv.addObject("error","");

		mv.setViewName("/admin/adminAddGroup");
		List<Group> nameGroupAdd = new ArrayList<Group>();
		nameGroupAdd = groupDAO.getGroupAdmin();
		for (Group group2 : nameGroupAdd) {
			String name = group2.getName();
			System.out.println("name group in database : " + name);

			session.setAttribute("groupNameADDCurrent", name);

		}
		return mv;
	}

	@RequestMapping(value = "/addGroup", method = RequestMethod.POST)
	public ModelAndView doPostAddGroup(@Valid @ModelAttribute("group4") Group group, BindingResult result,
			HttpSession session) {


		String GroupNameAdd = group.getName();
		System.out.println("GroupNameAdd " + GroupNameAdd);

		if (result.hasErrors()) {
			mv.addObject("error","Name must not empty or duplicate");

			mv.setViewName("/admin/adminAddGroup");
		} else {
			List<Group> listGroup = new ArrayList<Group>();
			listGroup = groupDAO.getGroupAdmin();
			Boolean flag = true;
			for (Group group2 : listGroup) {
				String name = group2.getName();

				if (GroupNameAdd.equals(name)) {
					flag = false;
					System.out.println(flag);
					mv.setViewName("/admin/adminAddGroup");
					return mv;

				}

			}
			groupServiceImpl.addGroup(group);
			return new ModelAndView("redirect:/ListGroup");
		}

		return mv;
	}

	@RequestMapping(value = "/editGroup", method = RequestMethod.POST)
	public ModelAndView editGroup(@Valid @ModelAttribute("group4") Group group, BindingResult result,
			HttpSession session) {
		int countGroupName = groupDAO.CountGroupNameAdmin(group.getName());
		System.out.println("count GroupName :" + countGroupName);

		Object groupNameCurrent = session.getAttribute("groupNameCurrent");
		String GroupNameCompare = groupNameCurrent.toString().trim();
		System.out.println("GroupNameCompare " + GroupNameCompare);

		String GroupNameEdit = group.getName().trim();
		System.out.println("GroupNameEdit " + GroupNameEdit);

		System.out.println("-------------------------");
		if (result.hasErrors()) {
			mv.addObject("error","Name must not empty or duplicate");
			mv.setViewName("/admin/adminEditGroup");
		} else {

			if (countGroupName >= 1 && GroupNameCompare.equalsIgnoreCase(GroupNameEdit)) {
//					mv.setViewName("/admin/adminAddGroup");
				groupServiceImpl.updateGroup(group);
				return new ModelAndView("redirect:/ListGroup");
			} else if (countGroupName == 0 && !GroupNameCompare.equalsIgnoreCase(GroupNameEdit)) {
				groupServiceImpl.updateGroup(group);
				return new ModelAndView("redirect:/ListGroup");
			}

		}

		return mv;
	}

	@GetMapping(value = "/editgroup/{id}")
	public ModelAndView editGroup(@PathVariable("id") int id, HttpSession session) {

		Group group = groupServiceImpl.findGroupById(id);

//		int countGroupName = groupDAO.CountGroupNameAdmin(group.getName());
//		System.out.println("number  group in database " + countGroupName);

		List<Group> nameGroup = new ArrayList<Group>();
		nameGroup = groupDAO.GetGroup_Name(id);
		for (Group group2 : nameGroup) {
			String name = group2.getName();
			System.out.println("name group in form : " + name);

			session.setAttribute("groupNameCurrent", name);

		}

		mv.setViewName("/admin/adminEditGroup");
		mv.addObject("error","");

		mv.addObject("group4", group);

		return mv;
	}

}