package BaoCaoDoAn.Service.User;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import BaoCaoDoAn.Entity.Account;

@Service
public interface IAccountService {
	
	
		@Autowired
		public Account CheckAccount(Account account) ;
		
		@Autowired
		public int AddAccount(Account account);
		
		@Autowired
		public Account getAccountById(int accId);
		
		@Autowired
		public List<Account> getAccountByGroupId(int groupId);
}
