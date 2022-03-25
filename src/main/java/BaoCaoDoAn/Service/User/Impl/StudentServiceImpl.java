package BaoCaoDoAn.Service.User.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BaoCaoDoAn.Dao.StudentDAO;
import BaoCaoDoAn.Dto.AccountSearchCondition;
import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Entity.Group;
import BaoCaoDoAn.Service.User.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentDAO studentDao;

	public Account getStudentByAccount(Account account) {
		return studentDao.GetStudentByAccount(account);
	}

	public List<Account> getAccountListByCondition(AccountSearchCondition condition) {

		return studentDao.getAccountListByCondition(condition);
	}
	
	public List<Account> getAccountList() {
		return studentDao.getStudentList();
	}
	
	public void deleteAccount(int id) {
		studentDao.delete(id);
	}
	
	public List<Account> findAccountByName(String name) {
		return studentDao.FindAccountbyaccount_name(name);
	}
	public List<Account> SearchAcc(String name) {
		return studentDao.listAcc(name);
	}
	
	public int addAccount(Account account) {
		return studentDao.addAccountStudent(account);
	}
	
	public int updateAccount(Account account) {
		return studentDao.updateStudentAccount(account);
	}
	
	public Account getAccountId(int id) {
		return studentDao.get(id);
		
	}
	
	public Group findGroupById(String name) {
		return studentDao.FindAccountaccount_name(name);
	}
	
	public Account getGroupIdByAccount(int id) {
		return studentDao.getAccountByGroupId(id);
	}
	
	public int isEmailExist(String email) {
		return studentDao.isEmailExist(email);
	}
	
}
