package BaoCaoDoAn.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Entity.Group;
import BaoCaoDoAn.Entity.MapperAccount;
import BaoCaoDoAn.Entity.MapperGroup;

@Repository
public class GroupDAO {
	@Autowired
	JdbcTemplate _jdbcTemplate;

	public List<Account> getStudent() {
		List<Account> list = new ArrayList<Account>();
		String sql = "SELECT * FROM account Where role = 'student' ORDER BY group_id";
		list = _jdbcTemplate.query(sql, new MapperAccount());
		return list;
	}

	public List<Account> getStudentInGroup(int id) {
		List<Account> list = new ArrayList<Account>();
		String sql = "SELECT * FROM account where role = 'student' AND group_id =" + id;
		list = _jdbcTemplate.query(sql, new MapperAccount());
		return list;
	}

	public List<Group> getGroupByProjectAndAccount(int id) {
		List<Group> list = new ArrayList<Group>();
		String sql = "SELECT * FROM  group_student AS grs ,account AS ac ,  project AS pr WHERE grs.id = pr.group_id AND ac.id = pr.teacher_id AND pr.teacher_id  = "
				+ id;
		list = _jdbcTemplate.query(sql, new MapperGroup());
		return list;
	}

	public List<Account> getStudentInGroupCach2(int group_id) {
		List<Account> list = new ArrayList<Account>();
		String sql = "SELECT * FROM group_student AS grs, account AS ac , project AS pr WHERE grs.id = pr.group_id AND ac.id = pr.teacher_id AND pr.group_id ="
				+ group_id;
		list = _jdbcTemplate.query(sql, new MapperAccount());
		return list;
	}

	public List<Group> getStudentInGroupCach3(int group_id) {
		List<Group> list = new ArrayList<Group>();
		String sql = "SELECT * FROM baocaodoan.group_student AS grs, account AS ac , project AS pr WHERE grs.id = pr.group_id AND ac.id = pr.teacher_id AND pr.group_id ="
				+ group_id;
		list = _jdbcTemplate.query(sql, new MapperGroup());
		return list;
	}

	public List<Account> GetGroup(int id) {
		List<Account> list = new ArrayList<Account>();
		String sql = "SELECT * FROM account where group_id = " + id;
		list = _jdbcTemplate.query(sql, new MapperAccount());
		return list;
	}

	public List<Group> getGroupAdmin() {
		List<Group> listGroup = new ArrayList<Group>();
		String sql = "SELECT * FROM `group_student` ";
		listGroup = _jdbcTemplate.query(sql, new MapperGroup());
		return listGroup;
	}

	public int addAccountInGroup(Group group) {
		String sql = "INSERT INTO group_student (`id`, `group_name`) VALUES (?,?)";
		int count = _jdbcTemplate.update(sql, new Object[] { group.getId(), group.getName() });
		return count;
	}

	public int updateGroup(Group group) {
		String sql = "UPDATE group_student SET `group_name`=? WHERE id=?";
		int count = _jdbcTemplate.update(sql, group.getName(), group.getId());
		return count;
	}

	public int updateGroupInAccount(Account accout_group) {
		String sql = "UPDATE account SET group_id=? WHERE id=?";
		int count = _jdbcTemplate.update(sql, accout_group.getGroup_id(), accout_group.getId());
		return count;
	}

	public Account get(int accountId) {
		String sql = "SELECT * FROM account WHERE id=" + accountId;
		Account result = _jdbcTemplate.queryForObject(sql, new MapperAccount());
		return result;
	}

	public Group FindGroupID(int groupID) {
		String sql = "SELECT * FROM group_student WHERE id = " + groupID;
		Group result = _jdbcTemplate.queryForObject(sql, new MapperGroup());
		return result;
	}

	// delete
	public void delete(int id) {
		String sql = "DELETE FROM group_student WHERE id=?";
		_jdbcTemplate.update(sql, id);
	}

	public Group getGroupByProjectId(int projectId) {
		String sql = "SELECT g.id,g.group_name\r\n" + "FROM group_student as g,project as p \r\n"
				+ "WHERE  g.id=p.group_id AND p.id=" + projectId;
		Group result = _jdbcTemplate.queryForObject(sql, new MapperGroup());
		return result;
	}

	public Group getGroupByAccountId(int accountId) {
		String sql = "SELECT g.*" + "FROM account as a, group_student as g\r\n" + "WHERE a.id ="
				+ accountId + " and a.group_id = g.id;";
		Group result = _jdbcTemplate.queryForObject(sql, new MapperGroup());
		return result;
	}
	public List<Group> CheckName(String name) {
		List<Group> listGroup = new ArrayList<Group>();
		String sql  = "Select * From 'group_student' Where 'group_name' = " + name;
		listGroup = _jdbcTemplate.query(sql, new MapperGroup());
		return listGroup;
	}
}
