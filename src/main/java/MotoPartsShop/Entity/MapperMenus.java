package MotoPartsShop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperMenus implements RowMapper<Menus>{

	public Menus mapRow(ResultSet rs, int rowNum) throws SQLException {
		Menus menu = new Menus();
		menu.setId(rs.getInt("id"));
		menu.setName(rs.getString("name"));
		menu.setUrl(rs.getString("url"));
		return menu;
	}
	
}
