package MotoPartsShop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import MotoPartsShop.DTO.BillStatisticsDto;
import org.springframework.jdbc.core.RowMapper;

public class BillStatisticsMapper implements RowMapper<BillStatisticsDto> {
    @Override
    public BillStatisticsDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new BillStatisticsDto(
            rs.getInt("month"),
            rs.getInt("year"),
            rs.getInt("billCount"),
            rs.getDouble("totalIncome")
        );
    }
}
