package MotoPartsShop.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import MotoPartsShop.Entity.MapperUsers;
import MotoPartsShop.Entity.Users;

@Repository
public class UsersDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;

	public int AddAccount(Users user) {
		StringBuffer  varname1 = new StringBuffer();
		varname1.append("INSERT INTO `motopartsshop`.`users` (username, password, display_name, address) ");
		varname1.append("VALUES ");
		varname1.append("( ");
		varname1.append("	'"+user.getUser()+"', ");
		varname1.append("	'"+user.getPassword()+"', ");
		varname1.append("	'"+user.getDisplay_name()+"', ");
		varname1.append("	'"+user.getAddress()+"' ");
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
}
