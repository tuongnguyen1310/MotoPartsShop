package MotoPartsShop.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import MotoPartsShop.Entity.BillDetail;
import MotoPartsShop.Entity.Bills;

@Repository
public class BillsDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;

	public int addBills(Bills bill) {
		 String sql = "INSERT INTO bills (user, phone, display_name, address, total, quanty, note) "
                 + "VALUES ( '"+bill.getUser()+ "','"+bill.getPhone()+ "','" + bill.getDisplay_name()+ "','" + bill.getAddress()+ "','"+ bill.getTotal() + "','" + bill.getQuanty() + "','" + bill.getNote()+ "' );";
		 int insert = _jdbcTemplate.update(sql);
		 return insert;
	}
	
	public int getIDLastBills() {
		String sqlString = "SELECT MAX(id) FROM bills;";
		int id = _jdbcTemplate.queryForObject(sqlString, Integer.class);
		return id;
	}

	public void addBillsDetail(BillDetail billDetail) {
	    String sql = "INSERT INTO billdetail (id_product, id_bills, quanty, total) "
	               + "VALUES (?, ?, ?, ?)";
	    _jdbcTemplate.update(sql, 
	        billDetail.getId_product(), 
	        billDetail.getId_bills(), 
	        billDetail.getQuanty(), 
	        billDetail.getTotal()
	    );
	}

}
