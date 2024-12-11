package MotoPartsShop.DAO;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import MotoPartsShop.DTO.ProductsDto;
import MotoPartsShop.Entity.Bills;
import MotoPartsShop.Entity.MapperUsers;
import MotoPartsShop.Entity.Users;

@Repository
public class UsersDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;

	public int AddAccount(Users user) {
		StringBuffer varname1 = new StringBuffer();
		varname1.append("INSERT INTO `motopartsshop`.`users` (username, password, display_name, address) ");
		varname1.append("VALUES ");
		varname1.append("( ");
		varname1.append("	'" + user.getUser() + "', ");
		varname1.append("	'" + user.getPassword() + "', ");
		varname1.append("	'" + user.getDisplay_name() + "', ");
		varname1.append("	'" + user.getAddress() + "' ");
		varname1.append(")");

		int insert = _jdbcTemplate.update(varname1.toString());
		return insert;
	}

	public boolean isUsernameExist(String username) {
		String sql = "SELECT COUNT(*) FROM `users` WHERE username = ?";
		Integer count = _jdbcTemplate.queryForObject(sql, Integer.class, username);
		return count != null && count > 0;
	}

	public Users GetUserByAccount(Users user) {
		String sql = "SELECT * FROM users WHERE username = '" + user.getUser() + "' ";

		Users resultUsers = _jdbcTemplate.queryForObject(sql, new MapperUsers());
		return resultUsers;
	}
	
	public Users GetUserById(int id) {
		String sql = "SELECT * FROM users WHERE id = '" + id + "' ";
		try {
	        return _jdbcTemplate.queryForObject(sql, new MapperUsers());
	    } catch (EmptyResultDataAccessException e) {
	        return null; // Trả về null nếu không tìm thấy người dùng
	    }
	}

	public List<Users> getDataAllUser(){
		String sql = "SELECT * FROM motopartsshop.users ";
		List<Users> list = _jdbcTemplate.query(sql, new MapperUsers());
		return list;
	}
	
	public int addUser(String username, String password, String displayName, String address, int role) {
        String sql = "INSERT INTO users (username, password, display_name, address, role) VALUES (?, ?, ?, ?, ?)";
        return _jdbcTemplate.update(sql, username, password, displayName, address, role);
    }

    // Update User
    public int updateUser(int id, String username, String password, String displayName, String address, int role) {
        String sql = "UPDATE users SET user = ?, password = ?, display_name = ?, address = ?, role = ? WHERE id = ?";
        return _jdbcTemplate.update(sql, username, password, displayName, address, role, id);
    }

    // Delete User
    public int deleteUser(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        return _jdbcTemplate.update(sql, id);
    }

    public void save(Users user) {
        String checkSql = "SELECT COUNT(*) FROM users WHERE id = ?";
        int count = _jdbcTemplate.queryForObject(checkSql, Integer.class, user.getId());

        if (count > 0) {
            // Cập nhật thông tin người dùng
            String updateSql = "UPDATE users SET username = ?, password = ?, display_name = ?, address = ?, role = ? WHERE id = ?";
            _jdbcTemplate.update(updateSql, user.getUser(), user.getPassword(), user.getDisplay_name(), user.getAddress(), user.getRole(), user.getId());
        } else {
            // Thêm mới người dùng
            String insertSql = "INSERT INTO users (username, password, display_name, address, role) VALUES (?, ?, ?, ?, ?)";
            _jdbcTemplate.update(insertSql, user.getUser(), user.getPassword(), user.getDisplay_name(), user.getAddress(), user.getRole());
        }
    }

}
