package MotoPartsShop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperBills implements RowMapper<Bills>{
	public Bills mapRow(ResultSet rs, int rowNum) throws SQLException {
		Bills bills = new Bills();
		bills.setId(rs.getInt("id"));
		bills.setUser(rs.getString("user"));
		bills.setPhone(rs.getString("phone"));
		bills.setDisplay_name(rs.getString("display_name"));
		bills.setAddress(rs.getString("address"));
		bills.setTotal(rs.getDouble("total"));
		bills.setQuanty(rs.getInt("quanty"));
		bills.setNote(rs.getString("note"));
		return bills;
	}
}
