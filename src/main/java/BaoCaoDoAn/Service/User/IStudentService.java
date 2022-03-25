package BaoCaoDoAn.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BaoCaoDoAn.Dto.AccountSearchCondition;
import BaoCaoDoAn.Entity.Account;

@Service
public interface IStudentService {
	@Autowired
	public Account getStudentByAccount(Account account);

	@Autowired
	public List<Account> getAccountListByCondition(AccountSearchCondition condition);
}
