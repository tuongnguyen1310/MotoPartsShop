package MotoPartsShop.Service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import MotoPartsShop.DTO.BillStatisticsDto;

@Repository
public class BillRepositoryImpl implements IBillRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<BillStatisticsDto> getMonthlyStatistics() {
        String sql = "SELECT MONTH(category_create_at) AS month, YEAR(category_create_at) AS year, "
                   + "COUNT(id) AS billCount, SUM(total) AS totalIncome "
                   + "FROM bills "
                   + "GROUP BY YEAR(category_create_at), MONTH(category_create_at) "
                   + "ORDER BY year, month";
        List<BillStatisticsDto> result = jdbcTemplate.query(sql, (rs, rowNum) -> {
            return new BillStatisticsDto(
                rs.getInt("month"),
                rs.getInt("year"),
                rs.getInt("billCount"),
                rs.getDouble("totalIncome")
            );
        });
        System.out.println(result); // Debug tại đây để kiểm tra kết quả SQL
        return result;
    }
}

