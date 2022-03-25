package BaoCaoDoAn.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import BaoCaoDoAn.Dto.AccountSearchCondition;
import BaoCaoDoAn.Entity.Account;
import BaoCaoDoAn.Entity.Group;
import BaoCaoDoAn.Entity.MapperAccount;
import BaoCaoDoAn.Entity.MapperGroup;
import BaoCaoDoAn.Entity.MapperProject;
import BaoCaoDoAn.Entity.Project;

@Repository
public class StudentDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	JdbcTemplate _jdbcTemplate;

	// Student List
	public List<Account> getStudentByAccount(Account account) {
		List<Account> list = new ArrayList<Account>();
		String sql = "SELECT * FROM account WHERE role=" + account.getRole();
		list = jdbcTemplate.query(sql, new MapperAccount());
		return list;
	}

	public Account GetStudentByAccount(Account account) {
		try {

			System.out.println(account.getMail());
			System.out.println(account.getPassword());
			String sql = "SELECT * FROM `account` WHERE role LIKE 'student' " + account.getRole();

			Account result = jdbcTemplate.queryForObject(sql, new MapperAccount());
			if (result != null) {
				return result;
			}
		} catch (EmptyResultDataAccessException e) {

			return null;
		}
		return null;
	}

	public List<Account> getAccountListByCondition(AccountSearchCondition condition) {
		List<Account> list = new ArrayList<Account>();

		String sql = "SELECT * FROM account ";
		String strCondition = "";
		if (condition != null) {
			sql += "Where ";
			if (condition.getRole() != null) {
				strCondition += " role = '" + condition.getRole() + "'";
			}
			if (strCondition != "") {
				strCondition += " AND ";
			}
			if (condition.getNamne() != null) {
				strCondition += " account_name like '" + condition.getNamne() + "%'";
			}
			sql += strCondition;
		}

		list = jdbcTemplate.query(sql, new MapperAccount());
		return list;
	}

	// student list by account
	public List<Account> getStudentList() {
		List<Account> list = new ArrayList<Account>();
//		String sql = "SELECT * FROM account WHERE role= 'student'";
		String sql = "SELECT * FROM account INNER JOIN group_student ON account.group_id = group_student.id order by group_id asc ";
		list = jdbcTemplate.query(sql, new MapperAccount());
		return list;
	}

	public void delete(int id) {
		String sql = " DELETE FROM `account` WHERE id=? ";
		_jdbcTemplate.update(sql, id);
	}

//	public int updateAccount(Account account) {
//		String sql = "UPDATE `account` SET `account_name`=?, `group_id`=?, `phone=`?, `isLeader`=?, `gender`=? WHERE id=?";
//		int count = _jdbcTemplate.update(sql, group.getName(), group.getId());
//		return count;
//	}

	public List<Account> FindAccountbyaccount_name(String name) {
		List<Account> list = new ArrayList<Account>();
		String sql = "SELECT * FROM `account` WHERE not role='admin' and account_name like '%" + name + "%' ";
		list = jdbcTemplate.query(sql, new MapperAccount());
		return list;
	}

	public List<Account> listAcc(String name) {
		String SQL = "select * from account where account_name like ?";
		List<Account> accounts = jdbcTemplate.query(SQL, new Object[] { "%" + name + "%" }, new MapperAccount());
		return accounts;
	}

	public int addAccountStudent(Account account) {
		String sql = " INSERT INTO `account` (`id`, `account_name`, `mail`, `password`, `group_id`, `phone`, `role`, `isLeader`, `gender`) VALUES (?,?,?,?,?,?,?,?,?)";

		int count = _jdbcTemplate.update(sql,
				new Object[] { account.getId(), account.getName(), account.getMail(), account.getPassword(),
						account.getGroup_id(), account.getPhone(), account.getRole(), account.getIsLeader(),
						account.getGender() });
		return count;
	}

	public int updateStudentAccount(Account account) {
		String sql = " UPDATE `account` SET `account_name` = ? , `mail` = ? , `password` = ? ,`group_id` = ? , `phone` = ? , `role` = ? , `isLeader` = ? , `gender` = ? WHERE id = ?";
		int count = _jdbcTemplate.update(sql, account.getName(), account.getMail(), account.getPassword(),
				account.getGroup_id(), account.getPhone(), account.getRole(), account.getIsLeader(),
				account.getGender(), account.getId());
		return count;
	}

	public Account get(int id) {

		String sql = "SELECT * FROM account WHERE id=" + id;
		Account result = _jdbcTemplate.queryForObject(sql, new MapperAccount());

		return result;

	}

	public Group FindAccountaccount_name(String name) {
		String sql = "SELECT * FROM `account` WHERE account_name LIKE \"?%\" " + name;
		Group result = _jdbcTemplate.queryForObject(sql, new MapperGroup());
		return result;
	}

	public Account getAccountByGroupId(int id) {
		try {
			Account account;
			String sql = "SELECT * FROM account where group_id = " + id;
			account = jdbcTemplate.queryForObject(sql, new MapperAccount());
			if (account != null) {
				return account;
			}
		} catch (EmptyResultDataAccessException e) {

			return null;
		}
		return null;

	}

	public int isEmailExist(String email) {
		int result = -1;
		String sql = "SELECT COUNT(mail) FROM `account` WHERE mail = '" + email + "'";
		result = jdbcTemplate.queryForObject(sql, Integer.class);
		return result;
	}

	public int checkLeader(Boolean leader, int id) {
		int result = -1;
		String sql = "SELECT COUNT(*) FROM `account` WHERE isLeader = " + true + " And group_id = '" + id + "'";
		result = jdbcTemplate.queryForObject(sql, Integer.class);
		return result;
	}

	public int checkgroup_id(int groupId) {
		int result = -1;
		String sql = "SELECT COUNT(*) FROM account WHERE group_id = " + groupId + "";
		result = jdbcTemplate.queryForObject(sql, Integer.class);
		return result;
	}

	public int checkTeacher(String role, int id) {
		int result = -1;
		String sql = "SELECT COUNT(*) FROM `account` WHERE role = 'teacher' And group_id = " + id + " ";
		result = jdbcTemplate.queryForObject(sql, Integer.class);
		return result;
	}
}
