package MotoPartsShop.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import MotoPartsShop.Entity.Categorys;
import MotoPartsShop.Entity.MapperCategorys;

@Repository
public class CategorysDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;

	public List<Categorys> GetDataCategorys() {
		List<Categorys> list = new ArrayList<Categorys>();
		String sql = "SELECT * FROM motopartsshop.categories;";
		list = _jdbcTemplate.query(sql, new MapperCategorys());
		return list;
	}
}
