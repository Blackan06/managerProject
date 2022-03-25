package BaoCaoDoAn.Service.User.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BaoCaoDoAn.Dao.GroupDAO;
import BaoCaoDoAn.Dao.ProjectDAO;
import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Entity.Group;
import BaoCaoDoAn.Entity.Project;
import BaoCaoDoAn.Service.User.IGroupService;

@Service
public class GroupServiceImpl implements IGroupService {
	@Autowired
	private GroupDAO groupdao;
	@Autowired
	private ProjectDAO projectDao;
	public List<Group> getGroupAdmin() {
		return groupdao.getGroupAdmin();
	}

	public Account getGroupID(int accountId) {
		return groupdao.get(accountId);
	}

	public List<Account> GetDataGroup(int id) {
		List<Account> list = new ArrayList<Account>();
		list = groupdao.GetGroup(id);
		if (list == null) {

			return null;
		}
		return list;
	}

	public int updateAccountInGroup(Account account) {
		return groupdao.updateGroupInAccount(account);
	}

	public int addGroup(Group group) {
		return groupdao.addAccountInGroup(group);
	}

	public List<Account> getStudent() {
		return groupdao.getStudent();
	}

	public void deleteGroup(int id) {
		groupdao.delete(id);
	}

	public Group findGroupById(int id) {
		return groupdao.FindGroupID(id);
	}

	public int updateGroup(Group group) {
		return groupdao.updateGroup(group);
	}

	public Project GetProjectByGroupID(int id) {
		return projectDao.getProjectByGroupId(id);
	}

	public Group getGroupByProjectId(int projectId) {
		return groupdao.getGroupByProjectId(projectId);
	}

	public Group getGroupByAccountId(int accountId) {
		return groupdao.getGroupByAccountId(accountId);
	}

	

}
