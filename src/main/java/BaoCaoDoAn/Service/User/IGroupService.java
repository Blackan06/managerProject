package BaoCaoDoAn.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Entity.Group;
import BaoCaoDoAn.Entity.Project;
@Service
public interface IGroupService {
	@Autowired
	public List<Group> getGroupAdmin();
	@Autowired
	public Account getGroupID(int accountId);
	
	@Autowired
	public List<Account> GetDataGroup(int id);
	@Autowired
	public int updateAccountInGroup(Account account);
	@Autowired
	public int addGroup(Group group);
	@Autowired
	public void deleteGroup(int id);
	@Autowired
	public List<Account> getStudent();
	@Autowired
	public Group findGroupById(int id);
	@Autowired
	public int updateGroup(Group group);
}
