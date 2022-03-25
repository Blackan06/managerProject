package BaoCaoDoAn.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperAccount implements RowMapper<Account> {

	public Account mapRow(ResultSet rs, int rowNum) {
		Account acc = new Account();
		try {
			acc.setId(rs.getInt("id"));

			acc.setName(rs.getString("account_name"));
			acc.setPassword(rs.getString("password"));
			acc.setMail(rs.getString("mail"));
			acc.setPhone(rs.getString("phone"));
			acc.setRole(rs.getString("role"));
			acc.setGroup_id(rs.getInt("group_id"));
			acc.setIsLeader(rs.getBoolean("isLeader"));
			acc.setGender(rs.getString("gender"));

			if (rs.getString("group_name") != null) {
				acc.setGroup_name(rs.getString("group_name"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return acc;
	}

}