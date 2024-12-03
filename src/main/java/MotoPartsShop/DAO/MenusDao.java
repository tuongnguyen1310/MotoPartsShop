package MotoPartsShop.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import MotoPartsShop.Entity.MapperMenus;
import MotoPartsShop.Entity.Menus;

@Repository
public class MenusDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	
	public List<Menus> GetDataMenus(){
		List<Menus> list = new ArrayList<Menus>();
		String sql = "SELECT * FROM motopartsshop.menu;";
		list = _jdbcTemplate.query(sql, new MapperMenus());
		return list;
	} 
}
