package BaoCaoDoAn.Service.User.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BaoCaoDoAn.Dao.AccountDAO;
import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Service.User.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService {
	@Autowired
	private AccountDAO accountDao;

	public Account CheckAccount(Account account) {
		account = accountDao.GetUserByAccount(account);

		if (account != null) {

			return account;
		} else {
			return null;
		}

	}

	public int AddAccount(Account account) {
//		account.setPassword(BCrypt.hashpw(account.getPassword(), BCrypt.gensalt(12))) ;
		String name = account.getName();
		String mail = account.getMail();
		String pass = account.getPassword();

		System.out.println("mail check " + accountDao.Checkmail());
		System.out.println("mail" + mail);
		if (name != "" && mail != "" && pass != "") {
			return accountDao.AddAccount(account);
		} else
			return 2;

	}

	public Account getAccountById(int accId) {
		// TODO Auto-generated method stub
		System.out.println("ACC-ID:"+accId);
		System.out.println(accountDao);
		return accountDao.getAccountByAccountId(accId);
	}

	public List<Account> getAccountByGroupId(int groupId) {
		List<Account> member = null;
		member = accountDao.getStudentByGroupId(groupId);
		if(member==null) {
			member= new ArrayList();
		}
		return member;
	}
}
