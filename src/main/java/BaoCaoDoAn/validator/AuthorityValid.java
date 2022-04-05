package BaoCaoDoAn.validator;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import BaoCaoDoAn.Entity.Account;
@Component
public class AuthorityValid {
	public boolean authorityWithoutLogin(HttpSession session,String requestMappingName) {
		Account account = (Account) session.getAttribute("InforAccount");
		System.out.println("ACCOUNT==NULL"+account);
		boolean result = true;
		 if(account!=null) {
			result = false;
		}
		return result;
	}
	public boolean authorityWithLogin(HttpSession session, String role,String requestMappingName) {
		Account account = (Account) session.getAttribute("InforAccount");
		boolean result = false;
		if (account != null) {
			if(account.getRole().equalsIgnoreCase(role)) {
				result = true;
			}
		}
		return result;
	}
}
