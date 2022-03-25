package BaoCaoDoAn.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import BaoCaoDoAn.Dao.AccountDAO;
import BaoCaoDoAn.Dao.StudentDAO;
import BaoCaoDoAn.Dto.AccountSearchCondition;
import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Service.User.Impl.GroupServiceImpl;
import BaoCaoDoAn.Service.User.Impl.StudentServiceImpl;

@Controller
public class StudentController {
	@Autowired
	StudentServiceImpl studentService;

	@Autowired
	GroupServiceImpl groupServiceImpl;

	@Autowired
	AccountDAO accountDao;

	@Autowired
	StudentDAO studentDao;

	private ModelAndView mv = new ModelAndView();

	@RequestMapping(value = "/studentList", method = RequestMethod.GET)
	public ModelAndView studentListAll(HttpServletRequest request) {
		List<Account> list = new ArrayList<Account>();
		list = studentService.getAccountList();
		mv.addObject("studentList", studentService.getAccountList());
		mv.addObject("accountSearch", new Account());
		mv.setViewName("/admin/studentAccount");
		/*
		 * mv.addObject("newAccount", new Account());
		 */
		return mv;
	}

	@RequestMapping(value = "/studentListByCondition", method = RequestMethod.GET)
	public ModelAndView studentListByCondition(HttpServletRequest request) {
		AccountSearchCondition condition = new AccountSearchCondition();
		String role = request.getParameter("role");
		condition.setRole(role);
		String name = request.getParameter("name");
		condition.setName(name);

		mv.addObject("studentList", studentService.getAccountListByCondition(condition));
		mv.setViewName("admin/studentAccount");

		return mv;
	}

	@RequestMapping(value = "/editStudentAccount", method = RequestMethod.GET)
	public ModelAndView editAdmin(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Account account = studentService.getAccountId(id);

		ModelAndView model = new ModelAndView("/admin/editAccount");

		model.addObject("roleAccount", accountDao.getTeacherAdmin());

		model.addObject("studentAcc1", account);
		model.addObject("leader", accountDao.getLeaderStudentAdmin());
		model.addObject("groups", groupServiceImpl.getGroupAdmin());
		List<String> listRole = new ArrayList<String>();
		listRole.add("teacher");
		listRole.add("student");
		model.addObject("listRole", listRole);

		List<String> listLeader = new ArrayList<String>();
		listLeader.add("true");
		listLeader.add("false");
		model.addObject("listLeader", listLeader);

		List<String> listGener = new ArrayList<String>();
		listGener.add("Male");
		listGener.add("Female");
		model.addObject("listGener", listGener);
		return model;
	}

	@RequestMapping(value = "/deleteAccount", method = RequestMethod.GET)
	public String deleteAccount(@RequestParam Integer id) {
		studentService.deleteAccount(id);
		return "redirect:/studentList";
	}

	@RequestMapping(value = "/addAccountStudent", method = RequestMethod.GET)
	public ModelAndView doGetAddUser(Model model, HttpSession session) {
		if (!model.containsAttribute("studentAcc1")) {
			model.addAttribute("studentAcc1", new Account());
		}
		mv.setViewName("/admin/addAccount");
		mv.addObject("roleAccount", accountDao.getTeacherAdmin());
		mv.addObject("leader", accountDao.getLeaderStudentAdmin());
		mv.addObject("groups", groupServiceImpl.getGroupAdmin());
		mv.addObject("getAllStudent", studentService.getAccountList());
		mv.addObject("emailExist", "");
		return mv;
	}

	@RequestMapping(value = "/addAccountStudent", method = RequestMethod.POST)
	public ModelAndView doPostAddGroup(@Valid @ModelAttribute("studentAcc1") Account account, BindingResult result) {
		int isEmailExist = studentService.isEmailExist(account.getMail());
		mv.addObject("groups", groupServiceImpl.getGroupAdmin());
		mv.addObject("emailExist", "");
		int checkleader = studentDao.checkLeader(true, account.getGroup_id());
		int group_id = studentDao.checkgroup_id(account.getGroup_id());
		int checkTeacher = studentDao.checkTeacher(account.getRole(), account.getGroup_id());

		System.out.println(" memeber group" + group_id);

		if (result.hasErrors()) {
			mv.setViewName("/admin/addAccount");
		} else {
			if (account.getId() == 0) {

				if (isEmailExist >= 1) {
					mv.addObject("errormail", "email has been already exists!");
					if (group_id >= 5) {
						mv.addObject("errorGroup", "group full memmember!");
						if (checkTeacher >= 1 && account.getRole().equals("teacher")) {
							mv.addObject("errorTecher", "techer full group!");

							if (checkleader >= 1 && account.getIsLeader() == true) {
								mv.addObject("errorleader", "leader full group!");
							}
						}
					}

					
					return new ModelAndView("redirect:/addAccountStudent");
				}

				else if (isEmailExist <= 0 && group_id < 5 && checkTeacher >= 1 && account.getRole().equals("student")
						&& checkleader >= 1 && account.getIsLeader() == false) {
					studentService.addAccount(account);

					return new ModelAndView("redirect:/studentList");
				}
			//Edit
			} else if (account.getId() > 0) {
				if (isEmailExist > 1) {

					if (group_id > 5) {
						mv.addObject("errorGroup", "group full memmember!");
						if (checkTeacher >= 1 && account.getRole().equals("teacher")) {
							mv.addObject("errorTecher", "techer full group!");

							if (checkleader >= 1 && account.getIsLeader() == true) {
								mv.addObject("errorleader", "leader full group!");
							}
						}
					}

					return new ModelAndView("redirect:/editStudentAccount?id="+account.getId());
				}

				else if (isEmailExist <= 1 && group_id <= 5 && checkTeacher >= 1 && account.getRole().equals("student")
						&& checkleader >= 1 && account.getIsLeader() == false) {
					studentService.updateAccount(account);

					return new ModelAndView("redirect:/studentList");
				}

			}
		}
		return mv;

	}

	@RequestMapping(value = "/searchAcc", method = RequestMethod.POST)
	public ModelAndView searchByName(@ModelAttribute("accountSearch") Account account) {
		List<Account> list = new ArrayList<Account>();
		list = studentService.findAccountByName(account.getName());

		System.out.println(list);
		if (list.isEmpty()) {
			mv.addObject("getAllStudent", studentService.getAccountList());
			mv.setViewName("/admin/studentAccount");
		} else {

			mv.setViewName("/admin/resultSearch");
			mv.addObject("resultSearch", list);
		}
		return mv;
	}

//	@RequestMapping(value = "/userSearch", method = RequestMethod.POST)
//	public String searchAction(@ModelAttribute Account account, BindingResult result, @RequestParam String action, ModelMap model ) {
//		String work = action.toLowerCase().toString();
//		if (work.equals("search") && !account.getName().equals("")) {
//            model.put("userList", studentService.SearchAcc(account.getName()));
//        } else {
//            model.put("userList", studentService.SearchAcc(null));
//        }
//		return "studentAccount";
//	}

}
