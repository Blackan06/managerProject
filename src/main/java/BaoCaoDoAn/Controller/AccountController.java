package BaoCaoDoAn.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import BaoCaoDoAn.Dao.AccountDAO;
import BaoCaoDoAn.Dao.ScheduleReportDAO;
import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Entity.ScheduleReport;
import BaoCaoDoAn.Service.User.IProjectService;
import BaoCaoDoAn.Service.User.Impl.AccountServiceImpl;


@SessionAttributes("user")
@Controller
public class AccountController {
	@Autowired
	AccountServiceImpl accountService;
	@Autowired
	AccountDAO accountDao;
	@Autowired
	private ScheduleReportDAO scheduleReportDAO;
	@Autowired
	private IProjectService projectService;

	private ModelAndView mv = new ModelAndView();

	 @ModelAttribute("account")
	    public Account setUpUserForm() {
	        return new Account();
	    }
	
	@RequestMapping(value = { "/", "/login" })
	public ModelAndView Login(@CookieValue(value = "setUser", defaultValue = "") String setUser, Model model) {
		Cookie cookie = new Cookie("setUser", setUser);
		
		 model.addAttribute("cookieValue", cookie);
		mv.setViewName("/loginpage");
		mv.addObject("account", new Account());
		mv.addObject("schduleReport", new ScheduleReport());
		mv.addObject("scheduleReportDAO", scheduleReportDAO.getAllScheduleReport());
		return mv;
	}

	@RequestMapping(value = "/trang-chu")
	public ModelAndView HomeTeacher(@ModelAttribute("account") Account account, HttpSession session) {
		mv.setViewName("/user/teacher");
		return mv;

	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.POST)
	public ModelAndView Login(@ModelAttribute("account") Account account, HttpSession session,
			 Model model, @CookieValue(value = "setUser", defaultValue = "") String setUser,
             HttpServletResponse response, HttpServletRequest request) {
		Account acc = accountService.CheckAccount(account);
		
		if (acc != null && acc.getRole().equals("student")) {
			session.setAttribute("InforAccount", accountDao.GetUserByAccount(account));
			mv.addObject("InforAccount", accountDao.GetUserByAccount(account));
			mv.setViewName("/user/student");
//			mv.addObject("statusLogin", "login success");
			mv.addObject("statusLogin", "");
			 setUser = account.getMail();
			  Cookie cookie = new Cookie("setUser", setUser);
			  cookie.setMaxAge(24 * 60 * 60);
	           response.addCookie(cookie);

	           //get all cookies
	           Cookie[] cookies = request.getCookies();
	           //iterate each cookie
	           for (Cookie ck : cookies) {
	               //display only the cookie with the name 'setUser'
	               if (ck.getName().equals("setUser")) {
	                   model.addAttribute("cookieValue", ck);
	                   break;
	               } else {
	                   ck.setValue("");
	                   model.addAttribute("cookieValue", ck);
	                   break;
	               }
	           }
	           model.addAttribute("message", "Login success. Welcome ");

		}
		if (acc != null && acc.getRole().equals("teacher")) {
			mv.setViewName("/user/teacher");
			session.setAttribute("InforAccount", accountDao.GetUserByAccount(account));
			mv.addObject("InforAccount", accountDao.GetUserByAccount(account));
//			mv.addObject("statusLogin", "login thanh cong");
			mv.addObject("statusLogin", "");
			 setUser = account.getMail();
			  Cookie cookie = new Cookie("setUser", setUser);
			  cookie.setMaxAge(24 * 60 * 60);
	           response.addCookie(cookie);

	           //get all cookies
	           Cookie[] cookies = request.getCookies();
	           //iterate each cookie
	           for (Cookie ck : cookies) {
	               //display only the cookie with the name 'setUser'
	               if (ck.getName().equals("setUser")) {
	                   model.addAttribute("cookieValue", ck);
	                   break;
	               } else {
	                   ck.setValue("");
	                   model.addAttribute("cookieValue", ck);
	                   break;
	               }
	           }
	           model.addAttribute("message", "Login success. Welcome ");
		}
		if (acc != null && acc.getRole().equals("admin")) {
			mv.setViewName("/admin/admin");
//			mv.addObject("statusLogin", "login thanh cong");
			mv.addObject("statusLogin", "");
			 setUser = account.getMail();
			  Cookie cookie = new Cookie("setUser", setUser);
			  cookie.setMaxAge(24 * 60 * 60);
	           response.addCookie(cookie);

	           //get all cookies
	           Cookie[] cookies = request.getCookies();
	           //iterate each cookie
	           for (Cookie ck : cookies) {
	               //display only the cookie with the name 'setUser'
	               if (ck.getName().equals("setUser")) {
	                   model.addAttribute("cookieValue", ck);
	                   break;
	               } else {
	                   ck.setValue("");
	                   model.addAttribute("cookieValue", ck);
	                   break;
	               }
	           }
	           model.addAttribute("message", "Login success. Welcome ");
		}

		else if (acc == null) {
			acc.setMail("");
            Cookie cookie = new Cookie("setUser", setUser);   
            model.addAttribute("cookieValue", cookie);

			mv.setViewName("/loginpage");
			mv.addObject("statusLogin", "login failed");
		}
		return mv;
	}

	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView DangKy() {
		mv.setViewName("/registrationpage");
		mv.addObject("account", new Account());
		return mv;
	}
	
	@RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
	public ModelAndView DangKy(@Valid @ModelAttribute("account") Account account,BindingResult result) {
		
		if(result.hasErrors()) {
			mv.setViewName("/registrationpage");
		}
		
		int count = accountService.AddAccount(account);

		

		if (count == 1) {
			mv.addObject("statusRegister", "\r\n"
					+ "Sign Up Success");
		} else if (count == 2) {
			mv.addObject("statusRegister", "registration failed");
		}
		
		mv.setViewName("/registrationpage");
		return mv;

	}

	@RequestMapping(value = "/logout")
	public ModelAndView LogOut() {
		mv.setViewName("/loginpage");
		mv.addObject("statusLogin", " ");
		return mv;
	}

	@RequestMapping(value = "/studenthome")
	public ModelAndView StudentHome() {
		mv.setViewName("/user/student");

		return mv;
	}

	@RequestMapping(value = "/searchAccount")
	public ModelAndView searchAccount() {
		mv.setViewName("/loginpage");
		mv.addObject("account", new Account());
		mv.addObject("schduleReport", new ScheduleReport());
		mv.addObject("scheduleReportDAO", scheduleReportDAO.getAllScheduleReport());
		return mv;
	}

//	@Autowired
//	private ScheduleReportServiceImpl  scheduleReportService ;
//	@RequestMapping(value =  "/dang-nhap", method = RequestMethod.POST)
//	
//	
//	public String AddScheduleReport(
//			@ModelAttribute("schduleReport") ScheduleReport schduleReport) {
//		
//		schduleReport =  scheduleReportService.AddScheduleReport(schduleReport.getId() ,(Date) schduleReport.getTimeReport(),
//				schduleReport.getAccount_id(), schduleReport.getReport_id()) ;
//		
//		
//		if(schduleReport != null) {
//			return "/user/AddSchedule" ;
//		}else {
//			mv.addObject("success" , "Add fail") ;
//		}
//		
//		return "/user/student" ;
//	
//	}

}
