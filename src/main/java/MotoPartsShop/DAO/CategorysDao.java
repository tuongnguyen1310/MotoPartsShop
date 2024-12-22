package MotoPartsShop.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import MotoPartsShop.Entity.Categorys;
import MotoPartsShop.Entity.MapperBills;
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

	public Categorys getCategoryById(int id) {
		String sql = "SELECT * FROM categories WHERE id = '" + id + "' ";
		try {
			return _jdbcTemplate.queryForObject(sql, new MapperCategorys());
		} catch (EmptyResultDataAccessException e) {
			return null; // Trả về null nếu không tìm thấy người dùng
		}
		
	}

	public void saveCategory(Categorys category) {
		
		String checkSql = "SELECT COUNT(*) FROM categories WHERE id = ?";
		int count = _jdbcTemplate.queryForObject(checkSql, Integer.class, category.getId());
		
		if (count > 0) {
	        // Cập nhật danh mục nếu ID tồn tại
	        String sql = "UPDATE categories SET name = ?, description = ? WHERE id = ?";
	        _jdbcTemplate.update(sql, category.getName(), category.getDescription(), category.getId());
	    } else {
	        // Thêm mới danh mục nếu ID chưa tồn tại
	        String sql = "INSERT INTO categories (name, description) VALUES (?, ?)";
	        _jdbcTemplate.update(sql, category.getName(), category.getDescription());
	    }
		
	}

	public int deleteCategory(int id) {
		String sql = "DELETE FROM categories WHERE id = ?";
		return _jdbcTemplate.update(sql, id);
	}
	
	
}
