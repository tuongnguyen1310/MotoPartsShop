package MotoPartsShop.DTO;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BillDetailDtoMapper implements RowMapper<BillDetailDto> {
    @Override
    public BillDetailDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        BillDetailDto dto = new BillDetailDto();
        dto.setBill_detail_id(rs.getInt("bill_detail_id")); // Ánh xạ từ SQL
        dto.setBill_id(rs.getInt("bill_id"));
        dto.setUser(rs.getString("user"));
        dto.setPhone(rs.getString("phone"));
        dto.setProduct_name(rs.getString("product_name"));
        dto.setQuanty(rs.getInt("quanty"));
        dto.setTotal(rs.getDouble("total"));
        return dto;
    }
}
