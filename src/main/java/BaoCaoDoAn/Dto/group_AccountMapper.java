package BaoCaoDoAn.Dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class group_AccountMapper  implements RowMapper<group_Account>{



	public group_Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		group_Account admin = new group_Account();
		admin.setAccountName(rs.getString("name"));
		admin.setGroupName(rs.getString("name"));
		return admin;
	}
	}