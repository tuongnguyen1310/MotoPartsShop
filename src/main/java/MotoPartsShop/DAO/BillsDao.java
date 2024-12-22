package MotoPartsShop.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import MotoPartsShop.DTO.BillDetailDto;
import MotoPartsShop.DTO.BillDetailDtoMapper;
import MotoPartsShop.Entity.BillDetail;
import MotoPartsShop.Entity.Bills;
import MotoPartsShop.Entity.MapperBills;
import MotoPartsShop.Entity.MapperSlides;
import MotoPartsShop.Entity.MapperUsers;
import MotoPartsShop.Entity.Slides;
import MotoPartsShop.Entity.Users;

@Repository
public class BillsDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;

	public int addBills(Bills bill) {
		String sql = "INSERT INTO bills (user, phone, display_name, address, total, quanty, note) " + "VALUES ( '"
				+ bill.getUser() + "','" + bill.getPhone() + "','" + bill.getDisplay_name() + "','" + bill.getAddress()
				+ "','" + bill.getTotal() + "','" + bill.getQuanty() + "','" + bill.getNote() + "' );";
		int insert = _jdbcTemplate.update(sql);
		return insert;
	}

	public int getIDLastBills() {
		String sqlString = "SELECT MAX(id) FROM bills;";
		int id = _jdbcTemplate.queryForObject(sqlString, Integer.class);
		return id;
	}

	public void addBillsDetail(BillDetail billDetail) {
		String sql = "INSERT INTO billdetail (id_product, id_bills, quanty, total) " + "VALUES (?, ?, ?, ?)";
		_jdbcTemplate.update(sql, billDetail.getId_product(), billDetail.getId_bills(), billDetail.getQuanty(),
				billDetail.getTotal());
	}

	public void getBillsDetailByIdBills(int id) {
		String sql = "SELECT " + "    bd.id AS bill_detail_id, " + "    b.id AS bill_id, " + "    b.user, "
				+ "    b.phone, " + "    p.name AS product_name, " + "    bd.quanty, " + "    bd.total "
				+ "FROM billdetail bd " + "JOIN bills b ON bd.id_bills = b.id "
				+ "JOIN products p ON bd.id_product = p.id " + "WHERE b.id = ?;";
		_jdbcTemplate.update(sql, id);
	}

	public List<Bills> GetDataBills() {
		List<Bills> list = new ArrayList<Bills>();
		String sql = "SELECT * FROM motopartsshop.bills;";
		list = _jdbcTemplate.query(sql, new MapperBills());
		return list;
	}

	public Bills GetBillsById(int id) {
		String sql = "SELECT * FROM bills WHERE id = '" + id + "' ";
		try {
			return _jdbcTemplate.queryForObject(sql, new MapperBills());
		} catch (EmptyResultDataAccessException e) {
			return null; // Trả về null nếu không tìm thấy người dùng
		}
	}

	public void saveBill(Bills bill) {
		// Kiểm tra xem hóa đơn đã tồn tại hay chưa
		String checkSql = "SELECT COUNT(*) FROM bills WHERE id = ?";
		int count = _jdbcTemplate.queryForObject(checkSql, Integer.class, bill.getId());

		if (count > 0) {
			// Cập nhật thông tin hóa đơn nếu đã tồn tại
			String updateSql = "UPDATE bills SET user = ?, phone = ?, display_name = ?, address = ?, total = ?, quanty = ?, note = ? WHERE id = ?";
			_jdbcTemplate.update(updateSql, bill.getUser(), bill.getPhone(), bill.getDisplay_name(), bill.getAddress(),
					bill.getTotal(), bill.getQuanty(), bill.getNote(), bill.getId());
		} else {
			// Thêm mới hóa đơn nếu chưa tồn tại
			String insertSql = "INSERT INTO bills (user, phone, display_name, address, total, quanty, note) VALUES (?, ?, ?, ?, ?, ?, ?)";
			_jdbcTemplate.update(insertSql, bill.getUser(), bill.getPhone(), bill.getDisplay_name(), bill.getAddress(),
					bill.getTotal(), bill.getQuanty(), bill.getNote());
		}
	}

	public int deleteBill(int id) {
		String sql = "DELETE FROM bills WHERE id = ?";
		return _jdbcTemplate.update(sql, id);
	}

	public List<BillDetailDto> getBillDetailsByBillId(int billId) {
		String sql = "SELECT " + "    bd.id AS bill_detail_id, " + "    b.id AS bill_id, " + "    b.user, "
				+ "    b.phone, " + "    p.name AS product_name, " + "    bd.quanty, " + "    bd.total "
				+ "FROM billdetail bd " + "JOIN bills b ON bd.id_bills = b.id "
				+ "JOIN products p ON bd.id_product = p.id " + "WHERE b.id = ?";
		return _jdbcTemplate.query(sql, new BillDetailDtoMapper(), billId);
	}

}
